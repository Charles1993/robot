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
<script
	src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>
<script
	src="https://apps.bdimg.com/libs/angular-route/1.3.13/angular-route.js"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

html, body {
	overflow: hidden;
	width: 100%;
	height: 100%;
}

.top {
	width: 100%;
	height: 30px;
}

.con {
	position: relative;
	width: 100%;
	height: 100%;
}

.left, .right {
	position: absolute;
	top: 0;
	bottom: 0;
	_height: 100%;
}

.left {
	width: 200px;
	left: 0;
	background: #eee;
}

.right {
	left: 0;
	right: 0;
	margin-left: 200px;
	/* 	background: #999; */
	_width: 100%
}
</style>
</head>

<body ng-app='routingDemoApp'>
	<div class="top">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a rel="nofollow" href="#">首页</a></li>
					<li><a rel="nofollow" href="#">关于我们</a></li>
					<li class="active">公司简介</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="con">
		<div class="left">
			<div class="container">
				<div class="row" style="position:relative;left:100px;top:100px;margin-top:-80px;margin-left:-80px;">
					<div class="col-md-12 column">
						<div class="side-left" id="sideMenu">
							<div class="bd">
								<ul class="menuList">
									<li><a rel="nofollow" href="#/">机器回复列表</a></li>
									<li><a rel="nofollow" href="#/computers">企业文化</a></li>
									<li><a rel="nofollow" href="#/printers">组织结构</a></li>
									<li><a rel="nofollow" href="#/blabla">资质认证</a></li>
									<li><a rel="nofollow" href="">联系我们</a></li>
								</ul>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		<div class="right">
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
								<label for="command">指令：</label> <input type="text"
									name="command" id="command" placeholder="请输入指令"
									value="${command}">
							</div>

							<div class="form-group">
								<label for="contend">内容：</label> <input type="text"
									name="contend" id="contend" placeholder="请输入内容"
									value="${contend}">
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
			<div ng-view></div>
			<script>
				angular
						.module('routingDemoApp', [ 'ngRoute' ])
						.config(
								[
										'$routeProvider',
										function($routeProvider) {
											$routeProvider
													.when('/',
															{
																templateUrl : 'rebot/WEB-INF/front/message/mes.html'
															})
													.when('/computers', {
														template : '这是电脑分类页面'
													}).when('/printers', {
														template : '这是打印机页面'
													}).otherwise({
														redirectTo : '/'
													});
										} ]);
			</script>

		</div>
	</div>

</body>
</html>