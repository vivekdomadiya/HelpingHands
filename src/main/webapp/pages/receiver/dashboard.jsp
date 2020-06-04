<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                <h1>Welcome to Dashboard</h1>
                <hr class="mb-5">
            </div>
        </div>

        <div class="row text-center">

            <div class="dashboard-card col-lg-3 mx-auto bg-success">
                <p class="icon"><i class="far fa-file-alt"></i></p>
                <h3>${count.countPandingRequest}</h3>
                <p class="cardstatus"><strong>Pending Request</strong></p>
            </div>

            <div class="dashboard-card col-lg-3 mx-auto bg-success">
                <p class="icon"><i class="far fa-file-alt"></i></p>
                <h3>${count.countApprovedRequest}</h3>
                <p class="cardstatus"><strong>Approved Request</strong></p>
            </div>

            <div class="dashboard-card col-lg-3 mx-auto bg-success">
                <p class="icon"><i class="far fa-address-card"></i></p>
                <h3>${count.countTotalRequest}</h3>
                <p class="cardstatus"><strong>Total Request</strong></p>
            </div>

        </div>

    </div>  <!-- /.container -->
    
    <!-- footer -->
    <%@ include file="/pages/include/footer.html" %>

</body>

</html>