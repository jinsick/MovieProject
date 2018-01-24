<%@page import="kr.ac.daegu.MovieDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
   ArrayList<MovieDTO> movieList = (ArrayList) request.getAttribute("movieList");
   MovieDTO mdto = new MovieDTO();
%>
<!DOCTYPE html>
<html>
<style>
#regist input[type=text], select {
   width: 100%;
   padding: 12px 20px;
   margin: 8px 0;
   display: inline-block;
   border: 1px solid #ccc;
   border-radius: 4px;
   box-sizing: border-box;
}

#regist input[type=submit] {
   width: 100%;
   background-color: #86858f /* #4CAF50 */;
   color: white;
   padding: 14px 20px;
   margin: 8px 0;
   border: none;
   border-radius: 4px;
   cursor: pointer;
}

#regist input[type=submit]:hover {
   background-color: #5f5e6f /* #45a049 */;
}

.regist {
   border-radius: 5px;
   background-color: #f2f2f2;
   padding: 20px;
   width: 100%;
   height: 100%;
   border: 1px red solid;
}
</style>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
   href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html, body, h1, h2, h3, h4 {
   font-family: "Lato", sans-serif
}

.mySlides {
   display: none;
   position: relative;
   left: 50%;
   margin-left: -200px;
   width: 50%;
   border: 1px solid green;
   height: 100%;
}

.w3-tag, .fa {
   cursor: pointer;
}

.w3-tag {
   height: 15px;
   width: 15px;
   padding: 0;
   margin-top: 6px;
}

.w3 {
   position: relative;
}

#w4 {
   width: 100%;
}

#bar {
   width: 60%;
   margin-left: 20%;
}

#main {
   margin-top: 0%;
   height: 50%;
   border: solid 5px blue;
}

h1 {
   text-align: center;
   font-variant: small-caps;
}
</style>
<body>
   <h1>I know movie -Manager Control v0.01-</h1>
   <div id=main>
      <!-- Content -->
      <!-- ==============================영화 메인===================== -->
      <div id="movie">

         <%
            for (int i = 0; i < movieList.size(); i++) {

               if (i < movieList.size()) {
                  mdto = movieList.get(i);
         %>
         <div class="w3-display-container mySlides">
            <table>
               <tr>
                  <td>
                     <div>
                        <img src="images/<%=mdto.getPicture()%>">
                     </div>
                  </td>
                  <td>
                     <div class="regist">
                        <form action="SM_MovieRegist.mo" method="post">
                           <input type="hidden" name="no" value="0">
                           <table>
                              <tr>
                                 <td><label for="영화제목">Title</label> <input type="text"
                                    id="fname" name="title" placeholder="Movie title..."
                                    required="required" value="<%=mdto.getTitle()%>"></td>
                              </tr>
                              <tr>
                                 <td><label for="감독">Director</label> <input type="text"
                                    id="fname" name="director" placeholder="Director..."
                                    required="required" value="<%=mdto.getDirector()%>"></td>
                              </tr>
                              <tr>
                                 <td><label for="배우">Actor</label> <input type="text"
                                    id="fname" name="actor" placeholder="Actor..."
                                    required="required" value="<%=mdto.getActor()%>"></td>
                              </tr>
                              <tr>
                                 <td><label for="순위">Rank</label> <input type="text"
                                    id="lname" name="rank" placeholder="Movie Ranking.."
                                    required="required" value="<%=mdto.getRank()%>"></td>
                              </tr>
                              <tr>
                                 <td><label for="평점">Review</label> <input type="text"
                                    name="review" placeholder="review" required="required"
                                    value="<%=mdto.getGrade()%>"></td>
                              </tr>
                              <tr>
                                 <td><label for="장르">Genre</label></td>
                              </tr>
                              <tr>
                                 <td><select id="genre" name="genre"
                                    value="<%=mdto.getKind()%>">
                                       <option value="action">액션</option>
                                       <option value="drama">드라마</option>
                                       <option value="comedy">코미디</option>
                                       <option value="noir">범죄/느와르</option>
                                       <option value="horror">공포</option>

                                 </select></td>
                              </tr>
                              <tr>
                                 <td><input type="submit" value="Submit"></td>
                              </tr>

                           </table>
                        </form>
                     </div>
                  </td>
               </tr>

            </table>
         </div>
         <%
            }
            }
         %>

         <div class="w3-display-container mySlides">
            <div class="regist">
               <form action="SM_MovieRegist.mo" method="post"
                  enctype="multipart/form-data">
                  <input type="file" name="theFile"> <label for="영화제목">Title</label>
                  <input type="text" id="fname" name="title"
                     placeholder="Movie title..." required="required"> <label
                     for="감독">Director</label> <input type="text" id="fname"
                     name="director" placeholder="Director..." required="required">

                  <label for="배우">Actor</label> <input type="text" id="fname"
                     name="actor" placeholder="Actor..." required="required">

                  <label for="순위">Rank</label> <input type="text" id="lname"
                     name="rank" placeholder="Movie Ranking.." required="required">

                  <label for="평점">Review</label> <input type="text" name="review"
                     placeholder="review" required="required"> <label for="장르">Genre</label>
                  <select id="genre" name="genre">
                     <option value="action">액션</option>
                     <option value="drama">드라마</option>
                     <option value="comedy">코미디</option>
                     <option value="noir">범죄/느와르</option>
                     <option value="horror">공포</option>

                  </select> <input type="submit" value="Submit">
               </form>
            </div>
         </div>
      </div>

      <!-- ==================================블루베리 바 ====================== -->
      <!-- Slideshow next/previous buttons -->
      <div id="bar">
         <div class="w3-container w3-dark-grey w3-padding w3-xlarge">
            <div class="w3-left" onclick="plusDivs(-1)">
               <i class="fa fa-arrow-circle-left w3-hover-text-teal"></i>
            </div>
            <div class="w3-right" onclick="plusDivs(1)">
               <i class="fa fa-arrow-circle-right w3-hover-text-teal"></i>
            </div>

            <div class="w3-center">
               <span
                  class="w3-tag demodots w3-border w3-transparent w3-hover-white"
                  onclick="currentDiv(1)"></span> <span
                  class="w3-tag demodots w3-border w3-transparent w3-hover-white"
                  onclick="currentDiv(2)"></span> <span
                  class="w3-tag demodots w3-border w3-transparent w3-hover-white"
                  onclick="currentDiv(3)"></span>
            </div>
         </div>
      </div>


      <div id="w4">
         <!-- Grid -->

         <div class="w3-col l3 m6 w3-light-grey w3-container w3-padding-16">
            <h3>Design</h3>
            <p>Phasellus eget enim eu lectus faucibus vestibulum.
               Suspendisse sodales pellentesque elementum.</p>
         </div>

         <div class="w3-col l3 m6 w3-grey w3-container w3-padding-16">
            <h3>Branding</h3>
            <p>Phasellus eget enim eu lectus faucibus vestibulum.
               Suspendisse sodales pellentesque elementum.</p>
         </div>

         <div class="w3-col l3 m6 w3-dark-grey w3-container w3-padding-16">
            <h3>Consultation</h3>
            <p>Phasellus eget enim eu lectus faucibus vestibulum.
               Suspendisse sodales pellentesque elementum.</p>
         </div>

         <div class="w3-col l3 m6 w3-black w3-container w3-padding-16">
            <h3>Promises</h3>
            <p>Phasellus eget enim eu lectus faucibus vestibulum.
               Suspendisse sodales pellentesque elementum.</p>
         </div>
      </div>
   </div>





   <script>
      // Slideshow
      var slideIndex = 1;
      showDivs(slideIndex);

      function plusDivs(n) {
         showDivs(slideIndex += n);
      }

      function currentDiv(n) {
         showDivs(slideIndex = n);
      }

      function showDivs(n) {
         var i;
         var x = document.getElementsByClassName("mySlides");
         var dots = document.getElementsByClassName("demodots");
         if (n > x.length) {
            slideIndex = 1
         }
         if (n < 1) {
            slideIndex = x.length
         }
         ;
         for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
         }
         for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" w3-white", "");
         }
         x[slideIndex - 1].style.display = "block";
         dots[slideIndex - 1].className += " w3-white";
      }
   </script>

</body>
</html>