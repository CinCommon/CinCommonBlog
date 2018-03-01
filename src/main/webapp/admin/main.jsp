<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理_CinCommon</title>
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
	function openTab(text, url, iconCls) {
		if ($("#tabs").tabs("exists", text)) {
			$("#tabs").tabs("select", text);
		} else {
			var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='/admin/"
					+ url + "'></iframe>";
			$("#tabs").tabs("add", {
				title : text,
				iconCls : iconCls,
				closable : true,
				content : content
			});
		}
	}
</script>
</head>
<body class="easyui-layout">
	<div region="north" style="height: 78px; background-color: #E0ECFF">
		<table style="padding: 5px" width="100%">
			<tr>
				<td width="50%"><div style="cursor: pointer"
						onclick="location='${pageContext.request.contextPath}/index.html'">
						<img alt="logo" src="/static/images/logo.png">
					</div></td>
				<td valign="bottom" align="right" width="50%"><font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>${loginUserInfo.userName }</font>
				</td>
			</tr>
		</table>
	</div>
	<div region="center">
		<div class="easyui-tabs" fit="true" border="false" id="tabs">
			<div title="首页" data-options="iconCls:'icon-home'">
				<div style="padding: 10px">
					<div id="p" class="easyui-panel" title="博主信息"
						style="width: 500px; height: 150px; padding: 10px; background: #fafafa;"
						data-options="iconCls:'icon-save'">
						<p>你好! ${loginUserInfo.userName }</p>
						<p>你好! 你已成为博主666天</p>
					</div>
				</div>
				<div style="padding: 10px">
					<div id="p" class="easyui-panel" title="博客信息"
						style="width: 500px; height: 150px; padding: 10px; background: #fafafa;"
						data-options="iconCls:'icon-save'">
						<p>你已发布666篇博客</p>
					</div>
				</div>
				<div style="padding: 10px">
					<div id="p" class="easyui-panel" title="评论信息"
						style="width: 500px; height: 150px; padding: 10px; background: #fafafa;"
						data-options="iconCls:'icon-save'">
						<p>你累计收到666条评论.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div region="west" style="width: 200px" title="导航菜单" split="true">
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<div title="常用操作" data-options="selected:true,iconCls:'icon-item'"
				style="padding: 10px">
				<a href="javascript:openTab('写博客','writeBlog.jsp','icon-writeblog')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-writeblog'"
					style="width: 150px">写博客</a> <a
					href="javascript:openTab('评论审核','commentReview.jsp','icon-review')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-review'"
					style="width: 150px">评论审核</a>
			</div>
			<div title="博客管理" data-options="iconCls:'icon-bkgl'"
				style="padding: 10px;">
				<a href="javascript:openTab('写博客','writeBlog.jsp','icon-writeblog')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-writeblog'"
					style="width: 150px;">写博客</a> <a
					href="javascript:openTab('博客信息管理','blogManage.jsp','icon-bkgl')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-bkgl'" style="width: 150px;">博客信息管理</a>
				<a
					href="javascript:openTab('博客类别信息管理','blogTypeManage.jsp','icon-bklb')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">博客类别信息管理</a>
			</div>
			<div title="评论管理" data-options="iconCls:'icon-plgl'"
				style="padding: 10px">
				<a
					href="javascript:openTab('评论审核','commentReview.jsp','icon-review')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-review'"
					style="width: 150px">评论审核</a> <a
					href="javascript:openTab('评论信息管理','commentManage.jsp','icon-plgl')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-plgl'" style="width: 150px;">评论信息管理</a>
			</div>
			<div title="其他管理" data-options="iconCls:'icon-grxx'"
				style="padding: 10px">
				<a
					href="javascript:openTab('修改个人信息','modifyInfo.jsp','icon-grxxxg')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-grxxxg'"
					style="width: 150px;">修改个人信息</a>
				<a href="javascript:openTab('友情链接管理','linkManage.jsp','icon-link')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-link'" style="width: 150px">友情链接管理</a>
			</div>
			<div title="系统管理" data-options="iconCls:'icon-system'"
				style="padding: 10px">
<!-- 				<a HREF="JAVASCRIPT:OPENPASSWORDMODIFYDIALOG()"
					CLASS="EASYUI-LINKBUTTON"
					DATA-OPTIONS="PLAIN:TRUE,ICONCLS:'ICON-MODIFYPASSWORD'"
					style="width: 150px;">修改密码</a>  -->
					<a href="javascript:refreshSystem()"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-refresh'"
					style="width: 150px;">刷新系统缓存</a> <a href="javascript:logout()"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-exit'" style="width: 150px;">安全退出</a>
			</div>
		</div>
	</div>
	<div region="south" style="height: 25px; padding: 5px" align="center">
		<!-- <div align="center" style="padding-top: 120px"> -->
			<span style="float: left;">Powered by <a
				href="${pageContext.servletContext.contextPath }/index.html"
				target="_blank">CinCommon</a> V0.1
			</span> Copyright © CinCommon
		<!-- </div> -->
	</div>
</body>
</html>