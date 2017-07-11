package com.yifengtec.springboot.hello.web.vo;

public class PostOnceReq {

	private String body;

	private String querys;

	private String path;

	private String others;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getQuerys() {
		return querys;
	}

	public void setQuerys(String querys) {
		this.querys = querys;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	@Override
	public String toString() {
		return "PostOnceReq [body=" + body + ", querys=" + querys + ", path=" + path + ", others=" + others + "]";
	}

}
