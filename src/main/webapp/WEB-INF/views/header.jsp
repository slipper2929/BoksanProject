<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
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
    <!--���css-->
    <link rel="stylesheet" href="../resources/css/header.css">

<title>Insert title here</title>
</head>


<body>
<header class="b_header">
            <section class="b_header_in">
                <div class="b_header_top">
                    <article class="b_header_logo">
                        <a href="/">
                            <h1>�ΰ��Դϴ�</h1>
                        </a>
                    </article>
                    <article class="b_header_util">
                    	<sec:authorize access="isAnonymous()">
	                        <div class="b_header_login"><a href="/login">�α���</a></div>
	                        <div class="b_header_join"><a href="/join">ȸ������</a></div>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                        	<div class="b_header_logout">
                        		<form action="/logout" method="post" id="logout">
                       			<input id="logout_a_btn" type="submit" value="�α׾ƿ�">
                       			<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>		
                       			</form>
                        	</div>
                        	</sec:authorize>
                        
                    </article>
                    <c:if test="${member != null}">
	                    <article class="b_beader_user">
	                    	<p><span>${member.name}</span>�� �ݰ����ϴ�.</p>
	                    </article>
                    </c:if>
                </div>
                <nav class="b_header_nav">
                    <ul class="b_header_nav_menu">
                        <li> <!--��ǰ-->
                            <p><a href="#">��ǰ</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li> <!--��ǰ���-->
                                    <p><a href="/product">��ǰ���</a></p>
                                </li> <!--��ǰ��ϳ�-->
                                <li> <!--��ǰ�з����-->
                                    <p><a href="/group_add">��ǰ�з����</a></p>
                                </li> <!--��ǰ�з���ϳ�-->
                                <li> <!--��ǰ��ȸ-->
                                    <p><a href="#">��ǰ��ȸ</a></p>
                                    <ul class="b_header_nav_menu_small">
                                        <li>
                                            <p><a href="/product_inquiry">��ǰ��ȸ</a></p>
                                        </li>
                                        <li>
                                            <p><a href="/overall_check">��ü��ȸ</a></p>
                                        </li>
                                    </ul>
                                </li> <!--��ǰ��ȸ ��-->
                            </ul>
                        </li> <!--��ǰ ��-->
                        <li> <!--���-->
                            <p><a href="#">���</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li>
                                    <p><a href="#">����̵�</a></p>
                                    <ul class="b_header_nav_menu_small">
                                        <li>
                                            <p><a href="/move_order">�̵�����</a></p>
                                        </li>
                                        <li>
                                            <p><a href="/move_order_list">�̵����</a></p>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <p><a href="#">������</a></p>
                                    <ul class="b_header_nav_menu_small">
                                        <li>
                                            <p><a href="/pallet">�ķ�Ʈ����</a></p>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li> <!--��� ��-->
                        <li> <!--�԰�-->
                            <p><a href="#">�԰�</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li>
                                    <p><a href="/arrive_list">�԰�����</a></p>
                                </li>
                                <li>
                                    <p><a href="/arrive">�԰��û</a></p>
                                </li>
                            </ul>
                        </li> <!--�԰�-->
                        <li> <!--����-->
                            <p><a href="#">����</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li>
                                    <p><a href="/order">���ֽ�û</a></p>
                                </li>
                            </ul>
                        </li> <!--���� ��-->
                        <li> <!--���-->
                            <p><a href="#">���</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li>
                                    <p><a href="/release">����û</a></p>
                                </li>
                                <li>
                                    <p><a href="/release_state_inquiry">����ûó����Ȳ</a></p>
                                </li>
                                <li>
                                    <p><a href="/release_pay">����û����</a></p>
                                </li>
                                <li>
                                    <p><a href="/release_order_list">������ø��</a></p>
                                </li>
                            </ul>
                        </li> <!--���-->
                        <li> <!--������-->
                            <p><a href="#">������</a></p>
                            <ul class="b_header_nav_menu_medium">
                                <li>
                                    <p><a href="/recipe_add">�������߰�</a></p>
                                </li>
                                <li>
                                    <p><a href="/recipe_inquiry">�����Ǹ��</a></p>
                                </li>
                            </ul>
                        </li> <!--������ ��-->
                        <li class="b_header_nav_manager"> <!--������-->
                            <p><a href="/manager_main" class="b_header_nav_manager_btn">�������������� �̵�</a></p>
                        </li> <!--������ ��-->
                    </ul>
                </nav> <!--�޴��� ��-->
            </section><!--.b_header_in-->
        </header> <!--header ��-->
        
            <!-- 3. jQuery ���� -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

    <!--��� js-->
    <script src="../resources/js/header.js"></script>
</body>
</html>