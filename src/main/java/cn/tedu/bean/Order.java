package cn.tedu.bean;

import java.io.Serializable;
import java.util.Date;

public class Order  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7721745163036052964L;
	private Integer id;
	private Integer uid;
	private String recv_name;
	private String  recv_district;
	private String recv_addr;
	private String  recv_zip;
	private String recv_phone;
	private String  recv_tel;
    private Integer total_price;
    private Integer status;
    private String  created_user;
	private Date  created_time;
	private String  modified_user;
	private Date modified_time;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Integer id, Integer uid, String recv_name, String recv_district, String recv_addr, String recv_zip,
			String recv_phone, String recv_tel, Integer total_price, Integer status, String created_user,
			Date created_time, String modified_user, Date modified_time) {
		super();
		this.id = id;
		this.uid = uid;
		this.recv_name = recv_name;
		this.recv_district = recv_district;
		this.recv_addr = recv_addr;
		this.recv_zip = recv_zip;
		this.recv_phone = recv_phone;
		this.recv_tel = recv_tel;
		this.total_price = total_price;
		this.status = status;
		this.created_user = created_user;
		this.created_time = created_time;
		this.modified_user = modified_user;
		this.modified_time = modified_time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getRecv_name() {
		return recv_name;
	}
	public void setRecv_name(String recv_name) {
		this.recv_name = recv_name;
	}
	public String getRecv_district() {
		return recv_district;
	}
	public void setRecv_district(String recv_district) {
		this.recv_district = recv_district;
	}
	public String getRecv_addr() {
		return recv_addr;
	}
	public void setRecv_addr(String recv_addr) {
		this.recv_addr = recv_addr;
	}
	public String getRecv_zip() {
		return recv_zip;
	}
	public void setRecv_zip(String recv_zip) {
		this.recv_zip = recv_zip;
	}
	public String getRecv_phone() {
		return recv_phone;
	}
	public void setRecv_phone(String recv_phone) {
		this.recv_phone = recv_phone;
	}
	public String getRecv_tel() {
		return recv_tel;
	}
	public void setRecv_tel(String recv_tel) {
		this.recv_tel = recv_tel;
	}
	public Integer getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Integer total_price) {
		this.total_price = total_price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreated_user() {
		return created_user;
	}
	public void setCreated_user(String created_user) {
		this.created_user = created_user;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	public String getModified_user() {
		return modified_user;
	}
	public void setModified_user(String modified_user) {
		this.modified_user = modified_user;
	}
	public Date getModified_time() {
		return modified_time;
	}
	public void setModified_time(Date modified_time) {
		this.modified_time = modified_time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created_time == null) ? 0 : created_time.hashCode());
		result = prime * result + ((created_user == null) ? 0 : created_user.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modified_time == null) ? 0 : modified_time.hashCode());
		result = prime * result + ((modified_user == null) ? 0 : modified_user.hashCode());
		result = prime * result + ((recv_addr == null) ? 0 : recv_addr.hashCode());
		result = prime * result + ((recv_district == null) ? 0 : recv_district.hashCode());
		result = prime * result + ((recv_name == null) ? 0 : recv_name.hashCode());
		result = prime * result + ((recv_phone == null) ? 0 : recv_phone.hashCode());
		result = prime * result + ((recv_tel == null) ? 0 : recv_tel.hashCode());
		result = prime * result + ((recv_zip == null) ? 0 : recv_zip.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((total_price == null) ? 0 : total_price.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (created_time == null) {
			if (other.created_time != null)
				return false;
		} else if (!created_time.equals(other.created_time))
			return false;
		if (created_user == null) {
			if (other.created_user != null)
				return false;
		} else if (!created_user.equals(other.created_user))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modified_time == null) {
			if (other.modified_time != null)
				return false;
		} else if (!modified_time.equals(other.modified_time))
			return false;
		if (modified_user == null) {
			if (other.modified_user != null)
				return false;
		} else if (!modified_user.equals(other.modified_user))
			return false;
		if (recv_addr == null) {
			if (other.recv_addr != null)
				return false;
		} else if (!recv_addr.equals(other.recv_addr))
			return false;
		if (recv_district == null) {
			if (other.recv_district != null)
				return false;
		} else if (!recv_district.equals(other.recv_district))
			return false;
		if (recv_name == null) {
			if (other.recv_name != null)
				return false;
		} else if (!recv_name.equals(other.recv_name))
			return false;
		if (recv_phone == null) {
			if (other.recv_phone != null)
				return false;
		} else if (!recv_phone.equals(other.recv_phone))
			return false;
		if (recv_tel == null) {
			if (other.recv_tel != null)
				return false;
		} else if (!recv_tel.equals(other.recv_tel))
			return false;
		if (recv_zip == null) {
			if (other.recv_zip != null)
				return false;
		} else if (!recv_zip.equals(other.recv_zip))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (total_price == null) {
			if (other.total_price != null)
				return false;
		} else if (!total_price.equals(other.total_price))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", uid=" + uid + ", recv_name=" + recv_name + ", recv_district=" + recv_district
				+ ", recv_addr=" + recv_addr + ", recv_zip=" + recv_zip + ", recv_phone=" + recv_phone + ", recv_tel="
				+ recv_tel + ", total_price=" + total_price + ", status=" + status + ", created_user=" + created_user
				+ ", created_time=" + created_time + ", modified_user=" + modified_user + ", modified_time="
				+ modified_time + "]";
	}
}
