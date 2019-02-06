package cn.tedu.service;

import cn.tedu.bean.User;
import cn.tedu.service.ex.UsernameAlreadyExistsExceptoion;

public interface IUserService {
	
    /**注册用户
     * @param user 用户信息
     * @return         用户id
     * @throws UsernameAlreadyExistsExceptoion   用户名已存在抛出的异常
     */
    public Integer regists(User user);
    
    /**根据用户名查询用户信息
     * @param username      用户姓名
     * @return                       查到返回该用户信息，没有返回null
     */
    public User findUserByUsername(String username);
    
    /**查询匹配的email是否被占用
     * @param email            用户邮箱
     * @return                      被占用返回1，
     */
    public Integer checkUser(User user);
    
     /**修改密码
     * @param id                         用户id
     * @param newPassword     新 密码
     * @param oldPassword       久密码
     * @throws   PasswordErroeException      密码错误抛出的异常
     * @throws   UserNotExistsException        该id用户信息不存在
     */
    public void changePassword(Integer id,String newPassword,String oldPassword);

	/**根据id查询用户信息
	 * @param id      用户id
	 * @return          用户信息
	 */
	public User findUserById(Integer id);
	
	/**修改个人信息
	 * @param id                  用户id
	 * @param username     用户姓名
	 * @param phone          用户电话
	 * @param email            用户邮箱
	 * @param gender         用户性别
	 * @return                      修改成功返回1，失败返回0
	 * @throws      UsernameAlreadyExistsExceptoion    用户名被占用抛出异常
	 * @throws     UserNotExistsException                       用户不存在抛出异常
	 */
	public Integer editProfile(Integer id,String username,String phone,String email,Integer gender);
}