package com.example.demo;

public class Product {
    private String productId;
	private String productName;
    private String productDesc;
    //private ArrayList relatedProds;
    //private image;
    public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	
    @Override
    public String toString() {
        return String.format("Product [ID=%s, Name=%s, Description=%s]", productId, productName, productDesc);

    }


}
