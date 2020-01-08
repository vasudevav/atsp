$(document).ready(function() {
		var owl = $('.owl-carousel');
		owl.owlCarousel({
			margin : 10,
			nav : true,
			loop : true,
			items : 1,
			autoplay : true,
			dots : false,
			loop : true,
			autoplayTimeout : 2000

		});
		$(function() {
			$('form[id="signInForm"]').validate({
				rules : {
					email : {
						required : true,
						email : true
					},
					pazzword : {
						required : true,
						minlength : 8,
						maxlength : 15
					}
				},
				messages : {
					email : {
						required : '*Mail Id Required',
						email : 'Enter valid Format'
					},
					pazzword : {
						required : '*Password Required',
						minlength : 'Enter correct Password',
						maxlength : 'Enter valid password'
					}
				},
				submitHandler : function(form) {
					form.submit();
				}
			});
		});

	});
