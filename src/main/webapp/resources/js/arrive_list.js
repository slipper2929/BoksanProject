/**
 * 
 */
 $(function(){
 
 	//입고일선택datepicker
 	$(".datepick").datepicker({
 		dateFormat : 'yy-mm-dd'
 	});
 	
 	//존재하는 창고번지인지 확인
 	
 	$(document).on("change", ".arrive_house",function(){
	
	let check = {
			"data" : $(this).val()
	}
	
	
	$.ajax({
		type : "post",
		url : "/changeHouse",
		dataType : "json",
		data : check,
		success : function(result){
			console.log(result)
			
			
			
			if($(".arrive_house").val() == ""){
				alert("입고시킬 창고번지를 입력하세요")
			} else if(result == 0){
				alert("존재하지 않는 창고번지입니다")
				$(".arrive_house").val("")
			}
			
	
		},
		error : function(e){
			console.log(e);
		}
	})
	
	
	})
	
	//바코드 만들기
	$(".barcode_btn").on("click", function(){
		let barcode = "";
		let pc_atag = $(this).parents("tr").find(".product_code").text()
		let an_atag = $(this).parents("tr").find(".arrive_num_check").text().slice(0,-2)
		let pallet_num = $(this).parents("tr").find(".pallet_num_selectbox").val()
		let arrive_date = $(this).parents("tr").find(".arrive_date").val()
		let arrive_house_barcode = $(this).parents("tr").find(".arrive_house").val()
		let date_YYmmdd = arrive_date.split('-')
		let date_YY = date_YYmmdd[0].substr(2,3)
		let date_mm = String.fromCharCode(date_YYmmdd[1]*1 + 64)
		let date_dd = ""
		if(date_YYmmdd[2]*1 < 10){
			date_dd = date_YYmmdd[2]*1
		} else {
			date_dd = String.fromCharCode(date_YYmmdd[2]*1 + 55)
		}
		
		let date_barcode = date_YY + date_mm + date_dd
		
		barcode = pallet_num + date_barcode + arrive_house_barcode 
	
		console.log("바코드 값들")
		console.log("파레트 : " + pallet_num)
		console.log("입고일 : " + arrive_date)
		console.log("창고번지 : " + arrive_house_barcode)
		console.log("년도 : " + date_YY)
		console.log("월 : " + date_mm)
		console.log("일 : " + date_dd)
		console.log("바코드 : " + barcode)
		
		if(pallet_num != "" &&  arrive_date != "" && arrive_house_barcode != ""){
			
			alert("생성된 바코드 : " + barcode)
			$(".check_link").attr("href","/check?product_barcode=" + barcode + "&product_code=" + pc_atag + "&arrive_num=" + an_atag)
			$(".check_link").get(0).click();
		} else {
			alert("입고일, 파레트번호, 창고번지를 입력하셔야합니다.")
		}
	
		
	
	})
 	
 	
 })