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
        <h1>Edit Prifile</h1>
        <hr class="mb-5">

        <div class="row">
            <div class="col-sm-6 mx-auto">

                <!-- form -->
                <form id="editProfileForm" class="customForm" action="/edit-profile" method="POST" enctype="multipart/form-data">

                    <div class="form-group">
                        <label for="name">Name: <font color="red">*</font></label>
                        <input type="text" class="form-control" id="name" placeholder="Enter Name" value="${user.name}" name="name" required autofocus>
                    </div>

                    <div class="form-group">
                        <label for="email">Email Id: <font color="red">*</font></label>
                        <input type="email" class="form-control" id="email" placeholder="Enter Email Id" value="${user.email}" name="email"
                            required>
                    </div>

                    <div class="form-group">
                        <label for="contact">Contact Number: <font color="red">*</font></label>
                        <input type="number" class="form-control" id="contact" placeholder="Enter Contact Number"
                            name="contact" value="${user.contact}" maxlength="10" required>
                    </div>

                    <div class="form-group">
                        <label for="address">Address: <font color="red">*</font></label>
                        <input type="text" class="form-control" name="addL1" id="addL1" value="${user.addL1}" placeholder="Address Line 1" required>
                        <input type="text" class="form-control mt-2" name="addL2" id="addL2" value="${user.addL2}" placeholder="Address Line 2" required>
                        <select class="form-control mt-2" name="state" id="state" value="${user.state}" required></select>
                        <select class="form-control mt-2" name="city" id="city" value="${user.city}" required></select>
                        <input type="number" class="form-control mt-2" name="pinCode" id="pinCode" placeholder="Postal Code" value="${user.pinCode}" required>
                    </div>

                    <div class="form-group text-center">
                        <input class="btn btn-success" type="submit" value="Update Profile">
                    </div>

                </form> <!-- /.form -->
            </div>
        </div> <!-- /.row -->
    </div> <!-- /.container -->

    <!-- footer -->
    <%@ include file="include/footer.html" %>
    
    <script type="text/javascript">
		$(document).ready(function() {
			$("#state").val("${user.state}");
			$("#city").val("${user.city}");
		});
    </script>

</body>

</html>