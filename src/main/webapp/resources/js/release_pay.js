$(function(){
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(".order_btn").on("click", function(){
	alert("dd")
		let order_pc = $(this).parents("tr").find(".rp_product_code").text()
		let order_pn = $(this).parents("tr").find(".rp_product_name").text()
		$("#order_link").attr("href","/order?product_code=" + order_pc + "&product_name=" + order_pn)
		$("#order_link").get(0).click();
	
	})
	
	$(".release_btn").on("click", function(){
		
		let product_code = $(this).parents("tr").find(".product_code")
		let product_name = $(this).parents("tr").find(".product_name")
		let release_num = $(this).parents("tr").find(".release_num")
		let release_code = $(this).parents("tr").find(".release_code")
		
		product_code.attr("name", "product_code")
		product_name.attr("name", "product_name")
		release_num.attr("name", "release_num")
		release_code.attr("name", "release_code")
		
		//console.log()
		
		$("#release_pay_form").submit()
	})
	
	$(".order_cancel").on("click", function(){
		
		let release_code_cancel = $(this).parents("tr").find(".release_code").val()
	
		$.ajax({
			url:"/release_cancel",
			type:"post",
			data: {"data" : release_code_cancel},
			dataType:'text',
			beforeSend : function(xhr){
				xhr.setRequestHeader(header, token);
			},
			success: function(data){
				alert(data)
				location.reload();
			},
			error: function(e){
				alert(e)
			}
		})
			
	})

})