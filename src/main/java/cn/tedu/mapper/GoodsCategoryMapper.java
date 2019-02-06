package cn.tedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.bean.GoodsCategory;

public interface GoodsCategoryMapper {
	
         /**根据父级分类id查找商品信息，只查取出从offse开始的count个的信息
         * @param parentId   父级分类id
         * @param offset        
         * @param count
         * @return
         */
        public List<GoodsCategory> getGoodsCategoryListByParentId(
										        		@Param("parentId")  Integer parentId,
										        		@Param("offset") Integer offset,
										        		@Param("count")  Integer count );
        /**根据商品信息id查询商品信息
         * @param id   商品信息id     
         * @return       商品信息
         */
        public GoodsCategory getGoodsCategoryById(Integer id);
        	 
}
