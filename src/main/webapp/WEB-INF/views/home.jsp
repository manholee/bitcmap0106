<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="common/head.jsp" />
<style>
	#box{width: 500px; height: 200px; margin: 0 auto;}
	#login-btn{
		width: 200px;
		height: 200px;
		background: yellow;
	}
		#board-btn{
		width: 200px;
		height: 200px;
		background: blue;
		margin-left: 50px;
	}
</style>

<div id="box">
	<button id="login-btn">LOGIN(ajax 조합 예시)</button>
	<button id="board-btn">BOARD(jsp 예시)</button>	
</div>

<!-- ${pageContext.request.contextPath} url 도메인  -->
<script>
$(function(){
	$('#login-btn').click(function(){
		location.href = "${pageContext.request.contextPath}/main";
	});
	$('#board-btn').click(function(){
		location.href = "${pageContext.request.contextPath}/move/board/list";
	});
});

</script>
