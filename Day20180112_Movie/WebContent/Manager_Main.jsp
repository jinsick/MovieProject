<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
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
					<div class="w3-right">
						<h3>티켓 판매수익.jstl</h3>
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
						<h3>마켓판매수익,jstl</h3>
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
						<h3>전체판매수익.jstl</h3>
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
									style="width: 25%; font-size: 27px;">+25%</div>
							</div>
						</div>
						<div class="w3-clear"></div>
						<div class="w3-left">
							<h4>Achievement rate</h4>
						</div>
					</div>
				</div>
			</div>
			<!-- =============================티켓 판매정보==================================== -->
			<br>
			<div class="w3-panel">
				<div class="w3-row-padding" style="margin: 0 -20px;">
					<div class="w3-threethird">
						<h5>티켓 판매정보</h5>
						<table class="w3-table w3-striped w3-white"
							style="text-align: center;">
							<tr>
								<td>순번</td>
								<td>날짜</td>
								<td>영화</td>
								<td>관</td>
								<td>기본가격</td>
								<td>할인</td>
								<td>판매액</td>
							</tr>
							<tr>
								<td>1</td>
								<td>10,000,000</td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
							</tr>
							<tr>
								<td>1</td>
								<td>10,000,000</td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
							</tr>
							<tr>
								<td>1</td>
								<td>10,000,000</td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
							</tr>
							<tr>
								<td>1</td>
								<td>10,000,000</td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
							</tr>
							<tr>
								<td>1</td>
								<td>10,000,000</td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
							</tr>
							<tr>
								<td>1</td>
								<td>10,000,000</td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
							</tr>
							<tr>
								<td>1</td>
								<td>10,000,000</td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
								<td><i>Rank1</i></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<hr>


			<hr>


			<div class="w3-container">
				<h5>Recent Users</h5>
				<ul class="w3-ul w3-card-4 w3-white">
					<li class="w3-padding-16">
						<span class="w3-xlarge">일 평균매출액</span><br></li>
					<li class="w3-padding-16">
						<span class="w3-xlarge">전일 대비 매출액</span><br></li>
					<li class="w3-padding-16">
						<span class="w3-xlarge">전월대비 매출액</span><br></li>
				</ul>
			</div>
			<hr>
			<!-- ==================================아랫쪽=============================== -->
			<br>
			<div class="w3-container w3-dark-grey w3-padding-32">
				<div class="w3-row">
					<div class="w3-container w3-third">
						<h5 class="w3-bottombar w3-border-green">Demographic</h5>
						<p>Language</p>
						<p>Country</p>
						<p>City</p>
					</div>
					<div class="w3-container w3-third">
						<h5 class="w3-bottombar w3-border-red">System</h5>
						<p>Browser</p>
						<p>OS</p>
						<p>More</p>
					</div>
					<div class="w3-container w3-third">
						<h5 class="w3-bottombar w3-border-orange">Target</h5>
						<p>Users</p>
						<p>Active</p>
						<p>Geo</p>
						<p>Interests</p>
					</div>
				</div>
			</div>

			<!-- Footer -->
			<footer class="w3-container w3-padding-16 w3-light-grey">
				<h4>FOOTER</h4>
				<p>
					Powered by <a href="https://www.w3schools.com/w3css/default.asp"
						target="_blank">w3.css</a>
				</p>
			</footer>

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
</body>
</html>
