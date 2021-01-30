<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
ここはユーザーページです。<br>
<c:choose>
<c:when test="${account.role == 2 }">
登録内容の確認。
<p>ログインID：<c:out value="${account.loginId }"></c:out></p>
<p>パスワード：<c:out value="${account.pass }"></c:out></p>
<p>　　　名前：<c:out value="${account.name }"></c:out></p>
<p>　　ロール：ユーザー</p>
<p><a href="/login/Logout"><button type="button" >ログアウト</button></a></p>
<a href="admin.jsp"><button type="button" >管理者ページへ</button></a>
</c:when>
<c:when test="${account.role == 1 }">
<a href="admin.jsp">管理者ページへ</a>
</c:when>
<c:otherwise>
<a href="login.jsp">ログインページへ</a>
</c:otherwise>
</c:choose>
</body>
</html>