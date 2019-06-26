package com.time;

public class Drink {
		SUGER suger;
		boolean select=false;
		String c_id,d_id,c_name;
		static ICE ice;
		SIZE size;
		float price;
		float afprice=price;
		int num=0;
		String name;
		public float getAfprice() {
			return afprice;
		}
		public void setAfprice(float afprice) {
			this.afprice = afprice;
		}
		
		public String getC_id() {
			return c_id;
		}
		public void setC_id(String c_id) {
			this.c_id = c_id;
		}
		public String getD_id() {
			return d_id;
		}
		public void setD_id(String d_id) {
			this.d_id = d_id;
		}
		public String getC_name() {
			return c_name;
		}
		public void setC_name(String c_name) {
			this.c_name = c_name;
		}
		public boolean isSelect() {
			return select;
		}
		public void setSelect(boolean select) {
			this.select = select;
		}
		public SUGER getSuger() {
			return suger;
		}
		public void setSuger(SUGER suger) {
			this.suger = suger;
		}
		public ICE getIce() {
			return ice;
		}
		public void setIce(ICE ice) {
			Drink.ice = ice;
		}
		public SIZE getSize() {
			return size;
		}
		public void setSize(SIZE size) {
			this.size = size;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float t) {
			this.price = t;
			afprice=t;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
		
		
}
