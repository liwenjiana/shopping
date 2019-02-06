package cn.tedu.bean;

import java.io.Serializable;

public class Area implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1375830533877867208L;
	private Integer id;
    private String name;
    private String code;
    private String cityCode;
	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Area(Integer id, String name, String code, String cityCode) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.cityCode = cityCode;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	@Override
	public String toString() {
		return "Area [id=" + id + ", name=" + name + ", code=" + code + ", cityCode=" + cityCode + "]";
	}
}
