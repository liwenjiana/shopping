package cn.tedu.bean;

import java.io.Serializable;
import java.util.Date;

public class OrderItem implements Serializable{
     /**
	 * 
	 */
	private static final long serialVersionUID = -4371737625989423266L;
	private Integer id;
     private Integer order_id;
	private String goods_image;
	private String goods_title;
	private String goods_item_type;
	 private Integer goods_price;
	 private Integer goods_count;
     private String created_user;
    private Date created_time;
   private String modified_user;
   private Date modified_time;
public OrderItem() {
	super();
	// TODO Auto-generated constructor stub
}
public OrderItem(Integer id, Integer order_id, String goods_image, String goods_title, String goods_item_type,
		Integer goods_price, Integer goods_count, String created_user, Date created_time, String modified_user,
		Date modified_time) {
	super();
	this.id = id;
	this.order_id = order_id;
	this.goods_image = goods_image;
	this.goods_title = goods_title;
	this.goods_item_type = goods_item_type;
	this.goods_price = goods_price;
	this.goods_count = goods_count;
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
public Integer getOrder_id() {
	return order_id;
}
public void setOrder_id(Integer order_id) {
	this.order_id = order_id;
}
public String getGoods_image() {
	return goods_image;
}
public void setGoods_image(String goods_image) {
	this.goods_image = goods_image;
}
public String getGoods_title() {
	return goods_title;
}
public void setGoods_title(String goods_title) {
	this.goods_title = goods_title;
}
public String getGoods_item_type() {
	return goods_item_type;
}
public void setGoods_item_type(String goods_item_type) {
	this.goods_item_type = goods_item_type;
}
public Integer getGoods_price() {
	return goods_price;
}
public void setGoods_price(Integer goods_price) {
	this.goods_price = goods_price;
}
public Integer getGoods_count() {
	return goods_count;
}
public void setGoods_count(Integer goods_count) {
	this.goods_count = goods_count;
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
	result = prime * result + ((goods_count == null) ? 0 : goods_count.hashCode());
	result = prime * result + ((goods_image == null) ? 0 : goods_image.hashCode());
	result = prime * result + ((goods_item_type == null) ? 0 : goods_item_type.hashCode());
	result = prime * result + ((goods_price == null) ? 0 : goods_price.hashCode());
	result = prime * result + ((goods_title == null) ? 0 : goods_title.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((modified_time == null) ? 0 : modified_time.hashCode());
	result = prime * result + ((modified_user == null) ? 0 : modified_user.hashCode());
	result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
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
	OrderItem other = (OrderItem) obj;
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
	if (goods_count == null) {
		if (other.goods_count != null)
			return false;
	} else if (!goods_count.equals(other.goods_count))
		return false;
	if (goods_image == null) {
		if (other.goods_image != null)
			return false;
	} else if (!goods_image.equals(other.goods_image))
		return false;
	if (goods_item_type == null) {
		if (other.goods_item_type != null)
			return false;
	} else if (!goods_item_type.equals(other.goods_item_type))
		return false;
	if (goods_price == null) {
		if (other.goods_price != null)
			return false;
	} else if (!goods_price.equals(other.goods_price))
		return false;
	if (goods_title == null) {
		if (other.goods_title != null)
			return false;
	} else if (!goods_title.equals(other.goods_title))
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
	if (order_id == null) {
		if (other.order_id != null)
			return false;
	} else if (!order_id.equals(other.order_id))
		return false;
	return true;
}
@Override
public String toString() {
	return "OrderItem [id=" + id + ", order_id=" + order_id + ", goods_image=" + goods_image + ", goods_title="
			+ goods_title + ", goods_item_type=" + goods_item_type + ", goods_price=" + goods_price + ", goods_count="
			+ goods_count + ", created_user=" + created_user + ", created_time=" + created_time + ", modified_user="
			+ modified_user + ", modified_time=" + modified_time + "]";
}
   
}
