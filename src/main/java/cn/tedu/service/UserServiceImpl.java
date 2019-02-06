package cn.tedu.service;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.bean.User;
import cn.tedu.mapper.UserMapper;
import cn.tedu.service.ex.PasswordErroeException;
import cn.tedu.service.ex.UserNotExistsException;
import cn.tedu.service.ex.UsernameAlreadyExistsExceptoion;
@Service("userService")
public class UserServiceImpl implements IUserService{
     
	@Resource(name="userMapper")
	private UserMapper  userMapper;
	@Value("#{dbConfig.salt}")
	private String salt;
	
	public Integer regists(User user) {
		try {
			userMapper.insert(user);
			return user.getId();
		} catch (Exception e) {
			throw new  UsernameAlreadyExistsExceptoion("�û����Ѿ���ע��");
		}
	}

	public User findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}
    
	public User findUserById(Integer id) {
		     return userMapper.findUserById(id);
	}
	public Integer checkUser(User user) {
		return userMapper.selectCount(user);
	}
     

	public void changePassword(Integer id, String newPassword, String oldPassword) {
		     User user=userMapper.findUserById(id);
		    
		     if(user==null) {
		    	 System.out.println("����2");
		    	 throw new UserNotExistsException("�û�������");
		     }else {
		    	 
		    	 if(user.getPassword().equals(oldPassword)) {
		    		 System.out.println("����3");
		    		 User u=new User();
		    		 u.setId(id);
		    		 u.setPassword(newPassword);
		    		 
		    		 userMapper.update(u);
		    		 System.out.println(u);
		    	 }else {
		    		 System.out.println("����1");
		    		 throw new PasswordErroeException("���벻��ȷ");
		    	 }
		     }
		
	}

	public Integer editProfile(Integer id, String username, String phone, String email,Integer gender) {
		User u=new User();
		u.setId(id);
		u.setUsername(username);
		u.setPhone(phone);
		u.setEmail(email);
		u.setGender(gender);
		u.setModifiedTime(new Date());
		u.setModifiedUser("System");
		User user1=userMapper.findUserById(id);
		
		if(user1==null) {
			throw new UserNotExistsException("�û������ڣ����ȵ�¼");
		}else{
			if(user1.getUsername().equals(username)) {
				u.setUsername(null);
				System.out.println(u);
				return userMapper.update(u);
			}else {
				User user2=userMapper.findUserByUsername(username);
				if(user2!=null) {
					throw new UsernameAlreadyExistsExceptoion("�û����Ѿ�����");
				}else {
					return userMapper.update(u);
				}
			}
		}
	}



}
