/**
 * 
 */

$(function(){
	$(document).on("click", ".approve_check", function(){
		if($(this).is(':checked')){
			$(this).val($(this).parents("tr").find(".emp_approve").val());
			$(this).attr("name","emp_code");
		}else{
			$(this).val("");
			$(this).attr("name","");
		}
	})
	
	$(document).on("click", "#approve_btn", function(){
		
		let emp_val=[];
		for(var i =0; i<$(".emp_approve").length; i++){
			let emp_value = $("table tr").eq(i+1).find(".emp_approve").val()
			emp_val.push(emp_value);
		}
		
		
		console.log(emp_val);
		
		$.ajax({
			type : "post",
			url : "/approve_success",
			traditional : true,
			data : {"emp_val" : emp_val},
			dataType : "json",
			success : function(data){
				alert(data)
			},
			error : function(e){
				alert("error : " + e)
			}
		})
	})
})