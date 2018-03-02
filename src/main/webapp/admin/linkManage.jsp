<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<script type="text/javascript">
	window.onload = function() {
		$('#dg').datagrid({
			onClickRow : function(rowIndex, rowData) {
				$("#dlg").dialog("open").dialog("setTitle", "修改友情链接");
				$("#fm").form("load", rowData);
			}
		});
		$('#fm').form('submit', {
			url : "${pageContext.request.contextPath}",
			onSubmit : function() {

			},
			success : function(data) {
// 				alert(data)
			}
		});
	}

	function close() {
		$("#dlg").dialog("close");
		resetValue();
	}

	function resetValue() {
		$("#linkName").val("");
		$("#linkUrl").val("");
		$("#linkOrder").val("");
	}
</script>
<title>友情链接管理</title>
</head>
<body>
	<table id="dg" title="友情链接管理" class="easyui-datagrid" fitColumns="true"
		pagination="true"
		url="${pageContext.request.contextPath}/admin/link/queryPageLinks.do"
		fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="id" width="20" align="center">编号</th>
				<th field="linkName" width="20" align="center">链接名</th>
				<th field="linkUrl" width="20" align="center">链接地址</th>
				<th field="linkOrder" width="20" align="center">排列序号</th>
			</tr>
		</thead>
	</table>

	<div id="dlg" class="easyui-dialog"
		style="text-align:'center'; width: 500px; height: 180px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table>
				<tr>
					<td>链接名
					<td>
					<td><input type="text" class="easyui-validatebox"
						id="linkName" name="linkName" data-options="required:true">
					<td>
				</tr>
				<tr>
					<td>链接地址
					<td>
					<td><input type="text" class="easyui-validatebox" id="linkUrl"
						name="linkUrl" data-options="required:true,validType:'url'">
					<td>
				</tr>
				<tr>
					<td>排列序号
					<td>
					<td><input type="text" class="easyui-validatebox"
						id="linkOrder" name="linkOrder"
						data-options="required:true,validType:'number'">
					<td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:save()" class="easyui-linkbutton"
			iconCls="icon-ok">保存</a> <a href="javascript:close()"
			class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>

</body>
</html>