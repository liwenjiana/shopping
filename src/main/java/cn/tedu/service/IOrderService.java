package cn.tedu.service;

import cn.tedu.bean.Order;
import cn.tedu.bean.OrderItem;

public interface IOrderService {
	
	  /**添加订单
	 * @param order           订单信息
	 * @param orderItem   订单相关的商品信息
	 */
	public  void createOrder(Order order,OrderItem orderItem);
}
