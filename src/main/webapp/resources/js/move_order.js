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

$(document).on("change", ".move_address",function(){
	
	let check = {
			"data" : $(this).val()
	}
	let Chouse = ""
	
	if($(this).val() == $(this).prev().val()){
		Chouse = true
	} else {
		Chouse = false
	}
	console.log(Chouse)
	$.ajax({
		type : "post",
		url : "/changeHouse",
		dataType : "json",
		data : check,
		success : function(result){
			console.log(result)
			
			
			
			if($(".move_address").val() == ""){
				alert("이동할 창고번지를 입력하거라")
			} else if(result == 0){
				alert("해당하는 창고는 없도다")
				$(".move_address").val("")
			} else if(Chouse){
				alert("동일한 창고입니다.")
				$(".move_address").val("")
			}
			
	
		},
		error : function(e){
			console.log(e);
		}
	})
	
	
})

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



