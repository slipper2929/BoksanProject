/**
 * 
 */

$(function(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
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
		
		let emp_val = [];
		let dept_val = [];
		for(var i =0; i<$(".emp_approve").length; i++){
			let emp_value = $("table tr").eq(i+1).find(".emp_approve").val()
			let dept_value = $("table tr").eq(i+1).find(".dept_value").val()
			
			if($("table tr").eq(i+1).find(".approve_check").is(':checked', true)){
				emp_val.push(emp_value);
				dept_val.push(dept_value);
			}
			
		}
	
		
		
		console.log(emp_val);
		console.log(dept_val);
		
		
		
		$.ajax({
			type : "post",
			url : "/approve_success",
			traditional : true,
			data : {
				"emp_val" : emp_val,
				"dept_val" : dept_val
				},
			dataType : "text",
			beforeSend : function(xhr){
				xhr.setRequestHeader(header, token);
			},
			success : function(data){
				alert(data)
				location.reload();
			},
			error : function(e){
				alert("error : " + e)
			}
		})
	})
	
	$(document).on("click","#approve_sorry_btn", function(){
		
		let emp_val = [];
		for(var i =0; i<$(".emp_approve").length; i++){
			let emp_value = $("table tr").eq(i+1).find(".emp_approve").val()
			
			if($("table tr").eq(i+1).find(".approve_check").is(':checked', true)){
				emp_val.push(emp_value);
			}
		}
		console.log(emp_val)
		
		$.ajax({
			type : "post",
			url : "/approve_sorry",
			traditional : true,
			data : {"emp_val" : emp_val},
			dataType : "text",
			beforeSend : function(xhr){
				xhr.setRequestHeader(header, token);
			},
			success : function(data){
				alert(data)
				location.reload();
			},
			error : function(e){
				alert("error : " + e)
			}
		})
	})
})