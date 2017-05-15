package com.where.where_web.business.model;

import java.io.Serializable;
import java.util.List;

import com.where.where_user_management.model.Business;

public class Shop implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    private String status;
    
    private List<String> list;

    private String province;
    
    private String city;
    
    private String county;
    
    private String specificAddress;

    private Business business;
    
    private ShopPicture shopPicture;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

  

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	
	
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

		
	
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	
	
	public String getSpecificAddress() {
		return specificAddress;
	}

	public void setSpecificAddress(String specificAddress) {
		this.specificAddress = specificAddress;
	}

	
	public ShopPicture getShopPicture() {
		return shopPicture;
	}

	public void setShopPicture(ShopPicture shopPicture) {
		this.shopPicture = shopPicture;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", status=" + status + ", list=" + list + ", business=" + business
				+ "]";
	}

	

   
}