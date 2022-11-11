$(function(){
    $(".release_after").hide();
    
    $(".release_btn").on("click", function(){
    	
    let ask_ha = $(this).parents("tr").find(".house_address_num").text();
    let check_ha = $(this).parents("tr").find(".check_house_address_num").val();
    let check_ha_box = $(this).parents("tr").find(".check_house_address_num")
    let release_list_code = $(this).parents("tr").find(".release_list_code");
    let release_num = $(this).parents("tr").find(".release_num");
    let release_code = $(this).parents("tr").find(".release_code");
    let release_list_code_P = $(this).parents("tr").find(".release_list_code_P");
    
    if(check_ha == "") {
    	alert("로케이션바코드검증을 입력하세요")
    } else if(ask_ha == check_ha) {
    	alert("검증완료")
    	release_list_code.attr("name", "release_list_code");
    	release_num.attr("name", "release_num");
    	release_code.attr("name", "release_code");
    	release_list_code_P.attr("name", "release_list_code_P");
    	$("#release_form").submit()
    } else {
    	alert("로케이션바코드가 일치하지 않습니다.")
    	check_ha_box.val("")
    }
    
    
    })
    
    
    
})