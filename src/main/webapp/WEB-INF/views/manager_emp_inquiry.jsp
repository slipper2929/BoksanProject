<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <!--헤더css-->
    <link rel="stylesheet" href="../resources/css/header.css">
    <!--푸터css-->
    <link rel="stylesheet" href="../resources/css/footer.css">
    <!--조회css-->
    <link rel="stylesheet" href="../resources/css/inquiry.css">
    <!--메인css-->
    <link rel="stylesheet" href="../resources/css/manager_emp_inquiry.css">




    <title>복산김치WMS_관리자_직원조회</title>
</head>
<body>
   <div id="wrap">
    
    	<jsp:include page="header.jsp"></jsp:include>
    
        <div id="container">
            <section class="b_inquiry_main">
                <div class="b_title">
                    <h1>관리자</h1>
                    <h2>직원조회</h2>
                </div> <!--.b_main-->
                <div class="b_content b_content_width_m">
                	<div class="b_search">
                        <form action="/manager_emp_inquiry" id="searchForm">
                            <input type="button" class="b_submit" id="searchbtn">
                            <input type="text" class="b_input_text sc_check" id="keyword" name="keyword" value="${pageMaker.cri.keyword }">
                        </form>
                        <p class="b_explain">*상품명, 상품코드, 파레트번호, 창고번지로 검색가능합니다.</p>
                    </div> <!--b_search-->
                    <form action="/emp_delete" method="post" class="emp_delete_form">
                    <div class="emp_btn">
                        <p class="btn_s_g emp_update"><input type="button" value="수정"></p>
                        <p class="btn_s_b emp_success"><input type="button" value="완료"></p>
                        <p class="btn_s_r"><input type="submit" id="emp_delete_button" value="삭제"></p>
                    </div>
                    <table class="b_table margin_t50 emp_talbe" >
                        <tr class="b_table_title">
                            <th>
                                <p>사원번호</p>
                            </th>
                            <th>
                                <p>이름</p>
                            </th>
                            <th>
                                <p>생년월일</p>
                            </th>
                            <th>
                                <p>주소</p>
                            </th>
                            <th>
                                <p>부서명</p>
                            </th>
                            <th>
                                <p>삭제임</p>
                            </th>
                        </tr>
                        <c:forEach var="emplist" items="${emplist }">
                        <tr class="b_table_data">
                            <td><p><input type="hidden" class="emp_value" value="${emplist.emp_code }">${emplist.emp_code }</p></td>
                            <td><p>${emplist.name }</p></td>
                            <td><p>${emplist.socialnum }</p></td>
                            <td><p>${emplist.address }</p></td>
                            <td>
                            	<p class="dept_value">${emplist.b_dept.dept_name }</p>
                            	<p class="dept_select">
                            		<select class="dept_choice">
                            			<option value="${emplist.dept_code }" class="dept_value">${emplist.b_dept.dept_name }</option>
                            			<c:forEach var="deptlist" items="${deptlist }">
                            				<option value="${deptlist.dept_code }" >${deptlist.dept_name }</option>
                            			</c:forEach>
                            		</select>
                            	</p>
                            </td>
                            <td>
                                <p><input type="checkbox" class="delete_check"></p>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
                    </form>
                    <form id="pageForm" action="/manager_emp_inquiry">
                    <div class="b_pager">
	                        <input type="hidden" id="pagenum" name="pagenum" value="${pageMaker.cri.pagenum}">
							<input type="hidden" id="amount" name="amount" value="${pageMaker.cri.amount}">
	                        
							<input type="hidden" id="keyword" name="keyword" value="${pageMaker.cri.keyword}">
							
							<c:choose>
								<c:when test="pageMaker.cri.keyword == null">
		                    		<div><a class="pageBtn" href="/manager_emp_inquiry?pagenum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}"><span>이전</span></a></div>
			                        	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			                        		<div><a class="pageNo" href="${num}"><span>${num}</span></a></div>
			                        	</c:forEach>
			                        <div><a class="pageBtn" href="/manager_emp_inquiry?pagenum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}"><span>다음</span></a></div>
                    			</c:when>
                    			<c:otherwise>
                    				<div><a class="pageBtn" href="/manager_emp_inquiry?pagenum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}&keyword=${pageMaker.cri.keyword}"><span>이전</span></a></div>
			                        	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			                        		<div><a class="pageNo" href="${num}"><span>${num}</span></a></div>
			                        	</c:forEach>
			                        <div><a class="pageBtn" href="/manager_emp_inquiry?pagenum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}&keyword=${pageMaker.cri.keyword}"><span>다음</span></a></div>
                    			</c:otherwise>
                    		</c:choose>
                    	</div>
                    </form>
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
    
    <!-- pageMaker.js -->
    <script src="../resources/js/pageMaker.js"></script>
    
    <!-- manager_emp_inquiry -->
    <script src="../resources/js/manager_emp_inquiry.js"></script>
</body>
</html>