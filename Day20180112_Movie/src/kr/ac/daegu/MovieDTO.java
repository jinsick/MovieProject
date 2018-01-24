package kr.ac.daegu;

public class MovieDTO {
   private int no;
   private String picture;
   private String title;
   private String rank;
   private String kind;
   private String time;
   private String grade;
   private String director;
   private String actor;
   private String side1;
   private String side2;
   private String side3;

   public MovieDTO() {
      super();
      // TODO Auto-generated constructor stub
   }

   





   public MovieDTO(int no, String picture, String title, String rank, String kind, String time, String grade,
         String director, String actor, String side1, String side2, String side3) {
      super();
      this.no = no;
      this.picture = picture;
      this.title = title;
      this.rank = rank;
      this.kind = kind;
      this.time = time;
      this.grade = grade;
      this.director = director;
      this.actor = actor;
      this.side1 = side1;
      this.side2 = side2;
      this.side3 = side3;
   }







   public int getNo() {
      return no;
   }



   public void setNo(int no) {
      this.no = no;
   }



   public String getPicture() {
      return picture;
   }







   public void setPicture(String picture) {
      this.picture = picture;
   }







   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getRank() {
      return rank;
   }

   public void setRank(String rank) {
      this.rank = rank;
   }

   public String getKind() {
      return kind;
   }

   public void setKind(String kind) {
      this.kind = kind;
   }

   public String getTime() {
      return time;
   }

   public void setTime(String time) {
      this.time = time;
   }

   public String getGrade() {
      return grade;
   }

   public void setGrade(String grade) {
      this.grade = grade;
   }

   public String getDirector() {
      return director;
   }

   public void setDirector(String director) {
      this.director = director;
   }

   public String getActor() {
      return actor;
   }

   public void setActor(String actor) {
      this.actor = actor;
   }

   public String getSide1() {
      return side1;
   }

   public void setSide1(String side1) {
      this.side1 = side1;
   }

   public String getSide2() {
      return side2;
   }

   public void setSide2(String side2) {
      this.side2 = side2;
   }

   public String getSide3() {
      return side3;
   }

   public void setSide3(String side3) {
      this.side3 = side3;
   }







   @Override
   public String toString() {
      return "MovieDTO [no=" + no + ", picture=" + picture + ", title=" + title + ", rank=" + rank + ", kind=" + kind
            + ", time=" + time + ", grade=" + grade + ", director=" + director + ", actor=" + actor + ", side1="
            + side1 + ", side2=" + side2 + ", side3=" + side3 + "]";
   }



   



}