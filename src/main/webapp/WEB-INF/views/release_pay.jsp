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
    <link rel="stylesheet" href="../resources/css/release_pay.css">

<!-- 	<style>
		.modal{ 
		  position: absolute; width:100%; height:100%; background: rgba(0,0,0,0.5); top: 0; left: 0;display:none; z-index: 5000;
		}
		
		.modal_content{
		  width:600px; height:350px;
		  background:#fff; border-radius:10px;
		  position:relative; top:50%; left:50%;
		  margin-top:-175px; margin-left:-300px;
		  box-sizing:border-box; padding:34px 0;
		  line-height:23px;
		}
		
		.modal_out{
			width: 30px;
			height: 30px;
			position: absolute;
			top: 10px;
			right: 10px;
			cursor:pointer;
			background-image: url(../resources/b_img/page_out1.png);
            background-position: center;
            background-repeat: no-repeat;
            background-size: 30px 30px;
		}
		
		.modal_out:hover{
			background-image: url(../resources/b_img/page_out2.png);
		}
		
		.modal_line{
			width: 600px;
			height: 2px;
			background-color: #ccc;
			margin-top: 15px;
			margin-bottom: 20px;
		}
		
		.modal_line2{
			width: 600px;
			height: 2px;
			background-color: #dde;
			margin-top: 20px;
			margin-bottom: 15px;
		}
		
		.modal h1{
			text-align: center;
		}
		
		.modal_title{
			width: 400px;
			margin-left: 100px;
			font-size: 18px;
			line-height: 30px;
		}
		
		.modal form{
			margin-left: 100px;
		}
		
		.modal_title p{
			position: relative;
		}
		
		.modal_title span{
			position: absolute;
            top: 0;
            left: 100px;
		}
		
		.modal_title button{
			position: absolute;
            top: 0;
            left: 300px;
            border: none;
            background-color: rgb(99, 99, 223);
            color: #fff;
            padding: 5px;
		}
		
		.modal_title button:hover{
		background-color: rgb(72, 72, 220);
		}
		
		.modal_order_form p{
			position: relative;
			font-size: 25px;
			margin-top: 10px;
		}
		
		.modal_order_form .order_result{
			position: absolute;
            top: 0;
            left: 100px;
            height: 25px;
            width: 150px;
            font-size: 18px;
            border-top: none;
            border-left: none;
            border-right: none;
		}
		
		.modal_order_form .order_result::placeholder{
			font-size: 15px;
			padding-left: 10px;
		}
		
		.modal_order_form button{
			position: absolute;
            top: -3px;
            left: 300px;
            border: none;
            background-color: rgb(99, 223, 120);
            color: #fff;
            padding: 7px 10px 7px 10px; 
		}
		
		.modal_order_form button:hover{
		background-color: rgb(52, 223, 81);
		}
		
		.modal_order_form span{
			position: absolute;
            top: 0;
            left: 255px;
            font-size: 20px;
		}
		
		.modal_price{
			margin-left: 100px;
		}
		
		.modal_price p{
			position: relative;
			font-size: 25px;
		}
		
		.modal_price .res{
			position: absolute;
			top: 0;
            left: 110px;
            font-size: 20px;
		}
		
		.modal_price .won{
			position: absolute;
			top: 0;
            left: 200px;
            font-size: 20px;
		}
		
	</style>
 -->

    <title>복산김치WMS_출고요청결제</title>
</head>
<body>
	<div class="modal">
 		<div class="modal_content" title="클릭하면 창이 닫힙니다.">
 			<div class="modal_out"></div>
 			<h1>발주신청</h1>
 			<div class="modal_line"></div>
 			<div class="modal_title">
	 			<p class="modal_name">상품명 : <span></span></p>
	 			<p class="modal_total_num">상품재고 : <span></span></p>
	 			<p class="modal_order_num">요청중량 : <span></span><button>기입</button></p>
	 			<p class="modal_total_product_num">총중량 : <span></span><button>기입</button></p>
 			</div>
 			<div class="modal_line2"></div>
 			<form class="modal_order_form" method="post" action="release_pay_order">
 				<p>수량 : <input type="text" class="order_result" placeholder="중량을 기입하세요" name="order_num_count"><span>kg</span><button type="button" class="release_pay_order_btn">발주하기</button></p>
 				<input class="modal_product_code" type="hidden" name="product_code">
 				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
 			</form>
 			<div class="modal_price">
 				<p class="modal_total_price_num">총구매가 : <span class="res">0</span></p>
 			</div>
 		</div>
	</div>
   <div id="wrap">
     	
     	<jsp:include page="header.jsp"></jsp:include>
     	
        <div id="container">
            <section class="b_inquiry_main">
                <div class="b_title">
                    <h1>출고요청결제</h1>
                    <h2 class="hidden"></h2>
                </div> <!--.b_main-->
                <div class="b_search" style="display:none">
                    <form id="searchForm" action="/recipe_inquiry">
                        <input type="button" class="b_submit" id="searchbtn">
                        <input type="text" class="b_input_text sc_check" id="keyword" name="keyword" value="${pageMaker.cri.keyword}">
                        <!--  <input type="text" class="b_input_text sc_check" name="search_text">-->
                    </form>
                    <p class="b_explain">*상품명으로 검색가능합니다.</p>
                </div> <!--b_search-->
                <div class="b_content b_content_width_m">
                	<form action="" method="post" id="release_pay_form">
                    <table class="b_table margin_t50 release_pay_table">
                        <tr class="b_table_title">
                            <th>
                                <p>출고요청자</p>
                            </th>
                            <th>
                                <p>출고요청시간</p>
                            </th>
                            <th>
                                <p>상품코드</p>
                            </th>
                            <th>
                                <p>상품명</p>
                            </th>
                            <th>
                                <p>중량</p>
                            </th>
                            <th>
                                <p>상태</p>
                            </th>
                            <th class="payment">
                                <p>결제</p>
                            </th>
                        </tr>
                        <c:forEach items="${rplist}" var="rp">
                        <tr class="b_table_data">
	                        <td><p class="">${rp.name}</p></td>
	                        <td><p class="">${rp.release_time}</p></td>
                            <td><p class="rp_product_code">${rp.product_code}</p></td>
                            <td><p class="rp_product_name">${rp.product_name}</p></td>
                            <td><p class="rp_release_num">${rp.release_num}kg</p></td>
                            <td><p>${rp.situation}</p></td>
                            <c:if test="${rp.res == -1}">
                            <td class="pay_btn">
                                <p class="btn_s_g"><input type="button" value="발주하기" class="order_btn"></p>
                                <p class="btn_s_r"><input type="button" value="취소하기" class="order_cancel"></p>
                                <input type="hidden" value="${rp.release_code}" class="release_code">
                            </td>
                            </c:if>
                            <c:if test="${rp.res == 1 || rp.res == 0}">
                            <td class="pay_btn">
                                <p class="btn_s_b"><input type="button" value="출고지시" class="release_btn"></p>
                                <p class="btn_s_r"><input type="button" value="취소하기" class="order_cancel"></p>
                                <input type="hidden" value="${rp.product_code}" class="product_code">
	                        	<input type="hidden" value="${rp.release_num}" class="release_num">
	                        	<input type="hidden" value="${rp.release_code}" class="release_code">
	                        	<input type="hidden" value="${rp.product_name}" class="product_name">                  	
                            </td>
                            </c:if>
                        </tr>
						
                        </c:forEach>
                    </table>
                    
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
                    </form>
                    <a id="order_link" style="display : none"></a>
                    <form id="pageForm" action="/release_pay">
                    	<div class="b_pager">
	                        <input type="hidden" id="pagenum" name="pagenum" value="${pageMaker.cri.pagenum}">
							<input type="hidden" id="amount" name="amount" value="${pageMaker.cri.amount}">
	                        
							<input type="hidden" id="keyword" name="keyword" value="${pageMaker.cri.keyword}">
							
							<c:choose>
								<c:when test="pageMaker.cri.keyword == null">
		                    		<div><a class="pageBtn" href="/release_pay?pagenum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}"><span>이전</span></a></div>
			                        	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			                        		<div><a class="pageNo" href="${num}"><span>${num}</span></a></div>
			                        	</c:forEach>
			                        <div><a class="pageBtn" href="/release_pay?pagenum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}"><span>다음</span></a></div>
                    			</c:when>
                    			<c:otherwise>
                    				<div><a class="pageBtn" href="/release_pay?pagenum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}&keyword=${pageMaker.cri.keyword}"><span>이전</span></a></div>
			                        	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			                        		<div><a class="pageNo" href="${num}"><span>${num}</span></a></div>
			                        	</c:forEach>
			                        <div><a class="pageBtn" href="/release_pay?pagenum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}&keyword=${pageMaker.cri.keyword}"><span>다음</span></a></div>
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
    
    <!-- pageMaker js -->
    <script src="../resources/js/pageMaker.js"></script>
    
    <!-- release_pay js -->
    <script src="../resources/js/release_pay.js"></script>
    
</body>
</html>