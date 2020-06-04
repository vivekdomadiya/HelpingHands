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
	<div class="container content">

        <c:if test="${param.msg!=null}">
        <div class="alert alert-${param.msgClass}">
            ${param.msg}
            <a href="#" class="close" data-dismiss="alert">&times;</a>
        </div>
        </c:if>

		<div class="row">
            <div class="col-lg-12">
                <h1>Panding Donation</h1>
                <hr class="mb-5">
            </div>
        </div>

        <c:if test="${myDonationRequests.isEmpty()}">
            <h2 class="text-center">No Donation Requests Found!!</h2>
        </c:if>
        <c:if test="${!myDonationRequests.isEmpty()}"> 
        <div class="row">
            <div class="col">
                <form action="/donor/panding-donation" method="POST" enctype="multipart/form-data">
                    <div class="form-row">
                        <div class="col">
                            <div id="bulkOptionContainer" class="form-group">
                                <select class="form-control" name="bulk_options" id="bulk_options">
                                    <option disabled hidden selected>Select Options</option>
                                    <option value="PICK-UP">PICK-UP</option>
                                    <option value="DROP">DROP</option>
                                    <option value="Delete">Delete</option>
                                </select>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-group">
                                <input type="submit" class="btn btn-success" value="Apply">
                                <a href="/make-donation" class="btn btn-primary">Add New</a>
                            </div>
                        </div>
                    </div>

                    <div class="table-responsive">
                        <table class="table table-hover table-bordered">
                            <thead>
                                <tr>
                                    <th><input id="selectAllBoxes" type="checkbox"></th>
                                    <th>Type</th>
                                    <th>Name</th>
                                    <th>Quantity</th>
                                    <th>Date of donate</th>
                                    <th>Pick UP/Drop</th>
                                    <th>Address</th>
                                    <th>Details</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                           	<c:forEach items="${myDonationRequests}" var="donation">
                                <tr>
                                    <td><input class="checkBoxes" type="checkbox" name="requestIdsList" value="${donation.requestId}"></td>
                                    <td>${donation.typeOfRequest}</td>
                                    <td>${donation.nameOfRequest}</td>
                                    <td>${donation.quantity}</td>
                                    <td><fmt:formatDate pattern="MMMM dd, yyyy" value="${donation.dateOfDonate}" /></td>
                                    <td>${donation.typeOfTransoprt}</td>
                                    <td>
                                        <address>
                                            ${donation.addL1}<br>
	                                        ${donation.addL2}<br>
	                                        ${donation.city}<br>
	                                        ${donation.state}-${donation.pinCode}.
                                        </address>
                                    </td>
                                    <td>${donation.details}</td>
                                    <td>
                                    	<a href="#" class="btn btn-danger openDeleteModal" data-toggle="modal" data-id="${donation.requestId}" data-target="#deleteModal">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </form>
            </div>
        </div>
        
        <%@ include file="/pages/include/deleteModal.html" %>
        </c:if>

    </div>  <!-- /.container -->
    
    <!-- footer -->
    <%@ include file="/pages/include/footer.html" %>

    <script>
        $(".openDeleteModal").click(function() {
            $("#deleteModalForm").attr("action","/donor/deleteDonation");
            $("#deleteId").val($(this).attr("data-id"));
        });
    </script>

</body>

</html>