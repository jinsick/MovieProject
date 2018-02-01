<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body { font-size : 15pt;
      font-weight: bold}
#title {font-size: 30pt;
      font-family:'Georgia', serif; 
      font-style:italic}

table.type08 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    border-left: 1px solid #ccc;
    margin: 20px 10px;
}

table.type08 thead th {
    padding: 10px;
    font-weight: bold;
    border-top: 1px solid #ccc;
    border-right: 1px solid #ccc;
    border-bottom: 2px solid #c00;
    background: #dcdcd1;
}
table.type08 tbody th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    background: #ececec;
}
table.type08 td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="board1">

<h1 id="title"> <input type="image" src="images/movie2.png" width="50px">MOVIE REVIEW</h1> 
<form action="registerStudent" method="post">
<table class="type08">
    <thead>
    <tr>
        <th scope="cols">번호</th>
        <th scope="cols">영화</th>
        <th scope="cols">제목</th>
        <th scope="cols">작성자</th>
        <th scope="cols">작성일</th>
        <th scope="cols">조회수</th>
    </tr>
    </thead>
    <c:forEach var="userboard" items="${boardList}">
  
    <tbody>
    <tr>
        <th scope="row">항목명</th>
        <td>${board.no}</td>
    </tr>
    <tr>
        <th scope="row">항목명</th>
        <td>${board.movie}</td>
    </tr>
    <tr>
        <th scope="row">항목명</th>
        <td><a href='boardContent.boa?no=${board.no}'>${board.title}</a></td>
    </tr>
    <tr>
        <th scope="row">항목명</th>
        <td>${board.author}</td>
    </tr>
    <tr>
        <th scope="row">항목명</th>
        <td>${board.nal}</td>
    </tr>
    <tr>
        <th scope="row">항목명</th>
       <td>${board.readcount}</td>
    </tr>
    </tbody>
</c:forEach>
</table>
</form>

<a href="usertemplate.jsp?page=userboardwrite">리뷰작성</a>
<a href="boardList.boa">목록으로</a>
<form action="boardSearch.boa">
<input type="text" name="title" required="required" placeholder="제목입력">
<input type="submit" value="찾기">
</form>
</div>
</body>
</html>