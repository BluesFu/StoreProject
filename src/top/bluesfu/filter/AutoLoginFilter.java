package top.bluesfu.filter;


import top.bluesfu.dao.UserDao;
import top.bluesfu.model.User;
import top.bluesfu.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fsy
 */
public class AutoLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        Cookie[] cookies=((HttpServletRequest) servletRequest).getCookies();
        User user=(User) request.getSession().getAttribute("user");
        if (user==null){
            String requestURI=request.getRequestURI();
            if (!requestURI.contains("/login")){
                Cookie cookie= CookieUtils.getCookieByName("aotuLogin",request);
                if (cookie !=null){
                    String username=cookie.getValue().split("-")[0];
                    String password=cookie.getValue().split("-")[1];
                     user=new UserDao().findUserByNameAndPwd(username,password);
                    if (user!=null){
                        request.getSession().setAttribute("user",user);
                    }

                }
            }
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
