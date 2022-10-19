/**
 * 
 */


$(document).on("click",".move_compare_btn", function(){
	if($(this).parent().parent().prev().find($(".move_compare")).val() == $(this).parent().parent().prev().prev().find($(".movement_value")).val()){
		
		$(this).prev().attr("name","pallet_num")
		alert("창고번지가 변경되었습니다.")
		$("#compare_form").submit();
		
	} else{
		alert("일치하지 않습니다.")
	}
})