<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head> 
	<title>Registration Page</title>
	<%@ include file = "styleInclude.jsp"%>
</head>

<body class = "body-background">
	<div class="blog-masthead">
      <div class="container">
        <nav class="blog-nav">
			<a class="blog-nav-item active" href="<c:url value="/"/>">Home!</a>
			<a class="blog-nav-item active" href="<c:url value="/showPosts"/>">View All Posts!</a>
			<a class="blog-nav-item active" href="<c:url value="/signin"/>">Login!</a>
        </nav>
      </div>
    </div>
    
    <div class="container">
    	<form class="form-signin" action = "<c:url value="/processRegistration"/>" method="post">
			<h2 class="form-signin-heading">Register below!</h2>
			<input type="text" name="userName" class="form-control" placeholder="enter user name" maxlength = "35" required/>
			<input type="password" name="password" class="form-control" placeholder="password" maxlength = "20" required/>
	       	<input type="password" name="validatePassword" class="form-control" placeholder="enter password again" maxlength = "20" required/>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Register user!</button>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<c:if test="${error != null}">
				<br/>
    			<div class = "form-control" id = "infoField">${error}</div>
			</c:if>
      </form>
    </div> <!-- /container -->
    
</body>
</html>

