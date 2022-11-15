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
    <link rel="stylesheet" href="../resources/css/group_add.css">




    <title>복산김치WMS_상품분류추가</title>
</head>
<body>
     <div id="wrap">
      
      	<jsp:include page="header.jsp"></jsp:include>
        
        <div id="container">
            <section class="b_inputform_main">
                <div class="b_inputform_title">
                    <h1>상품분류추가</h1>
                </div> <!--.b_main-->
                <div class="b_content b_content_width_m">
                    <form action="" method="post">
                        <p class="b_text b_inputform_name">
                            <label><span>상품분류명</span><input type="text" placeholder="내용을 입력해주세요." class="sc_check" name="product_group_name"></label>
                            <p class="b_explanation">이름은 한글 5자이내로만 입력해주세요</p>
                        </p>
                        <p class="b_select b_inputform_name b_text">
                        <span>상품분류타입</span>
                        <select name="product_group_type">
	                       	<option value="A">식자재타입</option>
                        	<option value="B">가공품타입</option>
                        	<option value="C">완제품타입</option>
                        	<option value="D">공산품타입</option>
                        </select>
                        </p>
                        <div class="b_submit btn_l_b">
                            <input type="submit" value="상품분류등록">
                        </div>
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

    <!--유효성검사-->
    <script src="../resources/js/b_regExp_check.js"></script>
</body>
</html>