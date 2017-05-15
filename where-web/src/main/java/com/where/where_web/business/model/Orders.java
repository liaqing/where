package com.where.where_web.business.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Orders implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String orderTime;

    private Integer status;

    private BigDecimal totalPrice;

    private Integer usersId;

    private String deliveryAddressId;

    private String remarks;

    private Integer businessId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime == null ? null : orderTime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setDeliveryAddressId(String deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderTime=" + orderTime + ", status=" + status + ", totalPrice=" + totalPrice
				+ ", usersId=" + usersId + ", deliveryAddressId=" + deliveryAddressId + ", remarks=" + remarks
				+ ", businessId=" + businessId + "]";
	}
    
    
}