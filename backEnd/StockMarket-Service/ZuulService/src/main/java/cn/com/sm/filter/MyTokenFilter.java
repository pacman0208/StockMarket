package cn.com.sm.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class MyTokenFilter extends GenericFilterBean {
    private final Logger log = LoggerFactory.getLogger(MyTokenFilter.class);

    private final static String XAUTH_TOKEN_HEADER_NAME = "my-auth-token";

//    private UserDetailsService detailsService;

//    private TokenProvider tokenProvider;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
