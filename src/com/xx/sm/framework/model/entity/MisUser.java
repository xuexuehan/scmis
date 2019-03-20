package com.xx.sm.framework.model.entity;

public class MisUser {
	private String userId = null;
	private String userName = null;
	private String userPassword = null;
	private String userMemo = null;
	private String roleId = null;
	private String addressId = null;
	
	public MisUser() {
		// TODO Auto-generated constructor stub
	}

	public MisUser(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public MisUser(String userId, String userName, String userPassword,
				   String userMemo, String roleId, String addressId) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userMemo = userMemo;
		this.roleId = roleId;
		this.addressId = addressId;
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserMemo() {
		return userMemo;
	}
	public void setUserMemo(String userMemo) {
		this.userMemo = userMemo;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	@Override
	public String toString() {
		return "MisUser [userId=" + userId + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", userMemo=" + userMemo
				+ ", roleId=" + roleId + ", addressId=" + addressId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((userMemo == null) ? 0 : userMemo.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		result = prime * result
				+ ((userPassword == null) ? 0 : userPassword.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MisUser other = (MisUser) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userMemo == null) {
			if (other.userMemo != null)
				return false;
		} else if (!userMemo.equals(other.userMemo))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		return true;
	}
	
}
