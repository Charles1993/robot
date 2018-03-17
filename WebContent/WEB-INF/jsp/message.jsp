<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String bath=request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Examples</title>
<meta name="description" content="">
<meta name="keywords" content="">

<link rel="stylesheet" href="<%=bath %>/resources/css/bootstrap.min.css">  
<script src="<%=bath %>/resources/js/bootstrap.min.js"></script>
</head>
<body>


	<form action="/rebot/message.action">
	
	</form>

	<div class="table-responsive">
		<table class="table">
			<caption>机器人信回复维护列表</caption>
			<thead>
				<tr>
					<th>id</th>
					<th>指令</th>
					<th>内容</th>
					<th>描述</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${messages}" var="message" varStatus="status">
					<c:if test="${status.index % 2 != 0}">
						<tr class="success">
							<td>${status.index + 1}</td>
							<td>${message.command}</td>
							<td>${message.contend}</td>
							<td>${message.describle}</td>
						</tr>
					</c:if>
					<c:if test="${status.index % 2 != 1}">
						<tr class="warning">
							<td>${status.index + 1}</td>
							<td>${message.command}</td>
							<td>${message.contend}</td>
							<td>${message.describle}</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>