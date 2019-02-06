package cn.tedu.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tedu.bean.Goods;
import cn.tedu.bean.GoodsCategory;
import cn.tedu.service.IGoodsCategoryService;
import cn.tedu.service.IGoodsService;
import cn.tedu.service.ex.GoodsNotFandException;

@Controller
@RequestMapping("/goods")
public class GoodsContrller extends BaseController{
	
	    @Resource(name="goodsService")
        private IGoodsService goodsService;
	    @Resource(name="goodsCategoryService")
		private  IGoodsCategoryService goodsCategoryService;
	    
	    @RequestMapping("/list.do")
	    public String handleGoodsList(
	    		               @RequestParam("category_id") Integer categoryId, 
	    		               @RequestParam("order_by")Integer orderBy,
	    		               @RequestParam("page")Integer page,
	    		               ModelMap map) {
	    	Integer count=goodsService.getGoodsCountBycategoryId(categoryId);
	    	String name=goodsCategoryService.getGoodsCategoryById(categoryId).getName();
	    	map.addAttribute("categoryName", name);
	    	System.out.println(count);
	    	Integer pageNum=count/goodsService.getCountPerPage();
	    	goodsService.setCountPerPage(20);
	    	pageNum+=count%goodsService.getCountPerPage()==0?0:1;
	    	map.addAttribute("count", count);
	    	map.addAttribute("categoryId", categoryId);
	    	map.addAttribute("pageNum", pageNum);
	    	map.addAttribute("currentPage", page);
	    	String orderStr;
	    	System.out.println(categoryId);
	    	if(categoryId==null||categoryId<1) {
	    		map.addAttribute("message", "输入商品分类有误，请重新输入");
	    		return "error";
	    	}
	    	if(orderBy==null||orderBy<0||orderBy>IGoodsService.ORDER_BY.length) {
	    	     orderStr=IGoodsService.ORDER_BY[0];
	    	}
	    	orderStr=IGoodsService.ORDER_BY[orderBy];
	    	if(page==null||page<1||page>pageNum) {
	    		   page=1;
	    		   map.addAttribute("currentPage", page);
	    	}
	    	List<Goods> list=goodsService.getGoodsByCategoryId(categoryId, orderStr, page);
	    	System.out.println(categoryId);
	    	map.addAttribute("goods", list);
	    	return "goods_list";
	    }
	    
	    @RequestMapping("/detail.do")
	    public String getGoodsDetail(Integer id,ModelMap map) {
		   Goods goods=goodsService.getGoodsById(id);
		   if(goods==null) {
				 map.addAttribute("message", "没有该商品详情");
			    	return "error";
			 }
		   List<Goods> itemGoods=goodsService.getGoodsByItemType(goods.getItemType());
		   map.addAttribute("itemGoods", itemGoods);
		   Integer parentId=goods.getCategoryId();
		   String itemType=goods.getItemType();
		   List<String> nameList=new ArrayList<String>();
		   nameList.add(itemType);
		   nameList=this.getcategoryName(nameList, parentId);
		   Collections.reverse(nameList);
		    map.addAttribute("nameList", nameList);
		     map.addAttribute("goods", goods);
	    	return "goods_detail";
	    }
	    
	    //通过递归获取某id商品的各级分类名称
	    private List<String> getcategoryName(List<String> list,Integer parentId){
	    	   if(parentId==0) {
	    		   return list;
	    	   }else {
	    		   GoodsCategory goodsCategory=goodsCategoryService.getGoodsCategoryById(parentId);
	    		   String name=goodsCategory.getName();
	    		   parentId=goodsCategory.getParentId();
	    			list.add(name);	   
	    		   return this.getcategoryName(list, parentId);
	    	   }
	    }
}
