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



    <title>복산김치WMS_상품별 위치조회</title>
</head>
<body>
     <div id="wrap">
     	
     	<jsp:include page="header.jsp"></jsp:include>
     	
        <div id="container">
            <section class="b_inquiry_main">
                <div class="b_title">
                    <h1>상품조회</h1>
                    <h2>상품별 위치조회</h2>
                </div> <!--.b_main-->
                <div class="b_content b_content_width_m">
                    <div class="b_search">
                        <form action="/product_position_inquiry" id="searchForm">
                            <input type="button" class="b_submit" id="searchbtn">
                            <input type="text" class="b_input_text sc_check" id="keyword" name="keyword" value="${pageMaker.cri.keyword }">
                        </form>
                        <p class="b_explain">*상품명, 상품코드, 파레트번호, 창고번지로 검색가능합니다.</p>
                    </div> <!--b_search-->
                    <table class="b_table margin_t50">
                        <tr class="b_table_title">
                            <th>
                                <p>파레트번호</p>
                            </th>
                            <th>
                                <p>상품명</p>
                            </th>
                            <th>
                                <p>분류</p>
                            </th>
                            <th>
                                <p>입고일</p>
                            </th>
                            <th>
                                <p>창고종류</p>
                            </th>
                            <th>
                                <p>창고번지</p>
                            </th>
                            <th>
                                <p>상세위치</p>
                            </th>
                        </tr>
                        <c:forEach var="pplist" items="${pplist }">
                        <tr class="b_table_data">
                            <td><p>${pplist.pallet_num }</p></td>
                            <td><p>${pplist.b_productdto.product_name }</p></td>
                            <td><p>${pplist.product_group_name }</p></td>
                            <td><p>${pplist.arrive_date }</p></td>
                            <td><p>${pplist.b_housedto.house_function }</p></td>
                            <td><p>${pplist.b_housedto.house_code }</p></td>
                            <td><p>${pplist.b_housedto.detail_position }</p></td>
                        </tr>
                        </c:forEach>
                    </table>
                     <form id="pageForm" action="/product_position_inquiry">
	                    <div class="b_pager">
		                        <input type="hidden" id="pagenum" name="pagenum" value="${pageMaker.cri.pagenum}">
								<input type="hidden" id="amount" name="amount" value="${pageMaker.cri.amount}">
		                        
								<input type="hidden" id="keyword" name="keyword" value="${pageMaker.cri.keyword}">
								
								<c:choose>
									<c:when test="pageMaker.cri.keyword == null">
			                    		<div><a class="pageBtn" href="/product_position_inquiry?pagenum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}"><span>이전</span></a></div>
				                        	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
				                        		<div><a class="pageNo" href="${num}"><span>${num}</span></a></div>
				                        	</c:forEach>
				                        <div><a class="pageBtn" href="/product_position_inquiry?pagenum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}"><span>다음</span></a></div>
	                    			</c:when>
	                    			<c:otherwise>
	                    				<div><a class="pageBtn" href="/product_position_inquiry?pagenum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}&keyword=${pageMaker.cri.keyword}"><span>이전</span></a></div>
				                        	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
				                        		<div><a class="pageNo" href="${num}"><span>${num}</span></a></div>
				                        	</c:forEach>
				                        <div><a class="pageBtn" href="/product_position_inquiry?pagenum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}&keyword=${pageMaker.cri.keyword}"><span>다음</span></a></div>
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
     <!-- pageMaker.js -->
     <script src="../resources/js/pageMaker.js"></script>
</body>
</html>