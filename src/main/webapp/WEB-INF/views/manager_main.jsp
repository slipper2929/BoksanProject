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
    <link rel="stylesheet" href="../resources/css/manager_main.css">



    <title>복산김치WMS_관리자메인</title>
</head>
<body>
   <div id="wrap">
       
		<jsp:include page="header.jsp"></jsp:include>
        
        <div id="container">
            <section class="b_main1">
                <h2 class="b_main1_title">관리자메인</h2>
                <div class="b_manager_content">
                    <article>
                        <h3><a href="/manager_emp_inquiry">직원조회</a></h3>
                    </article>
                    <article>
                        <h3><a href="/manager_emp_approve">가입요청승인</a></h3>
                    </article>
                    <article>
                        <h3><a href="/manager_dept_group">부서등록</a></h3>
                    </article>
                    <article>
                        <h3><a href="/manager_house_add">창고등록</a></h3>
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