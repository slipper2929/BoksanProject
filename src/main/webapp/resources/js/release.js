
 $(function(){
 	
 	
 	
 	$(document).on("click", "#release_search_btn", function(){

		let release_tr;

	    let objdata = {
	        "recipe_code" : $(".release_selectbox").val(),
	        "need_weight" :  $(".release_weight").val()
	    }
	    
	    $.ajax({
	        url: "release_recipe_select",
	        type: "get",
	        data: objdata,
	        dataType: "json",
	        success: function(data){
	            alert("성공")
	            console.log(data)
	            console.log(data[0].material_num)
	            
	            for(let i = 0; i < data.length; i++){
	            	
	            	let pc_true_check_switch = false;
	            	
	            	for(let j = 0; j < $(".pc_check_release").length; j++){
	            		
	            		if($(".pc_check_release").eq(j).find("p").text() == data[i].product_code){
	            			
	            			let add_num = $(".release_weight_textbox").eq(j).find("input").val();
	            			
	            			$(".release_weight_textbox").eq(j).find("input").val(add_num*1 + data[i].material_num)
	            			pc_true_check_switch = true;
	            			
	            		}
	            		
	            	
	            	}
	            	
	            	if(pc_true_check_switch == false){
	            	
	            		release_tr += '<tr class="b_table_data">'
		                release_tr += '<td class="pc_check_release"><p>'+data[i].product_code+'</p></td>'
		                release_tr += '<td><p>'+data[i].product_name+'</p></td>'
		                release_tr += '<td class="release_weight_textbox">'
		                release_tr += '<p><input type="text" placeholder="중량을 입력하세요" value="'+ data[i].material_num +'"></p></td>'
		                release_tr += '<td><p class="btn_s_r"><input type="submit" value="삭제"></p></td></tr>'
	            	}
	            	
	            	
	            	
	            
	            }
	            

	            //$("table").html('<tr class="b_table_title"><th><p>상품코드</p></th><th><p>상품명</p></th><th><p>중량</p></th><th><p>삭제</p></th></tr>' + release_tr)
	        	$("table").append(release_tr)
	        },
	        error: function(e){
	            alert("error : " + e)
	        }
	    })
	    
 	})
 	
 	$(document).on("click","#release_padd_btn", function(){
 	
 		let pc_padd = $(this).parent("section").find("#recipe_product_code_select").val();
 		let pn_padd = $("#recipe_product_code_select option:selected").text()
 		alert(pn_padd)
 	})
 })