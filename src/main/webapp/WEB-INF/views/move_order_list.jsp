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
    <!--조회css-->
    <link rel="stylesheet" href="../resources/css/inquiry.css">
    <!--메인css-->
    <link rel="stylesheet" href="../resources/css/move_order_list.css">


    <title>복산김치WMS_이동지시목록</title>
</head>
<body>
   <div id="wrap">
     
     	<jsp:include page="header.jsp"></jsp:include>

        <div id="container">
            <section class="b_inquiry_main">
                <div class="b_title">
                    <h1>이동목록</h1>
                    <h2 class="hidden"></h2>
                </div> <!--.b_main-->
                <div class="b_content b_content_width_m">
                <div class="b_search">
                        <form action="/move_order_list" id="searchForm">
                            <input type="button" class="b_submit" id="searchbtn">
                            <input type="text" class="b_input_text sc_check" id="keyword" name="keyword" value="${pageMaker.cri.keyword }">
                        </form>
                        <p class="b_explain">*상품명, 상품코드, 파레트번호, 창고번지로 검색가능합니다.</p>
                    </div> <!--b_search-->
                    <form action="/move_order_compare" method="post" id="compare_form">
                    <table class="b_table margin_t50">
                        <tr class="b_table_title">
                            <th>
                                <p>파레트번호</p>
                            </th>
                            <th>
                                <p>상품코드</p>
                            </th>
                            <th>
                                <p>상품명</p>
                            </th>
                            <th>
                                <p>창고번지</p>
                            </th>
                            <th>
                                <p>이동할 창고번지</p>
                            </th>
                            <th>
                                <p>이동된 로케이션바코드</p>
                            </th>
                            <th>
                                <p>이동완료</p>
                            </th>
                        </tr>
                        
                        <c:forEach var="molist" items="${molist}" varStatus="status">
                        <tr class="b_table_data">
                        	<td><p>${molist.pallet_num }</p></td>
                            <td><p>${molist.product_code }</p></td>
                            <td><p>${molist.b_productdto.product_name }</p></td>
                            <td>
                            	<p>${molist.house_code }</p>
                            	<input type="hidden" name="house_code" value="${molist.house_code }">
                            </td>
                            <td><p>
                            	<input type="hidden" class="movement_value"value="${movement[status.index]}">${movement[status.index]}</p>
                            	<input type="hidden" name="movement_address" value="${movement[status.index]}">
                            </td>
                            <td class="move_location_bacode">
                                <p>
                                    <input type="text" placeholder="로케이션바코드를 입력하세요" class="sc_check move_compare">
                                </p>
                            </td>
                            <td>
                            <p class="move_order_btn btn_s_b">
                            	<input type="hidden" value="${molist.pallet_num }">
                            	<input type="button" class="move_compare_btn" value="이동완료">
                            </p>
                            
                            </td>
                        </tr>
                        </c:forEach>
                        
                    </table>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
                    </form>
                    <form id="pageForm" action="/move_order_list">
                    <div class="b_pager">
	                        <input type="hidden" id="pagenum" name="pagenum" value="${pageMaker.cri.pagenum}">
							<input type="hidden" id="amount" name="amount" value="${pageMaker.cri.amount}">
	                        
							<input type="hidden" id="keyword" name="keyword" value="${pageMaker.cri.keyword}">
							
							<c:choose>
								<c:when test="pageMaker.cri.keyword == null">
		                    		<div><a class="pageBtn" href="/move_order_list?pagenum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}"><span>이전</span></a></div>
			                        	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			                        		<div><a class="pageNo" href="${num}"><span>${num}</span></a></div>
			                        	</c:forEach>
			                        <div><a class="pageBtn" href="/move_order_list?pagenum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}"><span>다음</span></a></div>
                    			</c:when>
                    			<c:otherwise>
                    				<div><a class="pageBtn" href="/move_order_list?pagenum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}&keyword=${pageMaker.cri.keyword}"><span>이전</span></a></div>
			                        	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			                        		<div><a class="pageNo" href="${num}"><span>${num}</span></a></div>
			                        	</c:forEach>
			                        <div><a class="pageBtn" href="/move_order_list?pagenum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}&keyword=${pageMaker.cri.keyword}"><span>다음</span></a></div>
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

    <!--유효성검사-->
    <script src="../resources/js/b_regExp_check.js"></script>
    <!-- move_order_list.js -->
    <script src="../resources/js/move_order_list.js"></script>
    <!-- pageMaker.js -->
     <script src="../resources/js/pageMaker.js"></script>
</body>
</html>