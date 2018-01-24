<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.register {
 font-size: 45px;
 text-shadow: 0 0 10px #666;
 color: #fff;
 margin: 0 auto;
 text-align: center;
 text-transform: capitalize;
 font-family: "맑은 고딕";
 font-style: normal;
 margin-top:5%;
}

fieldset {
   border-width:3px;
    border-color: purple; 
    border-right-color:purple;
    border-bottom-color:purple;  
    border-radius: 10px;
   width: 380px;
   position: relative;
   top:10%;
   margin-top: 3%;
    left:50%;
    margin-left: -200px;
}
input[type="button"]{
height: 30px;
background: #58ACFA;
border-radius: 5px;
border: none;
font-family:"맑은 고딕";
text-
}
input[type="submit"]{
height: 30px;
background: #58ACFA;
border-radius: 5px;
border: none;
font-family:"맑은 고딕";
}

th{
   float:right;
   margin-right: 10px;
   margin-bottom: 10px;
   margin-top:10px;
   }

#button{
   position: relative;
   left:50%;
    margin-left: -50px;
    margin-top: 2%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register form</title>
</head>
<body>
<h1 class="register">등록 <small>register</small></h1>
<form action="Register.manager" method="post">
<fieldset>
      <table>
      <tr><th>아이디</th>
      <td><input type="text" name="id" placeholder="아이디" required="required"></td>
      <td><input type="button" value="중복확인" onClick="openId(this.form)"></td>
      </tr>
      <tr><th>비밀번호</th>
      <td><input type="text" name="pw" placeholder="비밀번호" required="required"></td>
      </tr>
      <tr><th>비밀번호확인</th>
      <td><input type="text" name="pwsh" placeholder="비밀번호 확인" required="required"></td>
      </tr>
      <tr><th>직위</th>
      <td><input type="text" name="lv" placeholder="직위" required="required"></td>
      </tr>
      <tr><th>업무</th>
      <td><input type="text" name="part" placeholder="업무" required="required"></td>
      </tr>
      <tr><th>이름</th>
      <td><input type="text" name="name" placeholder="이름" required="required"></td>
      </tr>
      </table>
   </fieldset>
<div id=button>
   <input type="submit" value="등록" >
   <input type="button" value="취소" >
</div>
</form>
</body>
</html>