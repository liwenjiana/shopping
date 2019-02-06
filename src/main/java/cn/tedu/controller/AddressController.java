package cn.tedu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.bean.Address;
import cn.tedu.bean.ResponseResult;
import cn.tedu.service.IAddressService;
import cn.tedu.service.ex.DataNotFandException;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController{
	
	       @Resource(name="addressService")
           private IAddressService addressService;
	       
	       /**第二次做的地址栏列表请求
	     * @param session
	     * @return
	     */
	    @RequestMapping("/list2.do")
		   public String showList2() {
		    	    return "address_list2";
		       }
	       
	       @RequestMapping("/list.do")
	      public String showList(HttpSession session) {
	    	  
	    	   Integer uid=this.getUserId(session);
	    	   List<Address> list=addressService.getAddressByUid(uid);
	    	   session.setAttribute("list", list);
	    	    return "address_list";
	       }
          
	       /**处理添加收货地址请求
	     * @param addr           收货地址信息
	     * @param session       sesssion(用来获取用户id)
	     * @return                    ResponseBody
	     */
	     @RequestMapping(value="/add.do",method=RequestMethod.POST)
	     @ResponseBody
	      public ResponseResult<Void> handleAdd(Address addr,HttpSession session){
	    	    Integer uid=this.getUserId(session);
	    	    addr.setUid(uid);
	    	    System.out.println(addr);
	    	    addressService.add(addr);
	    	   
	    	    return new ResponseResult<Void>(1,"收货地址添加成功");
	      }
	     
	     @RequestMapping(value="/update.do",method=RequestMethod.POST)
	     @ResponseBody
	       public ResponseResult<Void> handleUpdateAddress(Address addr,HttpSession session){
	    	   Integer uid=this.getUserId(session);
	    	   addr.setUid(uid);
	    	   System.out.println(addr.getId());
	    	  Integer count= addressService.update(addr);
	    	  if(count==1) {
	    		  return new ResponseResult<Void>(1,"修改成功");
	    	  }else {
	    		  return new ResponseResult<Void>(-1,"修改失败，请你先登录");
	    	  }
	       }
	       /**处理获取某用户的收货地址请求
	     * @param uid        用户id
	     * @return               ResponseBody 
	     */
	       @RequestMapping(value="/get_list.do",method=RequestMethod.GET)
	       @ResponseBody
	       public ResponseResult<List<Address>>  handleList(HttpSession session){
	    	   Integer uid=this.getUserId(session);
	    	   List<Address> list= addressService.getAddressByUid(uid);
	    	   System.out.println(list);
	    	    return new  ResponseResult<List<Address>>(1,list);
	       }
	       
	       /**根据id和uid获取收货地址
	     * @param id
	     * @param session
	     * @return
	     */
	      @RequestMapping(value="/get.do",method=RequestMethod.GET)
	      @ResponseBody
	       public  ResponseResult<Address> getAddressByUidAndId(Integer id, HttpSession session) {
	    	   Integer uid=this.getUserId(session);
	    	  Address addr= addressService.getAddressByUidAndId(id, uid);
	    	  return  new ResponseResult<Address>(1,addr);
	       }
	    
	    /**根据收货地址删除收货地址  （不安全）
	     * @param id
	     * @return
	     */
	    @RequestMapping(value="/delAddress.do",method=RequestMethod.GET)
	    public String handleDelect(Integer id) {
	    	addressService.delete(id);
	    	System.out.println(id);
	    	return "redirect:list.do";
	    }
       
	    /**根据id和uid删除收货地址
	     * @param id            
	     * @param session 
	     * @return
	     */
	   @RequestMapping(value="/delAddress2.do",method=RequestMethod.GET)
	   
	    public String handleDelect2(Integer id,HttpSession session){
	    	  Integer uid=this.getUserId(session);
	    	  addressService.delete2(id, uid);
	   	      return "redirect:list.do";
	    }
	    /**处理设置默认收货地址
	     * @param id
	     * @param session
	     * @return
	     */
	    @RequestMapping(value="/setDefualt.do",method=RequestMethod.GET)
	    public String  handleSetDefault(Integer id,HttpSession session){
	    	System.out.println(id);
	    	Integer uid=this.getUserId(session);
	    	try {
				addressService.setNotDefault(uid, id);
			} catch (DataNotFandException e) {
			       System.out.println(e.getMessage()+"   链接请求，没有用ajax");
			}
	        return "redirect:list.do";
	    }
	    @RequestMapping(value="/setDefualt2.do",method=RequestMethod.GET)
	    @ResponseBody
	    public  ResponseResult<Address>  SetDefault(Integer id,HttpSession session){
	    	System.out.println(id);
	    	Integer uid=this.getUserId(session);
	    	try {
				addressService.setNotDefault(uid, id);
				return new ResponseResult<Address>(1,"设置默认成功");
			} catch (DataNotFandException e) {
				return new ResponseResult<Address>(0,"设置默认失败");
			}
	    }
}
