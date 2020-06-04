<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-US">

<head>
    <title>Helping Hands &#8211; Request and Donor management System</title>

	<%@ include file="include/header.html" %>
	
</head>

<body>

    <!-- navigation bar -->
    <%@ include file="include/navigation.jsp" %>
    
    <!-- Page Content -->
    <div class="container mt-4">
        <div class="row">
            
            <div class="col-lg-8 text-center mx-auto">

                <div class="row">

                    <div class="error-title">
                        <header class="entry-header">
                            <h1 class="text-light">404 error: Page not found</h1>
                        </header>   
                        <span><img src="vender/images/error.png" class="img-fluid"></span>
                    </div>

                    <div class="col-lg-12 col-md-12 mx-auto mt-4">                  
                        <h2 class="entry-title"><b>What is happening?</b></h2>
                        <p class="text-muted">The page that you are looking for does not exist on this website. You may have accidentally mistype the page address, or followed an expired link. Anyway, we will help you get back on track.</p>
                    </div>
                </div>
            </div>

        </div>  <!-- /.row -->
    </div>  <!-- ./container -->

    <!-- footer -->
    <%@ include file="include/footer.html" %>

</body>

</html>