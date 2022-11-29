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
    <link rel="stylesheet" href="../resources/css/arrive.css">




    <title>복산김치WMS_입고신청</title>
</head>
<body>
   <div id="wrap">
   
  		<jsp:include page="header.jsp"></jsp:include>
        
        <div id="container">
            <section class="b_inputform_main">
                <div class="b_inputform_title">
                    <h1>입고신청</h1>
                </div> <!--.b_main-->
                <div class="b_content b_content_width_l">
                    <form id="b_arrive" method="post" class="boksan_submit">
                        <p class="b_text b_select">
                            <label><span>입고할 상품</span>
                                <select class="recipe_product_selectbox pg_box gap">
                                	<option value="">선택안함</option>
                                	<c:forEach items="${pglist}" var="pg">
                                		<c:if test="${pg.product_group_type == 'B' || pg.product_group_type == 'C'}">
                                    	<option value="${pg.product_group_code}">${pg.product_group_name}</option>
                                    	</c:if>
                             		</c:forEach>
                                </select>
                                <select name="product_code" id="recipe_product_code_select" class="recipe_product_selectbox b_arrive_select gap">
                                    <option value="">선택안함</option>
                                </select>
                            </label>
                        </p>
                        <p class="b_text b_inputform_name">
                            <label><span>중량</span><input type="text" placeholder="내용을 입력해주세요." class="sc_check num_check gap" id="arrive_num" name="arrive_num"></label>
                            <span class="weight">kg</span>
                            <p class="b_explanation">이름은 한글 5자이내로만 입력해주세요</p>
                        </p>
                        <p class="b_arrive_ps">*해당상품은 키로(KG)단위로 입고합니다.</p>
                        <div class="b_submit btn_l_b">
                            <input type="button" class="button_submit" value="입고신청">
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

    <!--유효성검사 js-->
    <script src="../resources/js/b_regExp_check.js"></script>
    
    <!-- ajax 상품분류에 따른 상품목록 가져오기 -->
    <script src="../resources/js/product_select.js"></script>
</body>
</html>