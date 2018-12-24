<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"> 
	   传习教育网上书城
	</div>
    <div style="width:380px; height:50px; float:right; position:absolute; left:60%; top:2px; line-height:50px">
	    <img src="../images/cart.gif" style="margin-bottom:-4px" width="26" height="23">
		  欢迎您： visitor &nbsp;
                  <a href="myAccount.jsp">我的帐户</a>
				| <a href="productCategory.jsp">商品分类</a> 
				| <a href="#">帮助中心</a>  
		</div>
	<div id="navbar">
		<div class="userMenu">
			<ul>
				<li><a href="../index.jsp">User首页</a></li>
				<li><a href="../html/orderlist.html">我的订单</a></li>
				<li class="current"><a href="shopping.jsp">购物车</a></li>
				<li><a href="#">注销</a></li>
			</ul>
		</div>
		<form method="get" name="search" action="">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>
<div id="content" class="wrap">
	<div class="list bookList">
		<form method="post" name="shoping" action="../html/shopping-success.html">
			<table>
				<tr class="title">
					<th class="view">图片预览</th>
					<th>书名</th>
					<th class="nums">数量</th>
					<th class="price">价格</th>
				</tr>
				<tr>
					<td class="thumb"><img src="../images/book/book_01.gif" /></td>
					<td class="title">泰戈尔诗集</td>
					<td><input class="input-text" type="text" name="nums" value="1" /></td>
					<td>￥<span>18.00</span></td>
				</tr>
				<tr class="odd">
					<td class="thumb"><img src="../images/book/book_02.gif" /></td>
					<td class="title">痕记</td>
					<td><input class="input-text" type="text" name="nums" value="1" /></td>
					<td>￥<span>22.80</span></td>
				</tr>
				<tr>
					<td class="thumb"><img src="../images/book/book_03.gif" /></td>
					<td class="title">天堂之旅</td>
					<td><input class="input-text" type="text" name="nums" value="1" /></td>
					<td>￥<span>25.00</span></td>
				</tr>
			</table>
			<div class="button">
				<h4>总价：￥<span>65.00</span>元</h4>
				<input class="input-chart" type="submit" name="submit" value="" />
			</div>
		</form>
	</div>
</div>
<div id="footer" class="wrap">
	传习教育网上书城 &copy; 版权所有

</div>
</body>
</html>
