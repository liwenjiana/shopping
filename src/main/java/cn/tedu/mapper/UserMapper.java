package cn.tedu.mapper;

import cn.tedu.bean.User;

public interface UserMapper {
         /**�����û���Ϣ
         * @param user   �û���Ϣ
         */
        public void insert(User user);
        
        /**�����û�����ѯ�û���Ϣ
         * @param username      �û�����
         * @return                       �鵽���ظ��û���Ϣ��û�з���null
         */
        public User findUserByUsername(String username);
        
        /**��ѯƥ���email��uname,��phone�Ƿ�ռ��
         * @param email            �û�����
         * @return
         */
        public Integer selectCount(User user);
        
        /**�޸��û���Ϣ
         * @param user              Ҫ�޸ĵ��û���Ϣ���������id
          * @return
         */
        public Integer update(User user);

		/**�����û�����ѯ�û�
		 * @return      �û���Ϣ ,û�в鵽����null
		 */
		public User findUserById(Integer id);
 
         
}
