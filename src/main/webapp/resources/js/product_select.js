/**
 * 
 */
 
 $(function(){
 	
 	$(".pg_box").on("change", function(){
 	
 		alert($(this).val())
 		
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
	 			console.log(data[0].product_code)
	 			
	 			
	 			//$(".myChoice").next().children.remove()
	 			
	 			for(let i = 0; i < data.length; i++){
	 				var optionTag = $("<option value='"+ data[i].product_code +"'>" + data[i].product_name + "(" + data[i].product_code + ")</option>");
	 				$(".myProduct").append(optionTag);
	 			}
	 			
	 			
	 			
	 			
	 			
	 			$(".pg_box").removeClass("myChoice")
	 			$(".pg_box").next().removeClass("myProduct")
	 		},
	 		error: function(e,data){
	 			alert(data)
	 			alert("error : " + e)
	 			
	 		}
 		}) //에이젝스끝
 	})
 	
 	
 	
 	
 })