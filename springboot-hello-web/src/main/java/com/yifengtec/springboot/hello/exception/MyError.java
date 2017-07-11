package com.yifengtec.springboot.hello.exception;

import java.io.Serializable;

public class MyError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer status;

	private String message;

	public MyError(Integer status, String message) {
		this.status = status;
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
