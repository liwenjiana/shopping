package cn.tedu.bean;

public class uitl {
         public static boolean checkpassword(String password) {
        	 return password.length()<7;
         }
         public static boolean checkusername(String username) {
        	 return username.length()<7;
         }
         public static boolean checkPhone(String phone) {
        	 return phone.length()==11;
         }
         public static boolean checkEmail(String email) {
        	 return email.length()<7;
         }
}
