<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 상세페이지</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
<div id="header">
	<c:if test="${not empty errorMsg }">
		<h5>${errorMsg }</h5>
	</c:if>
	<h1>내 정보 페이지</h1>
<c:choose>
	<c:when test="${not empty authUser }">
	<form:form modelAttribute="userVo" id="Info" name="userInfoForm" method="POST" action="<c:url value='/users/Infoform' />">
	<div class="form-group">
			<label id="userNo" class="block-label" for="username">이름 ${authUser.username }</label>
			<br>
	
			<label id="userNo" class="block-label" for="email">이메일 ${authUser.email }</label>
			<br>
	
			<label id="userNo" class="block-label" for="birth">생년월일 ${authUser.birth }</label>
			<br>
		<div class="button">
			<button type="button" onclick="location.href='<c:url value="/users/updateform" />'">수정하기</button>
			<button type="button" onclick="location.href='<c:url value="/users/deleteconfirm" />'">탈퇴하기</button>
			<button type="button" onclick="window.location.href='<c:url value="/" />'">홈으로</button>
		</div>
		</div>
	</form:form>
	</c:when>
</c:choose>
</div>

</body>
</html>
