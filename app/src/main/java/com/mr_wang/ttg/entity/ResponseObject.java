package com.mr_wang.ttg.entity;

public class ResponseObject<T> {

	private String msg ;
	private int state= 1;//0失败 1成功
	private T dtates;//存放需要解析的数据
	private int page;
	private int size;
	private int count;
	public ResponseObject(String msg, int state) {
		super();
		this.msg = msg;
		this.state = state;
	}
	public ResponseObject(int state, T dtates) {
		super();
		this.state = state;
		this.dtates = dtates;
	}
	public ResponseObject(String msg, int state, T dtates) {
		super();
		this.msg = msg;
		this.state = state;
		this.dtates = dtates;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Object getDtates() {
		return dtates;
	}

	public void setDtates(T dtates) {
		this.dtates = dtates;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
