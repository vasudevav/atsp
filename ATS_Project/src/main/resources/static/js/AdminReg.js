$(document)
		.ready(
				function() {
					$("#dob").datepicker({
						changeMonth : true,
						changeYear : true,
						yearRange : "1985:2003"
					});
					$("#email")
							.blur(
									function() {
										$("#submitBtn").removeAttr('disabled');
										var email = $("#email").val();
										if (email == '') {
											$('#emailErr').html(
													'Please Enter Email..')
													.css({
														'color' : 'red'
													});
											return;
										}
										let isValid = validateEmail(email);
										if (isValid) {
											$
													.ajax({
														method : 'Get',
														url : '/ATSApplication/userReg/uniqueEmail',
														data : {
															email : email
														},
														success : function(
																result) {
															if (result == 'Duplicate') {
																$("#submitBtn").attr("disabled", true);
																$('#emailErr')
																		.html(
																				'Email is alredy used')
																		.css(
																				{
																					'color' : 'red'
																				});
															}
															else{
																$("#submitBtn").removeAttr('disabled');
															}
														}
													});
										}
									});
					$('#submitBtn').click(function() {
						var email = $("#email").val();
						if (email == '') {
							$('#emailErr').html('Please Enter Email..').css({
								'color' : 'red'
							});
						}
					});
					function validateEmail(email) {
						var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
						if (mailformat.test(email)) {
							$('#emailErr').text(' ');
							return true;
						} else {
							$("#emailErr").text('Invalid email format..!!')
									.css({
										'color' : 'red'
									});
							return false;
						}
					}
					$(function() {
						$('form[id="userDtls"]').validate({
							rules : {
								fname : 'required',
								lname : 'required',
								dob : {
									date : true,
									required : true
								},
								phno : {
									required : true,
									number : true,
									minlength : 10,
									maxlength : 10
								},
								zzn : {
									required : true,
									maxlength : 11,
									minlength : 11
								},
								roleType: {
									valueNotEquals : "-1"	
								}
							},
							messages : {
								fname : 'Please Enter First Name',
								lname : 'Please Enter Last Name',
								dob : {
									date : 'Please Enter Date',
									required : 'Please Enter Date'

								},
								phno : {
									required : 'Please Enter phone Number',
									number : 'Enter Only Numbers',
									minlength : 'Phone no. must be 10 digit',
									maxlength : 'Phone No. Must be 10 digit'
								},
								zzn : {
									required : 'Please Enter SSN Number',
									maxlength : 'Only 9 number are Entered',
									minlength : 'only 9 digit are Entered'
								},
								roleType:{
									valueNotEquals : 'Please Select Role'
								}
							},
							submitHandler : function(form) {
								$('#emailErr').text(' ');
								var email = $("#email").val();
								if (!validateEmail(email))
									return;
								else
									form.submit();
							}
						});
					});

					$.validator.addMethod("valueNotEquals", function(value, element, arg) {
						return arg !== value;
					}, "Value must not equal arg.");
					
					$('#zzn').keypress(
							function(e) {
								if (e.which != 8 && e.which != 0
										&& (e.which < 48 || e.which > 57)) {
									return false;
								} else if (e.which != 8 && e.which != 0
										&& (e.which <= 57 && e.which >= 48)) {
									var zzn1 = $('#zzn').val();
									if (event.keyCode != '8') {
										if (zzn1.length == 6) {
											$('#zzn').val(zzn1 + '-');
										} else if (zzn1.length == 3) {
											$('#zzn').val(zzn1 + '-');
										}
									}
								}
							});
				});

function clearConf() {

	return confirm("Are you want to reset Your Form....!!");
}
