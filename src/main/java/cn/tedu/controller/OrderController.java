package cn.tedu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.bean.Address;
import cn.tedu.bean.Order;
import cn.tedu.bean.OrderItem;
import cn.tedu.bean.ResponseResult;
import cn.tedu.service.IAddressService;
import cn.tedu.service.IOrderService;

@Controller
@RequestMapping(value="/order")
public class OrderController extends BaseController{
	    @Resource(name="orderService")
        private IOrderService orderService;
	    @Resource(name="addressService")
	    private IAddressService addressService;
	    
	    @RequestMapping(value="/createOrder.do",method=RequestMethod.POST)
	    @ResponseBody
	    public ResponseResult<Void>  createOrder(OrderItem orderItem,HttpSession session){
	    	    Integer uid=this.getUserId(session);
	    	    Address addr=addressService.getDefaultAddress(uid);
	    	    if(addr==null) {	
	    	   return new ResponseResult<Void>(0,"请添加默认收货地址");
	    	    }
	    	    Order order=getOrder(addr,uid);
	    	    try {
					orderService.createOrder(order, orderItem);
				} catch (RuntimeException e) {
					return new ResponseResult<Void>(0,"订单失效，请重新下单");
				}
	    	    return new ResponseResult<Void>(1,"下单完成");
	    }

		private Order getOrder( Address addr ,Integer uid) {
			
    	    Order order=new Order();
    	    order.setUid(uid);
    	    order.setRecv_name(addr.getRecvName());
    	    order.setRecv_addr(addr.getRecvAddr());
    	    order.setRecv_district(addr.getRecvDistrict());
    	    order.setRecv_phone(addr.getRecvPhone());
    	    order.setRecv_tel(addr.getRecvTel());
    	    order.setRecv_zip(addr.getRecvZip());
    	    order.setStatus(0);
			return order;
		}
	    
}
