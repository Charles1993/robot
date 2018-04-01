<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: duke
  Date: 2018/3/19
  Time: 下午11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
    <div>
        <div>
            <c:if test="${currentUser!=null}">
                <a>${currentUser.userName}</a>
            </c:if>
        </div>
        <div>
            <table border="1px">
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>userName</td>
                        <td>passWord</td>
                        <td>account</td>
                        <td>chineseName</td>
                    </tr>
                </thead>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.userName}</td>
                        <td>${user.passWord}</td>
                        <td>${user.account}</td>
                        <td>${user.chineseName}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </div>

</body>
</html>
