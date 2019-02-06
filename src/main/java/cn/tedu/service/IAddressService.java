package cn.tedu.service;

import java.util.List;

import cn.tedu.bean.Address;

public interface IAddressService {
	
         /**添加收货地址信息
         * @param addr       收货地址信息
         * @return                返回收货地址id
         */
        public Integer add(Address addr);
        
        /**根据用户uid查询该用户的收货地址
         * @param uid          用户id
         * @return                用户收货地址列表
         */
        public List<Address> getAddressByUid(Integer uid);
        
        /**根据用户id查询该用户的收货地址
         * @param id          货地址id
         * @return                用户收货地址列表
         */
        public Address getAddressById(Integer id);
        
        /**根据用户uid和收货地址id查询该用户的收货地址
         * @param id        收货地址id
         * @param uid     用户uid
         * @return
         */
        public Address getAddressByUidAndId(Integer id,Integer uid);
        
        /**根据id删除收货地址
         * @param id        收货地址id
         * @return            受影响的行数
         */
        public Integer delete(Integer id);
        
        /**设置该id的收货地址为默认（is_defualut==1）
         * @param addr      收货地址信息
         * @return             受影响的行数
         */
        public Integer setDefault(Integer id);
        
        /**设置指定用户的一些收货地址不为默认；
         * @param uid       用户id
         * @return              删除成功返回1
         */
        public Integer setNotDefault(Integer uid,Integer id);
        
        /**根据uid 和id 删除收货地址  （安全）
         * @param id
         * @param uid
         * @return
         */
        public Integer delete2(Integer id,Integer uid) ;
        
        /**修改收货地址
         * @param addr      收货地址信息
         * @return              受影响的行数
         */
        public Integer update(Address addr);
        
        /**根据用户id 获取默认收货地址
         * param uid         用户id
         * @return    收货地址
         */
        public Address getDefaultAddress(Integer uid);
        

}
