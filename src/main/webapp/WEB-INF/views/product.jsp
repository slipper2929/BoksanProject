<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
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



    <title>복산김치WMS_상품등록</title>
</head>
<body>
	<div class="modalc modal">
 		<div class="modal_content" title="클릭하면 창이 닫힙니다.">
 			<div class="modal_out"></div>
 			<h1>원산지 추가</h1>
 			<div class="modal_line"></div>
 			<div class="modal_input">
 				<label><span></span><input type="text" id="modal_country_data" class="sc_check" name="country_name" placeholder="원산지 이름을 입력하세요."></label>
 			</div>
 			<div class="modalc_btn">등록하기</div>
 		</div>
	</div>
	
	<div class="modalb modal">
 		<div class="modal_content" title="클릭하면 창이 닫힙니다.">
 			<div class="modal_out"></div>
 			<h1>업체 추가</h1>
 			<div class="modal_line"></div>
 			<div class="modal_input">
 				<label><span></span><input type="text" id="modal_business_name_data" class="sc_check" name="business_name" placeholder="업체명을 입력하세요."></label>
 				<label><span></span><input type="text" id="modal_business_tel_data" class="phone_check sc_check" name="business_tel" placeholder="업체 전화번호를 입력하세요."></label>
 			</div>
 			<div class="modalb_btn">등록하기</div>
 		</div>
	</div>
   <div id="wrap">
      
      	<jsp:include page="header.jsp"></jsp:include>
      
        <div id="container">
            <section class="b_inputform_main">
                <div class="b_inputform_title">
                    <h1>상품등록</h1>
                </div> <!--.b_main-->
                <div class="b_content b_content_width_m">
                		<div class="modal_country_btn"></div>
                		<div class="modal_business_btn"></div>
                    <form action="" method="post" class="boksan_submit">
                        <p class="b_text b_inputform_name">
                            <label><span>상품명</span><input type="text" class="sc_check gap" placeholder="이름을 입력해주세요" name="product_name"></label>
                            <p class="b_explanation">이름은 한글 5자이내로만 입력해주세요</p>
                        </p>
                        <p class="b_text b_select">
                            <label><span>분류</span>
                                <select name="product_group_code" class="gap">
                                    <option value="">선택안함</option>
                                    <c:forEach items="${plist }" var="plist">     
                                    <option value="${plist.product_group_code }">${plist.product_group_name }</option>
                                    </c:forEach>                                
                                </select>
                            </label>
                        </p>
                        <p class="b_text b_select">
                            <label><span>원산지</span>
	                           <select name="country_code" id="" class="country_select_box gap">
	                               <option value="">선택안함</option>
	                               <c:forEach items="${pclist}" var="pclist">
	                           	<option value="${pclist.country_code}">${pclist.country_name}</option>
	                       		</c:forEach>
	                       		
	                           </select>
                            </label>
                        </p>
                        <p class="b_text b_select">
                            <label><span>업체명</span>
                            	<select name="business_code" id="" class="business_select_box gap">
	                               	<option value="">선택안함</option>
	                               	<c:forEach items="${pblist}" var="pblist">
	                           		<option value="${pblist.business_code}">${pblist.business_name}</option>
	                       			</c:forEach>
	                           </select>
                            </label>
                        </p>
                        <p class="b_text">
                            <label><span>구매가</span><input type="text" class="sc_check gap num_check" name="price"></label>
                        </p>
                        <p class="b_text">
                            <label><span>파레트중량</span><input type="text" class="sc_check gap num_check" name="pallet_in_ratio"></label>
                        </p>
                        <p class="b_product_ps">*1파레트에 들어갈수 있는 최대중량(KG단위)</p>
                        <div class="b_submit btn_l_b">
                            <input type="button" class="button_submit" value="상품등록">
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    </form>
                </div> <!--.b_content-->
            </section>
            <div>
        <h1>Excel Download</h1>
    </div>
        </div>
        
        <jsp:include page="footer.jsp"></jsp:include>
        
    </div> <!--#wrap-->

    <!-- 3. jQuery 연결 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

    <!--헤더 js-->
    <script src="../resources/js/header.js"></script>
	<!-- 유효성 검사 -->
    <script src="../resources/js/b_regExp_check.js"></script>
    <!-- product js -->
    <script src="../resources/js/product.js"></script>
</body>
</html>