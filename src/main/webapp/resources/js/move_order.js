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

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

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
	alert("이동할 창고번지를 입력하세요")
}



})





$(".house_code_input_modal").on("click", function(){
    
    let result_input = $(this)

       $(".modal").fadeIn();
                   
       $("body").css({
           "overflow": "hidden",
           "margin-left" : "-17px"
       })


       let select1_data_val;
       $("#modal_select1").on("change", function(){
            $(".house_inner_num_box").html("")
            select1_data_val = $(this).val();
            $.ajax({
                url:"/house_out_num_select",
                type:"get",
                data: {
                    "data" : $(this).val()
                },
                dataType:'json',
                beforeSend : function(xhr){
                    xhr.setRequestHeader(header, token);
                },
                success: function(data){
                	console.log("@@@@@@@")
                	console.log(data[0])
                    $("#modal_select2").html("")

                    let option;
                    option += "<option value=''>선택안함</option>"
                    for(let i = 0; i < data.length; i++){
                        option += "<option value='"+ data[i] +"'>"+data[i]+"</option>"
                    }
                    
                    $("#modal_select2").append(option)
                    

                },
                error: function(e){
                    alert("dddd")
                    alert(e)
                }
            })

            
       })


       $("#modal_select2").on("change", function(){
        
            $(".house_inner_num_box").html("")
            $.ajax({
                url:"/house_out_num_select2",
                type:"get",
                data: {
                    "data1" : $("#modal_select1").val(),
                    "data2" : $(this).val()
                },
                dataType:'json',
                beforeSend : function(xhr){
                    xhr.setRequestHeader(header, token);
                },
                success: function(data){
                    console.log("@@@@@@@")
                    console.log(data)

                    let house_code_item;
                    for(let i = 0; i < data.length; i++){
                        house_code_item += '<div class="house_inner_num_item">'
                        house_code_item += '<p class="house_inner_num_title">'+data[i].house_code+'</p>'
                        house_code_item += '<p class="house_inner_num_count">'
                        house_code_item += '<span>'+data[i].now_quantity+'</span>'
                        house_code_item += '/<span>'+data[i].max_quantity+'</span></p></div>'

                    }
                    $(".house_inner_num_box").append(house_code_item)
                    $(".house_inner_num_box").html($(".house_inner_num_box").html().replace('undefined',''))

                },
                error: function(e){
                    alert("dddd")
                    alert(e)
                }
            })
        })

        $(document).on("click", ".house_inner_num_item",function(){

            let house_address_result;

            house_address_result = $(this).find(".house_inner_num_title").text();

            result_input.val(house_address_result)
            
            $(".modal").fadeOut();
            $("body").css({
                "overflow": "visible",
                "margin-left" : "0"
            })

        })
        

   })


   $(".modal_out").click(function(){
       $(".modal").fadeOut();
       $("body").css({
           "overflow": "visible",
           "margin-left" : "0"
       })
     
   })






