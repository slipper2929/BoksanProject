/**
 * 
 */





$(function(){
	 $(".Ppilist").hide();
	$(document).on("click", ".up_btn",function(){
		$(".Ppilist").show();
		$(".Upilist").hide();
		
	})
	$(document).on("click", ".success_btn",function(){
		$(".Ppilist").hide();
		$(".Upilist").show();
	})
	
})
	
