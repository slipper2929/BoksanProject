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
    <!--입력 폼css-->
    <link rel="stylesheet" href="../resources/css/inputform.css">
    <!--메인 css-->
    <link rel="stylesheet" href="../resources/css/product.css">



    <title>복산김치WMS_창고등록</title>
</head>
<body>
   <div id="wrap">
      
      	<jsp:include page="header.jsp"></jsp:include>  

        <div id="container">
            <section class="b_inputform_main">
                <div class="b_inputform_title">
                    <h1>창고등록</h1>
                </div> <!--.b_main-->
                <div class="b_content b_content_width_m">
                    <form action="" method="post" class="boksan_submit">
                        <p class="b_text b_inputform_name">
                        <p class="b_text b_select">
                            <label><span>기능</span>
                                <select name="house_function" class="gap">
                                    <option value="">선택안함</option>
                                    <c:forEach items="${hlist }" var="hlist">     
                                    <option value="${hlist.function_code }">${hlist.function_name }</option>
                                    </c:forEach>                                
                                </select>
                            </label>
                        </p>
                        <p class="b_text">
                            <label><span>out_num</span><input type="text" class="sc_check only_one_check num_check gap" name="out_num" placeholder="숫자로 한글자만 입력"></label>
                        </p>
                        <p class="b_text">
                            <label><span>in_num</span><input type="text" class="sc_check only_one_check english_upper_check gap" name="in_num" placeholder="영어대문자로 한글자만 입력"></label>
                        </p>
                        <p class="b_text">
                            <label><span>detail_position</span><input type="text" class="sc_check" name="detail_position"></label>
                        </p>                       
                        <div class="b_submit btn_l_b">
                            <input type="button" class="button_submit" value="창고등록">
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
	<!--유효성검사-->
    <script src="../resources/js/b_regExp_check.js"></script>
</body>
</html>