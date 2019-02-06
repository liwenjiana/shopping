package cn.tedu.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.bean.Goods;

public interface IGoodsService {
	   
	  Integer COUNT_PER_PAGE=20;
	  String ORDER_BY_PRIORITY="priority";
	  String ORDER_BY_PRICE="price";
	  String ORDER_BY_PRICE_DESC="price desc";
	  String ORDER_BY_PRIORITY_DESC="priority desc";
	  String[] ORDER_BY= {ORDER_BY_PRIORITY,ORDER_BY_PRICE,ORDER_BY_PRICE_DESC,ORDER_BY_PRIORITY_DESC};
	  
	  public void setCountPerPage(Integer count);
	  Integer getCountPerPage();
	
	  /**���ݷ���id��ѯ��Ʒ 
     * @param categoryId    ����id
     * @param orderBy        ��ѯ����
     * @param offset            ��ʼȡ����Ʒ��Ϣ����
     * @param count            Ҫȡ��Ʒ��Ϣ������
     * @return                      ��Ʒ ��Ϣ
     */
    public List<Goods> getGoodsByCategoryId(
						        		@Param("categoryId")  Integer categoryId,
						        		@Param("orderBy") String orderBy,
						        		@Param("offset") Integer offset,
						        		@Param("count") Integer count);
    
    
    /**���ݷ���id��ѯ��Ʒ 
     * @param categoryId    ����id
     * @param orderBy        ��ѯ����
     * @param page            ��Ҫ������Ʒ��Ϣ��λ�ã�ҳ���� 
     * @return                      ��Ʒ ��Ϣ
     */
    public List<Goods> getGoodsByCategoryId(
    		@Param("categoryId")  Integer categoryId,
    		@Param("orderBy") String orderBy,
    		@Param("categoryId")  Integer page);
    
    /**���ݷ���id��ѯ��Ʒ 
     * @param categoryId       ����id
     * @param page                ��Ҫ������Ʒ��Ϣ��λ�ã�ҳ����      
     * @return                          ��Ʒ ��Ϣ
     */
    public List<Goods> getGoodsByCategoryId(
    		@Param("categoryId")  Integer categoryId,
    		@Param("categoryId")  Integer page);
    /**���ݷ���id��ѯ��Ʒ
     * @param orderBy         ��ѯ����
     * @param categoryId    ����id
     * @return                      ��Ʒ ��Ϣ
     */
    
    public List<Goods> getGoodsByCategoryId(
    		@Param("orderBy") String orderBy,
    		@Param("categoryId")  Integer categoryId);
    
    /**���ݷ���id��ѯ��Ʒ
     * @param categoryId       ����id
     * @return                          ��Ʒ ��Ϣ
     */
    public List<Goods> getGoodsByCategoryId(
    		@Param("categoryId")  Integer categoryId);
    
    /**���ݷ���id��ѯ��Ʒ����
     * @param categoryId       ����id
     * @return
     */
    public Integer getGoodsCountBycategoryId(@Param("categoryId")  Integer categoryId);
    
    /**������Ʒid��ѯ��Ʒ��Ϣ
     * @param id     ��Ʒid
     * @return         ��Ʒ��Ϣ   
     */
    public Goods getGoodsById(Integer id);
    
    /**������Ʒ����ѯ��Ʒ��Ϣ
     * @param itemType ��Ʒ���
     * @return                  ��Ʒ��Ϣ
     */
    public List<Goods> getGoodsByItemType(String itemType);
    
    
}
