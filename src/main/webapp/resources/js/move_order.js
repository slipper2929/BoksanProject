$(function(){
 
    var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
    
    //입고일선택datepicker
    $(".datepick").datepicker({
        dateFormat : 'yy-mm-dd'
    });
    
    //존재하는 창고번지인지 확인
    
    $(document).on("change", ".arrive_house",function(){
   
   let check = {
           "data" : $(this).val()
   }
   
   
   $.ajax({
       type : "post",
       url : "/changeHouse",
       dataType : "json",
       data : check,
       success : function(result){
           console.log(result)
           
           
           
           if($(".arrive_house").val() == ""){
               alert("입고시킬 창고번지를 입력하세요")
           } else if(result == 0){
               alert("존재하지 않는 창고번지입니다")
               $(".arrive_house").val("")
           }
           
   
       },
       error : function(e){
           console.log(e);
       }
   })
   
   
   })
   
   //바코드 만들기
   $(".barcode_btn").on("click", function(){
       let arrive_code = $(this).parents("tr").find(".arrive_code").val()
       let barcode = "";
       let pc_atag = $(this).parents("tr").find(".product_code").text()
       let an_atag = $(this).parents("tr").find(".arrive_num_check").text().slice(0,-2)
       let pallet_num = $(this).parents("tr").find(".pallet_num_selectbox").val()
       let arrive_date = $(this).parents("tr").find(".arrive_date").val()
       let arrive_house_barcode = $(this).parents("tr").find(".arrive_house").val()
       let date_YYmmdd = arrive_date.split('-')
       let date_YY = date_YYmmdd[0].substr(2,3)
       let date_mm = String.fromCharCode(date_YYmmdd[1]*1 + 64)
       let date_dd = ""
       if(date_YYmmdd[2]*1 < 10){
           date_dd = date_YYmmdd[2]*1
       } else {
           date_dd = String.fromCharCode(date_YYmmdd[2]*1 + 55)
       }
       
       let date_barcode = date_YY + date_mm + date_dd
       
       barcode = pallet_num + date_barcode + arrive_house_barcode 
   
       console.log("바코드 값들")
       console.log("파레트 : " + pallet_num)
       console.log("입고일 : " + arrive_date)
       console.log("창고번지 : " + arrive_house_barcode)
       console.log("년도 : " + date_YY)
       console.log("월 : " + date_mm)
       console.log("일 : " + date_dd)
       console.log("바코드 : " + barcode)
       
       if(pallet_num != "" &&  arrive_date != "" && arrive_house_barcode != ""){
           
           alert("생성된 바코드 : " + barcode)
           $(".check_link").attr("href","/check?product_barcode=" + barcode + "&product_code=" + pc_atag + "&arrive_num=" + an_atag + "&arrive_code=" + arrive_code)
           $(".check_link").get(0).click();
       } else {
           alert("입고일, 파레트번호, 창고번지를 입력하셔야합니다.")
       }
   
       
   
   })
    
    $(".house_code_input_modal").on("click", function(){
        $(".house_inner_num_box").html("")
        $("#modal_select2").html("")
        let result_input = $(this)

           $(".modal").fadeIn();
                       
           $("body").css({
               "overflow": "hidden",
               "margin-left" : "-17px"
           })


           let select1_data_val;
           $("#modal_select1").on("change", function(){
                $(".house_inner_num_box").html("")
                select1_data_val = $(this).val();
                $.ajax({
                    url:"/house_out_num_select",
                    type:"get",
                    data: {
                        "data" : $(this).val()
                    },
                    dataType:'json',
                    beforeSend : function(xhr){
                        xhr.setRequestHeader(header, token);
                    },
                    success: function(data){
                    	console.log("@@@@@@@")
                    	console.log(data[0])
                        $("#modal_select2").html("")

                        let option;
                        option += "<option value=''>선택안함</option>"
                        for(let i = 0; i < data.length; i++){
                            option += "<option value='"+ data[i] +"'>"+data[i]+"</option>"
                        }
                        
                        $("#modal_select2").append(option)
                        

                    },
                    error: function(e){
                        alert(e)
                    }
                })

                
           })


           $("#modal_select2").on("change", function(){
            
                $(".house_inner_num_box").html("")
                $.ajax({
                    url:"/house_out_num_select2",
                    type:"get",
                    data: {
                        "data1" : $("#modal_select1").val(),
                        "data2" : $(this).val()
                    },
                    dataType:'json',
                    beforeSend : function(xhr){
                        xhr.setRequestHeader(header, token);
                    },
                    success: function(data){
                        console.log("@@@@@@@")
                        console.log(data)

                        let house_code_item;
                        for(let i = 0; i < data.length; i++){
                            house_code_item += '<div class="house_inner_num_item">'
                            house_code_item += '<p class="house_inner_num_title">'+data[i].house_code+'</p>'
                            house_code_item += '<p class="house_inner_num_count">'
                            house_code_item += '<span>'+data[i].now_quantity+'</span>'
                            house_code_item += '/<span>'+data[i].max_quantity+'</span></p></div>'

                        }
                        $(".house_inner_num_box").append(house_code_item)
                        $(".house_inner_num_box").html($(".house_inner_num_box").html().replace('undefined',''))

                    },
                    error: function(e){
                        alert(e)
                    }
                })
            })

            $(document).on("click", ".house_inner_num_item",function(){

                let house_address_result;

                house_address_result = $(this).find(".house_inner_num_title").text();

                result_input.val(house_address_result)
                
                $(".modal").fadeOut();
                $("body").css({
                    "overflow": "visible",
                    "margin-left" : "0"
                })

            })
            

       })


       $(".modal_out").click(function(){
           $(".modal").fadeOut();
           $("body").css({
               "overflow": "visible",
               "margin-left" : "0"
           })
         
       })
   
   
   
   
})