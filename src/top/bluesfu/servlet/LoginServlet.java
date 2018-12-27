package top.bluesfu.servlet;


import top.bluesfu.dao.UserDao;
import top.bluesfu.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
     String username=request.getParameter("username");
     String password=request.getParameter("password");
     String[] rememberpwd=request.getParameterValues("remember");
        User user=null;
        UserDao dao=new UserDao();
        Cookie[] cookies=request.getCookies();

        user=dao.findUserByNameAndPwd(username,password);
        if (user!=null){
              request.getSession().setAttribute("username",username);
              if (rememberpwd!=null){
                  Cookie cookie=new Cookie("autoLogin",username+"-"+password);
                  cookie.setMaxAge(36000);
                  cookie.setPath(request.getContextPath()+"/");
                  response.addCookie(cookie);
              }
              response.sendRedirect(request.getContextPath()+"/loginSuccess.jsp");
        }else {
                request.setAttribute("msg","用户名或密码错误！");
                request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
                return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
