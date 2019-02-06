package cn.tedu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.bean.Cart;
import cn.tedu.mapper.CartMapper;
import cn.tedu.service.ex.DataNotFandException;
@Service("cartService")
public class CartServiceImpl implements ICartService{
	
	@Resource(name="cartMapper")
    private CartMapper cartMapper;
	
	public Integer insert(Cart cart) {
		cartMapper.insert(cart);
		Integer id=cart.getId();
		if(id==null) {
			 throw new RuntimeException("添加购物信息出错，请联系客服");
		}
		return id;
	}
  //检查商品是否在购物车
	public Integer checkGoods(Integer uid, Integer goodsId) {
		
		return cartMapper.getRecordCount(uid, goodsId);
	}
//更新该用户购物车上该商品的数量
	public Integer changeCount(Integer uid, Integer goodsCount, Integer goodsId) {
		if(checkGoods(uid,goodsId)!=1) {
			throw new DataNotFandException("购物车上该商品的数据不存在，请添加该商品");
		}
		return cartMapper.update(uid, goodsCount, goodsId);
	}
	
	//查询用户购物车商品
	public List<Cart> getCartList(Integer uid) {
	
		return cartMapper.getCartList(uid);
	}
	public List<Cart> getCartListById(String ids) {
		List<String> id = Arrays.asList(ids.split(","));
	    
		return cartMapper.getCartListById(id);
	}
    

}
