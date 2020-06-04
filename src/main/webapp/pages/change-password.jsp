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

        <div class="row">
            <div class="col-md-6 col-lg-4 mx-auto">

				<!-- form -->
				<form method="POST" id="changePasswordForm" action="/change-password" enctype="multipart/form-data">
	                
	                <c:if test="${error}">
                   	<div class="alert alert-danger">
                   		old password does not match!
                   	</div>
                    </c:if>
	                
	                <div class="form-group">
                        <label for="oldPassword">Old Password:</label>
                        <input class="form-control" type="password" name="oldPassword" id="oldPassword" maxlength="32" required>
                    </div>
	                   
                    <div class="form-group">
                        <label for="newPassword">New Password:</label>
                        <input class="form-control" type="password" name="newPassword" id="newPassword" maxlength="32" required>
                    </div>

                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password:</label>
                        <input class="form-control" type="password" name="confirmPassword" id="confirmPassword" maxlength="32" required>
                    </div>
                   
                    <div class="form-group text-center">
                        <input class="btn btn-success" type="submit" value="Save Changes">
                    </div>
                    
                </form>   <!-- /.form -->
			</div>
        </div> <!-- /.row -->
    </div> <!-- /.container -->

    <!-- footer -->
    <%@ include file="include/footer.html" %>

</body>

</html>