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
    
        <h1>Change Password</h1>
        <hr class="mb-5">

        <c:if test="${linkBroken}">
	      	<div class="alert alert-danger">
	      		Oops!  Link is Invalid or Broken.
	      	</div>
	    </c:if>
        
        <c:if test="${!linkBroken}">

        <div class="row">
            <div class="col-md-6 col-lg-4 mx-auto">

				<!-- form -->
				<form method="POST" id="resetPasswordForm" action="/reset-password" enctype="multipart/form-data">
	                   
                    <div class="form-group">
                        <label for="newPassword">New Password:</label>
                        <input class="form-control" type="password" name="password" id="password" maxlength="32" required>
                    </div>

                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password:</label>
                        <input class="form-control" type="password" name="confirmPassword" id="confirmPassword" maxlength="32" required>
                    </div>
                   
                    <input class="form-control" type="hidden" value="${param.token}" name="token" id="token" maxlength="32" required>
                    

                    <div class="form-group text-center">
                        <input class="btn btn-success" type="submit" value="Save Changes">
                    </div>
                </form>   <!-- /.form -->
			</div>
        </div> <!-- /.row -->
        </c:if>
    </div> <!-- /.container -->

    <!-- footer -->
    <%@ include file="include/footer.html" %>

</body>

</html>