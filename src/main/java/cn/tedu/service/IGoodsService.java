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
	
	  /**根据分类id查询商品 
     * @param categoryId    分类id
     * @param orderBy        查询规则
     * @param offset            开始取的商品信息行数
     * @param count            要取商品信息的数量
     * @return                      商品 信息
     */
    public List<Goods> getGoodsByCategoryId(
						        		@Param("categoryId")  Integer categoryId,
						        		@Param("orderBy") String orderBy,
						        		@Param("offset") Integer offset,
						        		@Param("count") Integer count);
    
    
    /**根据分类id查询商品 
     * @param categoryId    分类id
     * @param orderBy        查询规则
     * @param page            需要具体商品信息的位置（页数） 
     * @return                      商品 信息
     */
    public List<Goods> getGoodsByCategoryId(
    		@Param("categoryId")  Integer categoryId,
    		@Param("orderBy") String orderBy,
    		@Param("categoryId")  Integer page);
    
    /**根据分类id查询商品 
     * @param categoryId       分类id
     * @param page                需要具体商品信息的位置（页数）      
     * @return                          商品 信息
     */
    public List<Goods> getGoodsByCategoryId(
    		@Param("categoryId")  Integer categoryId,
    		@Param("categoryId")  Integer page);
    /**根据分类id查询商品
     * @param orderBy         查询规则
     * @param categoryId    分类id
     * @return                      商品 信息
     */
    
    public List<Goods> getGoodsByCategoryId(
    		@Param("orderBy") String orderBy,
    		@Param("categoryId")  Integer categoryId);
    
    /**根据分类id查询商品
     * @param categoryId       分类id
     * @return                          商品 信息
     */
    public List<Goods> getGoodsByCategoryId(
    		@Param("categoryId")  Integer categoryId);
    
    /**根据分类id查询商品数量
     * @param categoryId       分类id
     * @return
     */
    public Integer getGoodsCountBycategoryId(@Param("categoryId")  Integer categoryId);
    
    /**根据商品id查询商品信息
     * @param id     商品id
     * @return         商品信息   
     */
    public Goods getGoodsById(Integer id);
    
    /**根据商品规格查询商品信息
     * @param itemType 商品规格
     * @return                  商品信息
     */
    public List<Goods> getGoodsByItemType(String itemType);
    
    
}
