<%@page import="kr.co.four.TableDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	TableDTO tdto = new TableDTO();
	ArrayList<TableDTO> tableDayList = (ArrayList) session.getAttribute("tableList");
	double ticketDay = 0;
	double marketDay = 0;
	double avgPeople = 0;
%>
<!DOCTYPE html>
<html>
<head>

<!-- ===================================pie chart=============================== -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<!-- ===================================date=============================== -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


</head>
<body>

	<title>Insert title here</title>
	<style type="text/css">
ul {
	list-style: none;
	font-size: 15px;
}

.gan2{
	margin-top: 108px;
	margin-bottom: 108px;
	}

h1 {
	font-family: "Raleway", sans-serif;
	font-size: 20px;
	margin-left:1%;
	width: 60%;
}

h2 {
	font-family: "Raleway", sans-serif;
	font-size: 20px;
	margin-left:1%;
	float: left;
}

h3 {
	font-family: "Raleway", sans-serif;
	font-size: 20px;
	margin-left: 1%;
	float: left;
	width: 100%;
}

input[type=number]{
	width: 50%;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	resize: vertical;
	font-size: 15px;
	text-align: right;
	padding: 0;
}

input[type=text], select {
	width: 50%;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	resize: vertical;
	font-size: 15px;
}

label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 8px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
}

input[type=submit]:hover {
	background-color: #45a049;
}

fieldset#valuesIncome {
	background-color: hsl(0, 0%, 47%);
	border-radius: 15px;
}

#butin {
	background-color: hsl(0, 0%, 94%);
	border-radius: 7px;
	width: 100%;
	margin-bottom: 0.5%;
	text-align: center;
	font-size: 15px;
	border-style: none;
	border-radius: 15px;
	border-right: none;
	border-left: none;
	border-top: none;
	border-bottom: none;
}

#datepicker3, #datepicker4 {
	width: 20%;
}

fieldset#incomeD_all {
	width: 100%;
	border-radius: 15px;
	background-color: hsl(0, 0%, 47%);
	margin-top: 0;
}

#pie {
	width: 48%;
	/* border: 3px solid blue; */
	float: right;
	z-index: 9999;
	margin-right: 2%;
}

fieldset#values2 {
	float: left;
	background-color: hsl(0, 0%, 94%);
	border-radius: 7px;
	width: 49%;
	margin-bottom: 0.5%;
	z-index: 9999;
	margin-top: -1px;
}

fieldset#but {
	background-color: hsl(0, 0%, 47%);
	border-radius: 7px;
	width: 100%;
	margin-bottom: 0.5%;
	height: 450px;
	/* border: 3px solid green; */
	z-index: 9999;
}

#pieSt {
	border-radius: 7px;
}
</style>
</head>
<body>
	<fieldset id="incomeM_All">
		<h1>구간별 매출액 분석</h1>
		<fieldset id="values1">
			<form action="incomeDay.ta" method="post">
				<%
					if (session.getAttribute("tableList") == null) {
				%>
				<ul>

					<li>
					<label for="날짜선택">날 짜</label> 
					<input type="text" id="datepicker1" placeholder="Start: 년-월-일" style="text-align: center;" name="nal1" required="required">
					<input type="submit" value="호출하기">
					</li>
				</ul>
				<%
					} else {
						tdto = tableDayList.get(tableDayList.size() - 1);
						ticketDay = tdto.getTicketSales();
						marketDay = tdto.getMarketSalse();
						avgPeople = tdto.getAvgPeopleSalse();
				%>
				<ul>

					<li>
					<label for="날짜선택">날 짜</label> <input type="text" id="datepicker1" placeholder="Start: 년-월-일" style="text-align: center;" name="nal1" required="required">
					<input type="submit" value="호출하기">
					</li>

					<li>
					<label for="오늘 티켓 매출 평균">오늘 티켓 매출</label> 
					<input type="number" name="incomeDay" value="<%=tdto.getTicketSales()%>" placeholder="일 평균 매출액" readonly="readonly">원
					</li>
					<li>
					<label for="오늘 매점 매출 평균">오늘 매점 매출</label> 
					<input type="number" name="incomeMon" value="<%=tdto.getMarketSalse()%>" placeholder="월 평균 매출액" readonly="readonly">원
					</li>
					<li>
					<label for="1인 매출액">1인당 평균매출</label> 
					<input type="number" name="incomeMon" value="<%=tdto.getAvgPeopleSalse()%>" placeholder="연 평균 매출액" readonly="readonly">원
					</li>
				</ul>
				<%
					}
				%>
			</form>

		</fieldset>


		<div id="pie">
			<fieldset id="pieSt">
				<div id="container"
					style="height: 100%; width: 100%; margin: 0 auto;"></div>
				<script>
					Highcharts
							.chart(
									'container',
									{
										chart : {
											plotBackgroundColor : null,
											plotBorderWidth : null,
											plotShadow : false,
											type : 'pie'
										},
										title : {
											text : 'Browser market shares January, 2015 to May, 2015'
										},
										tooltip : {
											pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
										},
										plotOptions : {
											pie : {
												allowPointSelect : true,
												cursor : 'pointer',
												dataLabels : {
													enabled : true,
													format : '<b>{point.name}</b>: {point.percentage:.1f} %',
													style : {
														color : (Highcharts.theme && Highcharts.theme.contrastTextColor)
																|| 'black'
													}
												}
											}
										},
										series : [ {
											name : '일 매출액 빈도',
											colorByPoint : true,
											data : [ {
												name : '티켓 매출액',
												y :
				<%=ticketDay%>
					}, {
												name : '매점 매출액',
												y :
				<%=marketDay%>
					,
												sliced : true,
												selected : true
											} ]
										} ]
									});
				</script>

		</fieldset id="values2">
		</div>
		<!-- ==================================아래 총 가격 출력창========================= -->
		<div id="buttum">
			<h3>날짜별 매출액</h3>
			<fieldset id="but">

				<table cellspacing="0" cellpadding="0" border="1" id="butin">
					<tr>
						<th>날짜</th>
						<th>티캣판매액</th>
						<th>매점판매액</th>
						<th>총판매액</th>
						<th>총할인액</th>
						<th>당기순이익</th>
					</tr>

					<c:forEach items="${list }" var="board">
						<tr>
							<td>${board.nal }</td>
							<td><a href="simulatorDelete.ta?nal=${board.nal }">삭제</a></td>
							<td>${board.ticketSales }</td>
							<td>${board.marketSalse }</td>
							<td>${board.totalSalse }</td>
							<td>${board.totalDiscount }</td>
							<td>${board.netIncome }</td>
						</tr>
					</c:forEach>
				</table>

			</fieldset>
		</div>
	</fieldset>

	<!-- =======================script 날짜========================= -->
	<script>
		$(function() {
			$("#datepicker1").datepicker({
				dateFormat : 'yy-mm-dd'
			});
		});
	</script>



</body>
</html>