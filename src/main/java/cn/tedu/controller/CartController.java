package cn.tedu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.bean.Address;
import cn.tedu.bean.Cart;
import cn.tedu.bean.ResponseResult;
import cn.tedu.service.IAddressService;
import cn.tedu.service.ICartService;
import cn.tedu.service.ex.DataNotFandException;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {
	     @Resource(name="cartService")
         private ICartService cartService;
	     @Resource(name="addressService")
         private IAddressService addressService;
	     
	     @RequestMapping("/orderonfirm.do")
	     public String showCartConfirm(String cartId,ModelMap map,HttpSession session) {
	    	 Integer uid=this.getUserId(session);
	    	 List<Address> addrs=addressService.getAddressByUid(uid);
	    	 map.addAttribute("addrs", addrs);
	    	 System.out.println(addrs);
	    	 List<Cart> carts=cartService.getCartListById(cartId);
	    	 System.out.println(cartId);
	    	 map.addAttribute("carts", carts);
	    	 return "orderConfirm";
	     }
	     
	     @RequestMapping(value="/add.do",method=RequestMethod.POST)
	     @ResponseBody
	     public ResponseResult<Void> handle_add(Cart cart,HttpSession session){
	    	     Integer uid=this.getUserId(session);
	    	     Integer goodsId=cart.getGoodsId();
	    	     Integer goodsCount=cart.getGoodsCount();
	    	     Integer count=cartService.checkGoods(uid, goodsId);
	    	     System.out.println(count);
	    	     if(count==1) {
	    	    	 try {
						cartService.changeCount(uid, goodsCount, goodsId);
						return new ResponseResult<Void>(1,"��ӳɹ�");
					} catch (DataNotFandException e) {
						return new ResponseResult<Void>(0,e.getMessage());
					}
	    	     }else if(count==0) {
	    	    	    cart.setUid(uid);
	    	    	   cartService.insert(cart);
	    	    	   return new ResponseResult<Void>(1,"��ӳɹ�");
	    	     }
	    		 return new ResponseResult<Void>(0,"���ﳵ���ݳ���̫��");
	     }
	     
	     @RequestMapping("/list.do")
	     public String handleCartList(HttpSession session,ModelMap map) {
	    	     Integer uid=this.getUserId(session);
	    	     List<Cart> carts=cartService.getCartList(uid);
	    	     map.addAttribute("carts", carts) ;
	    	     return "cart_list";
	     }
	     
	     @RequestMapping(value="/change.do",method=RequestMethod.POST)
	     @ResponseBody
	     public ResponseResult<Void> changeCount(Integer goodsCount,Integer goodsId,HttpSession session){
	    	   Integer uid=this.getUserId(session);
	    	   System.out.print(goodsId+"="+goodsCount);
	    	   try {
				cartService.changeCount(uid, goodsCount, goodsId);
			} catch (DataNotFandException e) {
			    return new ResponseResult<Void>(0,e.getMessage());
			}
	    	   return new ResponseResult<Void>(1,"�����޸ĳɹ�");
	     }
}
