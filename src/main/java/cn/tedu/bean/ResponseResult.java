package cn.tedu.bean;

import java.util.List;

public class ResponseResult<T> {
    private int state;
    private String message;
    private T data;
	public ResponseResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseResult(int state, String message) {
		super();
		this.state = state;
		this.message = message;
	}
	public ResponseResult(int state) {
		super();
		this.state = state;
	}
	public ResponseResult(int state, String message, T data) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
	}
	public ResponseResult(int state, T data) {
		
		this.state = state;
		this.data = data;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
