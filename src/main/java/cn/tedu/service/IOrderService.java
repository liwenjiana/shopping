package cn.tedu.service;

import cn.tedu.bean.Order;
import cn.tedu.bean.OrderItem;

public interface IOrderService {
	
	  /**��Ӷ���
	 * @param order           ������Ϣ
	 * @param orderItem   ������ص���Ʒ��Ϣ
	 */
	public  void createOrder(Order order,OrderItem orderItem);
}
