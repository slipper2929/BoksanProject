<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="./css/reset.css">
    <!--헤더css-->
    <link rel="stylesheet" href="./css/header.css">
    <!--푸터css-->
    <link rel="stylesheet" href="./css/footer.css">
    <!--조회css-->
    <link rel="stylesheet" href="./css/inquiry.css">
    <!--메인css-->
    <link rel="stylesheet" href="./css/release_state_inquiry.css">



    <title>복산김치WMS_출고요청처리현황</title>
</head>
<body>
    <div id="wrap">
        <header class="b_header">
            <section class="b_header_in">
                <div class="b_header_top">
                    <article class="b_header_logo">
                        <a href="#">
                            <h1>로고입니다</h1>
                        </a>
                    </article>
                    <article class="b_header_util">
                        <div class="b_header_login"><a href="./login.jsp">로그인</a></div>
                        <div class="b_header_join"><a href="./join.jsp">회원가입</a></div>
                    </article>
                </div>
                <nav class="b_header_nav">
                    <ul class="b_header_nav_menu">
                        <li> <!--상품-->
                            <p><a href="#">상품</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li> <!--상품등록-->
                                    <p><a href="./product.jsp">상품등록</a></p>
                                </li> <!--상품등록끝-->
                                <li> <!--상품분류등록-->
                                    <p><a href="#">상품분류등록</a></p>
                                </li> <!--상품분류등록끝-->
                                <li> <!--상품조회-->
                                    <p><a href="#">상품조회</a></p>
                                    <ul class="b_header_nav_menu_small">
                                        <li>
                                            <p><a href="./product_inquiry.jsp">상품조회</a></p>
                                        </li>
                                        <li>
                                            <p><a href="./product_position_inquiry.jsp">상품별조회</a></p>
                                        </li>
                                        <li>
                                            <p><a href="./location_inquiry.jsp">로케이션별조회</a></p>
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
                                            <p><a href="./move_order.jsp">이동지시</a></p>
                                        </li>
                                        <li>
                                            <p><a href="#">이동목록</a></p>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <p><a href="#">재고관리</a></p>
                                    <ul class="b_header_nav_menu_small">
                                        <li>
                                            <p><a href="#">파레트관리</a></p>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li> <!--재고 끝-->
                        <li> <!--입고-->
                            <p><a href="#">입고</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li>
                                    <p><a href="#">입고대기목록</a></p>
                                </li>
                                <li>
                                    <p><a href="./arrive.jsp">입고신청</a></p>
                                </li>
                            </ul>
                        </li> <!--입고-->
                        <li> <!--발주-->
                            <p><a href="#">발주</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li>
                                    <p><a href="./order.jsp">발주신청</a></p>
                                </li>
                            </ul>
                        </li> <!--발주 끝-->
                        <li> <!--출고-->
                            <p><a href="#">출고</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li>
                                    <p><a href="./release.jsp">출고요청</a></p>
                                </li>
                                <li>
                                    <p><a href="#">출고요청처리현황</a></p>
                                </li>
                                <li>
                                    <p><a href="#">출고요청결제</a></p>
                                </li>
                                <li>
                                    <p><a href="#">출고지시목록</a></p>
                                </li>
                            </ul>
                        </li> <!--출고끝-->
                        <li> <!--레시피-->
                            <p><a href="#">레시피</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li>
                                    <p><a href="#">레시피추가</a></p>
                                </li>
                                <li>
                                    <p><a href="./recipe_inquiry.jsp">레시피목록</a></p>
                                </li>
                                <li>
                                    <p><a href="#">레시피상세보기</a></p>
                                </li>
                            </ul>
                        </li> <!--레시피 끝-->
                        <li class="b_header_nav_manager"> <!--관리자-->
                            <p><a href="#" class="b_header_nav_manager_btn">관리자페이지로 이동</a></p>
                        </li> <!--관리자 끝-->
                    </ul>
                </nav> <!--메뉴바 끝-->
            </section><!--.b_header_in-->
        </header> <!--header 끝-->
        
        



        
        <div id="container">
            <section class="b_inquiry_main">
                <div class="b_title">
                    <h1>출고요청처리현황</h1>
                    <h2 class="hidden"></h2>
                </div> <!--.b_main-->
                <div class="b_content b_content_width_m">
                    <div class="release_inquiry">
                        <div>
                            <p class="btn_s_g"><input type="submit" value="출고요청수정"></p>
                            <p>*수정은 대기상태만 가능합니다.</p>                       
                        </div>
                        <div>
                            <select name="" id="">
                                <option value="">선택안함</option>
                                <option value="">대기</option>
                                <option value="">취소</option>
                                <option value="">수락</option>
                                <option value="">출고완료</option>
                            </select>
                            <p class="btn_s_b"><input type="submit" value="보기"></p>
                        </div>
                    </div>
                    <table class="b_table margin_t50">
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
                                <p>상태</p>
                            </th>
                            
                        </tr>
                        <tr class="b_table_data">
                            <td><p>01</p></td>
                            <td><p>절인배추</p></td>
                            <td><p>50kg</p></td>
                            <td><p>대기</p></td>
                        </tr>
                        <tr class="b_table_data">
                            <td><p>02</p></td>
                            <td><p>배추김치5kg</p></td>
                            <td><p>55kg</p></td>
                            <td><p>수락</p></td>
                        </tr>
                        <tr class="b_table_data">
                            <td><p>03</p></td>
                            <td><p>깍두기양념장</p></td>
                            <td><p>10kg</p></td>
                            <td><p>취소(취소사유:재고부족/재신청요망)</p></td>
                        </tr>
                        <tr class="b_table_data">
                            <td><p>04</p></td>
                            <td><p>부추</p></td>
                            <td><p>20kg</p></td>
                            <td><p>출고완료</p></td>
                        </tr>
                    </table>
                    <div class="b_pager">
                        <div><a href=""><span>이전</span></a></div>
                        <div><a href=""><span>1</span></a></div>
                        <div><a href=""><span>2</span></a></div>
                        <div><a href=""><span>3</span></a></div>
                        <div><a href=""><span>4</span></a></div>
                        <div><a href=""><span>5</span></a></div>
                        <div><a href=""><span>6</span></a></div>
                        <div><a href=""><span>7</span></a></div>
                        <div><a href=""><span>8</span></a></div>
                        <div><a href=""><span>9</span></a></div>
                        <div><a href=""><span>10</span></a></div>
                        <div><a href=""><span>다음</span></a></div>
                    </div>
                </div>
            </section>
        </div> <!--#container-->




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
    <script src="./js/header.js"></script>
</body>
</html>