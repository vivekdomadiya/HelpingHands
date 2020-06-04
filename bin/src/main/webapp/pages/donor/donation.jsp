<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en-US">

<head>
    <title>Helping Hands &#8211; Request and Donor management System</title>

	<%@ include file="/pages/include/header.html" %>
	
</head>

<body>

    <!-- navigation bar -->
    <%@ include file="/pages/donor/include/navigation.html" %>

    <!-- contant -->
    <div class="container mt-5">
        <h1>${donation.typeOfRequest}</h1>
        <small>Post Date: <fmt:formatDate pattern="MMMM dd, yyyy" value="${donation.appliedDate}" /></small>
        <hr class="mb-5">

        <div class="row">
            <div class="col-sm-8 mx-auto">
                <div class="table-responsive">
                    <table class="table table-hover table-bordered">
                        <tbody class="table-info">
                            <tr>
                                <td>Donor Name</td>
                                <td>${donation.user.name}</td>
                            </tr>
                            <tr class="table-danger">
                                <td>Short Name For Item</td>
                                <td>${donation.nameOfRequest}</td>
                            </tr>
                            <tr>
                                <td>Quantity</td>
                                <td>${donation.quantity}</td>
                            </tr>
                            <tr>
                                <td>When to donate?</td>
                                <td><fmt:formatDate pattern="MMMM dd, yyyy" value="${donation.dateOfDonate}" /></td>
                            </tr>
                            <tr class="table-danger">
                                <td>Mobile Number</td>
                                <td><a href="tel:${donation.user.contact}">${donation.user.contact}</a></td>
                            </tr>
                            <tr class="table-danger">
                                <td>Email</td>
                                <td><a href="mailto:${donation.user.email}">${donation.user.email}</a></td>
                            </tr>
                            <tr>
                                <td>Pick UP/Drop</td>
                                <td>${donation.typeOfTransoprt}</td>
                            </tr>
                            <tr class="table-danger">
                                <td>Address</td>
                                <td>
                                    <address>
                                        ${donation.addL1}<br>
                                        ${donation.addL2}<br>
                                        ${donation.city}<br>
                                        ${donation.state}-${donation.pinCode}.
                                    </address>
                                </td>
                            </tr>
                            <tr>
                                <td>Details</td>
                                <td>${donation.details}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div> <!-- /.row -->
    </div> <!-- /.container -->

    <!-- footer -->
	<%@ include file="/pages/include/footer.html" %>

</body>

</html>