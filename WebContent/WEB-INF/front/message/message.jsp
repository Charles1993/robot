<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String bath = request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>机器人指令回复页面展示</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link rel="stylesheet" href="<%=bath%>/resources/css/bootstrap.min.css">
<script src="<%=bath%>/resources/js/jquery.min.js"></script>
<script src="<%=bath%>/resources/js/bootstrap.min.js"></script>

</head>
<body>
<%=bath%>
	<div class="container_fluid">
		<div class="row">
			<div class="col-lg-7"></div>
      <div>
				<c:if test="${currentUser!=null}">
					<a>${currentUser.userName}</a>
				</c:if>
			</div>
			<div class="col-lg-5">
				<form action="<%=bath%>/message.action" class="form-inline">
					<div class="form-group">
						<label for="command">指令：</label> <input type="text" name="command"
							id="command" placeholder="请输入指令" value="${command}">
					</div>

					<div class="form-group">
						<label for="contend">内容：</label> <input type="text" name="contend"
							id="contend" placeholder="请输入内容" value="${contend}">
					</div>
					<button type="submit" class="success">查询</button>
				</form>

			</div>
		</div>
		<div class="row-fluid">
			<div class="span12">
				<div class="table-responsive">
					<table class="table">
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
			</div>
		</div>
	</div>
</body>
</html>