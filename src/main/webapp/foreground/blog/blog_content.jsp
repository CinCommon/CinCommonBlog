<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
<script type="text/javascript">
	SyntaxHighlighter.all();
</script>
<div class="col-md-9">
	<div class="data_list">
		<div class="data_list_title">
			<span class="glyphicon glyphicon-list-alt"></span>博客内容
		</div>
		<div class="blog-title">
			<h2>${blogDetails.title }</h2>
			<div>
				<fmt:formatDate value="${blogDetails.releaseDate }" type="date"
					pattern="[yyyy/MM/dd HH:mm]" />
				<small>类别: ${blogDetails.blogType.typeName }</small><small
					class="blog-detail-small"> 阅读(${blogDetails.clickCount })</small> <small
					class="blog-detail-small">评论(${blogDetails.replyCount })</small>
			</div>
			<c:choose>
				<c:when
					test="${blogDetails.userInfo.userName != null || blogDetails.userInfo.userName !=''}">
					<div>作者: ${blogDetails.userInfo.userName }</div>
				</c:when>
			</c:choose>
			<!-- JiaThis Button BEGIN -->
			<div class="blog-title jiathis_style">
				<a class="jiathis_button_tsina"></a> <a class="jiathis_button_tqq"></a>
				<a class="jiathis_button_weixin"></a> <a class="jiathis_button_fb"></a>
				<a class="jiathis_button_twitter"></a> <a
					class="jiathis_button_googleplus"></a> <a class="jiathis_button_qq"></a>
				<a class="jiathis_button_gmail"></a> <a
					href="http://www.jiathis.com/share"
					class="jiathis jiathis_txt jiathis_separator jtico jtico_jiathis"
					target="_blank"></a> <a class="jiathis_counter_style"></a>
			</div>
			<script type="text/javascript">
				var jiathis_config = {
					summary : "",
					shortUrl : false,
					hideMore : false
				}
			</script>
			<script type="text/javascript"
				src="http://v3.jiathis.com/code/jia.js" charset="utf-8"></script>
			<!-- JiaThis Button END -->
			<br />
		</div>
		<div class="datas blog-content">
			${blogDetails.content }
		</div>
		<div>
			关键字: ${blogDetails.keyword }
		</div>

		<hr style="border: 1px dotted #00f" />
		<div>
			<span style="margin-right: 20px">上一篇:</span>
			<c:choose>
				<c:when test="${lastBlogInfo != null }">
					<a
						href="${pageContext.request.contextPath }/articles/${lastBlogInfo.id}.html">${lastBlogInfo.title }</a>
				</c:when>
				<c:otherwise>
			没有啦!
		</c:otherwise>
			</c:choose>
		</div>
		<div>
			<span style="margin-right: 20px">下一篇:</span>
			<c:choose>
				<c:when test="${nextBlogInfo != null }">
					<a
						href="${pageContext.request.contextPath }/articles/${nextBlogInfo.id}.html">${nextBlogInfo.title }</a>
				</c:when>
				<c:otherwise>
			没有啦!
		</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>

