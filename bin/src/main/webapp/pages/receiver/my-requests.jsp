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
	<div class="container mt-5">
		<div class="row">
            <div class="col-lg-12">
                <h1>Your Requests</h1>
                <hr class="mb-5">
            </div>
        </div>
        
        <div class="row">
            <div class="col">
                <form action="" method="POST" enctype="multipart/form-data">
                    <div class="form-row">
                        <div class="col">
                            <div id="bulkOptionContainer" class="form-group">
                                <select class="form-control" name="bulk_options" id="bulk_options">
                                    <option disabled hidden selected>Select Options</option>
                                    <option value="Delete">Delete</option>
                                </select>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-success" value="Apply">
                                <a href="/panding-donation" class="btn btn-primary">Add New</a>
                            </div>
                        </div>
                    </div>

                    <div class="table-responsive">
                        <table class="table table-hover table-bordered">
                            <thead>
                                <tr>
                                    <th><input id="selectAllBoxes" type="checkbox"></th>
                                    <th>Donation Request</th>
                                    <th><i class="fa fa-eye"></i></th>
                                    <th>Status</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${myAcceptRequests}" var="myRequest"> 
                                <tr>
                                    <td><input class="checkBoxes" type="checkbox" name="checkBoxArray[]" value="${myRequest.acceptId}"></td>
                                    <td>${myRequest.donationRequest.typeOfRequest}</td>
                                    <td><a href="#" data-toggle="modal" data-target="#view-donation-${myRequest.donationRequest.requestId}"><i class="fa fa-eye"></i></a></td>
                                    <td>${myRequest.status}</td>
                                    <td><button class="btn btn-danger">Delete</button></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </form>
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
	                                <td>${myRequest.donationRequest.user.name}</td>
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
	                                <td><a href="tel:${myRequest.donationRequest.user.contact}">${myRequest.donationRequest.user.contact}</a></td>
	                            </tr>
	                            <tr class="table-danger">
	                                <td>Email</td>
	                                <td><a href="mailto:${myRequest.donationRequest.user.email}">${myRequest.donationRequest.user.email}</a></td>
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
	      
    </div>  <!-- /.container -->
    
    <!-- footer -->
    <%@ include file="/pages/include/footer.html" %>

</body>

</html>