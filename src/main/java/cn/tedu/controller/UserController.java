package cn.tedu.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.bean.ResponseResult;
import cn.tedu.bean.User;
import cn.tedu.bean.uitl;
import cn.tedu.service.IUserService;
import cn.tedu.service.ex.PasswordErroeException;
import cn.tedu.service.ex.UserNotExistsException;
import cn.tedu.service.ex.UsernameAlreadyExistsExceptoion;

@RequestMapping("/user")
@Controller
public class UserController extends BaseController{
	        @Resource(name="userService")
             private IUserService userService;
	        @Value("#{dbConfig.salt}")
	        private String salt;
	        
	        @RequestMapping("/profile.do")
	        public String showProfile(ModelMap map,HttpSession session) {
	        	Integer id=this.getUserId(session);
	        	User user=userService.findUserById(id);
	        	map.addAttribute("user", user);
	        	return "profile";
	        }
	        @RequestMapping("/login.do")
	        public String showlogin() {
	        	return "login";
	        }
	        
	        @RequestMapping("/password.do")
	        public String showpassword() {
	        	return "password";
	        }
	        
	        @RequestMapping("/regists.do")
	        public String showregists() {
	        	return "regists";
	        }
	        
	        @RequestMapping("/checkUser.do")
	        @ResponseBody
	        public ResponseResult<Void> checkUser(User user){
	        	Integer count=userService.checkUser(user);
	        	if(count>0) {
	        		return new ResponseResult<Void>(1,"��ռ��");
	        	}else {
	        		return new ResponseResult<Void>(0,"����ʹ��");
	        	}
	        }
	        
	        @RequestMapping("/checkPassword.do")
	        @ResponseBody
	        public ResponseResult<Void> checkPassword(String oldPassword,HttpSession session){
	        	     Integer id=this.getUserId(session);
	        	    if(id==null) {
	        	    	return new ResponseResult<Void>(-1,"�û����������ȵ�¼");
	        	    }else {
	        	    	User u=userService.findUserById(id);
	        	    	if(u==null) {
	        	    		return new ResponseResult<Void>(-2,"�û�����������ϵ��");
	        	    	}else {
	        	    		
	        	    		if(u.getPassword().equals(DigestUtils.md5Hex(oldPassword+salt))) {
	        	    			return new ResponseResult<Void>(1,"������ȷ");
	        	    		}else {
	        	    			return new ResponseResult<Void>(-3,"�������");
	        	    		}
	        	    	}
	        	    }
	        	      
	        }
	        
	        @RequestMapping(value="/check_yzm.do",method=RequestMethod.POST)
	        @ResponseBody
	        public ResponseResult<Void> checkYzm(String code,HttpSession session){
	        	String  createCode=(String)session.getAttribute("yzm");
	        	System.out.println(createCode+"="+code);
	        	if(createCode==null) {
	        		 return new ResponseResult<Void>(0,"��֤����ڣ�������ˢ��");
	        	}
	        	
	        	if(createCode.equalsIgnoreCase(code)) {
	        		return new ResponseResult<Void>(1,"��֤����ȷ");
	        	}
	        	return new ResponseResult<Void>(0,"��֤�����");
	        }
	        @RequestMapping(value="/handle_reg.do",method=RequestMethod.POST)
	        @ResponseBody
	       public ResponseResult<Void> handlereg(User user){
	        	try {
	        		String pwd=DigestUtils.md5Hex(user.getPassword()+salt);
	        		System.out.println(salt);
	        		user.setPassword(pwd);
					userService.regists(user);
					return new ResponseResult<Void>(1);
				} catch (UsernameAlreadyExistsExceptoion e) {
					return new ResponseResult<Void>(0,"�û�����ռ��");
				}
	        }
	        
	        @RequestMapping(value="/handle_login.do",method=RequestMethod.POST)
	        @ResponseBody
	        public ResponseResult<Void> handlelogin(
	        		@RequestParam("username")  String uname,
	        		@RequestParam("password")  String upwd,
	        		@RequestParam("yzm") String yzm,
	        		HttpSession session){
	        	System.out.println("��¼��ʼ");
	        	ResponseResult<Void> rr=this.checkYzm(yzm, session);
	        	if(rr.getState()!=1) {
	        		return rr;
	        	}
	        	System.out.println(rr);
	        	  User u=userService.findUserByUsername(uname);
	        	  if(u==null) {
	        		  return new ResponseResult<Void>(0,"�û���������");
	        	  }else {
	        		  String pwd=DigestUtils.md5Hex(upwd+salt);
	        		  if(u.getPassword().equals(pwd)) {
	        			  System.out.println(session);
	        			  session.setAttribute("uid", u.getId());
	        			  session.setAttribute("username", u.getUsername());
	        			  
	        			  return new ResponseResult<Void>(1);
	        		  }else {
	        			  return new ResponseResult<Void>(0,"�������");
	        		  }
	        	  }
	        }
	        
	      @RequestMapping(value="/handlePassword.do",method=RequestMethod.POST)
	      @ResponseBody
         public  ResponseResult<Void> handlechangePassword(String oldPassword,String newPassword,HttpSession session){
	    	          //��ȡid
	    	         System.out.println("�޸�����");
        	          Integer id=this.getUserId(session);
        	          try {
        	        	  System.out.println(newPassword+oldPassword);
        	        	String pwd=DigestUtils.md5Hex(oldPassword+salt);
        	        	String newpwd=DigestUtils.md5Hex(newPassword+salt);
						userService.changePassword(id, newpwd, pwd);
						return new ResponseResult<Void>(1);
					} catch (UserNotExistsException e) {
						return new ResponseResult<Void>(0,e.getMessage());
					}catch (PasswordErroeException e) {
						return new ResponseResult<Void>(0,e.getMessage());
					}
         }
	      @RequestMapping("/handlelogout.do")
	      public String handlelogout(HttpSession session) {
	    	        session.invalidate();
	    	        return "redirect:../main/index.do";
	      }
	      
	      @RequestMapping(value="/handle_edit_profile.do",method=RequestMethod.POST)
	      @ResponseBody
	      public  ResponseResult<Void> handleEditProfile(String username, String phone, String email,Integer gender,HttpSession session){
	    	      boolean result=uitl.checkEmail(email)&&uitl.checkusername(username)&&uitl.checkPhone(phone);
	    	      System.out.println(email+"..."+phone+"..."+username+"..."+gender);
	    	      if(result) {
	    	    	  Integer id=this.getUserId(session);
		    	       System.out.println(username);
		    	       try {
						userService.editProfile(id, username, phone, email, gender);
						User u=userService.findUserById(id);
						session.setAttribute("username", u.getUsername());
						System.out.println("�޸�"+u);
						return new  ResponseResult<Void>(1,"�޸ĳɹ�");
					} catch (UserNotExistsException e) {
						return new  ResponseResult<Void>(-1,e.getMessage());
					} catch (UsernameAlreadyExistsExceptoion e) {
						return new  ResponseResult<Void>(-2,e.getMessage());
					}
	    	      }else {
	    	    	  return new  ResponseResult<Void>(-3,"�޸ĸ�ʽ����");
	    	      }
	      }
	      
	 	 @RequestMapping(value="png.do",produces="image/png")
		 @ResponseBody
		 public byte[] pngDemo(HttpSession session) throws IOException {			  
			     //������֤��
	 		    String code=createCode(4);
	 		    session.setAttribute("yzm", code);
	 		    //������֤��ͼƬ�ֽ���
	 		    byte[] imgByte=createImg(code);
	 		   
	 		   //����ͼƬ�ֽ�������
			     return imgByte;
		 }
		private byte[] createImg(String code) throws IOException {
			//����ͼƬ����
			BufferedImage bi=new BufferedImage(85,37,BufferedImage.TYPE_3BYTE_BGR);
			//����ͼƬ
			Graphics gr=bi.getGraphics();
			Random ran=new Random();
			gr.setColor(new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
			gr.fillRect(0, 0, 100, 40);
			gr.setColor(new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
			Font f=new Font(Font.SANS_SERIF, Font.ITALIC, 35);
			gr.setFont(f);
			gr.drawString(code, 5,30);
			//ʹ���ֽ������������ͼƬ����ת�����ֽ�����
			ByteArrayOutputStream bos=new ByteArrayOutputStream();
			ImageIO.write(bi, "png", bos);
			byte[] img=bos.toByteArray();
			return img;
		}
		private String createCode(int n) {
			String str="abcdefjhijklnmopqrstuvwxyz123456789";
			char[] code=new char[n];
			Random ran=new Random();
			for(int i=0;i<n;i++) {
				code[i]=str.charAt(ran.nextInt(str.length()));
			}	
			return new String(code);
		}
}
