$(function() {

    // validator add method
    $.validator.addMethod( "regex", function(value, element, param) {
        var re = new RegExp(param);
        return this.optional(element) || re.test(value);
        },  "Please check your input."
    );

    var addL1Rule = {
            required:true,
            regex: /^[a-zA-Z0-9-.,\/] ?([a-zA-Z0-9-.,\/]|[a-zA-Z0-9-.,\/] )*[a-zA-Z0-9-.,\/]$/,
        },
        addL2Rule = {
            required:true,
            regex: /^[a-zA-Z0-9-.,\/] ?([a-zA-Z0-9-.,\/]|[a-zA-Z0-9-.,\/] )*[a-zA-Z0-9-.,\/]$/,
        },
        pinCodeRule = {
            required:true,
            regex: /^[1-9][0-9]{5}$/,
        }

    // Sign Up form validation
    $("#signUpForm, #editProfileForm").validate({

        invalidHandler: function(form, validator) {
            $('html, body').animate({
                scrollTop: $(validator.errorList[0].element).offset().top -100
            }, 1000);
            $(validator.errorList[0].element).focus();
        },
        
        rules: {
            name: {
                required: true,
                regex: /^[A-Za-z. ]+$/
            },
            
            email: {
                required: true,
                regex: /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})$/,
            },
            contact: {
                required: true,
                regex: /^[5-9][0-9]{9}$/,
            },
            password: {
                required: true,
                regex: /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])/,
                minlength:8,
                maxlength:32,
            },
            confirmPassword : {
                required: true,
                equalTo: '#password',
            },
            addL1: addL1Rule,
            addL2: addL2Rule,
            pinCode: pinCodeRule,
        },
        messages: {
            role: "Please select role.",
            name: "Please specify your valid name.",
            email: "Please specify a valid email address.",
            contact: "Please specify a valid Mobile Number.",
            password : `<div id="repassword">
                            <span>Password must contain the following:</span>
                            <p>A <b>lowercase</b> letter.</p>
                            <p>A <b>UPPERCASE</b> letter.</p>
                            <p>A <b>number (0-9)</b>.</p>
                            <p>A <b>special (!@#$%^&*) characters</b>.</p>
                            <p>Password length between <b>8-32 characters</b>.</p>
                        </div>`,
            confirmPassword: "Password don't match.",
            addL1: "Enter valid address line 1",
            addL2: "Enter valid address line 2",
            city: "Enter valid city name",
            state: "Enter valid state name",
            pinCode: "Check your Pin-Code",
        },
        submitHandler: function(form, event) {
            $(form).find('input:text').each(function(){
                $(this).val($.trim($(this).val()));
            })
            if($("#signUpForm").valid())
                form.submit();
        }
    });


    // login form validation
    $("#loginForm").validate({
        invalidHandler: function(form, validator) {
            $(validator.errorList[0].element).focus();
        },
        rules: {
            username: {
                required:true,
                regex: /^(([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4}))|([5-9][0-9]{9})$/,
            },
            password: "required", 
        },
        messages: {
            username: "Please enter valid Email.",
            password: "Please enter password.",
        },
        submitHandler: function(form, event) {
            $(form).find('input:text').each(function(){
                $(this).val($.trim($(this).val()));
            })
            if($("#loginForm").valid())
                form.submit();
        }
    });


    // forget password form validation
    $("#forgetPassForm").validate({
        errorLabelContainer: '.errorTxt',
        rules: {
            email: {
                required: true,
                regex: /^(([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4}))$/,
            },
        },
        messages: {
            email: "Please enter valid email address.",
        },
        submitHandler: function(form, event) {
            $(form).find('input:text').each(function(){
                $(this).val($.trim($(this).val()));
            })
            if($("#forgetPassForm").valid())
                form.submit();
        },
    });


    // Post Request Form
    // Set date of request
    $("#dateOfDonate").datepicker( {
        dateFormat: 'dd/mm/yy',
        minDate: '-0d',
        maxDate: '+2m',
        beforeShow: function(){    
            $(".ui-datepicker").css('font-size', 15) 
        }
    });

    // set address
    $('#sameAddress').click(function () {
        if ($(this).is(':checked')) {
            $("#addL1").val("12");
        } else {
            $("#addL1").val("");
        }
    });

    // validation
    $("#makeDonationForm").validate({

        invalidHandler: function(form, validator) {
            $(validator.errorList[0].element).focus();
        },
        rules: {
            typeOfRequest: {
                required: true,
            },
            nameOfRequest: {
                required: true,
            },
            quantity: {
                required: true,
            },
            dateOfDonate: {
                required: true,
            },
            addL1: addL1Rule,
            addL2: addL2Rule,
            pinCode: pinCodeRule,
        },
        messages: {
            typeOfRequest: "Please Enter What You Have?",
            nameOfRequest: "Please Enter Short Name For Item?",
            quantity: "Please Enter Quantity",
            dateOfDonate: "Please Enter When to donate?",
            addL1: "Enter valid address line 1",
            addL2: "Enter valid address line 2",
            city: "Enter valid city name",
            state: "Enter valid state name",
            pinCode: "Check your Pin-Code",
        },
        submitHandler: function(form, event) {
            $(form).find('input:text').each(function(){
                $(this).val($.trim($(this).val()));
            })
            if($("#makeDonationForm").valid())
                form.submit();
        },
    });
    
    
    // Reset Password Form validation
    $("#resetPasswordForm").validate({
        invalidHandler: function(form, validator) {
            $(validator.errorList[0].element).focus();
        },
        
        rules: {
            password: {
                required: true,
                regex: /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])/,
                minlength:8,
                maxlength:32,
            },
            confirmPassword : {
                required: true,
                equalTo: '#password',
            }
        },
        messages: {
            password : `<div id="repassword">
                            <span>Password must contain the following:</span>
                            <p>A <b>lowercase</b> letter.</p>
                            <p>A <b>UPPERCASE</b> letter.</p>
                            <p>A <b>number (0-9)</b>.</p>
                            <p>A <b>special (!@#$%^&*) characters</b>.</p>
                            <p>Password length between <b>8-32 characters</b>.</p>
                        </div>`,
            confirm_password: "Password don't match.",
        },
        submitHandler: function(form, event) {
            $(form).find('input:text').each(function(){
                $(this).val($.trim($(this).val()));
            })
            if($("#resetPasswordForm").valid())
                form.submit();
        }
    });

    // Change Password Form validation
    $("#changePasswordForm").validate({
        invalidHandler: function(form, validator) {
            $(validator.errorList[0].element).focus();
        },
        
        rules: {
            oldPassword: {
                required: true,
                regex: /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])/,
                minlength:8,
                maxlength:32,
            },
            newPassword: {
                required: true,
                regex: /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])/,
                minlength:8,
                maxlength:32,
            },
            confirmPassword : {
                required: true,
                equalTo: '#password',
            }
        },
        messages: {
            oldPassword : `<div id="repassword">
                            <span>Password must contain the following:</span>
                            <p>A <b>lowercase</b> letter.</p>
                            <p>A <b>UPPERCASE</b> letter.</p>
                            <p>A <b>number (0-9)</b>.</p>
                            <p>A <b>special (!@#$%^&*) characters</b>.</p>
                            <p>Password length between <b>8-32 characters</b>.</p>
                        </div>`,
            newPassword : `<div id="repassword">
                            <span>Password must contain the following:</span>
                            <p>A <b>lowercase</b> letter.</p>
                            <p>A <b>UPPERCASE</b> letter.</p>
                            <p>A <b>number (0-9)</b>.</p>
                            <p>A <b>special (!@#$%^&*) characters</b>.</p>
                            <p>Password length between <b>8-32 characters</b>.</p>
                        </div>`,
            confirmPassword: "Password don't match.",
        },
        submitHandler: function(form, event) {
            $(form).find('input:text').each(function(){
                $(this).val($.trim($(this).val()));
            })
            if($("#resetPasswordForm").valid())
                form.submit();
        }
    });

});