/**
 * 
 */
 $(function(){
 
 	
 
 	
 	
 	let product_code_count = 0;
 	let material_num_count = 0;
 	
 	function tr_making(pc_count, mn_count){
 	
 		let tr_make = '';
 		
	 	tr_make += '<tr class="b_table_data">';
	 	tr_make += '<td>'
	 	tr_make += '<p>'
	 	tr_make += '<select name="" id="" class="recipe_product_selectbox pg_box">'
	 	tr_make += '<option value="">선택안함</option>'
		
		for(let i = 0; i < code_list.length; i++){
			tr_make += '<option value="' + code_list[i] + '">' + name_list[i] + '</option>'
		}
	 	
	 	tr_make += '</select>'
	 	tr_make += '<select id="" class="recipe_product_selectbox product_code_list">'
	 	tr_make += '<option value="">선택안함</option>'
	 	tr_make += '</select>'
	 	tr_make += '</div>'
	 	tr_make += '</p>'
	 	tr_make += '</td>'
	 	tr_make += '<td class="recipe_weight">'
	 	tr_make += '<p><input type="text" placeholder="중량을 입력하세요" class="num_check weight_num"></p>'
	 	tr_make += '</td>'
	 	tr_make += '<td class="recipe_delete">'
	 	tr_make += '<p class="btn_s_r recipe_delete_btn"><input type="button" value="재료삭제" class="delete_btn"></p>'
	 	tr_make += '</td>'
	 	tr_make += '</tr>'
	 	
	 	return tr_make;
 	}
 	
 	
 	function total_weight_sum(){
 		
 		let weight_sum = 0;
 		
 		for(let i = 0; i < $(".weight_num").length; i++){
 			weight_sum += $(".weight_num").eq(i).val()*1
 			
 		}
 		//weight_sum = weight_sum*1;
 		
 		$(".weight span").text(weight_sum)
 		
 		$("#recipe_weight").val(weight_sum)
 	}
 	
 	$(document).on("click", "#add_btn", function(){
 		
 		$(".b_table").append(tr_making())
 		jQuery.pg_box_change();
 		
 		
 	})
 	
 	$(document).on("click", ".delete_btn",function(){
 	
	 		$(this).parent().parent().parent().remove()
	 		total_weight_sum();
	 })
 	
 	$("#recipe_product_code_select").on("change", function(){
 		$("#recipe_product_code").val($("#recipe_product_code_select").val())
 		
 		let selected = $(this).find("option:selected").text()
 		selected = selected.split('(')
 		//alert(selected[0])
 		$("#recipe_product_name").val(selected[0])
 	})
 	
 	
 	
 	$(document).on("change",".weight_num",function(){
 	
 		total_weight_sum();
 	})
 	
 	let today = new Date();
 	
 	var year = today.getFullYear();
	var month = ('0' + (today.getMonth() + 1)).slice(-2);
	var day = ('0' + today.getDate()).slice(-2);
	
	let now = year + '-' + month  + '-' + day;
 	
 	$(".date_now span").text(now)
 	$("#recipe_date").val(now)
 	
 	$(".recipe_save_btn input").on("click", function(){
 		
 		for(let i = 0; i < $("table tr").length - 1; i++){
 		
 			$("table tr").eq(i+1).find(".product_code_list").attr('name', 'product_code_list['+i+'].product_code');
 			$("table tr").eq(i+1).find(".weight_num").attr('name', 'material_num_list['+i+'].material_num');
 			
 			//console.log(i+"번째 목록 상품코드 : "+$("table tr").eq(i+1).find(".product_code_list").attr('name'))
 			//console.log(i+"번째 목록 중량"+$("table tr").eq(i+1).find(".weight_num").attr('name'))
 		}
 		
 		
 		$("form").submit();
 	})

 })