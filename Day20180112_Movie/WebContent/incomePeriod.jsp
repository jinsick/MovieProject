<%@page import="kr.co.four.TableDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	TableDTO tdto = new TableDTO();
	ArrayList<TableDTO> tablePeriodList = (ArrayList) session.getAttribute("tableList");
	float avgDay = 0;
	float avgMonth = 0;
	float avgYear = 0;
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
 
.gan1{
	margin-top: 108px;
	margin-bottom: 108px;
	}

h1 {
	font-family: "Raleway", sans-serif;
	font-size: 20px;
	margin-left:1%;
	float: left;
	width: 60%;
}

h2{
font-family: "Raleway", sans-serif;
	font-size: 20px;
	margin-left: 1%;
	float: left;
}

h3 {
	font-family: "Raleway", sans-serif;
	font-size: 20px;
	margin-top: 2%;
	margin-left:1%;
	float: left;
	width: 100%;
}

input[type=number], select {
	width: 50%;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	resize: vertical;
	font-size: 20px;
	text-align: right;
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

#datepicker1, #datepicker2 {
	width: 20%;
}

fieldset#incomeD_all {
	width: 100%;
	border-radius: 15px;
	background-color: hsl(0, 0%, 47%);
}

#line {
	width: 48%;
	/* border: 3px solid blue; */
	float: right;
	z-index: 9999;
	margin-right: 2%;
		}

fieldset#values1 {
	float: left;
	background-color: hsl(0, 0%, 94%);
	border-radius: 7px;
	width: 49%;
	/* margin-bottom: 0.5%; */
	margin-top: -1px;
}

fieldset#but {
	background-color: hsl(0, 0%, 47%);
	border-radius: 7px;
	width: 100%;
	margin-bottom: 0.5%;
	height: 450px; /*
	border: 3px solid green; *
	z-index: 9999;
	/
}

#lineSt {
	border-radius: 7px;
}
</style>
</head>


<body>
	<fieldset id="incomeD_All">
		<h1>일 매출액 분석</h1>
		<fieldset id="values2">
			<form action="incomPeriod.ta" method="post">
				<%
					if (tablePeriodList == null) {
				%>
				<ul>
					<li><label for="날짜선택">날 짜</label> <input type="text"
						id="datepicker3" placeholder="Start: 년-월-일"
						style="text-align: center;" name="nal1" required="required">
						~ <input type="text" id="datepicker4" placeholder="End: 년-월-일"
						style="text-align: center;" name="nal2" required="required">
						<input type="submit" value="호출하기"></li>
				</ul>
				<%
					} else {
						tdto = tablePeriodList.get(tablePeriodList.size() - 1);
				%>
				<ul>

					<li><label for="날짜선택">날 짜</label> <input type="text"
						id="datepicker3" placeholder="Start: 년-월-일"
						style="text-align: center;" name="nal1" required="required">
						~ <input type="text" id="datepicker4" placeholder="End: 년-월-일"
						style="text-align: center;" name="nal2" required="required">
						<input type="submit" value="호출하기"></li>

					<li><label for="일평균 매출액">일 평균매출액</label> <input type="number"
						name="incomeDay" value="<%=tdto.getAvgDay()%>"
						placeholder="일 평균 매출액" readonly="true">원</li>

					<li><label for="월평균 매출액">월 평균매출액</label> <input type="number"
						name="incomeMon" value="<%=tdto.getAvgMonth()%>"
						placeholder="월 평균 매출액" readonly="readonly">원</li>

					<li><label for="연평균 매출액">연 평균매출액</label> <input type="number"
						name="incomeMon" value="<%=tdto.getAvgYear()%>"
						placeholder="연 평균 매출액" readonly="readonly">원</li>
				</ul>
				<%
					}
				%>
			</form>

		</fieldset>

		<!-- =============================Ticket line chart ===================================== -->
		<div id="line">
			<fieldset id="lineSt">
				<div id="containerlineT"
					style="width: 100%; height: 100%; margin: 0 auto;"></div>
				<script>
					Highcharts.chart('containerlineT', {
						chart : {
							type : 'line'
						},
						title : {
							text : '매출액 추이'
						},
						subtitle : {
							text : ''
						},
						xAxis : {
							categories :<%-- [ 
								<% for(int i=0;i<tablePeriodList.size();i++){
									tdto = tablePeriodList.get(i);
									%>
									<%=tdto.getNal()%>,
									<%
								}%>]
								 --%>
								[ 'Jan', 'Feb', 'Mar', 'Apr', 'May',
									'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov',
									'Dec' ]
						},
						yAxis : {
							title : {
								text : 'Temperature (°C)'
							}
						},
						plotOptions : {
							line : {
								dataLabels : {
									enabled : true
								},
								enableMouseTracking : false
							}
						},
						series : [
								{
									name : 'Tokyo',
									data : [ 7.0, 6.9, 9.5, 14.5, 18.4, 21.5,
											25.2, 26.5, 23.3, 18.3, 13.9, 9.6 ]
								},
								{
									name : 'London',
									data : [ 3.9, 4.2, 5.7, 8.5, 11.9, 15.2,
											17.0, 16.6, 14.2, 10.3, 6.6, 4.8 ]
								} ]
					});
				</script>
			</fieldset>
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
							<td><a href="simulatorDelete.ta?nal=${board.nal }">삭제</a></td>
							<td>${board.nal }</td>
							<td>${board.ticketSales }</td>
							<td>${board.marketSalse }</td>
							<td>${board.totalSalse }</td>
							<td>${board.totalDiscount }</td>
							<td>${board.netIncome }</td>
						</tr>
					</c:forEach>
				</table>
				<%--          <center>
            <jsp:include page="#" flush="true" />
         </center> --%>
			</fieldset>
		</div>
	</fieldset>

	<!-- =======================script 날짜========================= -->
	<script>
			$(function() {
  				$( "#datepicker3" ).datepicker({
    				dateFormat: 'yy-mm-dd'
 				 });
			});
		</script>

	<script>
			$(function() {
  				$( "#datepicker4" ).datepicker({
    				dateFormat: 'yy-mm-dd'
 				 });
			});
		</script>


</body>
</html>