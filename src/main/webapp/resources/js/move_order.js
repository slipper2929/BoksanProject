/**
 * 
 */
//$("#abc").text($("#bbb").val())
//$("#abc").val($("#bbb").val())

//$("#move_btn").on("click", function(){
//	alert("ddd")
//	$("#abc").val($("#move_address").val());
//	$('#abc').parent().text($("#move_address").val());
//
//})

$(document).on("click", ".move_btn",function(){
	if($(this).parent().parent().prev().find($(".move_address")).val() != ""){
		
		console.log($(this).parent().parent().prev().find($(".move_address")).attr("name","movement_address").val())
		$(this).parent().parent().prev().find($(".move_address")).attr("name","movement_address")
		$(this).parent().parent().prev().find($(".pallet_num")).attr("name","pallet_num")
		$("#move_form").submit();
	} else {
		alert("이동할 창고번지를 입력하거라")
	}
	
})