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
    <!--메인css-->
    <link rel="stylesheet" href="../resources/css/manager_authority.css">



    <title>복산김치WMS_업무권한부여</title>
</head>
<body>
  <div id="wrap">
     
     	<jsp:include page="header.jsp"></jsp:include>
     	
        <div id="container">
            <section class="b_main1">
                <h2 class="b_main1_title">
                    관리자
                    <span>업무권한부여</span>
                </h2>
                <div class="b_manager_content">
                    <article class="authority_dept">
                        <h3>자재관리부서</h3>
                        <div class="authority_box">
                                <p>권한</p>
                                <ul>
                                    <li>
                                        <p>상품등록(001)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>상품별조회(002)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>로케이션별조회(003)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>레시피목록(004)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>레시피상세(005)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>레시피추가(006)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>이동지시(007)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>출고요청(008)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>자재요청결제(011)</p>
                                        <input type="checkbox">
                                    </li>
                                </ul>
                                <p class="btn_s_b"><input type="submit" value="권한부여"></p>
                            
                        </div>
                    </article>
                    <article class="authority_dept">
                        <h3>물류창고</h3>
                        <div class="authority_box">
                                <p>권한</p>
                                <ul>
                                    <li>
                                        <p>상품등록(001)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>상품별조회(002)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>로케이션별조회(003)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>레시피목록(004)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>레시피상세(005)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>레시피추가(006)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>이동지시(007)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>출고요청(008)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>자재요청결제(011)</p>
                                        <input type="checkbox">
                                    </li>
                                </ul>
                                <p class="btn_s_b"><input type="submit" value="권한부여"></p>
                            
                        </div>
                    </article>
                    <article class="authority_dept">
                        <h3>생산공장</h3>
                        <div class="authority_box">
                                <p>권한</p>
                                <ul>
                                    <li>
                                        <p>상품등록(001)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>상품별조회(002)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>로케이션별조회(003)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>레시피목록(004)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>레시피상세(005)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>레시피추가(006)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>이동지시(007)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>출고요청(008)</p>
                                        <input type="checkbox">
                                    </li>
                                    <li>
                                        <p>자재요청결제(011)</p>
                                        <input type="checkbox">
                                    </li>
                                </ul>
                                <p class="btn_s_b"><input type="submit" value="권한부여"></p>
                            
                        </div>
                    </article>
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
</body>
</html>