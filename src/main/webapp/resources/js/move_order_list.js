/**
 * 
 */


$(document).on("click",".move_compare_btn", function(){
	if($(this).parent().parent().prev().find($(".move_compare")).val() == $(this).parent().parent().prev().prev().find($(".movement_value")).val()){
		
		$(this).prev().attr("name","pallet_num")
		console.log($(".move_compare"))
		alert("창고번지가 변경되었습니다.")
		
		let house_code = $(this).parents("tr").find(".house_code")
		let movement_address = $(this).parents("tr").find(".movement_address")
		
		house_code.attr("name","house_code")
		movement_address.attr("name","movement_address")
		
		$("#compare_form").submit();
		
	} else{
		alert("일치하지 않습니다.")
	}
})