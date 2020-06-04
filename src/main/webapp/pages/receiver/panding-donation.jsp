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
        <h1>Panding Donations</h1>
		<hr class="mb-5">
		
		<div class="row">
			<div class="col">
				<form action="" method="get">
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label for="typeOfRequest">Type Of Request</label>
								<input type="text" class="form-control" name="typeOfRequest" id="typeOfRequest" value="${param.typeOfRequest}" placeholder="Food, Clothes..">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="nameOfRequest">Name Of Request</label>
								<input type="text" class="form-control" name="nameOfRequest" id="nameOfRequest" value="${param.nameOfRequest}" placeholder="Grain, Rice...">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="dateOfDonate">Date Of Donate</label>
								<input type="text" class="form-control" name="dateOfDonate" id="dateOfDonate" value="${param.dateOfDonate}" placeholder="dd/mm/yyyy" autocomplete="off">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label for="typeOfTransoprt">Type Of Transoprt</label>
								<select class="form-control" name="typeOfTransoprt" id="typeOfTransoprt" value="${param.typeOfTransoprt}">
									<option value="ANY" selected>ANY</option>
									<option value="PICK-UP">PICK UP</option>
									<option value="DROP">DROP</option>
								</select>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="AllCity">city</label>
								<select class="form-control" name="city" id="AllCity" value="${param.city}">
									<option value="ANY" selected>ANY</option>
								</select>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<input type="submit" class="btn btn-success btn-lg btn-block mt-md-4">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<hr class="mb-5">

		<c:if test="${donations.isEmpty()}">
			<h2 class="text-center">No Donation Request Found!!</h2>
        </c:if>
        <c:if test="${!donations.isEmpty()}"> 
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
						<a href="/receiver/donation/${donation.requestId}" class="btn btn-info">Details</a>
                    </div>
				</div>
            </div>
	              
            </c:forEach>

        </div> <!-- /.row -->

        <%@ include file="/pages/include/pagination.jsp" %>
	  
        </c:if>
        
    </div> <!-- /.container -->

    <!-- footer -->
	<%@ include file="/pages/include/footer.html" %>

	<script>
		if($("#typeOfTransoprt").attr("value")!="")
			$("#typeOfTransoprt").val($("#typeOfTransoprt").attr("value"));
		if($("#AllCity").attr("value")!="")
			$("#AllCity").val($("#AllCity").attr("value"));
	</script>

</body>

</html>