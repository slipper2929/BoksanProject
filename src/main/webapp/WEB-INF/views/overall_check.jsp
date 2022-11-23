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
    <!--����꽺 �۲�-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    
    <!-- 3-1. jQueryUI ����(animate) -->
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">

    <!--�ʱ�ȭcss-->
    <link rel="stylesheet" href="../resources/css/reset.css">
    <!--����css-->
    <link rel="stylesheet" href="../resources/css/overall_check.css">
    <!--��ȸcss-->
    <link rel="stylesheet" href="../resources/css/inquiry.css">
<title>��ü ��ȸ</title>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp"></jsp:include>
		<div id="container">
			<section class="b_inquiry_main">
				<div class="b_title">
                    <h1>��ü��ȸ</h1>
                    <h2 class="little_title"></h2>
                </div> <!--.b_main-->
                <div id="overall_search_box">
                	<div id="overall_sb_left">
                		<div id="overall_sbl_select">
                			<p>��ȸ����</p>
                			<select>
                				<option value="in_out_record">�������</option>
                				<option value="stock_record">���</option>
                				<option value="house_record">â��</option>
                			</select>
                		</div> <!-- #overall_sbl_select -->
                		<div class="overall_sbl_choice ior_choice">
                			<div class="overall_choice_check">
                				<p>�԰�</p>
                				<div><input type="checkbox" id="overall_sbl_check_ior_1" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>���</p>
                				<div><input type="checkbox" id="overall_sbl_check_ior_2" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>����</p>
                				<div><input type="checkbox" id="overall_sbl_check_ior_3" name="overall_sbl_check" checked></div>
                			</div>
                		</div> <!-- .ior_choice -->
                		
                		<div class="overall_sbl_choice sr_choice">
                			<div class="overall_choice_check">
                				<p>�� �� ��</p>
                				<div><input type="checkbox" id="overall_sbl_check_sr_1" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>�� �� ǰ</p>
                				<div><input type="checkbox" id="overall_sbl_check_sr_2" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>�� �� ǰ</p>
                				<div><input type="checkbox" id="overall_sbl_check_sr_3" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>�� �� ǰ</p>
                				<div><input type="checkbox" id="overall_sbl_check_sr_4" name="overall_sbl_check" checked></div>
                			</div>
                		</div> <!-- .sr_choice -->
                		
                		<div class="overall_sbl_choice hr_choice">
                			<div class="overall_choice_check">
                				<p>�� ��</p>
                				<div><input type="checkbox" id="overall_sbl_check_hr_1" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>�� ��</p>
                				<div><input type="checkbox" id="overall_sbl_check_hr_2" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>�� ��</p>
                				<div><input type="checkbox" id="overall_sbl_check_hr_3" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>�� ��</p>
                				<div><input type="checkbox" id="overall_sbl_check_hr_4" name="overall_sbl_check" checked></div>
                			</div>
                		</div> <!-- .hr_choice -->
                		
                	</div>
                	<!-- �ؿ��� ���������ȸ -->
                	<div class="overall_sb_right ior_right">
                		<div>
                			<p>����ڸ�</p>
                			<div>
                				<input type="text" class="sc_check charge_name_ior">
                			</div>
                		</div>
                		<div>
                			<p>��ǰ��</p>
                			<div>
                				<input type="text" class="sc_check product_name_ior">
                			</div>
                		</div>
                		<div class="overall_sbr_date">
                			<p>��ȸ�Ⱓ</p>
                			<div>
                				<span class="date_icon1"></span>
                				<span class="date_icon2"></span>
                				<input type="text" class="inquiry_date_start_ior">
                				<p>~</p>
                				<input type="text" class="inquiry_date_end_ior">
                			</div>
                		</div>
                		<div>
                			<p>��ǰ������</p>
                			<div>
                				<input type="text" class="sc_check country_name_ior">
                			</div>
                		</div>
                		<div>
                			<p>���޻��</p>
                			<div>
                				<input type="text" class="sc_check business_name_ior">
                			</div>
                		</div>
                	</div> <!-- .ior_right -->
                	
                	<!-- �ؿ��� �����ȸ -->
                	<div class="overall_sb_right sr_right">
                		<div>
                			<p>��ǰ��</p>
                			<div>
                				<input type="text" class="sc_check product_name_sr">
                			</div>
                		</div>
                		<div>
                			<p>��������</p>
                			<div>
                				<input type="text" class="sc_check country_name_sr">
                			</div>
                		</div>
                		<div class="overall_sbr_date">
                			<p>�԰���</p>
                			<div>
                				<span class="date_icon1"></span>
                				<span class="date_icon2"></span>
                				<input type="text" class="inquiry_date_start_sr">
                				<p>~</p>
                				<input type="text" class="inquiry_date_end_sr">
                			</div>
                		</div>
                		<div>
                			<p>���޻��</p>
                			<div>
                				<input type="text" class="sc_check business_name_sr">
                			</div>
                		</div>
                		<div>
                			<p>â�����</p>
                			<div>
                				<input type="text" class="sc_check house_code_sr">
                			</div>
                		</div>
                	</div> <!-- .sr_right -->
                	
                	<!-- �ؿ��� â����ȸ -->
                	<div class="overall_sb_right hr_right">
                		<div>
                			<p>�ִ�������</p>
                			<div>
                				<input type="text" class="sc_check max_load_hr">
                			</div>
                		</div>
						<div>
                			<p>������Ǽ���</p>
                			<div>
                				<input type="text" class="sc_check now_vacancy_hr">
                			</div>
                		</div>
                		<div>
                			<p>�����������</p>
                			<div>
                				<input type="text" class="sc_check now_load_hr">
                			</div>
                		</div>
                		<div>
                			<p>������</p>
                			<div>
                				<input type="text" class="sc_check loading_rate_hr">
                			</div>
                		</div>
                		<div>
                			<p>�����ǰ��</p>
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
	<!-- 3. jQuery ���� -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    
    <!--��ȿ���˻� js-->
    <script src="../resources/js/b_regExp_check.js"></script>
    
    <!-- overall_check.js -->
    <script src="../resources/js/overall_check.js"></script>
</body>
</html>