/**
 * 
 */

$(function(){
	$(".dept_select").hide();
	$(".emp_success").hide()
	$(document).on("click",".emp_update", function(){
		$(".dept_select").show();
		$(".emp_success").show()
		$(".dept_value").hide()
		$(".emp_update").hide()
		
	})
	
	$(document).on("click",".emp_success", function(){
		
	})
	
})