<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                    <h2 class="hidden"></h2>
                </div> <!--.b_main-->
                <div id="overall_search_box">
                	<div id="overall_sb_left">
                		<div id="overall_sbl_select">
                			<p>��ȸ����</p>
                			<select>
                				<option>���þ���</option>
                				<option>�������</option>
                			</select>
                		</div> <!-- #overall_sbl_select -->
                		<div id="overall_sbl_choice">
                			<div class="overall_choice_check">
                				<p>�԰�</p>
                				<div><input type="checkbox" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>���</p>
                				<div><input type="checkbox" name="overall_sbl_check" checked></div>
                			</div>
                			<div class="overall_choice_check">
                				<p>����</p>
                				<div><input type="checkbox" name="overall_sbl_check" checked></div>
                			</div>
                		</div> <!-- #overall_sbl_choice -->
                	</div>
                	<div id="overall_sb_right">
                		<div>
                			<p>����ڸ�</p>
                			<div>
                				<input type="text" class="sc_check">
                			</div>
                		</div>
                		<div>
                			<p>��ǰ��</p>
                			<div>
                				<input type="text" class="sc_check">
                			</div>
                		</div>
                		<div class="overall_sbr_date">
                			<p>��ȸ�Ⱓ</p>
                			<div>
                				<span class="date_icon1"></span>
                				<span class="date_icon2"></span>
                				<input type="text">
                				<p>~</p>
                				<input type="text">
                			</div>
                		</div>
                		<div>
                			<p>��ǰ������</p>
                			<div>
                				<input type="text" class="sc_check">
                			</div>
                		</div>
                		<div>
                			<p>���޻��</p>
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
                			<th>��������ڵ�</th>
                			<th>�з�</th>
                			<th>��ǰ��</th>
                			<th>��ǰ������</th>
                			<th>���޻��</th>
                			<th>�߷�</th>
                			<th>����</th>
                			<th>����ڸ�</th>
                			<th>�������ȭ��ȣ</th>
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
	<!-- 3. jQuery ���� -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    
    <!--��ȿ���˻� js-->
    <script src="../resources/js/b_regExp_check.js"></script>
    
    <!-- overall_check.js -->
    <script src="../resources/js/overall_check.js"></script>
</body>
</html>