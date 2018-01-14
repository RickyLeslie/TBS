// Nexus 4 Pure CSS Design
// Author : Erhan Basa ( erhanbasa.com )
// http://erhanbasa.com/blog/css-ile-nexus-4/
$(document).ready(function() {
	 $(window).load(function() {
	 	$(".phone-pic").hide();
	 	$(".re-phone").hide();					
		$(".over-phone").hide();	
		$(".bo").hide();	
		$(".tong").hide();	
		$(".cover").hide();	
		$('#hangup').hide();
	 });

	

	/*	Current Tab 	*/
	$('.phone-tabs li a').click(function() {
		$('.phone-tabs li').removeClass('current');
		$(this).parent().addClass('current');
	});

	/*	Simple Tab 	*/
	var tabContents = $('.phone-tab-contents');
	$('.phone-tabs .getphone').click(function() {
		tabContents.removeClass('getpeoples');
		tabContents.removeClass('getclock');
	});

	$('.phone-tabs .getclock').click(function() {
		tabContents.removeClass('getpeoples');
		tabContents.addClass('getclock');
	});

	$('.phone-tabs .getpeoples').click(function() {
		tabContents.removeClass('getclock');
		tabContents.addClass('getpeoples');
	});

	/*	Delete */
	$('.delete-btn').click(function() {
		var numbers = $('.number-area .numbers').text();
		var numbers2 = $('.number-area .numbers').text().length;
		$('.number-area .numbers').text(numbers.substr(0, numbers2 - 1));
		$('.speaker .numbers').text(numbers.substr(0, numbers2 - 1));
		if (numbers.substr(0, numbers2 - 1)=="") {
			$(".bo").hide();
			$(".circle").css('background-position', '0 -22px');
			$(".btn-btn").css('background-position', '0 0');

		}
		
	});


/*拨号键图片变化*/
	$("#call").click(function(event) {
		/*$(this).css('background-position', '0 -105px');*/


	});



	/*	Pusher	*/
	var pusher = {
		number: function(num) {
			$('.numbers-container .pushed' + num + '').click(function() {

				$('.number-area .numbers').append('' + num + '');
				$('.speaker .numbers').append('' + num + '');
				$("#call").css('background-position', '0 -105px');
				$(".bo").show();
				$(".circle").css('background-position', '0 0');
				$("#call").click(function(event) {
					$(".bo").hide();
					$(".tong").show();
					$(".numbers").hide();
					$(".phone-pic").show();
					$(".cover").show();
					$("#call").hide();
					$("#hangup").show();

					$(".btn-people").css('background-position', '0 -49px');
					$(".btn-del").css('background-position', '0 -49px');

					$("#hangup").click(function(event) {
						$(".tong").hide();
						$(".phone-pic").hide();
						$(".re-phone").show();
						$('#call').show();
						$(".circle").css('background-position', '0 -22px');
						/*$(".cover").hide();*/	
						$(".btn-people").css('background-position', '0 0');
						$(this).hide();
						$(".btn-del").css('background-position', '0 0');
						location.reload();
					});
				});
			});
		}
	}

	pusher.number(1);
	pusher.number(2);
	pusher.number(3);
	pusher.number(4);
	pusher.number(5);
	pusher.number(6);
	pusher.number(7);
	pusher.number(8);
	pusher.number(9);
	pusher.number(0);

	$('.numbers-container .pushedasterisk').click(function() {
		$('.number-area .numbers').append('*');
	});

	$('.numbers-container .pushednumber').click(function() {
		$('.number-area .numbers').append('#');
	});

});