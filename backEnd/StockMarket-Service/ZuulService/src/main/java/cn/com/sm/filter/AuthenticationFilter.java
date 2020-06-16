package cn.com.sm.filter;

import cn.com.sm.entity.UsersEntity;
import cn.com.sm.service.UserService;
import cn.com.sm.utils.Constants;
import cn.com.sm.utils.ResultBody;
import cn.com.sm.utils.ResultEnum;
import cn.com.sm.utils.TokenUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter  extends ZuulFilter{//
    public static final String AUTHORIZATION = Constants.AUTHORIZATION;
    private Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Resource
    private UserService userService;

    @Resource
    private ObjectMapper objectMapper;
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String uri = request.getRequestURI();
        if(logger.isDebugEnabled()){
            logger.debug("request uri:",uri);
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info("request URI:"+request.getServletPath());
        if(!isURLNeedAuth(request.getServletPath(),request.getMethod())){
            logger.info("request URL:"+request.getServletPath()+" don't need to be authorized for method:"+request.getMethod());
            return null;
        }
        String token = request.getHeader(AUTHORIZATION);
        if(StringUtils.isEmpty(token)) {
            // 请求头中没有，判断请求参数是否存在token信息
            token = request.getParameter(AUTHORIZATION);
        }

        if (StringUtils.isEmpty(token)) {
            // 请求中不包含token信息，提示登录
            setResponse(context,HttpServletResponse.SC_UNAUTHORIZED,ResultBody.error(ResultEnum.NOT_LOGIN));
        }else{
            // 从自定义tokenProvider中解析用户
            boolean isValidate = true;
            try {
                //判断token信息是否正确
                if(TokenUtil.isTokenExpired(token)){
                    setResponse(context,HttpServletResponse.SC_UNAUTHORIZED,ResultBody.error(ResultEnum.TOKEN_EXPIRED));
                    return null;
                }
                String username = TokenUtil.getUsernameFromToken(token);
                // 这里仍然是调用我们自定义的UserDetailsService，查库，检查用户名是否存在，
                // 如果是伪造的token,可能DB中就找不到username这个人了，抛出异常，认证失败
                UsersEntity user = userService.getUserByName(username);
                if (TokenUtil.validate(token, user)) {
                    logger.debug(" validateToken ok...");
                    context.addZuulRequestHeader(AUTHORIZATION, token);
                } else {
                    isValidate = false;
                }
            }catch(ExpiredJwtException e){
                logger.error(e.getMessage());
                setResponse(context, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,ResultBody.error(ResultEnum.TOKEN_EXPIRED));
            }catch (Exception e){
                e.printStackTrace();
                logger.error(e.getMessage());
                isValidate = false;
            }
            if(!isValidate){
//                context.setResponseStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
//                context.setResponseBody("Invalidate token!");
                setResponse(context,HttpServletResponse.SC_UNAUTHORIZED,ResultBody.error(ResultEnum.TOKEN_INVALIDATE));
            }
        }
        return null;
    }

    private void setResponse(RequestContext context,int statusCode,ResultBody resultBody) {
        context.setResponseStatusCode(statusCode);
        try {
            String responseBody = objectMapper.writeValueAsString(resultBody);
            context.setResponseBody(responseBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    /**
     * is URL/method need to be authorize
     * @param url
     * @param method
     * @return
     */
    private boolean isURLNeedAuth(String url,String method){
        if(url.endsWith("/login") || (url.endsWith("/user")&& method.equals("POST"))) {
            return false;
        }else if(url.endsWith("api/user") && method.equals("POST")){
            return false;
        }
        return true;
    }
}
