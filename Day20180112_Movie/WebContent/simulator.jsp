<%@page import="kr.co.four.TableDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	TableDTO tdto = new TableDTO();
ArrayList<TableDTO> topList = (ArrayList)request.getAttribute("totalList");
	ArrayList<TableDTO> tableList = (ArrayList) session.getAttribute("tableList");
	float totalTicketSalse = 0;
	float totalMarketSalse = 0;
	float totalSalse = 0;
	float targetTotalSalse = 10000000;
	float totalSalseRate = 0;
	float avgDay = 0;
	float avgMonth = 0;
 	float avgYear = 0;
	float toDayTicketSalse=0;
	float toDayMarketSalse=0;
	float avgPeopleSalse = 0;
%>

<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- ===================================pie chart=============================== -->
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<!-- ===================================date=============================== -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}

h6, h7, h8 {
	color: white;
	font-weight: bold;
}

h9 {
	font-family: "Raleway", sans-serif;
	font-size: 20px;
}

h10 {
	font-family: "Raleway", sans-serif;
	font-size: 20px;
	margin-top: 1%;
}

ul {
	list-style: none;
}

owser
#sideAll {
	width: 25%;
}

#sidebig {
	width: 25%;
	float: right;
	margin-top: 0%;
	background-color: hsl(0, 0%, 47%);
	border-radius: 15px;
	margin-top: 2.4%;
}

#ticket {
	background-color: hsl(0, 0%, 94%);
	border-radius: 7px;
}

#market {
	background-color: hsl(0, 0%, 94%);
	border-radius: 7px;
}

#Fixedspend {
	background-color: hsl(0, 0%, 94%);
	border-radius: 7px;
}

input[type=number], select {
	width: 50%;
	padding: 5px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	resize: vertical;
}

input[type=text], select {
	width: 50%;
	padding: 5px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	resize: vertical;
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

#pieall {
	margin-top: 9%;
}

#piefield1 {
	width: 74%;
	background-color: hsl(0, 0%, 47%);
	border-radius: 15px;
	float: left;
}

#container {
	width: 45%;
	float: left;
}

#containerlineT {
	width: 52.5%;
	float: right;
}

#table2 {
	margin-top: 25.5%;
}

.valueIncomeAll {
	float: left;
	width: 74.2%;
	margin-top: 1%;
}

fieldset#valuesIncome {
	background-color: hsl(0, 0%, 47%);
	border-radius: 15px;
}

fieldset#values1 {
	float: left;
	background-color: hsl(0, 0%, 94%);
	border-radius: 7px;
	width: 49.5%;
	margin-top: 1%;
	margin-bottom: 0.5%;
}

fieldset#values2 {
	float: right;
	background-color: hsl(0, 0%, 94%);
	border-radius: 7px;
	width: 49.5%;
	margin-top: 1%;
	margin-bottom: 0.5%;
}

fieldset#but {
	float: left;
	background-color: hsl(0, 0%, 47%);
	border-radius: 7px;
	width: 74%;
	margin-bottom: 0.5%;
	height: 450px;
}

#butin {
	background-color: hsl(0, 0%, 94%);
	border-radius: 7px;
	width: 100%;
	margin-top: 1%;
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

#datepicker4, #datepicker5 {
	width: 150px;
}
</style>


<body class="w3-light-grey">

	<!-- Top container -->
	<div class="w3-bar w3-top w3-black w3-large" style="z-index: 4">
		<button
			class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey"
			onclick="w3_open();">
			<i class="fa fa-bars"></i>  Menu
		</button>
	</div>
	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-hide-large w3-animate-opacity"
		onclick="w3_close()" style="cursor: pointer" title="close side menu"
		id="myOverlay"></div>

	<!-- !PAGE CONTENT! -->
	<!-- Header -->
	<header class="w3-container" style="padding-top: 5px">
		<h5>
			<b><i class="fa fa-dashboard"></i> Income</b>
		</h5>
	</header>


	<!-- ==========================================상단 메뉴 바:판매수익============================== -->

	<div class="w3-row-padding w3-margin-bottom">
		<div class="w3-quarter">
			<div class="w3-container w3-red w3-padding-16">
				<div class="w3-left">
					<i class="티켓이미지"></i>
				</div>
			<%
			for(int i=0;i<topList.size();i++){
				tdto = topList.get(i);
				totalTicketSalse = totalTicketSalse + tdto.getTicketSales();
				totalMarketSalse = totalMarketSalse + tdto.getMarketSalse();
				totalSalse = totalSalse +tdto.getTotalSalse();
				totalSalseRate = totalSalse/targetTotalSalse*100;
				
			}
			%>	
				
				<div class="w3-right">
		<h3><%=totalTicketSalse%></h3>
				</div>
				
				<div class="w3-clear"></div>
				<h4>Ticket sales</h4>
			</div>
		</div>

		<div class="w3-quarter">
			<div class="w3-container w3-blue w3-padding-16">
				<div class="w3-left">
					<i class="식자재  이미지"></i>
				</div>
				<div class="w3-right">
					<h3><%=totalMarketSalse %></h3>
				</div>
				<div class="w3-clear"></div>
				<h4>Market sales</h4>
			</div>
		</div>

		<div class="w3-quarter">
			<div class="w3-container w3-teal w3-padding-16">
				<div class="w3-left">
					<i class="fa fa-share-alt w3-xxxlarge"></i>
				</div>
				<div class="w3-right">
					<h3><%=totalSalse %></h3>
				</div>
				<div class="w3-clear"></div>
				<h4>Total sales</h4>
			</div>
		</div>

		<div class="w3-quarter">
			<div class="w3-container w3-orange w3-padding-16">
				<div class="w3-black" style="width: 100%;">
					<div class="w3-left">
						<div>
							<div class="w3-container w3-center w3-padding w3-green"
								style="width: <%=totalSalseRate%>%; font-size: 27px;">+<%=totalSalseRate%>%</div>
						</div>
					</div>
					<div class="w3-clear"></div>
					<div class="w3-left">
						<h4>Achievement rate</h4>
					</div>
				</div>
			</div>
		</div>

	
				<!-- ===============================옆구리========================== -->
				<div class="sideAll">
					<fieldset id="sidebig">
						<div>
							<form action="enter.hold" method="post">
								<h6>고정지출</h6>
								<fieldset id="Fixedspend">
									<ul>
										<li><label for="날짜선택">날 짜</label> <input type="text"
											id="datepicker3" placeholder="날짜선택: 년-월-일"
											style="text-align: center;" name="nal"></li>

										<li><label for="자릿세">자릿세</label> <input type="number"
											name="placem" placeholder="자릿세 " required="required" min=0>
										</li>

										<li><label for="인건비">인건비</label> <input type="number"
											name="wage" placeholder="인건비" required="required" min=0>
										</li>

										<li><label for="기타">기&nbsp;&nbsp;&nbsp;&nbsp;타</label> <input
											type="number" name="tax" placeholder="입력" required="required"
											min=0></li>

										<li>
											<button onclick="javascript:btn1()">저장</button>
										</li>

									</ul>
								</fieldset>
							</form>
						</div>
						<br>
						<div>
							<form action="enter.ticket" method="post">
								<h7>티켓설정</h7>
								<fieldset id="ticket">
									<ul>
										<li><label for="날짜선택">날 짜</label> <input type="text"
											id="datepicker1" placeholder="날짜선택: 년-월-일"
											style="text-align: center;" name="nal"></li>

										<li><label for="할인1">일 반</label> <input type="number"
											name="original" placeholder="일반티켓 갯수입력"
											style="text-align: right;" min=0 required="required">
										</li>

										<li><label for="할인2">조 조</label> <input type="number"
											name="morning" placeholder="조조티켓 갯수입력"
											style="text-align: right;" min=0 required="required">(-2000원)
										</li>

										<li><label for="할인3">야 간</label> <input type="number"
											name="night" placeholder="야간티켓 갯수입력"
											style="text-align: right;" min=0 required="required">(-2000원)
										</li>

										<li><label for="할인3">주말</label> <input type="number"
											name="wend" placeholder="+2000원 갯수입력"
											style="text-align: right;" min=0 required="required">&nbsp;(+2000원)
										</li>

										<li><label for="할인3">쿠폰</label> <input type="number"
											name="coupon" placeholder="-2000원 갯수입력"
											style="text-align: right;" min=0 required="required">&nbsp;(-2000원)
										</li>



										<li>
											<!-- <input type="submit" value="저장" > -->
											<button onclick="javascript:btn2()">저장</button>
										</li>
									</ul>
								</fieldset>
							</form>
						</div>
						<br>

						<div>
							<form action="enter.market" method="post">
								<h8>마켓설정</h8>
								<fieldset id="market">
									<ul>
										<li><label for="날짜선택">날 짜</label> <input type="text"
											id="datepicker2" placeholder="날짜선택: 년-월-일"
											style="text-align: center;" name="nal" required="required">
										</li>
										<li><label for="팝콘">팝콘</label> <input type="number"
											name="pop" value="#" placeholder="팝콘 갯수"
											style="text-align: right;" min=0 required="required">
											(5000원)</li>

										<li><label for="콜라R">탄산음료</label> <input type="number"
											name="col" value="#" placeholder="음료 갯수"
											style="text-align: right;" min=0 required="required">(2000원)
										</li>

										<li><label for="즉석구이 오징어">즉석구이 오징어</label> <input
											type="number" name="oging" value="#" placeholder="즉석구이 갯수"
											style="text-align: right;" min=0 required="required">
										</li>

										<li><label for="핫도그"> 핫도그</label> <input type="number"
											name="dog" value="#" placeholder="핫도그 갯수"
											style="text-align: right;" min=0 required="required">
										</li>

										<li><label for="후라이드치킨">치&nbsp;킨</label> <input
											type="number" name="chiken" value="#" placeholder="치킨 갯수"
											style="text-align: right;" min=0 required="required">
										</li>

										<li><label for="아메리카노">아메리카노</label> <input type="number"
											name="coffee" value="#" placeholder="아메리카노 갯수"
											style="text-align: right;" min=0 required="required">
										</li>

										<li><label for="콤보">콤보</label> <input type="number"
											name="combo1" value="#" placeholder="콤보 갯수"
											style="text-align: right;" min=0 required="required">
										</li>

										<li><label for="이벤트 콤보">이벤트 콤보</label> <input
											type="number" name="combo2" value="#" placeholder="이벤트 콤보 갯수"
											style="text-align: right;" min=0 required="required">
										</li>

										<li><label for="1500음료">1500음료</label> <input
											type="number" name="water1" value="#" placeholder="1500음료 갯수"
											style="text-align: right;" min=0 required="required">
										</li>

										<li>
											<button onclick="javascript:btn3()">저장</button>
										</li>
									</ul>


								</fieldset>
							</form>
						</div>
					</fieldset>
				</div>

				<!-- =========================매출액 분석============================== -->

			<%-- 	<div class="valueIncomeAll">
					<h9>매출 상세</h9>
					<fieldset id="valuesIncome">

						<fieldset id="values1">
							<form action="report.ta" method="post">
								<!-- <li><label for="날짜선택">날 짜</label> <input type="text"
									id="datepicker4" placeholder="Start: 년-월-일"
									style="text-align: center;" name="nal1" required="required">
									~ <input type="text" id="datepicker5" placeholder="End: 년-월-일"
									style="text-align: center;" name="nal2" required="required">
									<input type="submit" value="호출하기"></li> -->
								<!-- </form>
									<form action=""> -->
								<%
									if (session.getAttribute("tableList") == null) {
								%><ul>

									<li><label for="날짜선택">날 짜</label> <input type="text"
										id="datepicker4" placeholder="Start: 년-월-일"
										style="text-align: center;" name="nal1" required="required">
										~ <input type="text" id="datepicker5" placeholder="End: 년-월-일"
										style="text-align: center;" name="nal2" required="required">
										<input type="submit" value="호출하기"></li>
									<li><label for="일평균 매출액">일 평균매출액(1인)</label> <input
										type="number" name="incomeDay" value="<%=avgDay%>"
										placeholder="일 평균 매출액" readonly="true">원</li>
									<li><label for="월평균 매출액">월 평균매출액(1인)</label> <input
										type="number" name="incomeMon" value="" placeholder="월 평균 매출액"
										readonly="readonly">원</li>
									<li><label for="연평균 매출액">연 평균매출액(1인)</label> <input
										type="number" name="incomeMon" value="" placeholder="연 평균 매출액"
										readonly="readonly">원</li>
								</ul>
							</form>

						</fieldset>
<form action="" method="post">
						<fieldset id="values2">
							<ul>
							<li><label for="날짜선택">날짜선택</label><input type="text" id="datepicker5" placeholder="End: 년-월-일"
										style="text-align: center;" name="todayNal" required="required">
										<input type="submit" value="호출하기"></li>
								<li><label for="오늘 티켓 매출 평균">오늘 티켓 매출</label> <input
									type="number" name="incomeDay" value="" placeholder="일 평균 매출액"
									readonly="readonly">원
								<li>
								<li><label for="오늘 매점 매출 평균">오늘 매점 매출</label> <input
									type="number" name="incomeMon" value="" placeholder="월 평균 매출액"
									readonly="readonly">원
								<li>
								<li><label for="1인 매출액">1인당 평균매출</label> <input
									type="number" name="incomeMon" value="" placeholder="연 평균 매출액"
									readonly="readonly">원
								<li>
							</ul>
</form>
							<%
								} else {

									for (int i = 0; i < tableList.size(); i++) {
										tdto = tableList.get(i);
										avgMonth = tdto.getAvgMonth();
										avgDay = tdto.getAvgDay();
										avgYear = tdto.getAvgYear();
										toDayTicketSalse = tdto.getToDayTicketSalse();
										toDayMarketSalse = tdto.getToDayMarketSalse();
										avgPeopleSalse = tdto.getAvgPeopleSalse();
									}
							%>

							<ul>
								<li><label for="날짜선택">날 짜</label> <input type="text"
									id="datepicker4" placeholder="Start: 년-월-일"
									style="text-align: center;" name="nal1" required="required">
									~ <input type="text" id="datepicker5" placeholder="End: 년-월-일"
									style="text-align: center;" name="nal2" required="required">
									<input type="submit" value="호출하기"></li>
								<li><label for="일평균 매출액">일 평균매출액(1인)</label> <input
									type="number" name="incomeDay" value="<%=avgDay%>"
									placeholder="일 평균 매출액" readonly="true">원</li>

								<li><label for="월평균 매출액">월 평균매출액(1인)</label> <input
									type="number" name="incomeMon" value="<%=avgMonth%>"
									placeholder="월 평균 매출액" readonly="readonly">원</li>
								<li><label for="연평균 매출액">연 평균매출액(1인)</label> <input
									type="number" name="incomeMon" value="<%=avgYear %>" placeholder="연 평균 매출액"
									readonly="readonly">원</li>
							</ul>
							</form>

						</fieldset>
				

						<fieldset id="values2">
							<ul>
							<li><input type="text" id="datepicker5" placeholder="End: 년-월-일"
									style="text-align: center;" name="nal2" required="required">
									<input type="submit" value="호출하기"></li>
								<li><label for="오늘 티켓 매출 평균">오늘 티켓 매출</label> <input
									type="number" name="incomeDay" value="<%=toDayTicketSalse %>" placeholder="일 평균 매출액"
									readonly="readonly">원
								<li>
								<li><label for="오늘 매점 매출 평균">오늘 매점 매출</label> <input
									type="number" name="incomeMon" value="<%=toDayMarketSalse %>" placeholder="월 평균 매출액"
									readonly="readonly">원
								<li>
								<li><label for="1인 매출액">1인당 평균매출</label> <input
									type="number" name="incomeMon" value="<%=avgPeopleSalse %>" placeholder="연 평균 매출액"
									readonly="readonly">원
								<li>
							</ul>
							<%
								}
							%>
						</fieldset>
					</fieldset> --%>
				</div>
			</article>
		</section>
		<!-- ==================================아래 총 가격 출력창========================= -->
		<h10>날짜별 매출액</h10>
		<fieldset id="but">
		<%-- 	<table cellspacing="0" cellpadding="0" border="1" id="butin">
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
						<td>${board.ticketSales }</td>
						<td>${board.marketSalse }</td>
						<td>${board.totalSalse }</td>
						<td>${board.totalDiscount }</td>
						<td>${board.netIncome }</td>
					</tr>
				</c:forEach>
			</table> --%>
			<center>
				<jsp:include page="page.jsp" flush="true" />
			</center>
		</fieldset>
	<!-- =============================Tiket pie chart==================================== -->
		<section>
			<!-- display:table; -->
			<article id="pieall">
				<h4>판매 수익(%)</h4>
				<fieldset id="piefield1">
					<div id="pie">
						<div id="container"
							style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto; margin-top: 1%; margin-bottom: 1%; margin-left: 0.5%;">
							<hr>
							<script>
					Highcharts
							.chart('container',
									{
										chart : {
											plotBackgroundColor : null,
											plotBorderWidth : null,
											plotShadow : false,
											type : 'pie'
										},
										title : {
											text : '파트별 수익률(%)'
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
											name : 'Brands',
											colorByPoint : true,
											data : [ {
												name : '티켓',
												y : <%=toDayTicketSalse%>
											}, {
												name : '매점',
												y : <%=toDayMarketSalse%>,
												sliced : true,
												selected : true
											} ]
					} ]
			});
				</script>
							<hr>
						</div>
					</div>
					<!-- =============================Ticket pie chart END==================================== -->
					<!-- =============================Ticket line chart ===================================== -->
					<div id="lineT">
						<div id="containerlineT"
							style="min-width: 310px; height: 400px; margin: 0 auto; margin-top: 1%; margin-bottom: 1%; margin-right: 1%;"></div>
						<script>
				Highcharts.chart('containerlineT', {
			    chart: {
			        type: 'line'
			    },
			    title: {
			        text: '매출액 추이'
			    },
			    subtitle: {
			        text: ''
			    },
			    xAxis: {
			        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
			    },
			    yAxis: {
			        title: {
			            text: 'Temperature (°C)'
			        }
			    },
			    plotOptions: {
			        line: {
			            dataLabels: {
			                enabled: true
			            },
			            enableMouseTracking: false
			        }
			    },
			    series: [{
			        name: 'Tokyo',
			        data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
			    }, {
			        name: 'London',
			        data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
			    }]
			});
			
			</script>
					</div>
				</fieldset>

		<!-- ==================================아랫쪽=============================== -->

		<!-- Footer -->
		<!-- 		<footer class="w3-container w3-padding-16 w3-light-grey">
				<h4>FOOTER</h4>
				<p>
					Powered by <a href="https://www.w3schools.com/w3css/default.asp"
						target="_blank">w3.css</a>
				</p>
			</footer> -->

		<!-- End page content -->
	</div>





	<script>
			// Get the Sidebar
			var mySidebar = document.getElementById("mySidebar");

			// Get the DIV with overlay effect
			var overlayBg = document.getElementById("myOverlay");

			// Toggle between showing and hiding the sidebar, and add overlay effect
			function w3_open() {
				if (mySidebar.style.display === 'block') {
					mySidebar.style.display = 'none';
					overlayBg.style.display = "none";
				} else {
					mySidebar.style.display = 'block';
					overlayBg.style.display = "block";
				}
			}

			// Close the sidebar with the close button
			function w3_close() {
				mySidebar.style.display = "none";
				overlayBg.style.display = "none";
			}
		</script>
	<!-- ===================저장경고창 띄우기================== -->
	<script>
			function btn1(){
				function openNal(myform) {
				url="nalcheck.ticketcount?nal"+myform.nal.value;
				
				}
			}
  			  var save = confirm("저장하시겠습니까?")
  			  	if(save==true){
  			  		alert("저장되었습니다.")
  /* 			  		location.href="template.jsp?page=simulator" */
  			  	}else{
  			  		alert("취소되었습니다.")
  			  	
  			  
			}
		</script>
	<script>
			function btn2(){
  			  var save = confirm("저장하시겠습니까?")
  			  	if(save==true){
  			  		alert("저장되었습니다.")
  			  	}else{
  			  		alert("취소되었습니다.")
  			  	}
			}
		</script>
	<script>
			function btn3(){
  			  var save = confirm("저장하시겠습니까?")
  			  	if(save==true){
  			  		alert("저장되었습니다.")
  			  	}else{
  			  		alert("취소되었습니다.")
  			  	}
			}
		</script>

	<!-- =============날짜============== -->
	<script>
			$(function() {
  				$( "#datepicker1" ).datepicker({
    				dateFormat: 'yy-mm-dd'
 				 });
			});
		</script>
	<script>
			$(function() {
  				$( "#datepicker2" ).datepicker({
    				dateFormat: 'yy-mm-dd'
 				 });
			});
		</script>
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
	<script>
			$(function() {
  				$( "#datepicker5" ).datepicker({
    				dateFormat: 'yy-mm-dd'
 				 });
			});
	</script>

	<!-- ============================평균매출액 불러오기===================== -->
	<!-- 	<script>
		$(function () {
			var $btnAvg = $('.btnAvg');
			$btnAvg.click(function () {
				for(var i = 0; i <)
				
			})
		})
	
	
	</script> -->

</body>
</html>
