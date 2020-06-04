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
    <%@ include file="/pages/receiver/include/navigation.html" %>

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
                <h1>Panding Requests</h1>
                <hr class="mb-5">
            </div>
        </div>
        
        <c:if test="${myAcceptRequests.isEmpty()}">
            <h2 class="text-center">No Requests Found!!</h2>
        </c:if>
        <c:if test="${!myAcceptRequests.isEmpty()}"> 
        <div class="row">
            <div class="col">
                <div class="table-responsive">
                    <table class="table table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Donation Request</th>
                                <th><i class="fa fa-eye"></i></th>
                                <th>How To Use?</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${myAcceptRequests}" var="myRequest"> 
                            <tr>
                                <td>${myRequest.donationRequest.typeOfRequest} - ${myRequest.donationRequest.nameOfRequest}</td>
                                <td><a href="#" data-toggle="modal" data-target="#view-donation-${myRequest.donationRequest.requestId}"><i class="fa fa-eye"></i></a></td>
                                <td>${myRequest.howToUse}</td>
                                <td>
                                    <a href="#" class="btn btn-danger openDeleteModal" data-toggle="modal" data-id="${myRequest.acceptId}" data-target="#deleteModal">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        
        <c:forEach items="${myAcceptRequests}" var="myRequest">
        <!-- modal View Donation Request -->
        <div class="modal fade" id="view-donation-${myRequest.donationRequest.requestId}" tabindex="-1" role="dialog" aria-labelledby="view-donation_title" aria-hidden="true">
             <div class="modal-dialog" role="document">
               <div class="modal-content">
                 <div class="modal-header">
                   <h4 class="modal-title" id="view-donation_title">${myRequest.donationRequest.typeOfRequest}</h4>
                   <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                     <span aria-hidden="true">&times;</span>
                   </button>
                 </div>  <!-- \. modal header -->

                 <div class="modal-body">
                     
			        <small>Post Date: <fmt:formatDate pattern="MMMM dd, yyyy" value="${myRequest.donationRequest.appliedDate}" /></small>
			        <hr class="mb-5">

	                <div class="table-responsive">
	                    <table class="table table-hover table-bordered">
	                        <tbody class="table-info">
	                            <tr>
	                                <td>Donor Name</td>
	                                <td>${myRequest.donationRequest.donor.name}</td>
	                            </tr>
	                            <tr class="table-danger">
	                                <td>Short Name For Item</td>
	                                <td>${myRequest.donationRequest.nameOfRequest}</td>
	                            </tr>
	                            <tr>
	                                <td>Quantity</td>
	                                <td>${myRequest.donationRequest.quantity}</td>
	                            </tr>
	                            <tr>
	                                <td>When to donate?</td>
	                                <td><fmt:formatDate pattern="MMMM dd, yyyy" value="${myRequest.donationRequest.dateOfDonate}" /></td>
	                            </tr>
	                            <tr class="table-danger">
	                                <td>Mobile Number</td>
	                                <td><a href="tel:${myRequest.donationRequest.donor.contact}">${myRequest.donationRequest.donor.contact}</a></td>
	                            </tr>
	                            <tr class="table-danger">
	                                <td>Email</td>
	                                <td><a href="mailto:${myRequest.donationRequest.donor.email}">${myRequest.donationRequest.donor.email}</a></td>
	                            </tr>
	                            <tr>
	                                <td>Pick UP/Drop</td>
	                                <td>${myRequest.donationRequest.typeOfTransoprt}</td>
	                            </tr>
	                            <tr class="table-danger">
	                                <td>Address</td>
	                                <td>
	                                    <address>
	                                        ${myRequest.donationRequest.addL1}<br>
	                                        ${myRequest.donationRequest.addL2}<br>
	                                        ${myRequest.donationRequest.city}<br>
	                                        ${myRequest.donationRequest.state}-${myRequest.donationRequest.pinCode}.
	                                    </address>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td>Details</td>
	                                <td>${myRequest.donationRequest.details}</td>
	                            </tr>
	                        </tbody>
	                    </table>
                  	</div>
                 </div>  <!--/.modal-body-->
               </div>  <!--/.modal-content-->
        	</div>  <!--/.modal-dialog-->
        </div>
        </c:forEach>
        
        <%@ include file="/pages/include/deleteModal.html" %>
        </c:if>
	      
    </div>  <!-- /.container -->
    
    <!-- footer -->
    <%@ include file="/pages/include/footer.html" %>

    <script>
        $(".openDeleteModal").click(function() {
            $("#deleteModalForm").attr("action","/receiver/deleteRequest");
            $("#deleteId").val($(this).attr("data-id"));
        });
    </script>

</body>

</html>