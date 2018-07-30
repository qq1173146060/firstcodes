package com.panshi.domain;

import java.util.List;

public class Result {

	private int code;
	
	private String msg;
	
	private int count;
	
	private List<Student> data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Student> getData() {
		return data;
	}

	public void setData(List<Student> list) {
		this.data = list;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}

}
