package com.where.where_web.business.model;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Goods {
    private Integer id;
    
    @NotEmpty(message="餐品名不能为空！！")
    @Size(min=1,max=20,message="名字的长度不得超过20")
    private String name;
    
    @Digits(integer=3,fraction=2,message="价格的范围在0-999.99,小数精度为2")
    private BigDecimal price;

    //@NotEmpty(message="不能为空")
    @Digits(integer=5,fraction=0,message="必须为0到99999的整数")
    private Integer sort;
    
    private String repertory;

    private GoodsCategory goodsCategory;
    
    private Integer shopId;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRepertory() {
        return repertory;
    }

    public void setRepertory(String repertory) {
        this.repertory = repertory == null ? null : repertory.trim();
    }

  

	public GoodsCategory getGoodsCategory() {
		return goodsCategory;
	}

	public void setGoodsCategory(GoodsCategory goodsCategory) {
		this.goodsCategory = goodsCategory;
	}
	
	
	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", sort=" + sort + ", repertory=" + repertory
				+ ", goodsCategory=" + goodsCategory + ", shopId=" + shopId + "]";
	}

	


}