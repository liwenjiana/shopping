package cn.tedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.bean.Goods;

public interface GoodsMapper {
	
         /**���ݷ���id��ѯ��Ʒ 
         * @param categoryId    ����id
         * @param orderBy        ��ѯ����
         * @param offset            ��ʼȡ������
         * @param count            Ҫȡ��Ʒ��Ϣ������
         * @return                      ��Ʒ ��Ϣ
         */
        public List<Goods> getGoodsByCategoryId(
							        		@Param("categoryId")  Integer categoryId,
							        		@Param("orderBy") String orderBy,
							        		@Param("offset") Integer offset,
							        		@Param("count") Integer count);
        
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
        public List<Goods> getGoodsByItemType(@Param("itemType")  String itemType);
}
