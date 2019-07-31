<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String context = request.getContextPath();
	pageContext.setAttribute("context_", context);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Manager</title>
	
	<jsp:include page="../../common/adminCommon.jsp"></jsp:include>
	
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
    
</head>
<body>
	<table id="dg-1" class="easyui-datagrid" title="列表" style="width: 700px; height: 300px"
		data-options="toolbar:'#toolbar-1',checkOnSelect:true,selectOnCheck:true,fit:true,rownumbers:true,fitColumns:true,url:'${pageContext.request.contextPath}/${moduleName}/query',method:'get',pagination:true">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'phone',width:100">手机号</th>
				<th data-options="field:'createTime',width:100,formatter: formatDate">创建时间</th>
			</tr>
		</thead>
	</table>
	
	<div id="toolbar-1">
		<a href="#" class="easyui-linkbutton add" iconCls="icon-add" plain="true">新增</a> 
		<a href="#" class="easyui-linkbutton edit" iconCls="icon-edit" plain="true">修改</a> 
		<a href="#" class="easyui-linkbutton remove" iconCls="icon-remove" plain="true">删除</a>
		<input type="text" class="queryContent" style="margin-left: 365px;">
		<a href="#" class="easyui-linkbutton search" iconCls="icon-search" plain="true" onclick="query();">查询</a>		
		<br/>
		<div class="progress" style="display: none;">
			<progress id="progressBar" value="0" max="100" style="width: 300px;"></progress>
			<span id="percentage"></span><span id="time"></span>
		</div>
		<br/>		
		<input type="file" id="file" name="myfile" />
		<a href="#" class="easyui-linkbutton upload" iconCls="icon-upload" plain="true" onclick="uploadFile();">上传</a>		
		<a href="#" class="easyui-linkbutton clear" iconCls="icon-clear" plain="true" onclick="cancleUploadFile();">取消</a>				

	</div>
	
	<div id="dlg-1" class="easyui-dialog" title="数据参数" style="z-Index: 100px;" fit="true" closed="true" buttons="#dlg-buttons-1">
		<form method="post">
			<table cellpadding="5">
				<tr>
					<td><input type="hidden" name="pid" /></td>
				</tr>
	    		<tr>
	    			<td>手机号:</td>
	    			<td><input class="easyui-textbox" id="phone" name="phone" data-options="prompt:'请输入正确的手机号码！',validType:'phoneNum',required:true" />
	    			</td>
	    		</tr>
	    	</table>
		</form>
	</div>
	
	<div id="dlg-buttons-1">
		<a href="#" class="easyui-linkbutton  save" iconCls="icon-ok">保存</a> 
		<a href="#" class="easyui-linkbutton cancel" iconCls="icon-cancel">取消</a>
	</div>
	
	<script type="text/javascript">
	
		$( function() {
			var dg1 = new DataGridEasyui(context_, 1 , templateUrl, 'crud');
						
			$.extend(dg1, {
				formLoadData:function (data){
					DataGridEasyui.prototype.formLoadData.call(this,data);					
				},
				validateForm:function (form){
					DataGridEasyui.prototype.validateForm.call(this,form);					
				}

			});
			
			dg1.init();
		});
		

		/**
		 * easyUI时间戳转日期格式
		 */
		function formatDate(value) {
			if (value == null || value == '') {
				return '';
			}
			var date = new Date(value);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
			var Y = date.getFullYear() + '-';
			var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1)
					: date.getMonth() + 1)
					+ '-';
			var D = (date.getDate() < 10 ? '0' + date.getDate() : date
					.getDate())
					+ ' ';
			var h = (date.getHours() < 10 ? '0' + date.getHours() : date
					.getHours())
					+ ':';
			var m = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date
					.getMinutes())
					+ ':';
			var s = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date
					.getSeconds());
			return Y + M + D + h + m + s;
		}
		

		/**
		 * toorbar的查询按钮
		 */
		function query() {
			$('#dg-1').datagrid('load',{
				queryContent: $('.queryContent').val(),
			});
		}
		
	</script>
	
    <!-- 上传功能 -->
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/upload/upload.js"></script>
</body>
</html>