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
	
	img{
		width: 200px;
		height: 300px;
		cursor: pointer;
	}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>I know movie</h1>
<h3>현재 상영작 </h3>

	<table>
		<tr>
			<th>No.1</th>
			<th>No.2</th>
			<th>No.3</th>			
		</tr>
		<tr>
			<td><a href="Usertemplate.jsp?page=movie_Screening"><img src="images/코코.jpg" onclick="popup_win1()"></a></td>
			<td><a href="Usertemplate.jsp?page=movie_Screening"><img src="images/신과함게.jpg" onclick="popup_win2()"></a></td>
			<td><a href="Usertemplate.jsp?page=movie_Screening"><img src="images/쥬만지.jpg" onclick="popup_win3()"></a></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>

	<table>
		<tr>
			<th >No.4</th>
			<th >No.5</th>
			<th >No.6</th>			
		</tr>
		<tr>
			<td><a href="Usertemplate.jsp?page=movie_Screening"><img src="images/강철비.jpg" onclick="popup_win4()"></a></td>
			<td><a href="Usertemplate.jsp?page=movie_Screening"><img src="images/어쌔신더비기닝.jpg" onclick="popup_win5()"></a></td>
			<td><a href="Usertemplate.jsp?page=movie_Screening"><img src="images/위대한 쇼맨.jpg" onclick="popup_win6()"></a></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<table>
		<tr>
			<th>No.7</th>
			<th>No.8</th>
			<th>No.9</th>			
		</tr>
		<tr>
			<td><a href="Usertemplate.jsp?page=movie_Screening"><img src="images/dun.jpg" onclick="popup_win7()"></a></td>
			<td><a href="Usertemplate.jsp?page=movie_Screening"><img src="images/홈커밍.jpg" onclick="popup_win8()"></a></td>
			<td><a href="Usertemplate.jsp?page=movie_Screening"><img src="images/더울프오브더월스트릿.jpg" onclick="popup_win9()"></a></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
</body>
</html>