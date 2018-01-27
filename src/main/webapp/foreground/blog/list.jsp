<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-md-9">
	<div class="data_list">
		<div class="data_list_title">
			<img
				src="${pageContext.request.contextPath}/static/images/list_icon.png" />
			最新博客
		</div>
		<div class="datas">
			<ul>
				<c:forEach items="${blogList }" var="blogInfoEntity">
					<li style="margin-bottom: 30px"><span class="date"><fmt:formatDate
									value="${blogInfoEntity.releaseDate }" type="date"
									pattern="yyyy/MM" /></span> <span class="title"><a href="${pageContext.request.contextPath }/articles/${blogInfoEntity.id}.html">${blogInfoEntity.title }</a></span>
						<span class="summary">摘要:${blogInfoEntity.summary }...</span>
						<div class="row">
							<div class="col-xs-6 col-md-3">
								<span class="img"> <c:forEach
										items="${blogInfoEntity.images }" var="image">
										<span class="thumbnail">${image }</span>
									</c:forEach>
								</span>
							</div>
						</div> <span class="info">发表于<fmt:formatDate
								value="${blogInfoEntity.releaseDate }" type="date"
								pattern="yyyy-MM-dd HH:mm" /> 阅读(${blogInfoEntity.clickCount })
							评论(${blogInfoEntity.replyCount })
					</span></li>
					<hr
						style="height: 5px; border: none; border-top: 1px dashed gray; padding-bottom: 10px;" />
				</c:forEach>
			</ul>
		</div>
		<div>
			<nav>
				<ul class="pagination pagination-sm">${pageHtml }
				</ul>
			</nav>
		</div>
	</div>
</div>

