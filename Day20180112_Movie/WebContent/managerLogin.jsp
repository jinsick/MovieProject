<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.login {
 font-size: 50px;
 text-shadow: 0 0 10px #666;
 color: #fff;
 margin: 0 auto;
 text-align: center;
 text-transform: capitalize;
 font-family: "맑은 고딕";
 font-style: italic;
 margin-top:10%;
}
 
 fieldset{
 border-width:3px;
 border-color: purple; 
 border-right-color:purple;
 border-bottom-color:purple;  
 border-radius: 10px;
 font-size: 15px;
 width: 350px;
 position:relative;
 margin-top: 2%;
 left:49%;
 margin-left: -170px;
 } 
 input[type="submit"] {
 float: left;
 height: 55px;
 background: #FFBB00;
 border-radius: 5px;
 border: none;
 font-family: "맑은 고딕";
 position: relative;
 top: 18px;
 left:10px;
}
input[type="button"] {
 height: 30px;
 background: gray;
 border-radius: 5px;
 font-family:"맑은 고딕";
 margin-top:10px;
 margin-right:20px;

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 폼</title>
</head>
<body>
<h3 class="login">login</h3>
<form action="loginform.manager" method="post">
<fieldset>
<table>
   <tr><td>아이디</td>
   <td><input type="text" name="id" placeholder="아이디" required="required"></td>
   <td><input type="submit" value="로그인" ></td>
   </tr>
   <tr><td>비밀번호</td>
   <td><input type="text" name="pw" placeholder="비밀번호" required="required"></td>
   </tr>
 <tr>
    <td><input type="button" value="등록" onclick="location='managerRigister.jsp'"></td> 
    <td><input type="button" value="아이디/비밀번호 찾기"></td>
 </tr>
</table>
</fieldset>
</form>
</body>
</html>