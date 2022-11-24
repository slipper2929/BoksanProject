/**
 * 
 */
 
$(function(){

	let query = window.location.search;
	let param = new URLSearchParams(query);
	let product_code = param.get('product_code');
	let arrive_num = param.get('arrive_num');
	let product_barcode = param.get('product_barcode');
	let arrive_code = param.get('arrive_code');

	

	$(".arrive_code").val(arrive_code);
	$(".product_code").val(product_code)
	$(".arrive_num").val(arrive_num)
	let yyyy = "20" + product_barcode.substr(3,2)
	let mm = product_barcode.substr(5,1).charCodeAt(0)*1-64
	let dd = "";
	if(product_barcode.substr(6,1)*1 < 10){
		dd = product_barcode.substr(6,1)
	} else {
		dd = product_barcode.substr(6,1).charCodeAt(0)*1-55
	}
	product_barcode.substr(6,1).charCodeAt(0)
	console.log("yyyy : " + yyyy)
	console.log("mm : " + mm)
	console.log("dd : " + dd)
	
	$(".arrive_date").val(yyyy + "-" + mm + "-" + dd)
	
	console.log(product_code)
	console.log(arrive_num)
	console.log(product_barcode)
	
	$(".pallet_num").val(product_barcode.substr(0,3))
	
	$(".check_btn").on("click", function(){
	
		if($(".check_barcode_text").val() == product_barcode){
			
			if($(".check_house_barcode").val() == product_barcode.substr(7,9)){
				$("form").submit();
			} else {
				alert("창고번지가 일치하지 않습니다.")
			}
			
		} else {
			alert("검증하고자하는 바코드 번호가 발행된 바코드와 일치하지 않습니다.")
		}
	})
	
	
})