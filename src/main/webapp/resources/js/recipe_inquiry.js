/**
 * 
 */
 
 $(function(){
 
 	$("#searchbtn").on("click", function(e){

		//키워드가 입력되어 있지 않으면
		if($("#keyword").val()==""){
			alert("키워드를 입력하세요");
			return false;
		}
		// 검색버튼 클릭시 무조건 1페이지부터 검색할 수 있도록
		//pagenum을 1로 셋팅
		$("#pagenum").val("1")
		
		$("#searchForm").submit();
	}) //검색버튼을 클릭했을 때의 끝
 
 
 	$(".pageNo").on("click", function(e){
		e.preventDefault();
		// 사용자가 선택한 페이지 번호를 
		//<input type="text" id="pagenum" name="pagenum" value="">
		//값 세팅
		$("#pagenum").val($(this).attr("href"));
//		$("#type").val();
//		$("#keyword").val();
//		$("#amount").val();
		//if($("#keyword").val() == ""){
			//url에있는 pcategory값 가져오는 코드
			//var search = location.search
			//var params = new URLSearchParams(search);
			//var getCategory= params.get('pcategory');
			//$("#pcategory").val(getCategory)
		//}
	
		//그래서 다 들고 서브밋합니다
		$("#pageForm").submit();
	})
	
	//페이지버튼 클릭한것만 색깔넣기
	for(let i = 0; i < $(".pageNo").length; i++){
		
		if($(".pageNo").eq(i).find("span").text() == $("#pagenum").val()){
			
			$(".pageNo").eq(i).css({
				"color" : "#ff623e"
			})
		}
	}
	
	
	
	
 })