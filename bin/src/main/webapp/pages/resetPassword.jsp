<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <h1>Change Password</h1>
        <hr class="mb-5">

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
                   
                    <input class="form-control" type="hidden" value="${token}" name="token" id="token" maxlength="32" required>
                    

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