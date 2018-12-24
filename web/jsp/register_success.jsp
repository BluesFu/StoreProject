<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
		  欢迎您：visitor  &nbsp;
                  <a href="myAccount.jsp">我的帐户</a>
				| <a href="productCategory.jsp">商品分类</a> 
				| <a href="#">帮助中心</a>  
		</div>
	<div id="navbar">
		<form method="get" name="search" action="">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>
<div id="register">
	<div class="title">
		<h2>欢迎注册传习教育网上书城</h2>
	</div>
	<div class="steps">
		<ul class="clearfix">
			<li class="past">1.填写注册信息</li>
			<li class="last">2.注册成功</li>
		</ul>
	</div>
	<div class="success">
		<div class="information">
			<p>恭喜：注册成功！</p>
			<p><a href="../index.jsp">点此进入用户中心&gt;&gt;</a></p>
		</div>
	</div>
</div>
<div id="footer" class="wrap">
	传习教育网上书城 &copy; 版权所有

</div>
</body>
</html>
