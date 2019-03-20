package com.xx.sm.framework.model.entity;

public class OrgType {
	private String orgTypeId = null;
	private String orgTypeName = null;
	private String orgTypeMemo = null;
	
	public OrgType() {
		// TODO Auto-generated constructor stub
	}

	public OrgType(String orgTypeId) {
		this.orgTypeId = orgTypeId;
	}

	public OrgType(String orgTypeId, String orgTypeName, String orgTypeMemo) {
		this.orgTypeId = orgTypeId;
		this.orgTypeName = orgTypeName;
		this.orgTypeMemo = orgTypeMemo;
	}

	public String getOrgTypeId() {
		return orgTypeId;
	}
	public void setOrgTypeId(String orgTypeId) {
		this.orgTypeId = orgTypeId;
	}
	public String getOrgTypeName() {
		return orgTypeName;
	}
	public void setOrgTypeName(String orgTypeName) {
		this.orgTypeName = orgTypeName;
	}
	public String getOrgTypeMemo() {
		return orgTypeMemo;
	}
	public void setOrgTypeMemo(String orgTypeMemo) {
		this.orgTypeMemo = orgTypeMemo;
	}
	@Override
	public String toString() {
		return "OrgType [orgTypeId=" + orgTypeId + ", orgTypeName="
				+ orgTypeName + ", orgTypeMemo=" + orgTypeMemo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((orgTypeId == null) ? 0 : orgTypeId.hashCode());
		result = prime * result
				+ ((orgTypeMemo == null) ? 0 : orgTypeMemo.hashCode());
		result = prime * result
				+ ((orgTypeName == null) ? 0 : orgTypeName.hashCode());
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
		OrgType other = (OrgType) obj;
		if (orgTypeId == null) {
			if (other.orgTypeId != null)
				return false;
		} else if (!orgTypeId.equals(other.orgTypeId))
			return false;
		if (orgTypeMemo == null) {
			if (other.orgTypeMemo != null)
				return false;
		} else if (!orgTypeMemo.equals(other.orgTypeMemo))
			return false;
		if (orgTypeName == null) {
			if (other.orgTypeName != null)
				return false;
		} else if (!orgTypeName.equals(other.orgTypeName))
			return false;
		return true;
	}
	
}
