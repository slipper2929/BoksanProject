<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--노토산스 글꼴-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">

    <!-- 3-1. jQueryUI 연결(animate) -->
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">

    <!--초기화css-->
    <link rel="stylesheet" href="../resources/css/reset.css">
    <!--헤더css-->
    <link rel="stylesheet" href="../resources/css/header.css">
    <!--푸터css-->
    <link rel="stylesheet" href="../resources/css/footer.css">
    <!--입력폼css-->
    <link rel="stylesheet" href="../resources/css/inputform.css">
    <!--조회css-->
    <link rel="stylesheet" href="../resources/css/inquiry.css">
    <!--메인css-->
    <link rel="stylesheet" href="../resources/css/pallet.css">



    <title>복산김치WMS_파레트관리</title>
</head>
<body>
    <div id="wrap">
       
       	<jsp:include page="header.jsp"></jsp:include>
       
        <div id="container">
            <section class="b_inputform_main b_inquiry_main" >
                <div class="b_inputform_title">
                    <h1>파레트관리</h1>
                </div>
                <div class="b_content b_content_width_m">
                	<form action="/pallet" method="post" id="form_add">
	                   
	                    <p class="b_text b_select b_inputBox">
	                        <label><span>수량추가</span>
	                            <input type="text" name="pallet_count" value="" class="num_check" id="pallet_count" placeholder="수량을 입력하세요">
	                        </label>
	                    </p>
	                    <p class="btn_s_b pallet_add_btn"><input type="submit" value="추가하기" id="pallet_add_btn"></p>
	                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
                    </form>
                </div>    
                
                <form action="/pallet_delete" method="post" id="pallet_delete_form">
                <table class="b_table margin_t50" id = "PS_table">
                    <tr class="b_table_title">
                        <th>
                            <p>파레트번호</p>
                        </th>
                        <th>
                            <p>삭제</p>
                        </th>
                    </tr>
                 </table>
                 <div id = "scroll">
                 <table class="b_table margin_t50 tablerd">
                   	<c:forEach items="${plist}" var="pl">
                   		<tr class="b_table_data">
                   			<td><p>${pl.pallet_num}</p></td>
                   			<td><p><input type="checkbox" class="pallet_check" value="${pl.pallet_num}"></p></td>
                   		</tr>
                   	</c:forEach>
                   	     
                </table>
                </div>
                <p class="pallet_all_check"><input type="checkbox" id="pallet_all_check">전체체크하기</p>
                <p class="btn_l_r pallet_delete_check_btn"><input type="button" value="체크된 파레트 삭제하기"></p>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
                </form>
                
            </section>
            
        </div> <!--#container-->
        
        <jsp:include page="footer.jsp"></jsp:include>
        
    </div> <!--#wrap-->

    <!-- 3. jQuery 연결 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

    <!--헤더 js-->
    <script src="../resources/js/header.js"></script>

    <!--유효성검사 js-->
    <script src="../resources/js/b_regExp_check.js"></script>
    
    <!-- ajax 상품분류에 따른 상품목록 가져오기 -->
    <script src="../resources/js/product_select.js"></script>
    
    <!-- pallet.js -->
    <script src="../resources/js/pallet.js"></script>
</body>
</html>