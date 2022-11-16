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
    <link rel="stylesheet" href="../resources/css/release.css">




    <title>복산김치WMS_출고요청</title>
    
</head>
<body>
   <div id="wrap">
     	
     	<jsp:include page="header.jsp"></jsp:include>
     	
        <div id="container">
            <section class="b_inputform_main">
                <div class="b_inputform_title">
                    <h1>출고요청</h1>
                    
                </div> <!--.b_main-->
                <div class="b_content b_content_width_l">
                    <form action="" id="b_release">
                        <p class="b_text b_select">
                            <label><span>출고할 상품</span>
                                <select name="" id="" class="recipe_product_selectbox pg_box">
		                        	<option value="">선택안함</option>
		                        	<c:forEach items="${pglist}" var="pg">
		                        		<c:if test="${pg.product_group_type == 'B' || pg.product_group_type == 'C' }">
		                            		<option value="${pg.product_group_code}">${pg.product_group_name}</option>
		                            	</c:if>
		                        	</c:forEach>
		                        </select>
		                        
                                <select name="" id="recipe_product_code_select" class="recipe_product_selectbox release_selectbox">
		                            <option value="">선택안함</option>
		                        </select>
                            </label>
                        </p>
                        <p class="b_text b_inputform_name">
                            <label><span>중량</span><input type="text" placeholder="중량을 입력해주세요." class="num_check release_weight"></label>
                            <p class="b_explanation">이름은 한글 5자이내로만 입력해주세요</p>
                        </p>
                        <p class="b_release_ps">*해당상품은 키로(KG)단위로 출고합니다.</p>
                        <div class="b_submit btn_l_b">
                            <input type="button" value="검색해서 출고요청 추가" id="release_search_btn">
                        </div>    
                    </form>
                </div> <!--.b_content-->
            </section>
            <script>
				let sb_recipe_list = []
	
				<c:forEach items="${rlist}" var="rl">
					sb_recipe_list.push("${rl}")
				</c:forEach>
	        </script>
            <section class="b_inputform_main section2">
                <h2 class="small_title">출고요청 상품목록</h2>
                <div class="b_content b_content_width_l">
                    <p class="b_text b_select b_select1">
                        <label><span>출고상품선택</span>
                            <select name="" id="" class="recipe_product_selectbox pg_box">
	                        	<option value="">선택안함</option>
	                        	<c:forEach items="${pglist}" var="pg">
	                            	<option value="${pg.product_group_code}">${pg.product_group_name}</option>
	                        	</c:forEach>
	                        </select>
                            <select name="recipe_product_code_select" id="" class="recipe_product_selectbox release_selectbox">
	                            <option value="">선택안함</option>
	                        </select>
                        </label>
                    </p>
                    <p class="b_text b_select b_inputBox">
                        <label><span>중량</span>
                            <input type="text" placeholder="중량을 입력하세요" class="num_check" id="pw_padd">
                        </label>
                    </p>
                    <p class="btn_s_b pallet_add_btn"><input type="button" value="추가하기" id="release_padd_btn"></p>
            		</div>
            </section>
            <section class="b_inquiry_main">
            	<form method="post" id="release_insert_form">
                <table class="b_table">
                    <tr class="b_table_title">
                        <th>
                            <p>상품코드</p>
                        </th>
                        <th>
                            <p>상품명</p>
                        </th>
                        <th>
                            <p>중량</p>
                        </th>
                        <th>
                            <p>삭제</p>
                        </th>
                    </tr>
                </table>
                <p class="btn_l_b release_list_btn"><input type="button" value="출고요청하기"></p>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <input type="text" name="emp_code" value="${member.emp_code}">
            	</form>
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
    

    <!-- release js -->
    <script src="../resources/js/release.js"></script>
</body>
</html>