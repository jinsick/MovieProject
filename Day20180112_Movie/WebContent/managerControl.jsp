<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #86858f/* #4CAF50 */;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #5f5e6f/* #45a049 */;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
  <form action="/action_page.php">
    <label for="영화제목">Title</label>
    <input type="text" id="fname" name="title" placeholder="Movie title..." required="required">
    
    <label for="감독">Director</label>
    <input type="text" id="fname" name="director" placeholder="Director..." required="required">
   
    <label for="배우">Actor</label>
    <input type="text" id="fname" name="actor" placeholder="Actor..." required="required">

    <label for="순위">Rank</label>
    <input type="text" id="lname" name="rank" placeholder="Movie Ranking.." required="required">
   
   <label for="평점">Review</label>
   <input type="text" name="review" placeholder="review" required="required">
   

    <label for="장르">Genre</label>
    <select id="genre" name="genre">
      <option value="action">액션</option>
      <option value="drama">드라마</option>
      <option value="comedy">코미디</option>
      <option value="noir">범죄/느와르</option>
      <option value="horror">공포</option>
      
    </select>
  
    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>