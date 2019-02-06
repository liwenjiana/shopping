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
			 throw new RuntimeException("��ӹ�����Ϣ��������ϵ�ͷ�");
		}
		return id;
	}
  //�����Ʒ�Ƿ��ڹ��ﳵ
	public Integer checkGoods(Integer uid, Integer goodsId) {
		
		return cartMapper.getRecordCount(uid, goodsId);
	}
//���¸��û����ﳵ�ϸ���Ʒ������
	public Integer changeCount(Integer uid, Integer goodsCount, Integer goodsId) {
		if(checkGoods(uid,goodsId)!=1) {
			throw new DataNotFandException("���ﳵ�ϸ���Ʒ�����ݲ����ڣ�����Ӹ���Ʒ");
		}
		return cartMapper.update(uid, goodsCount, goodsId);
	}
	
	//��ѯ�û����ﳵ��Ʒ
	public List<Cart> getCartList(Integer uid) {
	
		return cartMapper.getCartList(uid);
	}
	public List<Cart> getCartListById(String ids) {
		List<String> id = Arrays.asList(ids.split(","));
	    
		return cartMapper.getCartListById(id);
	}
    

}
