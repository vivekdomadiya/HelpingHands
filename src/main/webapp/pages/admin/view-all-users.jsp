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
                <h1>View All Users</h1>
                <hr class="mb-5">
            </div>
        </div>
        
        <c:if test="${users.isEmpty()}">
            <h2 class="text-center">No Users Found!!</h2>
        </c:if>
        <c:if test="${!users.isEmpty()}"> 
        <div class="row">
            <div class="col">

	            <div class="table-responsive">
	                <table class="table table-hover table-bordered">
	                    <thead>
	                        <tr>
                                <th>Role</th>
								<th>Name</th>
								<th>Mobile Number</th>
	                            <th>Email</th>
                                <th>Address</th>
	                            <th>Delete</th>
	                        </tr>
	                    </thead>
	                    <tbody> 
	                    <c:forEach items="${users}" var="user">
	                        <tr>
                                <td>${user.role}</td>
								<td>${user.name}</td>
								<td><a href="tel:${user.contact}">${user.contact}</a></td>
	                            <td><a href="mailto:${user.email}">${user.email}</a></td>
	                            <td>
                                    <address>
                                        ${user.addL1}<br>
                                        ${user.addL2}<br>
                                        ${user.city}<br>
                                        ${user.state}-${user.pinCode}.
                                    </address>
                                </td>
	                            <td>
                                    <a href="#" class="btn btn-danger openDeleteModal" data-toggle="modal" data-id="${user.userId}" data-target="#deleteModal">Delete</a>
                                </td>
	                        </tr>
	                    </c:forEach>
	                    </tbody>
	                </table>
	            </div>
                
                <%@ include file="/pages/include/deleteModal.html" %>
                
            </div>
        </div>

        <%@ include file="/pages/include/pagination.jsp" %>
        </c:if>

    </div>  <!-- /.container -->
    
    <!-- footer -->
    <%@ include file="/pages/include/footer.html" %>

    <script>
        $(".openDeleteModal").click(function() {
            $("#deleteModalForm").attr("action","/admin/deleteUser");
            $("#deleteId").val($(this).attr("data-id"));
        });
    </script>

</body>

</html>