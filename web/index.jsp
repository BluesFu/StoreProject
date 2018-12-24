<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="top.bluesfu.model.Product" %>
<%@ page import="top.bluesfu.dao.ProductDao" %>
<%@ page import="java.util.Iterator" %>
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
                  <a href="myAccount.jsp">我的帐户</a>
				| <a href="productCategory.jsp">商品分类</a> 
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
		<%--		<c:forEach items="${productList}" var="p">
					<li>
						<div class="odd">
							<a href="findProductById?id=${p.id}>书名:(p.name)<br />售价:${p.price}"/>
						</div>
					</li>
				</c:forEach>
--%>
				<%
					ProductDao dao=new ProductDao();
					Iterator<Product> products=dao.findAll().iterator();
					while (products.hasNext()){
					    Product product=products.next();


				%>
				<tr class="odd">
					<td><input type="checkbox" name="bookId" value="1" /></td>
					<td class="title"><%=product.getName()%></td>
					<td><%=product.getPrice()%></td>
					<td><%=product.getPnum()%></td>
					<td class="thumb"><img src=<%=product.getImgurl()%> width=92px height=110px /></td>
				</tr>

				<%
					}

				%>
			</table>


			<div class="page-spliter">
				<a href="${pageContext.request.contextPath}/index.jsp?currentPage=${requestScope.pageBean.currentPage-1}">&lt;</a>
				<a href="${pageContext.request.contextPath}/index.jsp?currentPage=1">首页</a>
				<span class="current">1</span>
				<span>...</span>
				<a href="${pageContext.request.contextPath}/index.jsp?">尾页</a>
				<a href="#">&gt;</a>
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
