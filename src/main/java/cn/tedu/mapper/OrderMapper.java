package cn.tedu.mapper;

import cn.tedu.bean.Order;
import cn.tedu.bean.OrderItem;

public interface OrderMapper {
	
          /**添加订单
         * @param order      订单信息
         * @return                受影响行数
         */
        public Integer insertOrder(Order order);
          
          /**根据订单id添加该订单商品 
         * @param orderItem       订单中的商品信息
         * @return                         受影响行数
         */
        public Integer insertOrderItem(OrderItem orderItem);
}
