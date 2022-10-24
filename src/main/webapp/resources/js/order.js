/**
 * 
 */
 
 $(function(){
 

 
 		let result = "";
 
 		$("#recipe_product_code_select").on("change", function(){

			let pc_choice = $(this).val();
			let pc_choice_obj = {"data" : pc_choice};
    		
			$.ajax({
				url:"/price_select",
				type:"get",
				data: pc_choice_obj,
				dataType: 'json',
				success: function(data){
					
					if($("#arrive_num").val() == ""){
						$("#b_order_price span").text(data*1+"원")
					} else{
						$("#b_order_price span").text(data*$("#arrive_num").val()+"원")
					}
					result = data
				},
				error: function(e){
					alert(e)
				}
			})
			
			
        })
        
        $("#arrive_num").on("change", function(){
        	$("#b_order_price span").text(result*$("#arrive_num").val()+"원")
        })
 })