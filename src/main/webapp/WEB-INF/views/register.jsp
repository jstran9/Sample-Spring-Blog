<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head> 
	<title>Registration Page</title>
	<%@ include file = "styleInclude.jsp"%>
	<%@ include file = "validationInclude.jsp"%>
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
    	<form class="form-signin" action = "<c:url value="/processRegistration"/>" method="post" data-parsley-validate>
			<h2 class="form-signin-heading">Register below!</h2>
			<input type="text" id = "userName" name="userName" class="form-control" placeholder="enter user name" maxlength = "35" data-parsley-usernamecheck="^[a-z0-9_-]{6,35}$" onfocusout = "checkForUserName()" data-parsley-required novalidate/>
				<div class = "form-control" id = "userNameError"></div>
			<input type="password" id = "password" name="password" class="form-control" placeholder="password" maxlength = "20" data-parsley-passwordcheck = "((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])(?!.*\\s).{6,20})" 
    		data-parsley-required="true" novalidate/>
	       	<input type="password" name="validatePassword" class="form-control" placeholder="enter password again" maxlength = "20" data-parsley-equalto="#password"
 			data-parsley-error-message="Passwords must match!" data-parsley-required novalidate/>
			<button class="btn btn-lg btn-primary btn-block" type="submit" id = "register">Register user!</button>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<c:if test="${error != null}">
				<br/>
    			<div class = "form-control" id = "infoField">${error}</div>
			</c:if>
      </form>
    </div> <!-- /container -->
    
</body>
</html>

