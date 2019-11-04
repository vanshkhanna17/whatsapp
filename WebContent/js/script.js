$("#loginForm").validate({
    rules:{
        uname:{
            required: true,
            email: true,
        },
        password:{
            required: true,
            minlength: 4,
        },
    },
    messages: {
        uname:{
            required: "Email is required",
            email: "Email should be in abc@xyz.com format",
        },
        password:{
            required:"Password Is Mandatory",
            minlength: "Password must have minimum 4 characters",
        },
    },
    errorElement:'div',
});
//registration form
$("#registerForm").validate({
               rules: {
                              firstname: { required: true ,lettersonly: true},
                              lastname: { required: true,lettersonly: true },
                              uname: { required: true, email: true },
                              password: { required: true, minlength: 4 },
                              cpassword: { required: true, equalTo: "#password", minlength: 4  },
               },
               messages: {
                              firstname: { required: "First name is required",lettersonly: "First name can have only letters" },
                              lastname: { required: "Last name is required",lettersonly: "last name can have only letters"  },
                              uname: { required: "Email is required", email: "Email should be in someone@domain.com" },
                              password: { required: "Password is mandatory", minlength: "Password must be minimum 4 charecters long." },
                              cpassword: { required: "Password confirmation is mandatory", equalTo: "Passwords do not match", minlength: "Password must be minimum 4 charecters long." },
               },
               errorElement: 'div',
});
