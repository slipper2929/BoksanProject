$(function(){

	$("#situation_choice").on("change", function(){
	
		let situation_str = $("#situation_choice option:selected").val()
		
		$("#keyword").val(situation_str)
		
	})
	
	$("#situation_search_btn").on("click", function(){
		$("#searchbtn").trigger('click')
		

		
	})

})