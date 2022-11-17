/**
 * 
 */

$(function(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	$(".modal_country_btn").on("click", function(){
		$(".modalc").fadeIn();
		$("body").css({
			"overflow": "hidden",
			"margin-left" : "-17px"
		})
	})

	$(".modal_business_btn").on("click", function(){
		$(".modalb").fadeIn();
		$("body").css({
			"overflow": "hidden",
			"margin-left" : "-17px"
		})
	})
	

	$(".modal_out").click(function(){
	    $(".modalc").fadeOut();
	    $(".modalb").fadeOut();
	    
	    $("body").css({
			"overflow": "visible",
			"margin-left" : "0"
	    })
	})
	
	$(".modalc_btn").on("click", function(){

		if($("#modal_country_data").val() != "") {
	
			let country_data = $("#modal_country_data").val()

			$.ajax({
				url:"/country_insert",
				type:"post",
				data: {"data" : country_data},
				dataType:'text',
				beforeSend : function(xhr){
					xhr.setRequestHeader(header, token);
				},
				success: function(data){
					alert("원산지가 정상적으로 등록되었습니다.")
	
					$(".modal_out").trigger("click");
					
					let option_tag = "";
					option_tag += '<option value="' + data + '">' + country_data + '</option>'
					
					$(".country_select_box").append(option_tag)
				},
				error: function(e){
					alert("알수없는 이유로 정상적으로 수행되지 않았습니다. \n다시 작성해주세요")
					$("#modal_country_data").val("")
				}
			})
					
		} else {
			alert("정보를 입력해주세요")
		}
		

		
	})
	
	
	
	$(".modalb_btn").on("click", function(){
		alert("클릭함")
		if($("#modal_business_name_data").val() != "" && $("#modal_business_tel_data").val() != "") {
			alert("if문 들어옴")
			let business_name_data = $("#modal_business_name_data").val()
			let business_tel_data = $("#modal_business_tel_data").val()
			alert("에이젝스 직전")
			$.ajax({
				url:"/business_insert",
				type:"post",
				data: {
					"business_name_data" : business_name_data,
					"business_tel_data" : business_tel_data
				},
				dataType:'text',
				beforeSend : function(xhr){
					xhr.setRequestHeader(header, token);
				},
				success: function(data){
					
					alert("업체등록이 정상적으로 수행되었습니다.")
	
					$(".modal_out").trigger("click");
					
					let option_tag = "";
					option_tag += '<option value="' + data + '">' + business_name_data + '</option>'
					
					$(".business_select_box").append(option_tag)
				},
				error: function(e){
					alert("알수없는 이유로 정상적으로 수행되지 않았습니다. \n다시 작성해주세요")
					$("#modal_business_name_data").val("")
					$("#modal_business_tel_data").val("")
					
				}
			})
			
		} else {
			alert("정보를 입력해주세요")
		}
		
	})
	    
})