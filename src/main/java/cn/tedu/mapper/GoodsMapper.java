package cn.tedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.bean.Goods;

public interface GoodsMapper {
	
         /**根据分类id查询商品 
         * @param categoryId    分类id
         * @param orderBy        查询规则
         * @param offset            开始取的条数
         * @param count            要取商品信息的数量
         * @return                      商品 信息
         */
        public List<Goods> getGoodsByCategoryId(
							        		@Param("categoryId")  Integer categoryId,
							        		@Param("orderBy") String orderBy,
							        		@Param("offset") Integer offset,
							        		@Param("count") Integer count);
        
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
        public List<Goods> getGoodsByItemType(@Param("itemType")  String itemType);
}
