/**
 * 
 */
 $(function(){
 
 
 
 	
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
 	tr_make += '<select name="" id="" class="recipe_product_selectbox">'
 	tr_make += '<option value="">선택안함</option>'
 	tr_make += '</select>'
 	tr_make += '</div>'
 	tr_make += '</p>'
 	tr_make += '</td>'
 	tr_make += '<td class="recipe_weight">'
 	tr_make += '<p><input type="text" placeholder="중량을 입력하세요" class="num_check"></p>'
 	tr_make += '</td>'
 	tr_make += '<td class="recipe_delete">'
 	tr_make += '<p class="btn_s_r recipe_delete_btn"><input type="submit" value="재료삭제"></p>'
 	tr_make += '</td>'
 	tr_make += '</tr>'
 	
 	$("#add_btn").on("click", function(){
 		
 		$(".b_table").append(tr_make)
 		jQuery.pg_box_change();
 		
 	})

 })