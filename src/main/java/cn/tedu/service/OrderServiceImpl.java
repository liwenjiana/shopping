package cn.tedu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.bean.Order;
import cn.tedu.bean.OrderItem;
import cn.tedu.mapper.OrderMapper;

@Service("orderService")
public class OrderServiceImpl implements IOrderService{
	
	       @Resource(name="orderMapper")
           private OrderMapper orderMapper;
	        
	       @Transactional
	        public  void createOrder(Order order,OrderItem orderItem) {
	    	          System.out.println(order);
	    	          System.out.println(orderItem);
	        	       Integer  count=orderMapper.insertOrder(order);
	        	       if(count==0) 
	        	      throw new RuntimeException("订单失效，请重新下单");
	        	       Integer id=order.getId();
	        	       orderItem.setOrder_id(id);
	        	      count=orderMapper.insertOrderItem(orderItem);
	        	      if(count==0)
	        	       throw new RuntimeException("订单失效，请重新下单");
	        }
	        
}
