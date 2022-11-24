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
    <link rel="stylesheet" href="../resources/css/arrive_list.css">


    <title>복산김치WMS_입고대기목록</title>
</head>
<body>
	<div class="modal">
        <div class="modal_content">
            <div class="modal_out"></div>
            <h1>창고번지찾기</h1>
            <div class="modal_line"></div>
            <div class="house_map">
                <div class="house_number">
                    <div>
                        <p>창고기능</p>
                        <select id="modal_select1">
                        	<option value="">선택안함</option>
                            <option value="1">상온</option>
                            <option value="2">저온</option>
                            <option value="3">냉장</option>
                            <option value="4">냉동</option>
                        </select>
                    </div>
                    <div>
                        <p>창고외부번호</p>
                        <select id="modal_select2">

                        </select>
                    </div>
                    <div>
                        <p>창고내부번호</p>
                    </div>
                </div>
                <div class="house_inner_num">

                    <div class="house_inner_num_box">
                        
                    </div>
                </div>
            </div>
        </div>
   </div>
     <div id="wrap">

		<jsp:include page="header.jsp"></jsp:include>
        
        <div id="container">
            <section class="b_inquiry_main">
                <div class="b_title">
                    <h1>입고대기목록</h1>
                    <h2 class="hidden"></h2>
                </div> <!--.b_main-->
                <div class="b_content b_content_width_m">
                    
                    <table class="b_table margin_t50" id="arrive_list_table">
                        <tr class="b_table_title">
                            <th>
                                <p>상품정보코드</p>
                            </th>
                            <th>
                                <p>상품명</p>
                            </th>
                            <th>
                                <p>중량</p>
                            </th>
                            <th>
                                <p>입고일</p>
                            </th>
                            <th>
                                <p>파레트번호</p>
                            </th>
                            <th>
                                <p>입고시킬 창고번지</p>
                            </th>
                            <th>
                                <p>바코드발행</p>
                            </th>
                        </tr>
                        <c:forEach items="${alist}" var="al">
	                        <tr class="b_table_data">
	                        	<input type="hidden" class="arrive_code" value="${al.arrive_code}">
	                            <td><p class="product_code">${al.product_code}</p></td>
	                            <td><p>${al.product_name}</p></td>
	                            <td><p class="arrive_num_check">${al.arrive_num}kg</p></td>
	                            <td class="arrive_info">
	                                <p>
	                                    <input class="datepick arrive_date" type="text" placeholder="입고일을 입력하세요">
	                                </p>
	                            </td>
	                            <td class="arrive_info">
	                                <p class="pallet_info">
	                                    <select class="pallet_num_selectbox">
	                                    			<option value="">파레트번호 선택</option>
	                                    	<c:forEach items="${plist}" var="pl">
		                                    		<option value="${pl.pallet_num}">${pl.pallet_num}</option>
	                                    	</c:forEach>
	                                    </select>
	                                </p>
	                            </td>
	                            <td class="arrive_info">
	                                <p>
	                                    <input class="arrive_house house_code_input_modal" type="text" placeholder="입고시킬 창고번호를 입력하세요">
	                                </p>
	                            </td>
	                            <td>
	                                <p class="arrive_bacode_btn btn_s_b"><input class="barcode_btn" type="button" value="바코드발행하기"></p>
	                            </td>
	                        </tr>
                        </c:forEach>
                    </table>
                    <a href="#" class="check_link"></a>
                    
                    <form id="pageForm" action="arrive_list">
                    	<div class="b_pager">
	                        <input type="hidden" id="pagenum" name="pagenum" value="${pageMaker.cri.pagenum}">
							<input type="hidden" id="amount" name="amount" value="${pageMaker.cri.amount}">
							<input type="hidden" id="keyword" name="keyword" value="${pageMaker.cri.keyword}">
							
	                   		<div><a class="pageBtn" href="/arrive_list?pagenum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}"><span>이전</span></a></div>
	                        	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
	                        		<div><a class="pageNo" href="${num}"><span>${num}</span></a></div>
	                        	</c:forEach>
	                        <div><a class="pageBtn" href="/arrive_list?pagenum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}"><span>다음</span></a></div>

                    	</div>
                    </form>
                </div>
            </section>
            <section class="b_inquiry_main">
                <div class="b_title">
                    <h1>상품별 총대기목록</h1>
                    <h2 class="hidden"></h2>
                </div> <!--.b_main-->
                <div class="b_content b_content_width_m">
                    
                    <table class="b_table margin_t50">
                        <tr class="b_table_title">
                            <th>
                                <p>상품정보코드</p>
                            </th>
                            <th>
                                <p>상품명</p>
                            </th>
                            <th>
                                <p>분류</p>
                            </th>
                            <th>
                                <p>구매처</p>
                            </th>
                            <th>
                                <p>원산지</p>
                            </th>
                            <th>
                                <p>구매가(KG단위)</p>
                            </th>
                            <th>
                                <p>중량</p>
                            </th>
                        </tr>
                        <c:forEach items="${total}" var="to">
                        <tr class="b_table_data">
                            <td><p>${to.product_code}</p></td>
                            <td><p>${to.product_name}</p></td>
                            <td><p>${to.product_group_name}</p></td>
                            <td>
                            	<c:choose>
                            		<c:when test="${to.business_name != null}">
                            			<p>${to.business_name}</p>
                            		</c:when>
                            		<c:otherwise>
                            			<p>없음</p>
                            		</c:otherwise>
                            	</c:choose>
                            </td>
                            <td>
                            	<c:choose>
                            		<c:when test="${to.country_name != null}">
                            			<p>${to.country_name}</p>
                            		</c:when>
                            		<c:otherwise>
                            			<p>없음</p>
                            		</c:otherwise>
                            	</c:choose>
                            </td>
                            <td>
                            	<c:choose>
                            		<c:when test="${to.price != 0}">
                            			<p>${to.price}원</p>	
                            		</c:when>
                            		<c:otherwise>
                            			<p>없음</p>
                            		</c:otherwise>
                            	</c:choose>
                            </td>
                            <td><p>${to.arrive_num_total}kg</p></td>
                        </tr>
                        </c:forEach>
                        
                    </table>
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
    
    <!-- arrive_list js -->
    <script src="../resources/js/arrive_list.js"></script>
    
    <!-- pageMaker js -->
    <script src="../resources/js/pageMaker.js"></script>
</body>
</html>