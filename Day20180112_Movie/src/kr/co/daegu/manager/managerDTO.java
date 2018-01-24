package kr.co.daegu.manager;

public class managerDTO {
   private String id;
   private String pw;
   private String pwsh;
   private String lv;
   private String part;
   private String name;
   public managerDTO() {
      super();
   }
   public managerDTO(String id, String pw, String pwsh, String lv, String part, String name) {
      super();
      this.id = id;
      this.pw = pw;
      this.pwsh = pwsh;
      this.lv = lv;
      this.part = part;
      this.name = name;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPw() {
      return pw;
   }
   public void setPw(String pw) {
      this.pw = pw;
   }
   public String getPwsh() {
      return pwsh;
   }
   public void setPwsh(String pwsh) {
      this.pwsh = pwsh;
   }
   public String getLv() {
      return lv;
   }
   public void setLv(String lv) {
      this.lv = lv;
   }
   public String getPart() {
      return part;
   }
   public void setPart(String part) {
      this.part = part;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   @Override
   public String toString() {
      return "managerDTO [id=" + id + ", pw=" + pw + ", pwsh=" + pwsh + ", lv=" + lv + ", part=" + part + ", name="
            + name + "]";
   }

}