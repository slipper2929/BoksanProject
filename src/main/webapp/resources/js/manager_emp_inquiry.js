/**
 * 
 */

$(function(){
	
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	
	$(".emp_delete_form").find(".dept_select").hide();
	$(".emp_delete_form").find(".emp_success").hide();
	$(document).on("click",".emp_update", function(){
		$(".dept_select").show();
		$(".emp_success").show();
		$(".dept_value").hide();
		$(".emp_update").hide();
	})
	
	$(document).on("click",".emp_success", function(){
		
//		let arr = [];
		
//		function empdept(emp_code, dept_code){
//			this.emp_code = emp_code;
//			this.dept_code = dept_code;
//		}
//		for(var i =0; i<$(".emp_value").length; i++){
//			
//			let abc = new empdept($("table tr").eq(i+1).find(".emp_value").val(), $("table tr").eq(i+1).find(".dept_choice").val())
//			
//			arr.push(abc);
//			
//		}
//		console.log(arr);
//		console.log(JSON.stringify(arr));
		
		
		let emp_arr = []
		let dept_arr = []
		
		for(var i =0; i<$(".emp_value").length; i++){
			
			let emp_num = $("table tr").eq(i+1).find(".emp_value").val()
			let dept_num = $("table tr").eq(i+1).find(".dept_choice").val()
			
			emp_arr.push(emp_num)
			dept_arr.push(dept_num)
		}
		
		console.log(emp_arr)
		console.log(dept_arr)
		
		$.ajax({
			type : "post",
			url : "/emp_update",
			traditional : true,
			data : {
				"emp_arr" : emp_arr,
				"dept_arr" : dept_arr
				},
			beforeSend : function(xhr){
                    xhr.setRequestHeader(header, token);
                },
			dataType : "text",
			success : function(data){
				alert(data);
				location.reload();
			},
			error : function(request, error){
				alert("code : " + request.status + "\n" + "message : " + request.responseText + "\n" + "error : " + error )
			}
		})
	})
	
	$(document).on("click",".delete_check",function(){
		if($(".delete_check").is(':checked')){
			$(this).val($(this).parents("tr").find(".emp_value").val());
			$(this).attr("name","emp_code");
		}else{
			$(this).val("");
			$(this).attr("name","");
		}
		
		
	})
	$(document).on("click","#emp_delete_button",function(){
		if($(".delete_check").is(':checked')){
			alert("삭제되었습니다.")
			$(".emp_delete_form").submit();
		}else{
			alert("체크된 목록이 없습니다.")
		}
		
	})
//	$(document).on("click","#emp_delete_button", function(){
//		
//	})
	
})