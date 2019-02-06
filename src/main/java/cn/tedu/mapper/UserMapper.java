package cn.tedu.mapper;

import cn.tedu.bean.User;

public interface UserMapper {
         /**增加用户信息
         * @param user   用户信息
         */
        public void insert(User user);
        
        /**根据用户名查询用户信息
         * @param username      用户姓名
         * @return                       查到返回该用户信息，没有返回null
         */
        public User findUserByUsername(String username);
        
        /**查询匹配的email或uname,或phone是否被占用
         * @param email            用户邮箱
         * @return
         */
        public Integer selectCount(User user);
        
        /**修改用户信息
         * @param user              要修改的用户信息，必须包含id
          * @return
         */
        public Integer update(User user);

		/**根据用户名查询用户
		 * @return      用户信息 ,没有查到返回null
		 */
		public User findUserById(Integer id);
 
         
}
