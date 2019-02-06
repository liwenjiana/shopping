package cn.tedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.bean.GoodsCategory;

public interface GoodsCategoryMapper {
	
         /**���ݸ�������id������Ʒ��Ϣ��ֻ��ȡ����offse��ʼ��count������Ϣ
         * @param parentId   ��������id
         * @param offset        
         * @param count
         * @return
         */
        public List<GoodsCategory> getGoodsCategoryListByParentId(
										        		@Param("parentId")  Integer parentId,
										        		@Param("offset") Integer offset,
										        		@Param("count")  Integer count );
        /**������Ʒ��Ϣid��ѯ��Ʒ��Ϣ
         * @param id   ��Ʒ��Ϣid     
         * @return       ��Ʒ��Ϣ
         */
        public GoodsCategory getGoodsCategoryById(Integer id);
        	 
}
