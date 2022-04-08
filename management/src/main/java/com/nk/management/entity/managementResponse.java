package com.nk.management.entity;

import java.util.List;


public class managementResponse {

	private List<management> manage;
	
    public managementResponse(List<management> manage){
        this.manage = manage;
    }

//    public List<management> getEcommerceProducts() {
//        return management;
//    }
//
//    public void setEcommerceProducts(List<management> ecommerceProducts) {
//        this.ecommerceProducts = ecommerceProducts;
//    }
}
