$(function(){
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(".order_btn").on("click", function(){
		
		$(".modal_content form").find(".order_result").val("")

		let order_pc = $(this).parents("tr").find(".rp_product_code").text()
		let order_pn = $(this).parents("tr").find(".rp_product_name").text()
		let order_num = $(this).parents("tr").find(".rp_release_num").text()
		
		$("#order_link").attr("href","/order?product_code=" + order_pc + "&product_name=" + order_pn)
		//$("#order_link").get(0).click();
		
		$.ajax({
			url:"/release_order",
			type:"get",
			data: {"data" : order_pc},
			dataType:'json',
			beforeSend : function(xhr){
				xhr.setRequestHeader(header, token);
			},
			success: function(data){
				
				console.log(data)
				
				$(".modal").fadeIn();
				
				$("body").css({
					"overflow": "hidden",
					"margin-left" : "-17px"
				})
				
				
				$(".modal_name span").text(order_pn)
				if(data.data == null) {
					$(".modal_total_num span").text("0kg")
				} else {
					$(".modal_total_num span").text(data.data + "kg")
				}
				$(".modal_order_num span").text(order_num)
				$(".modal_product_code").val(order_pc)
				
				let modal_total_product_num = 0;
				
				for(let i = 1; i < $(".release_pay_table tr").length; i++) {
					
					if($(".release_pay_table tr").eq(i).find(".rp_product_code").text() == order_pc) {
						
						let slicestr = $(".release_pay_table tr").eq(i).find(".rp_release_num").text().slice(0, -2)
						
						modal_total_product_num += slicestr*1
					}
					
				}
				
				$(".modal_total_product_num span").text(modal_total_product_num + "kg")
				
				$(".modal_order_num button").on("click", function(){
					
					let result = $(".modal_order_num span").text().slice(0, -2) - data.data;
					
					$(".modal_content form").find(".order_result").val(result)
					
					let price_res = $(".order_result").val() * data.data_price
					
					$(".modal_total_price_num .res").text(price_res + "원")
					
					
				})
				
				$(".modal_total_product_num button").on("click", function(){
									
					let result = $(".modal_total_product_num span").text().slice(0, -2) - data.data;
					
					$(".modal_content form").find(".order_result").val(result)
					
					let price_res = $(".order_result").val() * data.data_price
					
					$(".modal_total_price_num .res").text(price_res + "원")
					
					
				})
				
				$(".order_result").on("change", function(){

					let price_res = $(".order_result").val() * data.data_price
							
					alert(price_res)
					$(".modal_total_price_num .res").text(price_res + "원")
					
				})
				
				$(".release_pay_order_btn").on("click", function(){
					
					if($(".order_result").val() != "") {
						alert("ddd")
						$(".modal_order_form").submit();
						
					} else {
						alert("중량을 입력하세요");
						$(".order_result").focus();
					}
					
				})
				
				
				
			},
			error: function(e){
				alert(e)
			}
		})
		
		
	    
		
	 });
	  
	  $(".modal_out").click(function(){
	    $(".modal").fadeOut();
	    $("body").css({
			"overflow": "visible",
			"margin-left" : "0"
		})
	  
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