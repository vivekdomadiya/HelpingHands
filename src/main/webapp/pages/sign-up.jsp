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
        <h1>Sign up</h1>
        <hr class="mb-5">

        <div class="row">
            <div class="col-sm-6 mx-auto">

                <!-- form -->
                <form id="signUpForm" class="customForm" action="/sign-up" method="POST" enctype="multipart/form-data">

                    <h2 class="form-title text-center">Registration form</h2>
                    
                    <c:if test="${error!=null}">
                   	<div class="alert alert-danger">
                   		${error}
                   	</div>
                    </c:if>

                    <div class="form-group">
                        <label for="role">Role: <font color="red">*</font></label>
                        <select class="form-control" name="role" id="role" value="${user.role}" required>
                            <option value="donor" selected>Donor</option>
                            <option value="receiver">Receiver</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="name">Name: <font color="red">*</font></label>
                        <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name" value="${user.name}" required autofocus>
                    </div>

                    <div class="form-group">
                        <label for="email">Email Id: <font color="red">*</font></label>
                        <input type="email" class="form-control" id="email" placeholder="Enter Email Id" name="email" value="${user.email}"
                            required>
                    </div>

                    <div class="form-group">
                        <label for="contact">Contact Number: <font color="red">*</font></label>
                        <input type="number" class="form-control" id="contact" placeholder="Enter Contact Number"
                            name="contact" value="${user.contact}" maxlength="10" required>
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
                        <input type="text" class="form-control" name="addL1" id="addL1" value="${user.addL1}" placeholder="Address Line 1" required>
                        <input type="text" class="form-control mt-2" name="addL2" id="addL2" value="${user.addL2}" placeholder="Address Line 2" required>
                        <select class="form-control mt-2" name="state" value="${user.state}" id="state" required></select>
                        <select class="form-control mt-2" name="city" value="${user.city}" id="city" required></select>
                        <input type="number" class="form-control mt-2" name="pinCode" value="${user.pinCode}" id="pinCode" placeholder="Postal Code" required>
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

    <script>
        if($("#role").attr("value")=="ROLE_RECEIVER")
            $("#role").val("receiver");
    </script>

</body>

</html>