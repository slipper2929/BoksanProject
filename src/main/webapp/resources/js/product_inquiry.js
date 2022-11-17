/**
 * 
 */
$(".success_btn").hide();
$(".pilist_out").hide();
$(document).on("click",".up_btn",function(){
	$(this).hide();
	$(this).parents("tr").find(".pilist_on").hide();
	$(this).parents("tr").find(".inquiry_delete").hide();
	$(this).parents("tr").find(".success_btn").show();
	$(this).parents("tr").find(".pilist_out").show();
})

$(document).on("click" , ".success_btn", function(){
	
	let listv = {
		"product_code" : $(this).parents("tr").find(".product_value_code").val(),
		"product_name": $(this).parents("tr").find(".product_value_name").val(),
		"price": $(this).parents("tr").find(".product_value_price").val(),
		"country_code": $(this).parents("tr").find(".product_value_place").val(),
		"business_name": $(this).parents("tr").find(".product_value_Bname").val(),
		"pallet_in_ratio": $(this).parents("tr").find(".product_value_pir").val(),
		"product_group_code": $(this).parents("tr").find(".product_value_Gcode").val()
	}
	
	console.log(listv)
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	$.ajax({
		type : "post",
		url : "/product_Iupdate",
		data : listv,
		dataType: "json",
		beforeSend : function(xhr){
		xhr.setRequestHeader(header, token);
		},
		success : function(result){
			console.log(result)
			alert("상품정보가 변경되었습니다.")
			location.reload();
			
		},
		error : function(request,status,error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	})
	$(this).parents("tr").find(".pilist_on").show();
	$(this).parents("tr").find(".up_btn").show();
	$(this).parents("tr").find(".inquiry_delete").show();
	$(this).parents("tr").find(".success_btn").hide();
	$(this).parents("tr").find(".pilist_out").hide();
	//location.reload();
})

$(document).on("click",".inquiry_delete",function(){
	$(this).next().attr("name", "product_code")
	$(".product_delete").submit();
	alert("삭제 성공!")
})
	
