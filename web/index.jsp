﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>传习教育网上书城</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"> 
	   传习教育网上书城
	</div>
    <div style="width:380px; height:50px; float:right; position:absolute; left:60%; top:2px; line-height:50px">
	    <img src="images/cart.gif" style="margin-bottom:-4px" width="26" height="23">
		  欢迎您： madan &nbsp;
                  <a href="/jsp/myAccount.jsp">我的帐户</a>
				| <a href="/jsp/productCategory.jsp">商品分类</a>
				| <a href="#">帮助中心</a>  
		</div>
	<div id="navbar">
		<div class="userMenu">
			<ul>
				<li class="current"><a href="index.jsp">User首页</a></li>
				<li><a href="html/orderlist.html">我的订单</a></li>
				<li><a href="jsp/shopping.jsp">购物车</a></li>
				<li><a href="logout.do" onclick="javascript:return confirm_logout()">注销</a></li>
			</ul>
		</div>
		<form method="get" name="search" action="">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>
<div id="content" class="wrap">
	<div class="list bookList" >
		<form method="post" name="shoping" action="jsp/shopping.jsp">
			<table>
				<tr class="title">
					<th class="checker"></th>
					<th>书名</th>
					<th class="price">价格</th>
					<th class="store">库存</th>
					<th class="view">图片预览</th>
				</tr>
            <c:choose>
				<c:when test="${not empty requestScope.pageBean.pageData}">
					<c:forEach var="emp" items="${requestScope.pageBean.pagedata}" varStatus="product">
					<tr class="odd">
						<td><input type="checkbox" name="bookId" value="1" /></td>
						<td class="title">${product.name}</td>
						<td>${product.price}</td>
						<td>${product.pnum}</td>
						<td class="thumb"><img src=${product.imgurl} width=92px height=110px /></td>
					</tr>
                </c:forEach>
				</c:when>
			</c:choose>

			</table>


			<div class="page-spliter">
				<a href="${pageContext.request.contextPath}/index?currentPage=${requestScope.pageBean.currentPage-1}">上一页</a>
				<a href="${pageContext.request.contextPath}/index?currentPage=1">首页</a>
				<span class="current">1</span>
				<span>...</span>
				<a href="${pageContext.request.contextPath}/index?currentPage=${requestScope.pageBean.totalPage}">尾页</a>
				<a href="${pageContext.request.contextPath}/index?currentPage=${requestScope.pageBean.CurrentPage+1}">下一页</a>
			</div>
			<div class="button"><input class="input-btn" type="submit" name="submit" value="" /></div>
		</form>
	</div>
</div>
<div id="footer" class="wrap">
	传习教育网上书城 &copy; 版权所有

</div>

</body>
</html>
