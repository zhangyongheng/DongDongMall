<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html>
<head>

<title>product-left</title>
<link href="/res/css/admin.css" rel="stylesheet"/>
<link href="/res/common/css/theme.css" rel="stylesheet"/>
<link href="/res/common/css/jquery.validate.css" rel="stylesheet"/>
<link href="/res/common/css/jquery.treeview.css" rel="stylesheet"/>
<link href="/res/common/css/jquery.ui.css" rel="stylesheet"/>

<!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
<!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
<script type="text/javascript" src="/res/fckeditor/fckeditor.js"></script>
<script src="/res/common/js/jquery.js" type="text/javascript"></script>
<script src="/res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="/res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="/res/common/js/yongheng.js" type="text/javascript"></script>
<script src="/res/js/admin.js" type="text/javascript"></script>
</head>
<body class="lbody">
<div class="left">
<%@ include file="/back_page/date.jsp" %>
     <ul class="w-lful">
		<li><a target="rightFrame" href="order_right.jsp">货到付款</a></li>
		<li><a target="rightFrame" href="order_right.jsp">待付款</a></li>
		<li><a target="rightFrame" href="order_right.jsp">已取消</a></li>
		<li><a target="rightFrame" href="order_right.jsp">已付款</a></li>
		<li><a target="rightFrame" href="order_right.jsp">仓库配货</a></li>
		<li><a target="rightFrame" href="order_right.jsp">商品出库</a></li>
		<li><a target="rightFrame" href="order_right.jsp">等待收货</a></li>
		<li><a target="rightFrame" href="order_right.jsp">已完成</a></li>
		<li><a target="rightFrame" href="order_right.jsp">待退货</a></li>
		<li><a target="rightFrame" href="order_right.jsp">待退款</a></li>
		<li><a target="rightFrame" href="order_right.jsp">已退货</a></li>
		<li><a target="rightFrame" href="order_right.jsp">已退款</a></li>
     </ul>
</div>
</body>
</html>