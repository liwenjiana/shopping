package cn.tedu.bean;

import java.io.Serializable;

public class City implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7775094673955435574L;
	private Integer id;
    private String name;
    private String code;
    private String provinceCode;
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	public City(Integer id, String name, String code, String provinceCode) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.provinceCode = provinceCode;
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
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", code=" + code + ", provinceCode=" + provinceCode + "]";
	}
}
