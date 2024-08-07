<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DVD</title>
</head>
<body>
	<div id="container">
		<!-- 헤더 포함 -->
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="search-bar">
            <c:url var="searchUrl" value="/products/search" />
            <form action="${searchUrl}" method="GET">
                <input type="text" name="keyword" placeholder="검색">
                <button type="submit">검색</button>
            </form>
        </div>
	</div>

	<div id="content">
		<div class="button" style="float:left;">
			<button onclick="goGenre('A')">공포</button>
			<button onclick="goGenre('B')">드라마</button>
			<button onclick="goGenre('C')">스릴러</button>
			<button onclick="goGenre('D')">코미디</button>
			<button onclick="goGenre('E')">로맨스</button>
			<button onclick="goGenre('F')">액션</button>
			<button onclick="goGenre('G')">SF</button>
		</div>
		<div class="list-container">
			<table border="1" width="100%">
				<tr>
					<th>상품번호</th>
					<th>상품이름</th>
					<th>장르</th>
					<th>출시일</th>
				</tr>
				<c:forEach var="product" items="${products}">
					<tr>
						<td>${product.productNo}</td>
						<td><a href="${pageContext.request.contextPath}/products/detail?productNo=${product.productNo}">${product.productName}</a></td> <!-- 상품이름에만 링크 -->
						<td>${product.genre}</td>
						<td>${product.releaseDate}</td>
					</tr>
				</c:forEach>
				<tr>
					<c:if test="${authUser.role == 1 }">
                    <li>
                        <button onclick="location.href='<c:url value="/admin/home" />'">관리자 화면</button>
                    </li>
                </c:if>
				</tr>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">
	function goGenre(type){
		alert(type);
	}

</script>
</html>
