package cn.tedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.bean.Cart;

public interface CartMapper {
	
      /**���û����ﳵ�����Ʒ��Ϣ
     * @param cart      ���ﳵ��¼��Ϣ
     * @return            ��Ӱ�������
     */
    public Integer insert(Cart cart);
    
    /**�����û�id����Ʒid��ѯ������Ʒ�Ƿ��Ѿ�����ӽ����ﳵ
     * @param uid                     �û�id
     * @param goodsId             ��Ʒid
     * @return                            ��Ʒ�Ѿ�����ӷ���1��û�÷���0
     */
    public Integer getRecordCount(@Param("uid") Integer uid, @Param("goodsId") Integer goodsId);
    
    /**�����û�id����Ʒid�����¹��ﳵ��Ʒ������
     * @param uid                       �û�id
     * @param goodsCount       ������Ʒ������
     * @param goodsId              ��Ʒid 
     * @return                             ��Ӱ�������
     */
    public Integer update(@Param("uid") Integer uid,@Param("goodsCount") Integer goodsCount,@Param("goodsId") Integer goodsId);
    
    /**�����û�id����ѯ���û����ﳵ����Ʒ��Ϣ
     * @param uid      �û�id
     * @return             ��Ʒ��Ϣ
     */ 
    public List<Cart> getCartList(Integer uid);
    
    /**���ݹ��ﳵ��¼id����ѯ��Ʒ��Ϣ
     * @param id             ���ﳵ��¼id,�����ж�����5��5��5��5
     * @return                 ��Ʒ��Ϣ
     */
    public List<Cart> getCartListById(List<String> id);
}
