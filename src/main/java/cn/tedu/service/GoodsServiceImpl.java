package cn.tedu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.bean.Goods;
import cn.tedu.mapper.GoodsMapper;
import cn.tedu.service.ex.GoodsNotFandException;
@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService{
	
    @Resource(name="goodsMapper")
	private  GoodsMapper  goodsMapper;
    
    private Integer countPerPage=COUNT_PER_PAGE;
    
	public Integer getCountPerPage() {
		return this.countPerPage;
	}
    
    public void setCountPerPage(Integer count) {
    	   if(5<count&&count<30) {
    		   this.countPerPage=count;
    	   }
   }
    
	public List<Goods> getGoodsByCategoryId(Integer categoryId, String orderBy, Integer offset, Integer count) {
		return  goodsMapper.getGoodsByCategoryId(categoryId, orderBy, offset, count);
	}
	public List<Goods> getGoodsByCategoryId(Integer categoryId, String orderBy, Integer page) {
		Integer offset=(page-1)*countPerPage;
		return getGoodsByCategoryId(categoryId, orderBy, offset, countPerPage);
	}
	public List<Goods> getGoodsByCategoryId(Integer categoryId, Integer page) {
		return getGoodsByCategoryId(categoryId, ORDER_BY_PRIORITY,page);
	}
	public List<Goods> getGoodsByCategoryId(String orderBy, Integer categoryId) {
		
		return getGoodsByCategoryId(categoryId, orderBy, 1);
	}
	public List<Goods> getGoodsByCategoryId(Integer categoryId) {
		return getGoodsByCategoryId( ORDER_BY_PRIORITY,categoryId);
	}

	public Integer getGoodsCountBycategoryId(Integer categoryId) {
		
		return goodsMapper.getGoodsCountBycategoryId(categoryId);
	}

	public Goods getGoodsById(Integer id) {
		return  goodsMapper.getGoodsById(id);  
	}

	public List<Goods> getGoodsByItemType(String itemType) {
		
		return goodsMapper.getGoodsByItemType(itemType);
	}

 
}
