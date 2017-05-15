package com.where.where_web.business.model;

import java.io.Serializable;

public class Area implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer code;

    private Integer parentcode;

    private String name;

    private Integer levelcount;

    private String latitude;

    private String longitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getParentcode() {
        return parentcode;
    }

    public void setParentcode(Integer parentcode) {
        this.parentcode = parentcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLevelcount() {
        return levelcount;
    }

    public void setLevelcount(Integer levelcount) {
        this.levelcount = levelcount;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

	@Override
	public String toString() {
		return "Area [id=" + id + ", code=" + code + ", parentcode=" + parentcode + ", name=" + name + ", levelcount="
				+ levelcount + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
    
    
}