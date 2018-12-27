<%@ page import="top.bluesfu.model.User" %>
<%@ page import="top.bluesfu.dao.UserDao" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: fsy
  Date: 18-12-20
  Time: 上午10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center;">
<table width="80%" border="1" cellpadding="0">
<tr align="center">
    <th>编号</th>
    <th>用户名</th>
    <th>密码</th>
    <th>邮箱</th>
    <th>操作</th>
</tr>
    <%

        UserDao dao=new UserDao();
       Iterator<User> users=dao.findAll().iterator();
      while(users.hasNext()){
         User user=users.next();
            %>
              <tr align="center">
                  <td><%=user.getId()%></td>
                  <td><%=user.getUsername()%></td>
                  <td><%=user.getPassword()%></td>
                  <td><%=user.getEmail()%></td>
                  <td><a href="#">编辑</a>
                      &nbsp;&nbsp;<a href="#">删除</a></td>
              </tr>


       <%
        }
    %>

</table>
</div>
</body>
</html>
