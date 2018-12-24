<%@ page import="top.bluesfu.dao.UserDao" %>
<%@ page import="top.bluesfu.model.User" %><%--
  Created by IntelliJ IDEA.
  User: fsy
  Date: 18-12-17
  Time: 下午3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>insert title here</title>
</head>
<body>
<%
    String name=request.getParameter("userName");
    String password=request.getParameter("passWord");
    String email=request.getParameter("email");
    UserDao dao =new UserDao();
    User user=new User();

    user.setUsername(name);
    user.setPassword(password);
    user.setEmail(email);

    int num=dao.addUser(user);

   if (num>=1){
       response.sendRedirect("register_success.jsp");
   }else {
       response.sendRedirect("register_failed.jsp");
   }



    %>
            </body>
</html>
