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
    <!--조회css-->
    <link rel="stylesheet" href="../resources/css/inquiry.css">
    <!--메인css-->
    <link rel="stylesheet" href="../resources/css/recipe_add.css">

    <title>복산김치WMS_레시피추가</title>
</head>
<body>
   <div id="wrap">
        
        <jsp:include page="header.jsp"></jsp:include>
        
        <div id="container">
        	${pglist}
        	${member}
            <section class="b_inquiry_main">
                <div class="b_title">
                    <h1>레시피추가</h1>
                    <h2 class="hidden"></h2>
                </div> <!--.b_main-->
                <div class="b_content b_content_width_m">
                    <div class="recipe_product_chois">
                        <h3 class="small_title">상품선택하기</h3>
                        <select name="" id="" class="recipe_product_selectbox pg_box">
                        	<option value="">선택안함</option>
                        	<c:forEach items="${pglist}" var="pg">
                        		<c:if test="${pg.product_group_type == 'B' || pg.product_group_type == 'C' }">
                            	<option value="${pg.product_group_code}">${pg.product_group_name}</option>
                            	</c:if>
                        	</c:forEach>
                        </select>
                        <select name="" id="recipe_product_code_select" class="recipe_product_selectbox">
                            <option value="">선택안함</option>
                        </select>
                    </div>
                    <form method="post"> <!-- teble 이랑 밑에 버튼까지 전체 포함 -->
                    <table class="b_table margin_t50">
                        <h3 class="small_title">재료선택하기</h3>
                        <p class="btn_s_b table_btn"><input type="button" value="재료추가" id="add_btn"></p>
                        <tr class="b_table_title">
                            <th>
                                <p>재료선택</p>
                            </th>
                            <th>
                                <p>중량(KG)</p>
                            </th>
                            <th>
                                <p>삭제</p>
                            </th>
                        </tr>
                        <script>
							let code_list = []
							let name_list = []

							<c:forEach items="${pglist}" var="pg">
								code_list.push("${pg.product_group_code}")
								name_list.push("${pg.product_group_name}")
							</c:forEach>
                        </script>
                        
                        <tr class="b_table_data">
                            <td>
                                <p>
                                    <select name="" id="" class="recipe_product_selectbox pg_box">
                                        <option value="">선택안함</option>
                                        <c:forEach items="${pglist}" var="pg">
                                        	<c:if test="${pg.product_group_type == 'A' || pg.product_group_type == 'B' }">
			                            	<option value="${pg.product_group_code}">${pg.product_group_name}</option>
			                            	</c:if>
			                        	</c:forEach>
                                    </select>
                                    <select id="" class="recipe_product_selectbox product_code_list">
                                        <option value="">선택안함</option>
                                    </select>
                                </p>
                            </td>
                            <td class="recipe_weight">
                                <p><input type="text" placeholder="중량을 입력하세요" class="num_check weight_num"></p>
                            </td>
                            <td class="recipe_delete">
                                <p class="btn_s_r recipe_delete_btn"><input type="button" value="재료삭제" class="delete_btn"></p>
                            </td>
                        </tr>
                        
                        
                    </table>
                    <div>
                        <h3 class="small_title mar_t_recipe">상세내용</h3>
                        <div class="recipe_content_info">
                            <textarea name="content" id=""></textarea>
                            <div>
                            	<input type="text" id="recipe_product_code" name="recipe_code">
                            	<input type="text" id="recipe_product_name" name="product_name">
                            	<input type="text" id="recipe_weight" name="gross_weight">
                            	<input type="text" id="recipe_date" name="production_date">
                            	<input type="text" id="" name="emp_code" value="${member.emp_code}">
                                <p class="weight">총중량 : <span>0</span></p>
                                <p class="date_now">제작일 : <span></span></p>
                                <p>레시피제작자 : <span>${member.name}</span></p>
                                <p class="btn_l_b recipe_save_btn"><input type="button" value="레시피저장"></p>

                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
                    </form>
                </div>
            </section>
        </div> <!--#container-->
		<script>
			let sb_recipe_list = []

			<c:forEach items="${rlist}" var="rl">
				sb_recipe_list.push("${rl}")
			</c:forEach>
        </script>
        
        <jsp:include page="footer.jsp"></jsp:include>
        
    </div> <!--#wrap-->

    <!-- 3. jQuery 연결 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

    <!--헤더 js-->
    <script src="../resources/js/header.js"></script>

    <!--유효성검사 js-->
    <script src="../resources/js/b_regExp_check.js"></script>
       
    <!-- recipe_add js -->
    <script src="../resources/js/recipe_add.js"></script>
    
    
</body>
</html>