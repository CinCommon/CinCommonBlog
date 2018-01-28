<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>写博客</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/static/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/static/ueditor/ueditor.all.min.js">
	
</script>
<script type="text/javascript">
	function submitData() {
		var title = $("#title").val();
		var blogTypeId = $("#blogTypeId").combobox("getValue")
		var content = UE.getEditor('editor').getContent()
		var keyWord = $("#keyWord").val();
		if (title == null || title == '') {
			alert("请输入标题！");
		} else if (blogTypeId == null || blogTypeId == '') {
			alert("请选择博客类别！");
		} else if (content == null || content == '') {
			alert("请填写内容！");
		} else {
			$.post("${pageContext.request.contextPath}/admin/blog/insert.do", {
				'title' : title,
				'blogType.id' : blogTypeId,
				'content' : content,
				'summary' : UE.getEditor('editor').getContentTxt().substr(0,
						155),
				'keyword' : keyWord,
				'userInfo.id' : "${loginUserInfo.id }"
			}, function(result) {
				if (result.success) {
					alert("博客发布成功！");
					resultValue();
				} else {
					alert("博客发布失败！");
				}
			}, "json");
		}
	}

	function resultValue() {
		$("#title").val("");
		$("#blogTypeId").combobox("setValue", "");
		UE.getEditor('editor').setContent('');
		$("#keyWord").val("");
	}
</script>
</head>
<body style="margin: 10px">

	<div id="p" class="easyui-panel" title="写博客" style="padding: 10px">
		<table cellspacing="20px">
			<tr>
				<td>博客标题：</td>
				<td><input type="text" id="title" name="title"
					style="width: 400px" /></td>
			</tr>
			<tr>
				<td>所属类别：</td>
				<td><select class="easyui-combobox" style="width: 154px"
					id="blogTypeId" name="blogType.id" editable="false"
					panelHeight="auto">
						<option value="">请选择博客类别...</option>
						<c:forEach var="blogType" items="${blogTypeEntites }">
							<option value="${blogType.id }">${blogType.typeName }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td valign="top">博客内容：</td>
				<td><script id="editor" name="content" type="text/plain"
						></script></td>
			</tr>
			<tr>
				<td>关键字：</td>
				<td><input type="text" id="keyWord" name="keyWord"
					style="width: 400px" />&nbsp;(多个关键字中间用空格隔开)</td>
			</tr>
			<tr>
				<td></td>
				<td><a href="javascript:submitData()" class="easyui-linkbutton"
					data-options="iconCls:'icon-submit'">发布博客</a></td>
			</tr>
		</table>
	</div>

	<!-- 实例化编辑器 -->
	<script type="text/javascript">
		var ue = UE.getEditor('editor');
	</script>
</body>
</html>
