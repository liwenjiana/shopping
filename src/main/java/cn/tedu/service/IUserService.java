package cn.tedu.service;

import cn.tedu.bean.User;
import cn.tedu.service.ex.UsernameAlreadyExistsExceptoion;

public interface IUserService {
	
    /**ע���û�
     * @param user �û���Ϣ
     * @return         �û�id
     * @throws UsernameAlreadyExistsExceptoion   �û����Ѵ����׳����쳣
     */
    public Integer regists(User user);
    
    /**�����û�����ѯ�û���Ϣ
     * @param username      �û�����
     * @return                       �鵽���ظ��û���Ϣ��û�з���null
     */
    public User findUserByUsername(String username);
    
    /**��ѯƥ���email�Ƿ�ռ��
     * @param email            �û�����
     * @return                      ��ռ�÷���1��
     */
    public Integer checkUser(User user);
    
     /**�޸�����
     * @param id                         �û�id
     * @param newPassword     �� ����
     * @param oldPassword       ������
     * @throws   PasswordErroeException      ��������׳����쳣
     * @throws   UserNotExistsException        ��id�û���Ϣ������
     */
    public void changePassword(Integer id,String newPassword,String oldPassword);

	/**����id��ѯ�û���Ϣ
	 * @param id      �û�id
	 * @return          �û���Ϣ
	 */
	public User findUserById(Integer id);
	
	/**�޸ĸ�����Ϣ
	 * @param id                  �û�id
	 * @param username     �û�����
	 * @param phone          �û��绰
	 * @param email            �û�����
	 * @param gender         �û��Ա�
	 * @return                      �޸ĳɹ�����1��ʧ�ܷ���0
	 * @throws      UsernameAlreadyExistsExceptoion    �û�����ռ���׳��쳣
	 * @throws     UserNotExistsException                       �û��������׳��쳣
	 */
	public Integer editProfile(Integer id,String username,String phone,String email,Integer gender);
}