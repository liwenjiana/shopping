package cn.tedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.bean.Cart;

public interface CartMapper {
	
      /**给用户购物车添加商品信息
     * @param cart      购物车记录信息
     * @return            受影响的行数
     */
    public Integer insert(Cart cart);
    
    /**根据用户id和商品id查询，该商品是否已经被添加进购物车
     * @param uid                     用户id
     * @param goodsId             商品id
     * @return                            商品已经被添加返回1，没用返回0
     */
    public Integer getRecordCount(@Param("uid") Integer uid, @Param("goodsId") Integer goodsId);
    
    /**根据用户id和商品id，更新购物车商品的数量
     * @param uid                       用户id
     * @param goodsCount       更新商品的数量
     * @param goodsId              商品id 
     * @return                             受影响的行数
     */
    public Integer update(@Param("uid") Integer uid,@Param("goodsCount") Integer goodsCount,@Param("goodsId") Integer goodsId);
    
    /**根据用户id，查询该用户购物车的商品信息
     * @param uid      用户id
     * @return             商品信息
     */ 
    public List<Cart> getCartList(Integer uid);
    
    /**根据购物车记录id，查询商品信息
     * @param id             购物车记录id,可以有多条，5，5，5，5
     * @return                 商品信息
     */
    public List<Cart> getCartListById(List<String> id);
}
