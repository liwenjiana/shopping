package cn.tedu.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
         /**
	 * 
	 */
	private static final long serialVersionUID = 736781078905614958L;
		private Integer id;
         private String username;
         private String password;
         private String phone;
         private String email;
         private Integer gender;
         private String createdUser;
         private Date createdTime;
         private String modifiedUser;
         private Date modifiedTime;
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public User(int id, String username, String password, String phone, String email, int gender,
				String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.phone = phone;
			this.email = email;
			this.gender = gender;
			this.createdUser = createdUser;
			this.createdTime = createdTime;
			this.modifiedUser = modifiedUser;
			this.modifiedTime = modifiedTime;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Integer getGender() {
			return gender;
		}
		public void setGender(Integer gender) {
			this.gender = gender;
		}
		public String getCreatedUser() {
			return createdUser;
		}
		public void setCreatedUser(String createdUser) {
			this.createdUser = createdUser;
		}
		public Date getCreatedTime() {
			return createdTime;
		}
		public void setCreatedTime(Date createdTime) {
			this.createdTime = createdTime;
		}
		public String getModifiedUser() {
			return modifiedUser;
		}
		public void setModifiedUser(String modifiedUser) {
			this.modifiedUser = modifiedUser;
		}
		public Date getModifiedTime() {
			return modifiedTime;
		}
		public void setModifiedTime(Date modifiedTime) {
			this.modifiedTime = modifiedTime;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone
					+ ", email=" + email + ", gender=" + gender + ", createdUser=" + createdUser + ", createdTime="
					+ createdTime + ", modifiedUser=" + modifiedUser + ", modifiedTime=" + modifiedTime + "]";
		}
}
