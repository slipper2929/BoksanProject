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
    <link rel="stylesheet" href="../resources/css/product_inquiry.css">



    <title>복산김치WMS_상품조회</title>
</head>
<body>
   <div id="wrap">
       
       	<jsp:include page="header.jsp"></jsp:include>
       
        <div id="container">
            <section class="b_inquiry_main">
                <div class="b_title">
                    <h1>상품조회</h1>
                </div> <!--.b_main-->
                <div class="b_content b_content_width_m">
                  <div class="b_search">
                        <form action="/product_inquiry" id="searchForm">
                            <input type="button" class="b_submit" id="searchbtn">
                            <input type="text" class="b_input_text sc_check" id="keyword" name="keyword" value="${pageMaker.cri.keyword }">
                        </form>
                        <p class="b_explain">*상품명, 상품코드, 파레트번호, 창고번지로 검색가능합니다.</p>
                    </div> <!--b_search-->
                    <form action="product_delete" method="post" class="product_delete">
                    <table class="b_table margin_t50">
                    
                        <tr class="b_table_title">
                            <th>
                                <p>상품코드</p>
                            </th>
                            <th>
                                <p>상품명</p>
                            </th>
                            <th>
                                <p>분류</p>
                            </th>
                            <th>
                                <p>원산지</p>
                            </th>
                            <th>
                                <p>업체명</p>
                            </th>
                            <th>
                                <p>구매가</p>
                            </th>
                            <th>
                                <p>파레트용량</p>
                            </th>
                            <th>
                                <p>관리</p>
                            </th>
                        </tr>
                        
                        <c:forEach var="pilist" items="${pilist }">
                        <tr class="b_table_data">
                            <td>
                            	<p>${pilist.product_code }</p>
                            	<p class="pilist_out"><input type="hidden" class="product_value_code" value="${pilist.product_code }"></p>                            	
                            </td>
                            <td>
                            	<p class="pilist_on">${pilist.product_name }</p>
                            	<p class="pilist_out"><input type="text" class="product_value_name" value="${pilist.product_name }"></p>
                            </td>
                            <td>
                            	<p class="pilist_on">${pilist.product_groupdto.product_group_name }</p>
                            	<p class="pilist_out">
                            		<!-- <input type="hidden" class="product_value_Gcode" value="${pilist.product_group_code }"> -->
                            		<select class="product_value_Gcode">
                            			<option value="${pilist.product_group_code }">${pilist.product_groupdto.product_group_name }</option>
                            			<c:forEach var="pglist" items="${pglist}">
                            				<c:if test="${pilist.product_group_code != pglist.product_group_code}">
                            				<option value="${pglist.product_group_code }">${pglist.product_group_name }</option>
                            				</c:if>
                            			</c:forEach>
                            		</select>
                            	</p>
                            </td>
                            <td>
                            	<p class="pilist_on">${pilist.country_name }</p>
                            	<p class="pilist_out">
	                            	<select class="product_value_place">
	                           			<option value="${pilist.country_code }">${pilist.country_name}</option>
	                           			<c:forEach var="pclist" items="${pclist}">
	                           				<c:if test="${pilist.country_code != pclist.country_code}">
	                           				<option value="${pclist.country_code }">${pclist.country_name }</option>
	                           				</c:if>
	                           			</c:forEach>
	                            	</select>
                            	</p>
                            </td>
                            <td>
                            	<p class="pilist_on">${pilist.business_name }</p>
                            	<p class="pilist_out">
	                            	<select class="product_value_Bname">
	                           			<option value="${pilist.business_code }">${pilist.business_name}</option>
	                           			<c:forEach var="pblist" items="${pblist}">
	                           				<c:if test="${pilist.business_code != pblist.business_code}">
	                           				<option value="${pblist.business_code }">${pblist.business_name }</option>
	                           				</c:if>
	                           			</c:forEach>
	                            	</select>
                            	</p>
                            </td>
                            <td>
                            	<p class="pilist_on">${pilist.price }</p>
                            	<p class="pilist_out"><input type="text" class="product_value_price" value="${pilist.price }"></p>
                            </td>
                            <td>
                            	<p class="pilist_on">${pilist.pallet_in_ratio }</p>
                            	<p class="pilist_out"><input type="text" class="product_value_pir" value="${pilist.pallet_in_ratio }" readonly></p>
                            </td>
                            <td>
                            	
                                <p class="btn_s_g"><input type="button" class="up_btn" value="수정"></p>
                                <p class="btn_s_b">
	                                <input type="button" class="success_btn" value="완료">
	                                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                </p>
                                <p class="btn_s_r">
                                	<input type="button" class="inquiry_delete" value="삭제">
                                	<input type="hidden" value="${pilist.product_code }">
                                </p>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    </form>
                    <form id="pageForm" action="/product_inquiry">
                    <div class="b_pager">
	                        <input type="hidden" id="pagenum" name="pagenum" value="${pageMaker.cri.pagenum}">
							<input type="hidden" id="amount" name="amount" value="${pageMaker.cri.amount}">
	                        
							<input type="hidden" id="keyword" name="keyword" value="${pageMaker.cri.keyword}">
							
							<c:choose>
								<c:when test="pageMaker.cri.keyword == null">
		                    		<div><a class="pageBtn" href="/product_inquiry?pagenum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}"><span>이전</span></a></div>
			                        	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			                        		<div><a class="pageNo" href="${num}"><span>${num}</span></a></div>
			                        	</c:forEach>
			                        <div><a class="pageBtn" href="/product_inquiry?pagenum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}"><span>다음</span></a></div>
                    			</c:when>
                    			<c:otherwise>
                    				<div><a class="pageBtn" href="/product_inquiry?pagenum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}&keyword=${pageMaker.cri.keyword}"><span>이전</span></a></div>
			                        	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			                        		<div><a class="pageNo" href="${num}"><span>${num}</span></a></div>
			                        	</c:forEach>
			                        <div><a class="pageBtn" href="/product_inquiry?pagenum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}&keyword=${pageMaker.cri.keyword}"><span>다음</span></a></div>
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
    <!-- product_inquiry -->
    <script src="../resources/js/product_inquiry.js"></script>
    <!-- pageMaker.js -->
    <script src="../resources/js/pageMaker.js"></script>
</body>
</html>