package cn.com.sm.filter;

import cn.com.sm.service.AuthUserDetailService;
import cn.com.sm.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class TokenFilter extends GenericFilterBean {

    private final Logger log = LoggerFactory.getLogger(TokenFilter.class);

    private final static String TOKEN_HEADER_NAME = "token";

    @Resource
    private AuthUserDetailService detailsService; //= new AuthUserDetailService();

    //    private TokenProvider tokenProvider;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TokenFilter->doFilter()");
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            String authToken = httpServletRequest.getHeader(TOKEN_HEADER_NAME);
            if (StringUtils.hasText(authToken)) {
                // 从自定义tokenProvider中解析用户
                String username = TokenUtil.getUsernameFromToken(authToken);
                // 这里仍然是调用我们自定义的UserDetailsService，查库，检查用户名是否存在，
                // 如果是伪造的token,可能DB中就找不到username这个人了，抛出异常，认证失败
                UserDetails details = detailsService.loadUserByUsername(username);
                if (TokenUtil.validate(authToken,details)) {
                    log.debug(" validateToken ok...");
                    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(details, details.getPassword(), details.getAuthorities());
                    // 这里还是上面见过的，存放认证信息，如果没有走这一步，下面的doFilter就会提示登录了
                    SecurityContextHolder.getContext().setAuthentication(token);
                }
            }
            // 调用后续的Filter,如果上面的代码逻辑未能复原“session”，SecurityContext中没有相关信息，后面的流程会检测出"需要登录"
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
