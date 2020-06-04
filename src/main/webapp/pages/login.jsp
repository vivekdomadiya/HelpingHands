<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">

<head>
    <title>Helping Hands &#8211; Request and Donor management System</title>

	<%@ include file="include/header.html" %>
	
</head>

<body>

    <!-- navigation bar -->
    <%@ include file="include/navigation.jsp" %>

    <!-- contant -->
    <div class="container content">

        <c:if test="${param.msg!=null}">
        <div class="alert alert-${param.msgClass}">
            ${param.msg}
            <a href="#" class="close" data-dismiss="alert">&times;</a>
        </div>
        </c:if>

        <h1>Login</h1>
        <hr class="mb-5">

        <div class="row">
            <div class="col-md-6 col-lg-4 mx-auto">

				<!-- form -->
				<form id="loginForm" class="customForm" action="/login" method="POST" enctype="multipart/form-data">

                    <h2 class="form-title text-center">Login</h2>
                    
                    <c:if test="${param.error}">
                   	<div class="alert alert-danger">
                   		Invilid Username or Password!
                   	</div>
                    </c:if>

                    <div class="form-group">
                        <label for="username">Email Id:</label>
                        <input type="text" class="form-control" name="username" id="username" placeholder="Username" required autofocus>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control" name="password" id="password" placeholder="Password" required>
					</div>
					
					<div class="form-group">
						<label style="cursor: pointer;"><input type="checkbox" name="remember-me"> Remember Me</label>
						<a href="/forgot-password" class="float-right">Forgot Password?</a>
                    </div>

                    <div class="form-group text-center">
                        <input id="login" type="submit" name="login" value="Login" class="btn btn-success">
                    </div>

                    <div class="form-group text-center">
						Create a New Account? <a href="/sign-up">Sign up!</a>
					</div>

				</form>   <!-- /.form -->
			</div>
        </div> <!-- /.row -->
    </div> <!-- /.container -->

    <!-- footer -->
    <%@ include file="include/footer.html" %>

</body>

</html>