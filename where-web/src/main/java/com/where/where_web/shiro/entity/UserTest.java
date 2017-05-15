package com.where.where_web.shiro.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserTest {
	
    private Integer id;
    @NotEmpty(message="用户名不能为空")
    @NotNull(message="用户名不能为空") //注意：@NotNull验证的是null，而不是""
    @Size(min=5)
    private String username;
    
    @NotNull(message="密码不能为空")
    private String password;

    private String salt;

    private Short locked;

    
    
    
    public UserTest() {
		
	}

	public UserTest(String username, String password) {
		
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCredentialsSalt() {
        return username+salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Short getLocked() {
        return locked;
    }

    public void setLocked(Short locked) {
        this.locked = locked;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())
			return false;
		UserTest other = (UserTest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "UserTest [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ ", locked=" + locked + "]";
	}
    
    
    
}