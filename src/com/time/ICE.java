package com.time;



public enum ICE{
	NOMAL("正常冰") ,LESS("少冰"),NONE("去冰"),WARM("常温"),HOT("加热");
	
	
	String desc;
	
	
	private ICE(String desc) {
		this.desc=desc;
		
	}
	
	  public String toString() {
	        return desc;
	    }
	
}
