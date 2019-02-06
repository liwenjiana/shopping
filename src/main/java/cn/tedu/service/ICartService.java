package cn.tedu.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.bean.Cart;

public interface ICartService {
	
	  /**给用户购物车添加商品信息
     * @param cart      购物车记录信息
     * @return             购物车记录id
     */
	public Integer insert(Cart cart);
	
    /**根据用户id和商品id查询，该商品是否已经被添加进购物车
     * @param uid                     用户id
     * @param goodsId             商品id
     * @return                            商品已经被添加返回1，没用返回0
     */
    public Integer checkGoods(Integer uid,  Integer goodsId);
    
    /**根据用户id和商品id，更新购物车商品的数量
     * @param uid                       用户id
     * @param goodsCount       更新商品的数量
     * @param goodsId              商品id 
     * @throws    DataNotFandException   购物车没有该商品信息抛出异常
     * @return                             更新成功返回1，失败返回0
     */
    public Integer changeCount(Integer uid, Integer goodsCount, Integer goodsId);
    
    /**根据用户id，查询该用户购物车的商品信息
     * @param uid      用户id
     * @return             商品信息
     */ 
    public List<Cart> getCartList(Integer uid);
    
    /**根据购物车记录id，查询商品信息
     * @param id             购物车记录id,可以有多条，5，5，5，5
     * @return                 商品信息
     */
    public List<Cart> getCartListById(String id);
}
