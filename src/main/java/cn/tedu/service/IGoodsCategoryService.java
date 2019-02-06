package cn.tedu.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.bean.GoodsCategory;

public interface IGoodsCategoryService {
	
	  /**���ݸ�������id������Ʒ��Ϣ��ֻ��ȡ����offse��ʼ��count������Ϣ
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<GoodsCategory> getGoodsCategoryListByParentId( Integer parentId, Integer offset, Integer count );
	
    /**������Ʒ��Ϣid��ѯ��Ʒ��Ϣ
     * @param id   ��Ʒ��Ϣid     
     * @return       ��Ʒ��Ϣ
     */
    public GoodsCategory getGoodsCategoryById(Integer id);
}
