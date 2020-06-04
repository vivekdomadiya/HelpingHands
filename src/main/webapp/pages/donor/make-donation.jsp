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
    <%@ include file="/pages/donor/include/navigation.html" %>

    <!-- contant -->
    <div class="container content">
        <h1>Make a Doantion</h1>
        <hr class="mb-5">

        <div class="row">
            <div class="col-md-8 col-lg-6 mx-auto">

				<!-- form -->
				<form id="makeDonationForm" class="customForm" action="/donor/make-donation" method="POST" enctype="multipart/form-data">

                    <div class="form-group">
                        <label for="typeOfRequest">What You Have? <font color="red">*</font></label>
                        <input type="text" class="form-control" name="typeOfRequest" id="typeOfRequest" placeholder="Food, Clothes.." required autofocus>
                    </div>

                    <div class="form-group">
                        <label for="nameOfRequest">Short Name For Item? <font color="red">*</font></label>
                        <input type="text" class="form-control" name="nameOfRequest" id="nameOfRequest" placeholder="Grain, Rice..." required>
                    </div>

                    <div class="form-group">
                        <label for="quantity">Quantity? <font color="red">*</font></label>
                        <input type="text" class="form-control" name="quantity" id="quantity" placeholder="10 Unit" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="dateOfDonate">When to donate? <font color="red">*</font></label>
                        <input type="text" class="form-control" name="dateOfDonate" id="dateOfDonate" placeholder="dd/mm/yyyy" autocomplete="off" required>
                    </div>

                    <div class="form-group">
                        <label>
                            <input type="radio" name="typeOfTransoprt" id="drop" value="DROP" required checked> Drop By Self
                        </label>
                        <label>
                            <input type="radio" name="typeOfTransoprt" id="pickUp" value="PICK-UP" required> Pick UP
                        </label>
                    </div>

                    <div class="form-group">
                        <label for="address">Address: <font color="red">*</font></label><br>

                        <label>
                            <input type="checkbox" id="sameAddress"> Same as your address
                        </label>
                        <input type="text" class="form-control" name="addL1" id="addL1" placeholder="Address Line 1" required>
                        <input type="text" class="form-control mt-2" name="addL2" id="addL2" placeholder="Address Line 2" required>
                        <select class="form-control mt-2" name="state" id="state" required></select>
                        <select class="form-control mt-2" name="city" id="city" required></select>
                        <input type="number" class="form-control mt-2" name="pinCode" id="pinCode" placeholder="Postal Code" required>
                    </div>

                    <div class="form-group">
                        <label for="details">details <font color="grey">(optional)</font></label>
                        <textarea class="form-control" name="details" id="details" rows="5"></textarea>
                    </div>

                    <div class="form-group text-center">
                        <input id="postRequest" type="submit"  class="btn btn-success" name="postRequest" value="Make Doantion">
                    </div>

				</form>   <!-- /.form -->
			</div>
        </div> <!-- /.row -->
    </div> <!-- /.container -->

    <!-- footer -->
    <%@ include file="/pages/include/footer.html" %>

</body>

</html>