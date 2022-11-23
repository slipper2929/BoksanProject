<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
                    <h2 class="little_title"></h2>
                </div> <!--.b_main-->
                <div id="overall_search_box">
                	<div id="overall_sb_left">
                		<div id="overall_sbl_select">
                			<p>조회구분</p>
                			<select>
                				<option value="in_out_record">입출고내역</option>
                				<option value="stock_record">재고</option>
                				<option value="house_record">창고</option>
                			</select>
                		</div> <!-- #overall_sbl_select -->
                		<div class="overall_sbl_choice ior_choice">
                			<div class="overall_choice_check">
                				<p>입고</p>
                				<div><input type="checkbox" id="overall_sbl_check_ior_1" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>출고</p>
                				<div><input type="checkbox" id="overall_sbl_check_ior_2" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>발주</p>
                				<div><input type="checkbox" id="overall_sbl_check_ior_3" name="overall_sbl_check" checked></div>
                			</div>
                		</div> <!-- .ior_choice -->
                		
                		<div class="overall_sbl_choice sr_choice">
                			<div class="overall_choice_check">
                				<p>식 자 재</p>
                				<div><input type="checkbox" id="overall_sbl_check_sr_1" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>가 공 품</p>
                				<div><input type="checkbox" id="overall_sbl_check_sr_2" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>완 제 품</p>
                				<div><input type="checkbox" id="overall_sbl_check_sr_3" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>공 산 품</p>
                				<div><input type="checkbox" id="overall_sbl_check_sr_4" name="overall_sbl_check" checked></div>
                			</div>
                		</div> <!-- .sr_choice -->
                		
                		<div class="overall_sbl_choice hr_choice">
                			<div class="overall_choice_check">
                				<p>냉 장</p>
                				<div><input type="checkbox" id="overall_sbl_check_hr_1" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>냉 동</p>
                				<div><input type="checkbox" id="overall_sbl_check_hr_2" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>상 온</p>
                				<div><input type="checkbox" id="overall_sbl_check_hr_3" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>저 온</p>
                				<div><input type="checkbox" id="overall_sbl_check_hr_4" name="overall_sbl_check" checked></div>
                			</div>
                		</div> <!-- .hr_choice -->
                		
                	</div>
                	<!-- 밑에꺼 입출고내역조회 -->
                	<div class="overall_sb_right ior_right">
                		<div>
                			<p>담당자명</p>
                			<div>
                				<input type="text" class="sc_check charge_name_ior">
                			</div>
                		</div>
                		<div>
                			<p>상품명</p>
                			<div>
                				<input type="text" class="sc_check product_name_ior">
                			</div>
                		</div>
                		<div class="overall_sbr_date">
                			<p>조회기간</p>
                			<div>
                				<span class="date_icon1"></span>
                				<span class="date_icon2"></span>
                				<input type="text" class="inquiry_date_start_ior">
                				<p>~</p>
                				<input type="text" class="inquiry_date_end_ior">
                			</div>
                		</div>
                		<div>
                			<p>상품원산지</p>
                			<div>
                				<input type="text" class="sc_check country_name_ior">
                			</div>
                		</div>
                		<div>
                			<p>공급사명</p>
                			<div>
                				<input type="text" class="sc_check business_name_ior">
                			</div>
                		</div>
                	</div> <!-- .ior_right -->
                	
                	<!-- 밑에꺼 재고조회 -->
                	<div class="overall_sb_right sr_right">
                		<div>
                			<p>상품명</p>
                			<div>
                				<input type="text" class="sc_check product_name_sr">
                			</div>
                		</div>
                		<div>
                			<p>원산지명</p>
                			<div>
                				<input type="text" class="sc_check country_name_sr">
                			</div>
                		</div>
                		<div class="overall_sbr_date">
                			<p>입고일</p>
                			<div>
                				<span class="date_icon1"></span>
                				<span class="date_icon2"></span>
                				<input type="text" class="inquiry_date_start_sr">
                				<p>~</p>
                				<input type="text" class="inquiry_date_end_sr">
                			</div>
                		</div>
                		<div>
                			<p>공급사명</p>
                			<div>
                				<input type="text" class="sc_check business_name_sr">
                			</div>
                		</div>
                		<div>
                			<p>창고번지</p>
                			<div>
                				<input type="text" class="sc_check house_code_sr">
                			</div>
                		</div>
                	</div> <!-- .sr_right -->
                	
                	<!-- 밑에꺼 창고조회 -->
                	<div class="overall_sb_right hr_right">
                		<div>
                			<p>최대허용수량</p>
                			<div>
                				<input type="text" class="sc_check max_load_hr">
                			</div>
                		</div>
						<div>
                			<p>현재공실수량</p>
                			<div>
                				<input type="text" class="sc_check now_vacancy_hr">
                			</div>
                		</div>
                		<div>
                			<p>현재적재수량</p>
                			<div>
                				<input type="text" class="sc_check now_load_hr">
                			</div>
                		</div>
                		<div>
                			<p>적재율</p>
                			<div>
                				<input type="text" class="sc_check loading_rate_hr">
                			</div>
                		</div>
                		<div>
                			<p>적재상품명</p>
                			<div>
                				<input type="text" class="sc_check product_name_hr">
                			</div>
                		</div>
                	</div> <!-- .hr_right -->
                	
                	<div id="overall_sb_btn"></div>
                </div><!-- #overall_search_box -->
                <div id="overall_list">
                	<table class="b_table2">
                	</table>
                </div>
                <div><button class="excel_btn">Excel</button></div>
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