package com.gabrielamorim.order;

public class OrderItem {
	
	public OrderItem() {
		
	}
	
	public OrderItem(String productCategory, String productType, String actionCode) {
		this.productCategory = productCategory;
		this.productType = productType;
		this.actionCode = actionCode;
	}
	
	String number;
	String productCategory;
	String productType;
	String actionCode;
}