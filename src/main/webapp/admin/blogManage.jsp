<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	
	function formatTitle(val,row){
		return "<a target='_blank' href='${pageContext.request.contextPath}/articles/"+row.id+".html'>"+val+"</a>";
	}
	
	function formatBlogType(val,row){
		return val.typeName;
	}
	
	function formatDate(val,row){
		var date = new Date(val);
		return date.getFullYear()+"-"+(date.getMonth() + 1) +"-"+date.getDate();
	}
	
	function searchBlog(){
		$("#dg").datagrid('load',{
			"title":$("#s_title").val()
		});
	}
	function showSystemAlert(msg) {
		$.messager.alert("系统提示", msg)
	}
	
	function openBlogModifyTab() {
		
	}
	
	function deleteBlog(){
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length==0){
			showSystemAlert("请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].id);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确定要删除这"+selectedRows.length+"条数据吗？",function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/admin/blog/deleteBlog.do",{ids:ids},function(result){
					if(result.success){
						showSystemAlert("数据已成功删除！");
						$("#dg").datagrid("reload");
					}else{
						showSystemAlert("数据删除失败！");
					}
				},"json");
			}
		});
	}
	
		function openBlogModifyTab(){
			var selectedRows=$("#dg").datagrid("getSelections");
			if(selectedRows.length!=1){
				showSystemAlert("请选择一个要修改的博客！");
				return;
			}
			var row=selectedRows[0];
			window.parent.openTab('修改博客','modifyBlog.jsp?id='+row.id,'icon-writeblog');
		}
</script>
<title>博客一览</title>
</head>
<body>
<table id="dg" title="博客管理" class="easyui-datagrid" 
  fitColumns="true" pagination="true" rownumbers="true"
  url="${pageContext.request.contextPath}/admin/blog/querypageBlogs.do" fit="true" toolbar="#tb">
  <thead>
  	<tr>
  		<th field="cb" checkbox="true" align="center"></th>
  		<th field="id" width="20" align="center">编号</th>
  		<th field="title" width="200" align="center" formatter="formatTitle">标题</th>
  		<th field="releaseDate" width="50" align="center" formatter="formatDate">发布日期</th>
  		<th field="blogType" width="50" align="center" formatter="formatBlogType">博客类型</th>
  	</tr>
  </thead>
</table>
<div id="tb">
	<a href="javascript:openBlogModifyTab()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
	<a href="javascript:deleteBlog()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
	<input id="s_title" class="easyui-textbox" data-options="iconCls:'icon-search'" style="margin: 5px; width:200px" onkeydown="if(event.keyCode==13) searchBlog()" /> 
	<a href="javascript: searchBlog()" iconCls="icon-search" class="easyui-linkbutton" >搜索</a>
</div>
</body>
</html>