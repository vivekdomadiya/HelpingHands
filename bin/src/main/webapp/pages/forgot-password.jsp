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
    <div class="container mt-5">
        <h1>Forget Password</h1>
        <hr class="mb-5">

        <div class="row">
            <div class="col-lg-4 col-md-6 text-center mx-auto">
                    <h3><i class="fa fa-lock fa-4x"></i></h3>
                    <h2 class="text-center">Forgot Password?</h2>
                    <p>You can reset your password here.</p>
                    
                    <c:if test="${error}">
                    <div class="alert alert-danger">No account found with this email.<br><a class="link" href="/sign-up">sign up here</a>.</div>
                    </c:if>

                    <form id="forgetPassForm" role="form" autocomplete="off" class="form" method="POST" action="" enctype="multipart/form-data">

                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-envelope color-blue"></i></span>
                                </div> 
                                <input id="email" name="email" placeholder="email address" class="form-control"  type="email" autofocus required>
                            </div>
                            <span class="errorTxt"></span>
                        </div>
                        <div class="form-group">
                            <input name="reset_password" class="btn btn-lg btn-primary btn-block" value="Reset Password" type="submit">
                        </div>
                    </form>  <!-- /.form -->
                    
                    <c:if test="${success}">
                    <div class="alert alert-success">Reset Password link sent to your email address.<br>Please Check your email.</div>
                    </c:if>
            </div>
        </div>  <!-- /.row -->
    </div>  <!-- /.container -->

    <!-- footer -->
	<%@ include file="include/footer.html" %>

</body>

</html>