package cn.tedu.mapper;

import cn.tedu.bean.Order;
import cn.tedu.bean.OrderItem;

public interface OrderMapper {
	
          /**��Ӷ���
         * @param order      ������Ϣ
         * @return                ��Ӱ������
         */
        public Integer insertOrder(Order order);
          
          /**���ݶ���id��Ӹö�����Ʒ 
         * @param orderItem       �����е���Ʒ��Ϣ
         * @return                         ��Ӱ������
         */
        public Integer insertOrderItem(OrderItem orderItem);
}
