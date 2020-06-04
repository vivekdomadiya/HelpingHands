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
        <h1>Panding Donations</h1>
        <hr class="mb-5">

        <div class="row">
        
        	<c:forEach items="${donations}" var="donation">

            <div class="col-lg-3 col-md-5 mx-auto">
				<div class="single-request">
					<div class="profile">
						<div class="image">
							<div class="circle-1"></div>
							<div class="circle-2"></div>
							<i class="fas fa-hand-holding-heart icon"></i>
						</div>

						<div class="name">${donation.typeOfRequest}</div>
						<div class="date">Post Date: <fmt:formatDate pattern="MMMM dd, yyyy" value="${donation.appliedDate}" /></div>
					</div>
					<div class="request-info-area">
                        <ul>
                            <li>
                                <i class="fa fa-object-group"></i>
                                <span class="float-right">${donation.nameOfRequest}</span>
                            </li>
                            <li>
                                <i class="fa fa-gift"></i>
                                <span class="float-right">Quantity: ${donation.quantity}</span>
                            </li>
                            <li>
                                <i class="fa fa-calendar"></i><span class="float-right"><fmt:formatDate pattern="MMMM dd, yyyy" value="${donation.dateOfDonate}" /></span>
                            </li>
                            <li>
                                <i class="fas fa-truck-pickup"></i><span class="float-right">${donation.typeOfTransoprt}</span>
                            </li>
                        </ul>
                    </div>
                    <div class="mt-3 text-center">
                        <button class="btn btn-info" data-toggle="modal" data-target="#view-donation-${donation.requestId}">Details</button>
                    </div>
				</div>
            </div>
            
            <!-- modal View Donation Request -->
	        <div class="modal fade" id="view-donation-${donation.requestId}" tabindex="-1" role="dialog" aria-labelledby="view-donation_title" aria-hidden="true">
	             <div class="modal-dialog" role="document">
	               <div class="modal-content">
	                 <div class="modal-header">
	                   <h4 class="modal-title" id="view-donation_title">${donation.typeOfRequest}</h4>
	                   <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                     <span aria-hidden="true">&times;</span>
	                   </button>
	                 </div>  <!-- \. modal header -->
	
	                 <div class="modal-body">
	                     
				        <small>Post Date: <fmt:formatDate pattern="MMMM dd, yyyy" value="${donation.appliedDate}" /></small>
				        <hr class="mb-5">
	
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
	                    <form id="acceptRequestForm" action="/receiver/accept-request" method="POST" enctype="multipart/form-data">
							
							<input type="hidden" name="donationRequestId" value="${donation.requestId}">

		                    <div class="form-group">
		                        <label for="details">How to use it? <font color="red">*</font></label>
		                        <textarea class="form-control" name="howToUse" id="howToUse" rows="5" required></textarea>
		                    </div>
		
		                    <div class="form-group text-center">
		                        <input id="requestAccept" type="submit"  class="btn btn-success" name="requestAccept" value="Request Accept">
		                    </div>
		
						</form>   <!-- /.form -->
	                 </div>  <!--/.modal-body-->
	               </div>  <!--/.modal-content-->
	             </div>  <!--/.modal-dialog-->
	         </div>
	              
            </c:forEach>

        </div> <!-- /.row -->

        <%@ include file="/pages/include/pagination.jsp" %>
      
        
    </div> <!-- /.container -->

    <!-- footer -->
    <%@ include file="/pages/include/footer.html" %>

</body>

</html>