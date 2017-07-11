package com.yifengtec.springboot.hello.config;

public enum ColorRgb {

	RED(255, 0, 0), GREEN(0, 255, 0),;

	private ColorRgb(int r, int g, int b) {

	}

	private int r;

	private int g;

	private int b;

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
}
