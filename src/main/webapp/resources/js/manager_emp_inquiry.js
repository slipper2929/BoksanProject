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
		
		let arr = [];
		
		function empdept(emp_code, dept_code){
			this.emp_code = emp_code;
			this.dept_code = dept_code;
		}
		for(var i =0; i<$(".emp_value").length; i++){
			
			let abc = new empdept($("table tr").eq(i+1).find(".emp_value").val(), $("table tr").eq(i+1).find(".dept_choice").val())
			
			arr.push(abc);
			
		}
		console.log(arr);
		console.log(JSON.stringify(arr));
		
		$.ajax({
			type : "post",
			url : "/emp_update",
			traditional : true,
			data : {"arr" : JSON.stringify(arr)},
			dataType : "json",
			contentType : "json",
			success : function(data){
				alert("성공");
				console.log(data)
			},
			error : function(e){
				alert("error : " + e)
			}
		})
	})
	
})