$(function(){


check();

//유효성검사
function check(){

    //만들어야하는 정규식 남은거 : 입고대기목록의 입고일, 입고시킬 창고번지
    //                              회원가입폼, 로그인폼

    let sc_check = $(".sc_check")
    let num_check = $(".num_check")

    //회원가입폼 관련
    let name_check = $(".name_check")
    let residentNum_check = $(".residentNum_check")
    let address_check = $(".address_check")
    let id_check = $(".id_check")
    let pw_check = $(".pw_check")
    let pw_check2 = $(".pw_check2")

    //특수문자 안받기
    sc_check.change(function(){
        
        var regExp = /[\{\}\[\]\?.,;:|\*~`!^\_+<>@\#$&\\\=\\\"]/g;
        
        if(regExp.test($(this).val())){
            alert("특수문자는/)-(%',를 제외하고는 입력할 수 없습니다");
            $(this).val("").focus();
        }
        
    })

    //숫자만 받기
    $(document).on("change", ".num_check", function(){
        
        var regExp = /^[0-9]+$/g;
        
        if(!regExp.test($(this).val())){
            alert("숫자로만 입력해주세요");
            $(this).val("").focus();
        }
        
    })
    
    //영어대문자만 받기
        $(document).on("change", ".english_upper_check", function(){
        
        var regExp = /^[A-Z]+$/g;
        
        if(!regExp.test($(this).val())){
            alert("영어 대문자로만 입력해주세요");
            $(this).val("").focus();
        }
        
    })

    //회원가입관련 검사---------------------

    //회원가입_이름(한글로 5글자 이내)
    name_check.change(function(){
        
        var regExp = /^[가-힣]{2,6}$/g;
        
        if(!regExp.test($(this).val())){
            alert("2~6자 한글로만 입력하세요");
            $(this).val("").focus();
        }
        
        
        
    })

    //회원가입_주민번호(숫자로만13자 입력)
    residentNum_check.change(function(){
        
        var regExp = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))[-]?[1-4][0-9]{6}$/g;
        if(!regExp.test($(this).val())){
            alert("주민번호를 다시 확인해주세요(-은 넣어도되고 안넣어도 됩니다)");
            $(this).val("").focus();
        }

        //2월일때
        if($(this).val().substr(2,1) == 0 && $(this).val().substr(3,1) == 2){
            
            var check_year = $(this).val().substr(0,2)
            var check_day = $(this).val().substr(4,2)

            //윤년구하기
            if(check_day  == 29){
                if(check_year % 4 != 0){ //윤년이 아님
                    alert("주민번호를 다시 확인해주세요(해당년은 윤년이 아닙니다)");
                    $(this).val("").focus();
                }
            } else if(check_day > 29 || check_day < 1){
                alert("주민번호를 다시 확인해주세요(해당일이 이상합니다)");
                $(this).val("").focus();
            }

        }
        
        
    })

    //회원가입_주소(일부특수문자안받기sc_check)
    
    ////회원가입_아이디(영어대문자 혹은 소문자로 시작,영어혹은 숫자, 길이 5~15자)
    id_check.change(function(){
        
        var regExp = /^[a-zA-Z][0-9a-zA-Z]{4,14}$/g;
        
        if(!regExp.test($(this).val())){
            alert("영어대문자 혹은 소문자로 시작하는 영어,숫자 아이디를 5~15자이내로 입력하세요");
            $(this).val("").focus();
        }
        
        let chch = "";
        overlapId(id_check.val(),function(chch){
     
        	if(chch == "0"){
        		alert("중복된 아이디입니다.");
        		console.log($(this))
        		$(".user_id").val("").focus();
        	} else if(chch == "1"){
        		alert("사용가능한 아이디입니다.");
        	}
        })
    })
    
    //아이디중복검사(ajax)
    
    function overlapId(id,callback){
    	$.getJSON("/replies/overlapId/"+id+".json", function(data){
    		if(data == ""){
	        	chch = "1";
	        }else if(data[0].id == id){
				chch = "0"
			}
			
			if(callback){
				callback(chch);
			}
    	})
    	return overlapId;
    }

    ////회원가입_비밀번호(하나 이상의 영문자, 숫자, 특수문자를 포함한 길이 8~20자)
    pw_check.change(function(){
        
        var regExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,20}$/g;
        
        if(!regExp.test($(this).val())){
            alert("하나 이상의 영문자, 숫자, 특수기호를 넣어서 8~20자 이내로 입력하세요");
          	$(this).val("").focus();
        }
        
    })

    //비밀번호확인
    pw_check2.change(function(){
        if(pw_check.val() != pw_check2.val()){
            alert("비밀번호가 일치하지 않습니다.")
            $(this).val("").focus();
        }
        
    })

    // $(".jointest").click(function(){
    //     $(".indextest").get(0).click();
    // })
}


    

})