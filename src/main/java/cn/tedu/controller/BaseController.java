package cn.tedu.controller;

import javax.servlet.http.HttpSession;

public abstract class BaseController {
         /**从session中获取uid
         * @param session      
         * @return           
         */
        protected Integer getUserId(HttpSession session) {
        	         Object id=session.getAttribute("uid");
        	         if(id==null) {
        	        	 return null;
        	         }else {
        	        	 return Integer.valueOf(id.toString());
        	         }
         }
}
