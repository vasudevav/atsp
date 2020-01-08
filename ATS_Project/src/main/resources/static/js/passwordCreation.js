	$(document).ready(function() {
		$(function() {
			$('form[id="pwdForm"]').validate({
				rules : {
					tempPwd : "required",
					pazzword : {
							required: true,
							minlength: 8,
							maxlength: 15
							
						},
					confirmPazzword : {
						required : true,
						equalTo : "#pazzword"
					}
				},
				messages : {
					tempPwd : {
						reuired : "*Temporary Password Required!"
					},
					pazzword : {
						reqiured : "New Password Required"
					},
					confirmPazzword : {
						required : "confirm  password",
						equalTo : "Password are Not  Matching..!!"
					}
				},
				submitHandler : function(form) {
					form.submit();
				}
			});
		});
	});