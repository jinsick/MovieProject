<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.search {
 font-size: 35px;
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
 width: 300px;
 position:relative;
 margin-top: 2%;
 left:49%;
 margin-left: -145px;
 } 
 input[type="submit"] {
 float: left;
 height: 40px;
 background: #FFBB00;
 border-radius: 5px;
 border: none;
 font-family: "맑은 고딕";
 position: relative;
 left:10px;
 top: 10px;
}
th{
   float: left;
   margin-top:5px;
    margin-right: 5px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search form</title>
<script type="text/javascript">
function openId(myform){
   url = "idsearch.manager?name="+myform.name.value+"&part="+myform.part.value;
   window.open(url,"win02","width=300 height=300")
}
function openPw(myform){
   url = "pwserach.manager?id="+myform.id.value+"&name="+myform.name.value+"&part="+myform.part.value;
   window.open(url,"win03","width=300 height=300")
}
</script>
</head>
<body>
<h3 class="search">아이디/비번찾기</h3>
<form action="idSearch.manager" method="post">
   <fieldset>
   <legend>ID찾기</legend>
   <table>
      <tr><th>이름</th>
      <td><input type="text" name="name" placeholder="이름을 입력하세요" required="required"></td>
      <td><input type="submit" value="ID찾기" onClick="openId(this.form)"></td>
      </tr>
      <tr><th>부서</th>
      <td><input type="text" name="part" placeholder="부서를 입력하세요" required="required"></td>
      </tr>
   </table>
   </fieldset>
</form>
<form action="pwSearch.manager" method="post">
   <fieldset>
   <legend>비밀번호 찾기</legend>
      <table>
         <tr><th>ID</th>
         <td><input type="text" name="id" placeholder="ID를 입력하세요" required="required"></td>
         <td><input type="submit" value="비번 찾기" onClick="openPw(myform)"></td>
         </tr>
         <tr><th>이름</th>
         <td><input type="text" name="name" placeholder="이름를 입력하세요" required="required"></td>
         </tr>
         <tr><th>부서</th>
         <td><input type="text" name="part" placeholder="부서를 입력하세요" required="required"></td>
         </tr>
      </table>
   </fieldset>
   </form>
</body>
</html>