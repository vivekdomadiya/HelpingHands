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
		<div class="row">
            <div class="col-lg-12">
                <h1>View All donations</h1>
                <hr class="mb-5">
            </div>
        </div>
        
        <div class="row">
            <div class="col">
                <div class="table-responsive">
                    <table class="table table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Name of Donor</th>
                                <th>Type</th>
                                <th>Name of request</th>
                                <th>Quantity</th>
                                <th>Date of donate</th>
                                <th>Pick UP/Drop</th>
                                <th>Address</th>
                                <th>Details</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${donationRequests}" var="donation">
                            <tr>
                                <td>${donation.user.name}</td>
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
            </div>
        </div>
        
        <%@ include file="/pages/include/deleteModal.html" %>

        <!-- Pagenation -->
        <%@ include file="/pages/include/pagination.jsp" %>

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