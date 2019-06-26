package com.time;

public enum SUGER {
	NOMAL("正常糖"),HALF("半糖"),NONE("无糖");
	
	
	
	String desc;
	
	
	private SUGER(String desc) {
		this.desc=desc;
		
	}
	
	  public String toString() {
	        return desc;
	    }
}
