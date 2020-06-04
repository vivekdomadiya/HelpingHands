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
                <h1>View All Requests</h1>
                <hr class="mb-5">
            </div>
        </div>
		
		<c:if test="${requests.isEmpty()}">
            <h2 class="text-center">No Requests Found!!</h2>
        </c:if>
        <c:if test="${!requests.isEmpty()}"> 
        <div class="row">
            <div class="col">

	            <div class="table-responsive">
	                <table class="table table-hover table-bordered">
	                    <thead>
	                        <tr>
								<th>Donation Request</th>
								<th><i class="fa fa-eye"></i></th>
	                            <th>Name of Receiver</th>
	                            <th><i class="fa fa-eye"></i></th>
								<th>How To Use?</th>
								<th>Status</th>
	                        </tr>
	                    </thead>
	                    <tbody> 
	                    <c:forEach items="${requests}" var="requests">
	                        <tr>
								<td>${requests.donationRequest.typeOfRequest} - ${requests.donationRequest.nameOfRequest}</td>
								<td><a href="#" data-toggle="modal" data-target="#view-donation-${requests.donationRequest.requestId}"><i class="fa fa-eye"></i></a></td>
	                            <td>${requests.receiver.name}</td>
	                            <td><a href="#" data-toggle="modal" data-target="#view-receiver-${requests.receiver.userId}"><i class="fa fa-eye"></i></a></td>
								<td>${requests.howToUse}</td>
								<td>${requests.status}</td>
	                        </tr>
	                    </c:forEach>
	                    </tbody>
	                </table>
	            </div>
	            
            </div>
        </div>
        
        <c:forEach items="${requests}" var="requests">
        <!-- modal View Donation Request -->
        <div class="modal fade" id="view-receiver-${requests.receiver.userId}" tabindex="-1" role="dialog" aria-labelledby="view-donation_title" aria-hidden="true">
             <div class="modal-dialog" role="document">
               <div class="modal-content">
                 <div class="modal-header">
                   <h4 class="modal-title" id="view-donation_title">${requests.receiver.name}</h4>
                   <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                     <span aria-hidden="true">&times;</span>
                   </button>
                 </div>  <!-- \. modal header -->

                 <div class="modal-body">
	                <div class="table-responsive">
	                    <table class="table table-hover table-bordered">
	                        <tbody class="table-info">
	                            <tr>
	                                <td>Name</td>
	                                <td>${requests.receiver.name}</td>
	                            </tr>
	                            <tr>
	                                <td>Mobile Number</td>
	                                <td><a href="tel:${requests.receiver.contact}">${requests.receiver.contact}</a></td>
	                            </tr>
	                            <tr>
	                                <td>Email</td>
	                                <td><a href="mailto:${requests.receiver.email}">${requests.receiver.email}</a></td>
	                            </tr>
	                            <tr>
	                                <td>Address</td>
	                                <td>
	                                    <address>
	                                        ${requests.receiver.addL1}<br>
	                                        ${requests.receiver.addL2}<br>
	                                        ${requests.receiver.city}<br>
	                                        ${requests.receiver.state}-${requests.receiver.pinCode}.
	                                    </address>
	                                </td>
	                            </tr>
	                        </tbody>
	                    </table>
                  	</div>
                 </div>  <!--/.modal-body-->
               </div>  <!--/.modal-content-->
             </div>  <!--/.modal-dialog-->
		 </div>
		 
		 <!-- modal View Donation Request -->
		<div class="modal fade" id="view-donation-${requests.donationRequest.requestId}" tabindex="-1" role="dialog" aria-labelledby="view-donation_title" aria-hidden="true">
			<div class="modal-dialog" role="document">
			  <div class="modal-content">
				<div class="modal-header">
				  <h4 class="modal-title" id="view-donation_title">${requests.donationRequest.typeOfRequest}</h4>
				  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				  </button>
				</div>  <!-- \. modal header -->

				<div class="modal-body">
					
				   <small>Post Date: <fmt:formatDate pattern="MMMM dd, yyyy" value="${requests.donationRequest.appliedDate}" /></small>
				   <hr class="mb-5">

				   <div class="table-responsive">
					   <table class="table table-hover table-bordered">
						   <tbody class="table-info">
							   <tr>
								   <td>Donor Name</td>
								   <td>${requests.donationRequest.donor.name}</td>
							   </tr>
							   <tr class="table-danger">
								   <td>Short Name For Item</td>
								   <td>${requests.donationRequest.nameOfRequest}</td>
							   </tr>
							   <tr>
								   <td>Quantity</td>
								   <td>${requests.donationRequest.quantity}</td>
							   </tr>
							   <tr>
								   <td>When to donate?</td>
								   <td><fmt:formatDate pattern="MMMM dd, yyyy" value="${requests.donationRequest.dateOfDonate}" /></td>
							   </tr>
							   <tr class="table-danger">
								   <td>Mobile Number</td>
								   <td><a href="tel:${requests.donationRequest.donor.contact}">${requests.donationRequest.donor.contact}</a></td>
							   </tr>
							   <tr class="table-danger">
								   <td>Email</td>
								   <td><a href="mailto:${requests.donationRequest.donor.email}">${requests.donationRequest.donor.email}</a></td>
							   </tr>
							   <tr>
								   <td>Pick UP/Drop</td>
								   <td>${requests.donationRequest.typeOfTransoprt}</td>
							   </tr>
							   <tr class="table-danger">
								   <td>Address</td>
								   <td>
									   <address>
										   ${requests.donationRequest.addL1}<br>
										   ${requests.donationRequest.addL2}<br>
										   ${requests.donationRequest.city}<br>
										   ${requests.donationRequest.state}-${requests.donationRequest.pinCode}.
									   </address>
								   </td>
							   </tr>
						   </tbody>
					   </table>
					 </div>
				</div>  <!--/.modal-body-->
			  </div>  <!--/.modal-content-->
			</div>  <!--/.modal-dialog-->
		</div>
		</c:forEach>
		
		<%@ include file="/pages/include/pagination.jsp" %>
        </c:if>

    </div>  <!-- /.container -->
    
    <!-- footer -->
    <%@ include file="/pages/include/footer.html" %>

</body>

</html>