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
    <link rel="stylesheet" href="../resources/css/recipe_detail.css">

    <title>복산김치WMS_레시피상세보기</title>
</head>
<body>
   <div id="wrap">
       
       	<jsp:include page="header.jsp"></jsp:include>
       
        <div id="container">
            <section class="b_inquiry_main">
                <div class="b_title">
                    <h1>레시피상세보기</h1>
                    ${choiseRecipe}
                    <h2 class="hidden"></h2>
                </div> <!--.b_main-->
                <div class="b_content b_content_width_m">
                    <div class="recipe_product_name">
                        <h3 class="small_title">상품명</h3>
                        <p>${choiseRecipe[0].product_name}(${choiseRecipe[0].recipe_code})</p>
                    </div>
                    <table class="b_table margin_t50">
                        <h3 class="small_title">재료목록</h3>
                        
                        <tr class="b_table_title">
                            <th>
                                <p>재료명</p>
                            </th>
                            <th>
                                <p>중량(KG)</p>
                            </th>
                        </tr>
                        <c:forEach items="${choiseRecipe}" var="material">
                        <tr class="b_table_data">
                            <td>
                                <p>${material.material_name}(${material.product_code})</p>
                            </td>
                            <td>
                                <p>${material.material_num}</p>
                            </td>
                        </tr>
                        </c:forEach>
                        
                    </table>
                    <div>
                        <h3 class="small_title mar_t_recipe">상세내용</h3>
                        <div class="recipe_content_info">
                            <textarea name="" id="" readonly>${choiseRecipe[0].content}</textarea>
                            <div>
                                <p>총중량 : <span>${choiseRecipe[0].gross_weight}kg</span></p>
                                <p>제작일 : <span>${choiseRecipe[0].production_date}</span></p>
                                <p>레시피제작자 : <span>${choiseRecipe[0].maker_name}</span></p>
                                <p class="btn_l_g recipe_update_btn">
                                	<input type="button" value="레시피수정하기">
                                	<a href="recipe_update?product_code=${choiseRecipe[0].recipe_code}" style="display:hidden" id="update_link"></a>
                                </p>
                                <p class="btn_l_b recipe_out_btn">
                                	<input type="submit" value="레시피나가기">
                                	<a href="recipe_inquiry" style="display:none" id="recipe_exit"></a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div> <!--#container-->
        
        <jsp:include page="footer.jsp"></jsp:include>
        
    </div> <!--#wrap-->

    <!-- 3. jQuery 연결 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

    <!--헤더 js-->
    <script src="../resources/js/header.js"></script>
    
    <!-- recipe_detail js -->
    <script src="../resources/js/recipe_detail.js"></script>
</body>
</html>