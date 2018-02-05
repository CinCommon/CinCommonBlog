<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<script
	src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>

<script>
	window.onload = function() {
		var t = 5
		setInterval(
				function() {
					t--;
					document.getElementById('sec').innerHTML = t
					if (t == 0) {
						window.location = '${pageContext.request.contextPath}/index.html'
					}
				}, 1000)
	}
</script>
</head>
<body style="background-color: #eeeeee">
	<div class="jumbotron" style="height: 100%">
		<div style="text-align: center">
			<h1>大兄弟! 404! Page Not Found!</h1>
			<h2>
				抱歉! 您所访问的地址不存在! 将在<span id="sec">5</span>秒后跳转回妙♂妙♂屋
			</h2>
			<p>
				迫不及待地进入
				<a class="btn btn-primary btn-xs"
					href="${pageContext.request.contextPath}/index.html" role="button">♂</a>
			</p>
		</div>
	</div>
</body>
</html>