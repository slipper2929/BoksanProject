/**
 * 
 */

$(function(){
	$("#pallet_select_btn").on("click", function(){
		//var dps = $("#Pcode").val();
		var dpsobj = {"data" : "data"}
		console.log(dpsobj)
		$.ajax({
			url:"/delete_pallet_select",
			type:"get",
			data: dpsobj,
			dataType:'json',
			success: function(data){
				console.log(data)
				
				console.log(data[0]);
				
				function dps_select(Ddps){
					let Sdps = "";
					
					Sdps += '<tr class="b_table_data" id="dps" >'
					Sdps += ' <td><p>'+ Ddps +'</p></td>'	
					Sdps += '<td><p><input type="checkbox" class="pallet_check" value="'+ Ddps +'"></p></td>'
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
		$("#PS_table").html('<tr class="b_table_title"><th><p>파레트번호</p></th><th><p>삭제</p></th></tr>')
		
	})
	pallet_num_list = []
	$(document).on("click", ".pallet_check", function(){
					if($(".pallet_check").is(":checked")){
						$(this).val();	
						console.log($(this).val())
						
						//pallet_num_list.push($(this).val())
					} else {
						$(this).attr("name", "")
						//배열에 값 빼주기(내가 클릭한 체크박스의 값을 비교해서)
					}
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
	
	$(document).on("click", ".pallet_delete_check_btn input", function(){
		let count = 0;
		for(let i = 0; i < $(".pallet_check").length; i++){
			
			if($(".pallet_check").eq(i).is(":checked")){
				$(".pallet_check").eq(i).attr("name", "pallet_num_list["+count+"].pallet_num")
				count++

			}
		}
		
		
		$("#pallet_delete_form").submit();
		
	})
	
		/*let CheckValue = [];
		function CheckValue(event){
			let result = "";
			if(event.target.checked){
				result = event.target.value;
			}else{
				result="";
			}
			return CheckValue.push(result); 
		}
		CheckValue();
		console.log(CheckValue);
		//$(this).submit();
	})*/
	
	
	
	
	
	
})