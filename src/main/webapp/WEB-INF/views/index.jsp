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
    <!--푸터css-->
    <link rel="stylesheet" href="../resources/css/footer.css">
    <!--메인css-->
    <link rel="stylesheet" href="../resources/css/style.css">



    <title>복산김치WMS</title>
</head>
<body>
  <div id="wrap">
        <%-- <header class="b_header">
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
        </header> <!--header 끝--> --%>
        
        

		<jsp:include page="header.jsp"></jsp:include>

        
        <div id="container">
            <section class="b_main1">
                <h2 class="b_main1_title">업무별 기능모음</h2>
                <div class="b_main1_department">
                    <div class="b_main1_factory"> <!--생산공장-->
                        <div class="b_main1_smallTitle">
                            <h3>생산공장</h3>    
                        </div>
                        <div>
                            <ul>
                                <li>
                                    <p><a href="#">상품조회</a></p>
                                </li>
                                <li>
                                    <p><a href="#">상품별조회</a></p>
                                </li>
                                <li>
                                    <p><a href="#">로케이션별조회</a></p>
                                </li>
                                <li>
                                    <p><a href="#">레시피추가</a></p>
                                </li>
                                <li>
                                    <p><a href="#">레시피목록</a></p>
                                </li>
                                <li>
                                    <p><a href="#">레시피상세보기</a></p>
                                </li>
                                <li>
                                    <p><a href="#">입고신청</a></p>
                                </li>
                                <li>
                                    <p><a href="#">출고요청</a></p>
                                </li>
                                <li>
                                    <p><a href="#">출고요청처리현황</a></p>
                                </li>
                            </ul>
                        </div>   
                    </div> <!--생산공장 끝-->
                    <div class="b_main1_material"> <!--자재관리부서-->
                        <div class="b_main1_smallTitle">
                            <h3>자재관리부서</h3>    
                        </div>
                        <div>
                            <ul>
                                <li>
                                    <p><a href="#">상품조회</a></p>
                                </li>
                                <li>
                                    <p><a href="#">상품별조회</a></p>
                                </li>
                                <li>
                                    <p><a href="#">로케이션별조회</a></p>
                                </li>
                                <li>
                                    <p><a href="#">이동지시</a></p>
                                </li>
                                <li>
                                    <p><a href="#">파레트관리</a></p>
                                </li>
                                <li>
                                    <p><a href="#">발주신청</a></p>
                                </li>
                                <li>
                                    <p><a href="#">출고요청결제</a></p>
                                </li>
                            </ul>
                        </div>   
                    </div> <!--자재관리부서 끝-->
                    <div class="b_main1_house"> <!--물류창고-->
                        <div class="b_main1_smallTitle">
                            <h3>물류창고</h3>    
                        </div>
                        <div>
                            <ul>
                                <li>
                                    <p><a href="#">상품조회</a></p>
                                </li>
                                <li>
                                    <p><a href="#">상품별조회</a></p>
                                </li>
                                <li>
                                    <p><a href="#">로케이션별조회</a></p>
                                </li>
                                <li>
                                    <p><a href="#">이동목록</a></p>
                                </li>
                                <li>
                                    <p><a href="#">파레트관리</a></p>
                                </li>
                                <li>
                                    <p><a href="#">입고대기목록</a></p>
                                </li>
                                <li>
                                    <p><a href="#">출고지시목록</a></p>
                                </li>
                            </ul>
                        </div>   
                    </div> <!--물류창고 끝-->
                </div>
            </section>
        </div> <!--#container-->



		<jsp:include page="footer.jsp"></jsp:include>
		
<!--         <footer class="b_footer">
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
        </footer> #footer -->
    </div> <!--#wrap-->

    <!-- 3. jQuery 연결 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    
    
</body>
</html>