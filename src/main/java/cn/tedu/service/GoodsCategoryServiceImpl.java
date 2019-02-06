package cn.tedu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.bean.GoodsCategory;
import cn.tedu.mapper.GoodsCategoryMapper;
@Service("goodsCategoryService")
public class GoodsCategoryServiceImpl implements IGoodsCategoryService{
    
	@Resource(name="goodsCategoryMapper")
	private  GoodsCategoryMapper goodsCategoryMapper;
	
	//���ݸ��������ȡ��Ʒ��Ϣ
	public List<GoodsCategory> getGoodsCategoryListByParentId(Integer parentId, Integer offset, Integer count) {
		return goodsCategoryMapper.getGoodsCategoryListByParentId(parentId, offset, count);
	}

	//������Ʒid��ѯ��Ʒ��Ϣ
	public GoodsCategory getGoodsCategoryById(Integer id) {
		return goodsCategoryMapper.getGoodsCategoryById(id);
	}

}
