<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.update {
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

th{
   float:right;
   margin-right: 10px;
   margin-bottom: 10px;
   margin-top:10px;
   
   }

input#but1,#but2,#but3{
   position: relative;
     height: 30px;
   background: #58ACFA;
   border-radius: 5px;
   border: none;
   font-family:"맑은 고딕";
   margin-top: 20px;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update form</title>
</head>
<body>
<h1 class="update">수정 폼<small>update</small></h1>
<div id="center">
<form action="updateView.manager" method="post">
<fieldset>
      <table>
      <tr><th>아이디</th>
      <td><input type="text" name="id" required="required" value="${mdto.getId()}" readonly="readonly"></td>
      </tr>
      <tr><th>비밀번호</th>
      <td><input type="text" name="pw" placeholder="비밀번호" required="required" value="${mdto.getPw()}"></td>
      </tr>
      <tr><th>비밀번호확인</th>
      <td><input type="text" name="pwsh" placeholder="비밀번호 확인" required="required" value="${mdto.getPwsh()}"></td>
      </tr>
      <tr><th>직위</th>
      <td><input type="text" name="lv" placeholder="직위" required="required" value="${mdto.getLv()}"></td>
      </tr>
      <tr><th>업무</th>
      <td><input type="text" name="part" placeholder="업무" required="required" value="${mdto.getPart()}"></td>
      </tr>
      <tr><th>이름</th>
      <td><input type="text" name="name" placeholder="이름" required="required" value="${mdto.getName()}"></td>
      </tr>
      </table>
   </fieldset>
   <center>
         <input type="submit" value="수정" id="but1">
         <input type="button" value="취소" onclick="location='template.jsp'" id="but2">
         <%-- <input type="button" value="탈퇴 " id="but3" onclick="location='delete.manager?id=${mdto.getId()}'"> --%>
         <%-- <input type="button" value="탈퇴 " id="but3" onclick="btn3(${mdto.getId()})'"> --%>
         <input type="button" value="탈퇴 " name="but3" onclick="btn3(${mdto.id})">
   </center>


 <script>
function btn3(id){
   var out =confirm("탈퇴하시겠습니까?");
    /* alert('회원탈퇴되었습니다.');
    alert(out); */
   if(out==true){
      /* alert('회원탈퇴되었습니다.'); */
      location.href = "delete.manager?id=" + id;
   }else{
      alert('취소되었습니다.');
   }
}

</script>



</form>
</div>
</body>

</html>