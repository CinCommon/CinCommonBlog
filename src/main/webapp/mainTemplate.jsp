<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet"
 	href="${pageContext.request.contextPath}/static/css/blogStyle.css">
<script
	src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
<title>${pageTitle }_CinCommonBlog</title>
<style type="text/css">
body {
	padding-top: 10px;
	padding-bottom: 40px;
}
</style>
</head>
<body style="background-color: #d0d0d0; padding: 10px">
	<div class="constainer">
		<jsp:include page="foreground/common/head.jsp" />
		<jsp:include page="foreground/common/navbar.jsp" />
		<div class="row">
			<jsp:include page="${mainPage }" />
			<div class="col-md-3">
				<script src='//w.segmentfault.com/card/1030000011237262.js?w=0&3rd=1&bg=FFFFFF&bd=DDDDDD&cl=333333&btn=009a61&noBtn=0'></script>
				<div class="data_list">
					<div class="data_list_title">
						<span class="glyphicon glyphicon-tag" style="margin: 2px"></span>
						按日志类别
					</div>
					<div class="datas">
						<ul>
							<c:forEach var="type" items="${ blogTypeEntites}">
								<li><span><a href="${pageContext.request.contextPath }/index.html?typeId=${type.id }">${type.typeName }(${type.blogCounts })</a></span></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="data_list">
					<div class="data_list_title">
						<span class="glyphicon glyphicon-calendar" style="margin: 2px"></span>
						按日志日期
					</div>
					<div class="datas">
						<ul>
							<c:forEach var="blogCate" items="${blogInfoEntites }">
								<li><span><a href="${pageContext.request.contextPath }/index.html?formatDate=${blogCate.formatDate}">${blogCate.formatDate }(${blogCate.countByDate })</a></span></li>
							</c:forEach>
						</ul>
					</div>
				</div>

				<div class="data_list">
					<div class="data_list_title">
						<span class="glyphicon glyphicon-link" style="margin: 2px"></span>
						友情链接
					</div>
					<div class="datas">
						<ul>
							<c:forEach var="link" items="${links }">
								<!-- EL表达式引号里面千万不能手贱加空格!!!!  fuck-->
								<li><span><a href="${link.linkUrl }" target="_blank">${link.linkName }</a></span></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="foreground/common/foot.jsp" />
	</div>
</body>
</html>
