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
    <%@ include file="/pages/admin/include/navigation.html" %>

	<!-- contant -->
	<div class="container mt-5">

        <c:if test="${param.msg!=null}">
        <div class="alert alert-${param.msgClass}">
            ${param.msg}
            <a href="#" class="close" data-dismiss="alert">&times;</a>
        </div>
        </c:if>

		<div class="row">
            <div class="col-lg-12">
                <h1>View All donations</h1>
                <hr class="mb-5">
            </div>
        </div>
        
        <c:if test="${donationRequests.isEmpty()}">
            <h2 class="text-center">No Users Found!!</h2>
        </c:if>
        <c:if test="${!donationRequests.isEmpty()}"> 
        <div class="row">
            <div class="col">
                <div class="table-responsive">
                    <table class="table table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Name of Donor</th>
                                <th>Request</th>
                                <th>Quantity</th>
                                <th>Date</th>
                                <th>Pick UP/Drop</th>
                                <th>Address</th>
                                <th>Details</th>
                                <th>Status</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${donationRequests}" var="donation">
                            <tr>
                                <td>${donation.donor.name}</td>
                                <td>${donation.typeOfRequest} - ${donation.nameOfRequest}</td>
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
                                <td>${donation.status}</td>
                                <td>
                                    <a href="#" class="btn btn-danger openDeleteModal" data-toggle="modal" data-id="${donation.requestId}" data-target="#deleteModal">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        
        <%@ include file="/pages/include/deleteModal.html" %>

        <!-- Pagenation -->
        <%@ include file="/pages/include/pagination.jsp" %>

        </c:if>

    </div>  <!-- /.container -->
    
    <!-- footer -->
    <%@ include file="/pages/include/footer.html" %>

    <script>
        $(".openDeleteModal").click(function() {
            $("#deleteModalForm").attr("action","/admin/deleteDonation");
            $("#deleteId").val($(this).attr("data-id"));
        });
    </script>

</body>

</html>