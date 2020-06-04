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
        <h1>Sign up</h1>
        <hr class="mb-5">

        <div class="row">
            <div class="col-sm-6 mx-auto">

                <!-- form -->
                <form id="signUpForm" class="customForm" action="/sign-up" method="POST" enctype="multipart/form-data">

                    <h2 class="form-title text-center">Registration form</h2>

                    <div class="form-group text-center">
                        <label class="form-check-label radio-inline">
                            <input type="radio" name="role" id="donor" value="ROLE_DONOR" checked> Donor 
                        </label>
                        <label class="form-check-label radio-inline pl-3">
                            <input type="radio" name="role" id="receiver" value="ROLE_RECEIVER"> Receiver 
                        </label>
                    </div>

                    <div class="form-group">
                        <label for="name">Name: <font color="red">*</font></label>
                        <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name" required autofocus>
                    </div>

                    <div class="form-group">
                        <label for="email">Email Id: <font color="red">*</font></label>
                        <input type="email" class="form-control" id="email" placeholder="Enter Email Id" name="email"
                            required>
                    </div>

                    <div class="form-group">
                        <label for="contact">Contact Number: <font color="red">*</font></label>
                        <input type="number" class="form-control" id="contact" placeholder="Enter Contact Number"
                            name="contact" maxlength="10" required>
                    </div>

                    <div class="form-group">
                        <label for="password">Password: <font color="red">*</font></label>
                        <input type="password" class="form-control" id="password" placeholder="Enter Password"
                            name="password" maxlength="32" required>
                    </div>

                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password: <font color="red">*</font></label>
                        <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password"
                            name="confirmPassword" maxlength="32" required>
                    </div>

                    <div class="form-group">
                        <label for="address">Address: <font color="red">*</font></label>
                        <input type="text" class="form-control" name="addL1" id="addL1" placeholder="Address Line 1" required>
                        <input type="text" class="form-control mt-2" name="addL2" id="addL2" placeholder="Address Line 2" required>
                        <select class="form-control mt-2" name="state" id="state" required></select>
                        <select class="form-control mt-2" name="city" id="city" required></select>
                        <input type="number" class="form-control mt-2" name="pinCode" id="pinCode" placeholder="Postal Code" required>
                    </div>

                    <div class="form-group text-center">
                        <input class="btn btn-success" type="submit" value="Sign Up">
                    </div>

                </form> <!-- /.form -->
            </div>
        </div> <!-- /.row -->
    </div> <!-- /.container -->

    <!-- footer -->
    <%@ include file="include/footer.html" %>

</body>

</html>