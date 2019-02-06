package cn.tedu.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.bean.Goods;
import cn.tedu.bean.GoodsCategory;
import cn.tedu.service.IGoodsCategoryService;
import cn.tedu.service.IGoodsService;

@Controller
@RequestMapping("/main")
public class MainController {
	 
	@Resource(name="goodsCategoryService")
	private  IGoodsCategoryService goodsCategoryService;
	@Resource(name="goodsService")
	private IGoodsService goodsService;
	
	@RequestMapping("/index.do")
     public String showindex(HttpSession session,ModelMap map) { 
		//获取3个电脑商品集合
		List<Goods> computers=goodsService.getGoodsByCategoryId(163, "priority desc", 0, 3);
		map.addAttribute("computers",computers);
		//获取商品分类集合
		List<List<GoodsCategory>> computerCategory=new ArrayList<List<GoodsCategory>>();
		List<GoodsCategory> goodsCategories=goodsCategoryService.getGoodsCategoryListByParentId(161, 0, 3);
		map.addAttribute("goodsCategories", goodsCategories);
		for (GoodsCategory goodsCategory : goodsCategories) {
			Integer id=goodsCategory.getId();
			goodsCategories=goodsCategoryService.getGoodsCategoryListByParentId(id, null,null);
			computerCategory.add(goodsCategories);
		}
		map.addAttribute("computerCategory", computerCategory);
		
		//输出日志
		System.out.println("获取商品分类");
		System.out.println(goodsCategories);
		 for (List<GoodsCategory> goodsCategory :computerCategory) {
			        for (GoodsCategory goodsCategory2 : goodsCategory) {
						 System.out.println(goodsCategory2.getName());	 
					}
			        System.out.println("========");
		}
		 //
     	return "index";
     }
	 
	 @RequestMapping("/header.do")
     public String showheader() {
     	return "header";
     }
	 

}
