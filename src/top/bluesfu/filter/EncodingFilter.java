package top.bluesfu.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @author fsy
 */
public class EncodingFilter implements Filter {
   private String charSet;

    @Override
    public void init(FilterConfig filterConfig) {
        this.charSet=filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException,ServletException{
        request.setCharacterEncoding(this.charSet);
        System.out.println("filter启动");
         chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
