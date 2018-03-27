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
				url = "${pageContext.request.contextPath}/admin/link/update.do" + "?id="+rowData.id,
				$("#dlg").dialog("open").dialog("setTitle", "修改友情链接");
				$("#fm").form("load", rowData);
			}
		});
	}
	
	var url;
	function createLink() {
		$("#dlg").dialog("open").dialog("setTitle", "修改友情链接");
		url = "${pageContext.request.contextPath}/admin/link/save.do";
	}
	
	function save(){
		$('#fm').form('submit', {
			url: url, 
			onSubmit: function() {
				return $(this).form("validate");			
			},
			success: function (data) {
				$.messager.alert("系统提示", "保存成功!");
				resetValue();			
				$("#dlg").dialog("close");
				$("#dg").datagrid("reload");
			}
		});
	}
	
	function deleteLink() {
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].id);
		}
		
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
		fit="true" toolbar="#tb" checkOnSelect="false">
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
		style="text-align: center; width: 500px; padding: 10px 20px"
		closed="true" buttons="#dlg-buttons" toolbar="#tb">
		<form id="fm" method="post">
			<table>
				<tr>
					<td style="text-align: right;">链接名:</td>
					<td style="width: 150px;"><input type="text"
						class="easyui-validatebox" id="linkName" name="linkName"
						data-options="required:true"></td>
				</tr>
				<tr>
					<td style="text-align: right;">链接地址:</td>
					<td style="width: 150px;"><input type="text"
						class="easyui-validatebox" id="linkUrl" name="linkUrl"
						data-options="required:true,validType:'url'"></td>
				</tr>
				<tr>
					<td style="text-align: right;">排列序号:</td>
					<td style="width: 150px;"><input type="text"
						class="easyui-validatebox" id="linkOrder" name="linkOrder"
						data-options="required:true,validType:'number'"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:save()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	    <a href="javascript:close()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	<div id="tb">
		<a href="javascript:createLink()" class="easyui-linkbutton" plain=true iconCls="icon-add">新建</a>
	    <a href="javascript:deleteLink()" class="easyui-linkbutton" plain=true iconCls="icon-cancel">删除</a>		
	</div>
</body>
</html>