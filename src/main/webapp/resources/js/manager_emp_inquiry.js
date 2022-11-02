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
	
})