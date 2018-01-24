<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


</head>
<body>

<title>Insert title here</title>
<style type="text/css">
ul {
   list-style: none;
   /* line-height: 67px; */
   font-size: 20px;
}

h1{
font-family: "Raleway", sans-serif;
   font-size: 20px;
   margin-left:1%;
   float: left;
   width: 59%;
}

h2{
font-family: "Raleway", sans-serif;
   font-size: 20px;
   margin-left:1%;
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
   padding: 0;
}

input[type=text], select {
   width: 50%;
   border: 1px solid #ccc;
   border-radius: 4px;
   box-sizing: border-box;
   resize: vertical;
   font-size: 20px;
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
   width: 150px;
}

fieldset#incomeM_all{
   width:100%;
   border-radius: 15px;
   background-color: hsl(0, 0%, 47%);
}
#pie{
   width: 40%; 
   /* border: 3px solid blue; */       
   float: right;
   z-index: 9999;
      }

fieldset#values1 {
   float: left;
   background-color: hsl(0, 0%, 94%);
   border-radius: 7px;
   width: 57%;
   /* margin-bottom: 0.5%; */
   z-index: 9999;
}

fieldset#but {
   background-color: hsl(0, 0%, 47%);
   border-radius: 7px;
   width: 98.5%;
   margin-bottom: 0.5%;
   height: 450px;
   /* border: 3px solid green; */
   z-index: 9999;
}

#pieSt{border-radius: 7px;}
</style>

</head>
<body>
<fieldset id="incomeM_All">
   <h1>구간별 매출액 분석</h1>
   <fieldset id="values1">
      <form action="#" method="post">                  
         <%-- <%
         if (session.getAttribute("tableList") == null) {
         %> --%>
         <ul>

            <li>
            <label for="날짜선택">날 짜</label> 
            <input type="text" id="datepicker1" placeholder="Start: 년-월-일" style=" text-align: center;" name="nal1" required="required" >
            ~ <input type="text" id="datepicker2" placeholder="End: 년-월-일" style=" text-align: center;" name="nal2" required="required" >
            <input type="submit" value="호출하기">
            </li>
                           
            <li>
            <label for="일평균 매출액">일 평균매출액(1인)</label> <input type="number" name="incomeDay" value="<%-- <%=avgDay%> --%>" placeholder="일 평균 매출액" readonly="true">원
            </li>
                           
            <li>
            <label for="월평균 매출액">월 평균매출액(1인)</label> <input type="number" name="incomeMon" value="" placeholder="월 평균 매출액" readonly="readonly">원
            </li>
                           
            <li>
            <label for="연평균 매출액">연 평균매출액(1인)</label> 
            <input type="number" name="incomeMon" value="" placeholder="연 평균 매출액" readonly="readonly">원
            </li>
         </ul>
      </form>

   </fieldset>


<div id="pie">
<fieldset id="pieSt">
<div id="container" style="height: 100%; width: 100%; margin: 0 auto;" ></div>
<script>
Highcharts.chart('container', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    },
    title: {
        text: 'Browser market shares January, 2015 to May, 2015'
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                }
            }
        }
    },
    series: [{
        name: 'Brands',
        colorByPoint: true,
        data: [{
            name: 'IE',
            y: 56.33
        }, {
            name: 'Chrome',
            y: 24.03,
            sliced: true,
            selected: true
        }, {
            name: 'Firefox',
            y: 10.38
        }, {
            name: 'Safari',
            y: 4.77
        }, {
            name: 'Opera',
            y: 0.91
        }, {
            name: 'Other',
            y: 0.2
        }]
    }]
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
  $( function() {
          $( "#datepicker1" ).datepicker();
  } );
  </script>
   
  <script>
  $( function() {
          $( "#datepicker2" ).datepicker();
  } );
  </script>
                  
                  
</body>
</html>