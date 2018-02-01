<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body {
  background: #000;
  padding: 2rem;
}

h2 {
  font-family: 'Arial';
  color: #fff;
  text-transform: uppercase;
  font-weight: bold;
  font-size: 3rem;
  line-height: 1; 
  margin-left: 40%;
  margin-top: 15%;
}

span {
  display: block;
}

span:not(.light) {
  opacity: 0;
  animation: flashText .5s ease-out alternate infinite;
}

span.light {
  position: relative;
  display: inline-block;
  
  &:before {
    position: absolute;
    left: 0;
    top: -10%;
    width: 100%;
    height: 120%;
    background: #fff;
    filter: blur(10px);
    content: "";
    opacity: 0;
    animation: flash .5s ease-out alternate infinite;
  }
}

@keyframes flash{
  to {
    opacity: 1;
  }
}

@keyframes flashText {
  to {
    opacity: 0.15;
  }
}


</style>
</head>
<body>
	<div class="firstAll">
		<h2>
 		 <span>MEGABOX</span>
 		 <a href="movieList.mo?name=user"><span class="light">I KNOW MOVIE</span></a>
 		 <span>THEATER</span>  
 		 <span>LOTTE CINEMA</span>
		</h2>
	</div>
</body>
</html>