<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
    <!--메인css-->
    <link rel="stylesheet" href="../resources/css/overall_check.css">
    <!--조회css-->
    <link rel="stylesheet" href="../resources/css/inquiry.css">
<title>전체 조회</title>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp"></jsp:include>
		<div id="container">
			<section class="b_inquiry_main">
				<div class="b_title">
                    <h1>전체조회</h1>
                    <h2 class="hidden"></h2>
                </div> <!--.b_main-->
                <div id="overall_search_box">
                	<div id="overall_sb_left">
                		<div id="overall_sbl_select">
                			<p>조회구분</p>
                			<select>
                				<option>선택안함</option>
                				<option>입출고내역</option>
                			</select>
                		</div> <!-- #overall_sbl_select -->
                		<div id="overall_sbl_choice">
                			<div class="overall_choice_check">
                				<p>입고</p>
                				<div><input type="checkbox" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>출고</p>
                				<div><input type="checkbox" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>발주</p>
                				<div><input type="checkbox" name="overall_sbl_check" checked></div>
                			</div>
                		</div> <!-- #overall_sbl_choice -->
                	</div>
                	<div id="overall_sb_right">
                		<div>
                			<p>담당자명</p>
                			<div>
                				<input type="text" class="sc_check">
                			</div>
                		</div>
                		<div>
                			<p>상품명</p>
                			<div>
                				<input type="text" class="sc_check">
                			</div>
                		</div>
                		<div class="overall_sbr_date">
                			<p>조회기간</p>
                			<div>
                				<span class="date_icon1"></span>
                				<span class="date_icon2"></span>
                				<input type="text">
                				<p>~</p>
                				<input type="text">
                			</div>
                		</div>
                		<div>
                			<p>상품원산지</p>
                			<div>
                				<input type="text" class="sc_check">
                			</div>
                		</div>
                		<div>
                			<p>공급사명</p>
                			<div>
                				<input type="text" class="sc_check">
                			</div>
                		</div>
                	</div>
                	<div id="overall_sb_btn"></div>
                </div><!-- #overall_search_box -->
                <div id="overall_list">
                	<table>
                		<tr>
                			<th>입출고내역코드</th>
                			<th>분류</th>
                			<th>상품명</th>
                			<th>상품원산지</th>
                			<th>공급사명</th>
                			<th>중량</th>
                			<th>가격</th>
                			<th>담당자명</th>
                			<th>담당자전화번호</th>
                		</tr>
                		<tr>
                			<td></td>
                		</tr>
                	</table>
                </div>
			</section>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<!-- 3. jQuery 연결 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    
    <!--유효성검사 js-->
    <script src="../resources/js/b_regExp_check.js"></script>
    
    <!-- overall_check.js -->
    <script src="../resources/js/overall_check.js"></script>
</body>
</html>