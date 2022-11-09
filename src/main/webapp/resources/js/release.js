
 $(function(){
	 
	 jQuery.pg_box_change = function(){
		 	
		 	
		 	$(".pg_box").on("change", function(){
		 		
		 		let pgCode = $(this).val();
		 		let objdata = {"data" : pgCode};
		 		$(this).addClass("myChoice")
		 		$(this).next().addClass("myProduct")
		 		
		 		$.ajax({
		 			url:"/testajax",
			 		type:"get",
			 		data: objdata,
			 		dataType:'json',
			 		success: function(data){
			 			console.log(data)
			 			
			 			
			 			$(".myProduct *").remove()
			 			$(".myProduct").append("<option>선택안함</option>")
			 			
			 			for(let i = 0; i < data.length; i++){
			 				var optionTag = $("<option value='"+ data[i].product_code +"'>" + data[i].product_name + "(" + data[i].product_code + ")</option>");
			 				$(".myProduct").append(optionTag);
			 			}
			 			
			 			
			 			
			 			
			 			
			 			$(".pg_box").removeClass("myChoice")
			 			$(".pg_box").next().removeClass("myProduct")
			 			
			 			for(let i = 0; i < $("#recipe_product_code_select").find("option").length; i++) {
			 	        	
			 	        	let check_point = false;
			 	        	
			 	        	for(let j = 0; j < sb_recipe_list.length; j++) {
			 	        		
			 	        		if($("#recipe_product_code_select").find("option").eq(i+1).val() == sb_recipe_list[j]) {
			 	        			check_point = true
			 	        		}
			 	        		
			 	        	}
			 	        	
			 	        	if(check_point == false) {
			 	    			$("#recipe_product_code_select").find("option").eq(i+1).hide()
			 	    		}
			 	        	
			 	        }
			 			
			 			
			 		},
			 		error: function(e,data){
			 			alert(data)
			 			alert("error : " + e)
			 			
			 		}
		 		}) //에이젝스끝
		 		
		 	})
		 	
		 	
		 	
		 	}
		 	jQuery.pg_box_change(); 
	 
	 
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
		                release_tr += '<td class="pc_check_release"><p>'+data[i].product_code
		                release_tr += '<input type="hidden" name="product_code" value="' + data[i].product_code + '"></p></td>'
		                release_tr += '<td><p>'+data[i].product_name
		                release_tr += '<input type="hidden" name="product_name" value="' + data[i].product_name + '"></p></td>'
		                release_tr += '<td class="release_weight_textbox">'
		                release_tr += '<p><input type="text" placeholder="중량을 입력하세요" name="release_num" value="'+ data[i].material_num +'"></p></td>'
		                release_tr += '<td><p class="btn_s_r"><input type="button" value="삭제" class="release_product_delete_btn"></p></td></tr>'
	            	}
	            	
	            	
	            	
	            
	            }
	            

	        	$("table").append(release_tr)
	        },
	        error: function(e){
	            alert("error : " + e)
	        }
	    })
	    
 	})
 	
 	$(document).on("click","#release_padd_btn", function(){
 	
 		let pc_padd = $("select[name = recipe_product_code_select]").val();
 		let pn_padd_str = $("select[name = recipe_product_code_select] option:selected").text()
 		let pw_padd = $("#pw_padd").val()
 		let pn_padd = pn_padd_str.split('(')
 		
 		let release_tr;
 		let pc_true_check_switch2 = false;
 		
 		for(let j = 0; j < $(".pc_check_release").length; j++){
	            		
			if($(".pc_check_release").eq(j).find("p").text() == pc_padd){
				
				let add_num = $(".release_weight_textbox").eq(j).find("input").val();
				
				$(".release_weight_textbox").eq(j).find("input").val(add_num*1 + pw_padd*1)
				pc_true_check_switch2 = true;
			
			}
 		}
 		
 		if(pc_true_check_switch2 == false){
	            	
    		release_tr += '<tr class="b_table_data">'
            release_tr += '<td class="pc_check_release"><p>'+pc_padd
            release_tr += '<input type="hidden" name="product_code" value="' + pc_padd + '"></p></td>'
            release_tr += '<td><p>'+pn_padd[0]
            release_tr += '<input type="hidden" name="product_name" value="' + pn_padd[0] + '"></p></td>'
            release_tr += '<td class="release_weight_textbox">'
            release_tr += '<p><input type="text" placeholder="중량을 입력하세요" name="release_num" value="'+ pw_padd +'"></p></td>'
            release_tr += '<td><p class="btn_s_r"><input type="button" value="삭제" class="release_product_delete_btn"></p></td></tr>'
    	}
    	
    	$("table").append(release_tr)
 		
 	})
 	

 	$(document).on("click", ".release_product_delete_btn", function(){
		alert("dd")
        $(this).parents("tr").remove()
    })
    
    $(document).on("click", ".release_list_btn input", function(){
    	
    	for(let i = 1; i < $("table tr").length; i++){
    		$("table tr").eq(i).find("input[name = product_code]").attr('name', 'release_insert_list[' + (i-1) + '].product_code')
    		$("table tr").eq(i).find("input[name = product_name]").attr('name', 'release_insert_list[' + (i-1) + '].product_name')
    		$("table tr").eq(i).find("input[name = release_num]").attr('name', 'release_insert_list[' + (i-1) + '].release_num')
    	}
    	
    	$("#release_insert_form").submit();
    	
    })
    
    
    
    
    
   
    
    
 })