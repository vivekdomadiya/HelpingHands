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
                <h1>Panding Requests</h1>
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
	                            <th>Name of Receiver</th>
	                            <th><i class="fa fa-eye"></i></th>
	                            <th>How To Use?</th>
	                            <th>Approve</th>
	                            <th>Unapprove</th>
	                        </tr>
	                    </thead>
	                    <tbody> 
	                    <c:forEach items="${requests}" var="requests">
	                        <tr>
	                            <td>${requests.donationRequest.typeOfRequest} - ${requests.donationRequest.nameOfRequest}</td>
	                            <td>${requests.receiver.name}</td>
	                            <td><a href="#" data-toggle="modal" data-target="#view-receiver-${requests.receiver.userId}"><i class="fa fa-eye"></i></a></td>
								<td>${requests.howToUse}</td>
								<td>
									<a href="#" class="btn btn-success openApproveModal" data-toggle="modal" data-id="${requests.acceptId}" data-target="#approveModal">Approve</a>
								</td>
								<td>
									<a href="#" class="btn btn-danger openUnapproveModal" data-toggle="modal" data-id="${requests.acceptId}" data-target="#unapproveModal">Unapprove</a>
								</td>
	                            <!-- <td><button class="btn btn-success">Approve</button></td>
								<td><button class="btn btn-danger">Unapprove</button></td> -->
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
		 </c:forEach>
		 
		<%@ include file="/pages/donor/include/ApproveModal.html" %>
		<%@ include file="/pages/donor/include/UnapproveModal.html" %>
		
		</c:if>

    </div>  <!-- /.container -->
    
    <!-- footer -->
	<%@ include file="/pages/include/footer.html" %>
	
	<script>
        $(".openApproveModal").click(function() {
            $("#approveModalForm").attr("action","/donor/ApproveRequest");
            $("#approveId").val($(this).attr("data-id"));
        });

        $(".openUnapproveModal").click(function() {
            $("#unapproveModalForm").attr("action","/donor/UnapproveRequest");
            $("#unapproveId").val($(this).attr("data-id"));
        });
    </script>

</body>

</html>