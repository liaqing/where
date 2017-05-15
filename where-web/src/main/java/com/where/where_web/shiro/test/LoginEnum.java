package com.where.where_web.shiro.test;

public enum LoginEnum {

	users("1"),business("2"),administrator("3");
	
	private String type;
	
	private LoginEnum(String type){
		this.type = type;
	}
	@Override
	public  String toString(){
		return this.type.toString();
	}
}
