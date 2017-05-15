package com.where.where_web.business.model;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class GoodsCategory {
    private Integer id;
    
    @NotEmpty(message="名字不能为空！！")
    @Size(min=0,max=10,message="名字长度不能超过10！！")
    private String name;
    
    @Digits(fraction = 0, integer = 5,message="必须为0到99,999的整数！！")
    private Integer sort;

    private Integer shopId;
    
    private List<Goods> list;
    
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	
	
	
	public List<Goods> getList() {
		return list;
	}

	public void setList(List<Goods> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "GoodsCategory [id=" + id + ", name=" + name + ", sort=" + sort + ", shopId=" + shopId + "]";
	}

	
    
    
}