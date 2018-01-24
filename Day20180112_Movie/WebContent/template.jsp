<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 	 <c:set var="pagefile" value="${param.page}"/>
   	 <c:choose>
  	  <c:when test="${pagefile==null}">
  		<c:set var="pagefile" value="Main_Movie_User"/>
  	  </c:when>
     </c:choose>

<!DOCTYPE html>
<html lang="en">
<head>
<title>CSS Template</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
    box-sizing: border-box;
}


body {
    margin: 0;
}


/* Style the side navigation */
.sidenav {	
    height: 100%;
    width: 200px;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;    
}


/* Side navigation links */
.sidenav a {
    color: white;
    padding: 16px;
    
    text-decoration: none;
    display: block;
    
}

/* Change color on hover */
.sidenav a:hover {
    background-color: #ddd;
    color: black;
}

/* Style the content */
.content {
    margin-left: 200px;
    padding-left: 20px;
}

#manager{}
</style>
</head>
<body>

<div class="sidenav">

<c:choose>
<c:when test="${sessionScope.id == null }">
	<div id="managerLog">
  	<a href="template.jsp?page=managerLogin">Login</a>
  </div>
  </c:when>
  <c:otherwise>
  <div id="managerLog">
    <center><h4 style="color: white; font-size: 15px;">${sessionScope.id}님 환영합니다.</h4></center>
  	<a href="logout.manager">LogOut</a><a href="update.manager">매니저 정보수정</a>
  </div>
</c:otherwise>  
  </c:choose>
  <br>
  <a href="template.jsp?page=Main_Movie_User">User Home</a>
  <div id="manager">
  	<a href="template.jsp?page=Manager_Main">일매출액 분석</a>
  </div>
  <a href="mainList.ta">영화관 수익 시뮬</a>
  <a href="movieList.mo">Main제어 툴</a>
</div>

<div class="content">
  <div id="movie">
	 <jsp:include page='${pagefile}.jsp' />
  </div>
  
</div>

</body>
</html>
