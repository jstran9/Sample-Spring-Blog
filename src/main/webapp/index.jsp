<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>Table Of Contents Page</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/home.css"/>" type="text/css">
</head>
<body>
	<h2>Welcome, your table of contents is below. </h2>
	<ol>
		<li><a href="${pageContext.request.contextPath}/showPosts">Show Posts</a></li>
		<li><a href="${pageContext.request.contextPath}/register">Go to registration page</a></li>
		<li><a href="${pageContext.request.contextPath}/signin">Go to login</a></li>
	</ol>
</body>
</html>
