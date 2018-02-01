<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
div#write1{

   position: absolute;
   top:200px; left:100px;
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="write1">글쓰기

<form action="boardUpdate.boa" method="post">
<input type="hidden" name="no" value="${boardDTO.no }">
<fieldset>
	<legend>글쓰기폼</legend>
	<ul>
		<li>
			<label for="제목">제목</label>
			<input type="text" name="title" size="50" value="${boardDTO.title }">
		</li>
		<li>
			<label for="작성자">작성자</label>
			<input type="text" name="author" size="50" value="${boardDTO.author }">
		</li>
		<li>
			<label for="내용">내용</label>
			<textarea rows="12" cols="80" name="content" >${boardDTO.content }
			</textarea>
		</li>
		<li>
			<label for="날짜">날짜</label>
			<input type="text" name="nal" value="${boardDTO.nal }">
		</li>
		<li>
			<input type="submit" value="수정하기">
	
		</li>
	</ul>
	<form action="boardDelete.boa" method="post">
	<input type="hidden" name="no" value="${boardDTO.no }">
	<input type="submit" value="삭제하기">
	</form>

</fieldset>

</form>
</div>
</body>
</html>