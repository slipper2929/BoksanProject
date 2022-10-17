/**
 * 
 */

$(function(){
	$("#pallet_select_btn").on("click", function(){
		var dps = $("#Pcode").val();
		var dpsobj = {"data" : dps}
		console.log(dpsobj)
		$.ajax({
			url:"/delete_pallet_select",
			type:"get",
			data: dpsobj,
			dataType:'json',
			success: function(data){
				console.log("성공시")
				console.log(data)
				
				console.log(data[0]);
				
				function dps_select(Ddps){
					let Sdps = "";
					
					Sdps += '<tr class="b_table_data" id="dps" >'
					Sdps += ' <td><p>'+ Ddps +'</p></td>'	
					Sdps += '<td><p><input type="checkbox" class="pallet_check"></p></td>'
					Sdps += '</tr>'
						
					return Sdps;
				}

				
				for(let i = 0; i < data.length; i++){
					$("#PS_table").append(dps_select(data[i]));
				}
			},
			error: function(e){
				alert("error : " + e)
			}
		})
		
	})
	
	function checkAll() {
		if($("#pallet_all_check").is(':checked')) {
			$(".pallet_check").prop("checked", true);
		} else {
			$(".pallet_check").prop("checked", false);
		}
	}
	function checkfalse(){
		var total = $(".pallet_check").length;
		var checked = $(".pallet_check:checked").length;
		
		if(total != checked){
			$("#pallet_all_check").prop("checked", false)
		} else{
			$("#pallet_all_check").prop("checked", true);
		}
	}
	
	$(document).on("click", "#pallet_all_check", function(){
		checkAll()

	})
	$(document).on("click", ".pallet_check", function(){
		checkfalse()
	})
	
	
})