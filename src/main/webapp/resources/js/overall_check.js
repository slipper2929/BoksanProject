$(function(){

    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
   
    let in_out_record_data;
    
    //$(".ior_choice").hide()
    //$(".ior_right").hide()
    $(".little_title").text("입출고내역조회")
    $(".sr_choice").hide()
    $(".sr_right").hide()
    $(".hr_choice").hide()
    $(".hr_right").hide()
    $(".record_excel").hide()
    $(".stock_excel").hide()
    //다른거 생기면 전부 하이드해줘야함
    
    $(".inquiry_date_start_ior").datepicker({
        dateFormat : 'yy-mm-dd'
    });

    $(".inquiry_date_end_ior").datepicker({
        dateFormat : 'yy-mm-dd'
    });
    $(".inquiry_date_start_sr").datepicker({
        dateFormat : 'yy-mm-dd'
    });

    $(".inquiry_date_end_sr").datepicker({
        dateFormat : 'yy-mm-dd'
    });

    $("#overall_sbl_select").find("select").on("change", function(){
    	
    	if($("#overall_sbl_select").find("select").val() == "") {
    		//다른것이 생긴다면 걔네들을 전부 하이드해야함
    	    $(".ior_choice").hide()
    	    $(".ior_right").hide()
    	    $(".sr_choice").hide()
    	    $(".sr_right").hide()
            $(".hr_choice").hide()
    	    $(".hr_right").hide()
    	} else if($("#overall_sbl_select").find("select").val() == "in_out_record") {
        	
    		//다른것이 생긴다면 걔네들을 전부 하이드해야함
    	    $(".ior_choice").show()
    	    $(".ior_right").show()
    	    $(".sr_choice").hide()
    	    $(".sr_right").hide()
            $(".hr_choice").hide()
    	    $(".hr_right").hide()
            
    	} else if($("#overall_sbl_select").find("select").val() == "stock_record") {
    		
    		//다른것이 생긴다면 걔네들을 전부 하이드해야함
    		$(".sr_choice").show()
    		$(".sr_right").show()
    	    $(".ior_choice").hide()
    	    $(".ior_right").hide()
            $(".hr_choice").hide()
    	    $(".hr_right").hide()

    	} else if($("#overall_sbl_select").find("select").val() == "house_record"){

            //다른것이 생긴다면 걔네들을 전부 하이드해야함
    		$(".hr_choice").show()
    	    $(".hr_right").show()
            $(".sr_choice").hide()
    		$(".sr_right").hide()
    	    $(".ior_choice").hide()
    	    $(".ior_right").hide()

        }

    })
    
    $("#overall_sb_btn").on("click", function(){
    	

        //조회구분 셀렉박스
        let overall_sbl_select = $("#overall_sbl_select").find("select");
        
        
        if(overall_sbl_select.val() == ""){
            alert("조회구분을 선택하여 주세요")
        } else if($(".inquiry_date_start_ior").val() > $(".inquiry_date_end_ior").val()){
            alert("조회기간을 다시 확인해 주세요")
            $(".inquiry_date_start_ior").val("")
            $(".inquiry_date_end_ior").val("")
        } else if(($(".inquiry_date_start_ior").val() != "" && $(".inquiry_date_end_ior").val() == "") || ($(".inquiry_date_start_ior").val() == "" && $(".inquiry_date_end_ior").val() != "")){
            alert("조회기간을 하나만 입력하지 마세요")
            $(".inquiry_date_start_ior").val("")
            $(".inquiry_date_end_ior").val("")
        } else if (overall_sbl_select.val() == "in_out_record"){
            

            let record_arr = [];
            let overall_sbl_check_ior_1 = $("#overall_sbl_check_ior_1");
            let overall_sbl_check_ior_2 = $("#overall_sbl_check_ior_2");
            let overall_sbl_check_ior_3 = $("#overall_sbl_check_ior_3");
            let charge_name_ior = $(".charge_name_ior").val();
            let country_name_ior = $(".country_name_ior").val();
            let product_name_ior = $(".product_name_ior").val();
            let business_name_ior = $(".business_name_ior").val();
            let inquiry_date_start_ior = $(".inquiry_date_start_ior").val();
            let inquiry_date_end_ior = $(".inquiry_date_end_ior").val();

            if(overall_sbl_check_ior_1.is(':checked') == true){
                record_arr.push("입고")
            } else{
                record_arr.push("false")
            }

            if(overall_sbl_check_ior_2.is(':checked') == true){
                record_arr.push("출고")
            } else{
                record_arr.push("false")
            }

            if(overall_sbl_check_ior_3.is(':checked') == true){
                record_arr.push("발주")
            } else{
                record_arr.push("false")
            }
            
            $(".record_arr_excel").val(record_arr);
            $(".charge_name_excel").val(charge_name_ior);
            $(".country_name_excel").val(country_name_ior);
            $(".product_name_excel").val(product_name_ior);
            $(".business_name_excel").val(business_name_ior);
            $(".inquiry_date_start_excel").val(inquiry_date_start_ior);
            $(".inquiry_date_end_excel").val(inquiry_date_end_ior);
         

            let record_data = {
                "record_arr" : record_arr,
                "charge_name" : charge_name_ior,
                "country_name" : country_name_ior,
                "product_name" : product_name_ior,
                "business_name" : business_name_ior,
                "inquiry_date_start" : inquiry_date_start_ior,
                "inquiry_date_end" : inquiry_date_end_ior
            }
            
            in_out_record_data = record_data;

            console.log(record_data)

            $.ajax({
                url:"/in_out_record",
                type:"get",
                data: record_data,
                traditional : true,
                dataType:'json',
                beforeSend : function(xhr){
                    xhr.setRequestHeader(header, token);
                },
                success: function(data){
                	console.log(data)
<<<<<<< HEAD
                
=======
                	$(".record_excel").show()
                	$(".stock_excel").hide()
>>>>>>> main
                	$(".little_title").text("입출고내역조회")
                    $("#overall_list table").html("")

                    $("#overall_list").css({"display" : "block"})

                    let th;
                    let td;

                    th += "<tr><th>입출고내역코드</th><th>분류</th><th>날짜</th><th>상품명</th><th>상품원산지</th><th>공급사명</th>"
                    th += "<th>중량</th><th>가격</th><th>담당자명</th><th>담당자전화번호</th></tr>"
                   
                    for(let i = 0; i < data.length; i++){
                        td += "<tr>"
                        td += "<td>" + data[i].statement_code + "</td>"
                        td += "<td>" + data[i].classification + "</td>"
                        td += "<td>" + data[i].date + "</td>"
                        td += "<td>" + data[i].product_name + "</td>"
                        td += "<td>" + data[i].product_country + "</td>"
                        td += "<td>" + data[i].product_business + "</td>"
                        td += "<td>" + data[i].quantity + "kg</td>"
                        
                        if(data[i].product_price == 0) {
                        	td += "<td>-</td>"
                        } else {
                        	td += "<td>" + data[i].product_price + "원</td>"
                        }
                        
                        td += "<td>" + data[i].emp_name + "</td>"
                        td += "<td>" + data[i].emp_tel + "</td>"
                        td += "</tr>"
                    }

                    $("#overall_list table").append(th)
                    $("#overall_list table").append(td)

                    
                },
                error: function(e){
                	alert("dddd")
                    alert(e)
                }
            })

        } else if(overall_sbl_select.val() == "stock_record"){

            let record_arr = [];
            let overall_sbl_check_sr_1 = $("#overall_sbl_check_sr_1");
            let overall_sbl_check_sr_2 = $("#overall_sbl_check_sr_2");
            let overall_sbl_check_sr_3 = $("#overall_sbl_check_sr_3");
            let overall_sbl_check_sr_4 = $("#overall_sbl_check_sr_4");
            let product_name_sr = $(".product_name_sr").val();
            let country_name_sr = $(".country_name_sr").val();
            let inquiry_date_start_sr = $(".inquiry_date_start_sr").val();
            let inquiry_date_end_sr = $(".inquiry_date_end_sr").val();
            let business_name_sr = $(".business_name_sr").val();
            let house_code_sr = $(".house_code_sr").val();

            if(overall_sbl_check_sr_1.is(':checked') == true){
                record_arr.push("A")
            } else{
                record_arr.push("false")
            }

            if(overall_sbl_check_sr_2.is(':checked') == true){
                record_arr.push("B")
            } else{
                record_arr.push("false")
            }

            if(overall_sbl_check_sr_3.is(':checked') == true){
                record_arr.push("C")
            } else{
                record_arr.push("false")
            }

            if(overall_sbl_check_sr_4.is(':checked') == true){
                record_arr.push("D")
            } else{
                record_arr.push("false")
            }
            
            $(".record_arr_stock_excel").val(record_arr);
            $(".product_name_stock_excel").val(product_name_sr);
            $(".country_name_stock_excel").val(country_name_sr);
            $(".inquiry_date_start_stock_excel").val(inquiry_date_start_sr);
            $(".inquiry_date_end_stock_excel").val(inquiry_date_end_sr);
            $(".business_name_stock_excel").val(business_name_sr);
            $(".house_code_stock_excel").val(house_code_sr);
            
            let record_data = {
                "record_arr" : record_arr,
                "product_name" : product_name_sr,
                "country_name" : country_name_sr,
                "inquiry_date_start" : inquiry_date_start_sr,
                "inquiry_date_end" : inquiry_date_end_sr,
                "business_name" : business_name_sr,
                "house_code" : house_code_sr
            }

            console.log(record_data)

            $.ajax({
                url:"/stock_record",
                type:"get",
                data: record_data,
                traditional : true,
                dataType:'json',
                beforeSend : function(xhr){
                    xhr.setRequestHeader(header, token);
                },
                success: function(data){
                	$(".stock_excel").show()
                	$(".record_excel").hide()
                	console.log(data)
                	$(".little_title").text("재고조회")
                    $("#overall_list table").html("")

                    $("#overall_list").css({"display" : "block"})
 
                    let th;
                    let td;

                    th += "<tr><th>파레트번호</th><th>상품명</th><th>원산지</th><th>공급사명</th><th>중량</th><th>창고번지</th><th>입고일</th>"
                   
                    for(let i = 0; i < data.length; i++){
                        td += "<tr>"
                        td += "<td>" + data[i].pallet_num + "</td>"
                        td += "<td>" + data[i].product_name + "</td>"
                        td += "<td>" + data[i].country_name + "</td>"
                        td += "<td>" + data[i].business_name + "</td>"
                        td += "<td>" + data[i].stock_num + "kg</td>"
                        td += "<td>" + data[i].house_code + "</td>"
                        td += "<td>" + data[i].arrive_date + "</td>"
                        td += "</tr>"
                    }

                    $("#overall_list table").append(th)
                    $("#overall_list table").append(td)

                    
                },
                error: function(e){
                	alert("dddd")
                    alert(e)
                }
            })

        } else if(overall_sbl_select.val() == "house_record"){

        }

    })
<<<<<<< HEAD
	$(".excel_btn").on("click",function(){
=======
	/*$(".excel_btn").on("click",function(){
>>>>>>> main
		
		 let record_arr = [];
	        let overall_sbl_check_ior_1 = $("#overall_sbl_check_ior_1");
            let overall_sbl_check_ior_2 = $("#overall_sbl_check_ior_2");
            let overall_sbl_check_ior_3 = $("#overall_sbl_check_ior_3");
            let charge_name_ior = $(".charge_name_ior").val();
            let country_name_ior = $(".country_name_ior").val();
            let product_name_ior = $(".product_name_ior").val();
            let business_name_ior = $(".business_name_ior").val();
            let inquiry_date_start_ior = $(".inquiry_date_start_ior").val();
            let inquiry_date_end_ior = $(".inquiry_date_end_ior").val();
		if(overall_sbl_check_ior_1.is(':checked') == true){
            record_arr.push("입고")
        } else{
            record_arr.push("false")
        }

        if(overall_sbl_check_ior_2.is(':checked') == true){
            record_arr.push("출고")
        } else{
            record_arr.push("false")
        }

        if(overall_sbl_check_ior_3.is(':checked') == true){
            record_arr.push("발주")
        } else{
            record_arr.push("false")
        }
		
			  let record_data = {
                "record_arr" : record_arr,
                "charge_name" : charge_name_ior,
                "country_name" : country_name_ior,
                "product_name" : product_name_ior,
                "business_name" : business_name_ior,
                "inquiry_date_start" : inquiry_date_start_ior,
                "inquiry_date_end" : inquiry_date_end_ior
            }
		console.log(record_data);
		
		$.ajax({
			url:"/excelDownXlsx",
            type:"get",
            data: in_out_record_data,
            traditional : true,
<<<<<<< HEAD
            dataType:"json",
=======
            dataType:"text",
>>>>>>> main
            beforeSend : function(xhr){
            xhr.setRequestHeader(header, token);
            alert("dd");
            },
			success: function(data){
				alert("성공")
				console.log(data);
<<<<<<< HEAD
=======
			
>>>>>>> main
			},
			error:function(request,status,error){
		        alert("에러지롱@@@@@@@@@@"+"code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		       }
		})
<<<<<<< HEAD
	})
	
=======
	})*/
	

>>>>>>> main

})