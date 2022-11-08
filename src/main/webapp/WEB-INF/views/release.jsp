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
        <header class="b_header">
            <section class="b_header_in">
                <div class="b_header_top">
                    <article class="b_header_logo">
                        <a href="/">
                            <h1>로고입니다</h1>
                        </a>
                    </article>
                    <article class="b_header_util">
                    	<c:if test="${member == null }">
	                        <div class="b_header_login"><a href="/login">로그인</a></div>
	                        <div class="b_header_join"><a href="/join">회원가입</a></div>
                        </c:if>
                        <c:if test="${member != null }">
                        	<div class="b_header_logout"><a href="/logout">로그아웃</a></div>
                        </c:if>
                    </article>
                    <c:if test="${member != null}">
	                    <article class="b_beader_user">
	                    	<p><span>${member.name}</span>님 반갑습니다.</p>
	                    </article>
                    </c:if>
                </div>
                <nav class="b_header_nav">
                    <ul class="b_header_nav_menu">
                        <li> <!--상품-->
                            <p><a href="#">상품</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li> <!--상품등록-->
                                    <p><a href="/product">상품등록</a></p>
                                </li> <!--상품등록끝-->
                                <li> <!--상품분류등록-->
                                    <p><a href="/group_add">상품분류등록</a></p>
                                </li> <!--상품분류등록끝-->
                                <li> <!--상품조회-->
                                    <p><a href="#">상품조회</a></p>
                                    <ul class="b_header_nav_menu_small">
                                        <li>
                                            <p><a href="/product_inquiry">상품조회</a></p>
                                        </li>
                                        <li>
                                            <p><a href="/product_position_inquiry">상품별조회</a></p>
                                        </li>
                                        <li>
                                            <p><a href="/location_inquiry">로케이션별조회</a></p>
                                        </li>
                                    </ul>
                                </li> <!--상품조회 끝-->
                            </ul>
                        </li> <!--상품 끝-->
                        <li> <!--재고-->
                            <p><a href="#">재고</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li>
                                    <p><a href="#">재고이동</a></p>
                                    <ul class="b_header_nav_menu_small">
                                        <li>
                                            <p><a href="/move_order">이동지시</a></p>
                                        </li>
                                        <li>
                                            <p><a href="/move_order_list">이동목록</a></p>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <p><a href="#">재고관리</a></p>
                                    <ul class="b_header_nav_menu_small">
                                        <li>
                                            <p><a href="/pallet">파레트관리</a></p>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li> <!--재고 끝-->
                        <li> <!--입고-->
                            <p><a href="#">입고</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li>
                                    <p><a href="/arrive_list">입고대기목록</a></p>
                                </li>
                                <li>
                                    <p><a href="/arrive">입고신청</a></p>
                                </li>
                            </ul>
                        </li> <!--입고-->
                        <li> <!--발주-->
                            <p><a href="#">발주</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li>
                                    <p><a href="/order">발주신청</a></p>
                                </li>
                            </ul>
                        </li> <!--발주 끝-->
                        <li> <!--출고-->
                            <p><a href="#">출고</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li>
                                    <p><a href="/release">출고요청</a></p>
                                </li>
                                <li>
                                    <p><a href="/release_state_inquiry">출고요청처리현황</a></p>
                                </li>
                                <li>
                                    <p><a href="/release_pay">출고요청결제</a></p>
                                </li>
                                <li>
                                    <p><a href="/release_order_list">출고지시목록</a></p>
                                </li>
                            </ul>
                        </li> <!--출고끝-->
                        <li> <!--레시피-->
                            <p><a href="#">레시피</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li>
                                    <p><a href="/recipe_add">레시피추가</a></p>
                                </li>
                                <li>
                                    <p><a href="/recipe_inquiry">레시피목록</a></p>
                                </li>
                                <li>
                                    <p><a href="/recipe_detail">레시피상세보기</a></p>
                                </li>
                            </ul>
                        </li> <!--레시피 끝-->
                        <li class="b_header_nav_manager"> <!--관리자-->
                            <p><a href="/manager_main" class="b_header_nav_manager_btn">관리자페이지로 이동</a></p>
                        </li> <!--관리자 끝-->
                    </ul>
                </nav> <!--메뉴바 끝-->
            </section><!--.b_header_in-->
        </header> <!--header 끝-->
        
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
            	</form>
            </section>
        </div>



        
        



        <footer class="b_footer">
            <div class="b_footer_in">
                <div class="b_footer_top">
                    <div class="b_footer_logo">로고입니다</div>
                    <div class="b_footer_info">
                        <p>(주)복산김치</p>
                        <p>
                            <span>사업자등록번호 : 000-00-00000 </span>
                            <span class="b_footer_line"></span>
                            <span>통신판매업 신고번호 : 제 2000-00호</span>
                        </p>
                        <p>주소 : 울산광역시 중구 종가로 406-12 / 비즈파크c동 3층</p>
                        <p>
                            <span>업무문의 : 1500-0000</span>
                            <span class="b_footer_line"></span>
                            <span>FAX :  000-000-0000</span>
                            <span class="b_footer_line"></span>
                            <span>E-mail : slipper2929@naver.com</span>
                        </p>
                    </div>
                </div>
                <div class="b_footer_copyright">
                    <p>Copyright ⓒ 2022 BOKSANKIMCHI CO. Rights Reserved.</p>
                </div>
            </div>
        </footer> <!--#footer-->
    </div> <!--#wrap-->

    <!-- 3. jQuery 연결 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

    <!--헤더 js-->
    <script src="../resources/js/header.js"></script>

    <!--입력폼 js-->
    <script src="../resources/js/inputform.js"></script>

    <!--유효성검사 js-->
    <script src="../resources/js/b_regExp_check.js"></script>
    
    <!-- ajax 상품분류에 따른 상품목록 가져오기 -->
    <script src="../resources/js/product_select.js"></script>
    
    <!-- release js -->
    <script src="../resources/js/release.js"></script>
</body>
</html>