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
// 	$('#dg').datagrid({    
// 	    columns:[[
// 	        {field:'code',title:'Code',width:100},    
// 	        {field:'name',title:'Name',width:100},    
// 	        {field:'price',title:'Price',width:100,align:'right'}    
// 	    ]]    
// 	}); 
	
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
	<input class="easyui-textbox" data-options="iconCls:'icon-search'" style="margin: 5px; width:200px" /> 
	<a href="" iconCls="icon-search" class="easyui-linkbutton" >搜索</a>
</div>
</body>
</html>