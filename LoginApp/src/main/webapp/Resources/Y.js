$(document).ready(function(){

	$('input[name="userId"]').keyup(function(){
		var userId=$(this).val();
		username=/^[0-9]{1,5}$/;
		
		if(!username.test(userId)||userId=="")
		{
			$('.n1').text("plz enter valid userId...");
		}
		else 
		{
			$('.n1').text("");
		}
		$(this).on("focusin",function(){
		if(!username.test(userId)||userId=="")
		{
			$('.n1').text("plz enter valid userId...");
		}
		else 
		{
			$('.n1').text("");
		}
		});
		$(this).on("focusout",function(){
		$('.n1').text("");
		});	
	});
	$('input[name="password"]').keyup(function(){
		var password=$(this).val();
		username1=/^[0-9a-zA-Z@#!$%^&*()_+<>?,./]{5,15}$/;
		
		if(!username1.test(password)||password=="")
		{
			$('.n2').text("plz enter valid password...");
		}
		else 
		{
			$('.n2').text("");
		}
		$(this).on("focusin",function(){
		if(!username1.test(password)||password=="")
		{
			$('.n2').text("plz enter valid password...");
		}
		else 
		{
			$('.n2').text("");
		}
		});
		$(this).on("focusout",function(){
		$('.n2').text("");
		});	
	});
	
	
});