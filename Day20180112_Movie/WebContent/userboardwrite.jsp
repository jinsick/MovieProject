<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body { font-size : 15pt;
<<<<<<< HEAD
      font-weight: bold}
div#write1{
   position: absolute;
   top:200px; left:300px;
}
ul{list-style: none;}
#title {font-size: 30pt;
      font-family:'Georgia', serif; 
      font-style:italic}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="write1">
<form action="boardWrite.boa" method="post">
<!-- <input type="hidden" name="icon" value="du2.jpg"> -->
<fieldset>
   <legend id="title"><input type="image" src="images/movie2.png" width="50px">REVIEW</legend>
   <ul>
      <li>
         <label for="영화">영화</label>
      <select name="movietitle">
         <option value="1">1987</option>
         <option value="2">신과함께</option>
         <option value="3">메이즈러너-데스큐어</option>
         <option value="4">위대한 쇼맨</option>
      </select>
      </li>
      <li>
         <label for="제목">제목</label>
         <input type="text" name="title" size="52" placeholder="제목을 입력하세요" required="required">
      </li>
      <li>
         <label for="작성자">작성자</label>
         <input type="text" name="author" size="20" placeholder="작성자입력" required="required">
         <label for="날짜">날짜</label>
         <input type="date" name="nal">
      </li>
      
      <br>
      <li>
         <label for="내용">내용</label>
         <textarea rows="12" cols="80" name="content" placeholder="내용을 입력하세요" required="required"></textarea>
      </li>
      <li>
         <input type="submit" value="등록">
         <!-- <input type="submit" value="수정">
         <input type="submit" value="삭제"> -->
      </li>
      
   </ul>
</fieldset>

</form>
</div>
</body>
</html>