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
    <!--메인css-->
    <link rel="stylesheet" href="../resources/css/check.css">




    <title>복산김치WMS_입고대기목록_검증</title>
</head>
<body>
   <div id="wrap">
 
 		<jsp:include page="header.jsp"></jsp:include>
        
        <div id="container">
            <section class="b_inputform_main">
                <div class="b_inputform_title">
                    <h1>입고대기목록_검증</h1>
                </div> <!--.b_main-->
                <div class="b_content b_content_width_l" id="b_content_check">
                    <form method="post">
                        <p class="b_text b_inputform_name">
                            <label><span class="b_check_bacode">발행한 입고상품바코드</span>
                            	<input type="text" placeholder="내용을 입력해주세요." class="B_input check_barcode_text">
                            </label>
                            
                        </p>
                        <p class="b_text b_inputform_name">
                            <label><span>로케이션 바코드</span><input name="house_code" class="check_house_barcode" type="text" placeholder="내용을 입력해주세요."></label>
                            
                        </p>
                        <p class="b_check_ps">*검증에 실패하면 새로 바코드발행을 해야합니다.</p>
                        <div class="b_submit btn_l_b">
                            <input class="check_btn" type="button" value="검증 후 입고완료하기">
                        </div>
                        	<input type="hidden" class="product_code" name="product_code">
                        	<input type="hidden" class="arrive_num" name="stock_num">
                        	<input type="hidden" class="arrive_date" name="arrive_date">
                        	<input type="hidden" class="pallet_num" name="pallet_num">
                        	<input type="hidden" class="arrive_code" name="arrive_code">
                        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
                    </form>
                </div> <!--.b_content-->
            </section>
        </div>
	
		<jsp:include page="footer.jsp"></jsp:include>
		
    </div> <!--#wrap-->

    <!-- 3. jQuery 연결 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

    <!--헤더 js-->
    <script src="../resources/js/header.js"></script>

    <!--입력폼 js-->
    <script src="../resources/js/inputform.js"></script>
    
    <!-- check js -->
    <script src="../resources/js/check.js"></script>
</body>
</html>