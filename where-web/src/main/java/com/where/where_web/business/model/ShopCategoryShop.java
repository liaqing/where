package com.where.where_web.business.model;

import java.io.Serializable;

public class ShopCategoryShop implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer shopCategoryId;

    private Integer shopId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopCategoryId() {
        return shopCategoryId;
    }

    public void setShopCategoryId(Integer shopCategoryId) {
        this.shopCategoryId = shopCategoryId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

	@Override
	public String toString() {
		return "ShopCategoryShop [id=" + id + ", shopCategoryId=" + shopCategoryId + ", shopId=" + shopId + "]";
	}
    
    
}