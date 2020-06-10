package cn.com.sm.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter  extends ZuulFilter{//
    public static final String AUTHORIZATION = "Authorization";
    private Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

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
        System.out.println("request uri:"+uri);
        if(logger.isDebugEnabled()){
            logger.debug("request uri:",uri);
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        System.out.println("request URI:"+request.getRequestURI());
        if(request.getRequestURI().equals("/api/auth/login")){
            context.setSendZuulResponse(true);// 对该请求进行路由
            context.setResponseStatusCode(200);
            context.set("isSuccess", true);// 设值，让下一个Filter看到上一个Filter的状态
            return null;
        }
        String header = request.getHeader(AUTHORIZATION);
        if(StringUtils.isEmpty(header)) {
            // 请求头中没有，判断请求参数是否存在token信息
            header = request.getParameter(AUTHORIZATION);
            if (StringUtils.isEmpty(header)) {
                // 请求中不包含token信息，提示登录
                context.setResponseStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
                context.setResponseBody("please login first!");
            }
        }
        context.addZuulRequestHeader(AUTHORIZATION,header);
        return null;
    }
}