<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

	body {
		background-color: #F0F8FF;
	}
	
	h1 {
    text-align: center;
    font-family: "Lato", sans-serif;
    font-variant: small-caps;
    position:relative;
	margin:auto;
	margin-top: auto;
	margin-right: auto;
	margin-left: auto;
	text-align: center;
	}
	
	h3 {
    text-align: center;
    font-variant: small-caps;
    position:relative;
    top:20px;
	margin:auto;
	margin-top: auto;
	margin-right: auto;
	margin-left: auto;
	text-align: center;
	}
	
	table{
	position: relative;
	top:30px;
	border-spacing: 20px;
	margin:auto;
	margin-top: auto;
	margin-right: auto;
	margin-left: auto;
	text-align: center;
	}
	th{
	width: 200px;
	height:50px; 
	}
	
	img{
		width: 200px;
		height: 300px;
		cursor: pointer;
	}
</style>
<script type="text/javascript">
function popup_win1() { 
	window.open("images/e1.jpg", "e1", "width=400, height=570,  scrollbars=0");
	}
function popup_win2() { 
	window.open("images/e2.jpg", "e2", "width=400, height=570,  scrollbars=0");
	}
function popup_win3() { 
	window.open("images/e3.jpg", "e3", "width=400, height=570,  scrollbars=0");
	}
function popup_win4() { 
	window.open("images/e4.jpg", "e4", "width=400, height=570,  scrollbars=0");
	}
function popup_win5() { 
	window.open("images/e5.jpg", "e5", "width=400, height=570,  scrollbars=0");
	}
function popup_win6() { 
	window.open("images/e11.jpg", "e6", "width=700, height=700,  scrollbars=0");
	}
function popup_win7() { 
	window.open("images/e9.jpg", "e7", "width=400, height=570,  scrollbars=0");
	}
function popup_win8() { 
	window.open("images/e12.jpg", "e8", "width=400, height=570,  scrollbars=0");
	}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>I know movie</h1>
<h3>이벤트</h3>

	<table>
		<tr>
			<td><a href="Usertemplate.jsp?page=event"><img src="images/e1.jpg" onclick="popup_win1()"></a></td>
			<td><a href="Usertemplate.jsp?page=event"><img src="images/e2.jpg" onclick="popup_win2()"></a></td>
			<td><a href="Usertemplate.jsp?page=event"><img src="images/e3.jpg" onclick="popup_win3()"></a></td>
			<td><a href="Usertemplate.jsp?page=event"><img src="images/e4.jpg" onclick="popup_win4()"></a></td>
		</tr>
		<tr>
			<th>코코 콤보</th>
			<th>2013 VIP 선정기준 발표</th>
			<th>KT멤버십 VIP 무료예매</th>			
			<th>T맴버십 내맘대로 플러스 영화1+1</th>			
		</tr>
	</table>

	<table>
		<tr>
			<td><a href="Usertemplate.jsp?page=event"><img src="images/e5.jpg" onclick="popup_win5()"></a></td>
			<td><a href="Usertemplate.jsp?page=event"><img src="images/e11.jpg" onclick="popup_win6()"></a></td>
			<td><a href="Usertemplate.jsp?page=event"><img src="images/e9.jpg" onclick="popup_win7()"></a></td>
			<td><a href="Usertemplate.jsp?page=event"><img src="images/e12.jpg" onclick="popup_win8()"></a></td>
		</tr>
		<tr>
			<th>GRAND OPENING</th>
			<th>예메 경품이벤트</th>
			<th>관람평 이벤트</th>			
			<th>하이큐 다이어리</th>			
		</tr>
	</table>
</body>
</html>