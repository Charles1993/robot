<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String bath=request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Examples</title>
<meta name="description" content="">
<meta name="keywords" content="">

<link rel="stylesheet" href="<%=bath %>/resources/css/bootstrap.min.css">  
<script src="<%=bath %>/Wresources/js/bootstrap.min.js"></script>
</head>
<body>


<form action="/rebot/message.action"></form>

<div class="table-responsive">
<table class="table">
	<caption>上下文表格布局</caption>
	<thead>
		<tr>
			<th>id</th>
			<th>指令</th>
			<th>内容</th>
			<th>描述</th>
		</tr>
	</thead>
	<tbody>
		<tr class="active">
			<td>产品1</td>
			<td>23/11/2013</td>
			<td>待发货</td>
		</tr>
		<tr class="success">
			<td>产品2</td>
			<td>10/11/2013</td>
			<td>发货中</td>
		</tr>
		<tr  class="warning">
			<td>产品3</td>
			<td>20/10/2013</td>
			<td>待确认</td>
		</tr>
		<tr  class="danger">
			<td>产品4</td>
			<td>20/10/2013</td>
			<td>已退货</td>
		</tr>
	</tbody>
</table>

</div>  	
    
</body>
</html>