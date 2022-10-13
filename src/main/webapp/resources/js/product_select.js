/**
 * 
 */
 
 $(function(){
 	
 	$("#pg_box").on("change", function(){
 	
 		alert($("#pg_box").val())
 		
 		let pgCode = $("#pg_box").val();
 		let objdata = {"data" : pgCode};
 		
 		$.ajax({
 			url:"/testajax",
	 		type:"get",
	 		data: objdata,
	 		dataType:'text',
	 		success: function(data){
	 			alert(data);
	 		},
	 		error: function(e,data){
	 			alert(data)
	 			alert("error : " + e)
	 			
	 		}
 		}) //에이젝스끝
 	})
 	
 	
 	
 	
 })