package com.xx.sm.framework.model.entity;

public class MisFunction {
	private String functionId = null;
	private String functionName = null;
	private String functionClass = null;
	private String functionMemo = null;
	private String menuId = null;
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getFunctionClass() {
		return functionClass;
	}
	public void setFunctionClass(String functionClass) {
		this.functionClass = functionClass;
	}
	public String getFunctionMemo() {
		return functionMemo;
	}
	public void setFunctionMemo(String functionMemo) {
		this.functionMemo = functionMemo;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
	public MisFunction() {
		// TODO Auto-generated constructor stub
	}
	public MisFunction(String functionId, String functionName,
			String functionClass, String functionMemo, String menuId) {
		this.functionId = functionId;
		this.functionName = functionName;
		this.functionClass = functionClass;
		this.functionMemo = functionMemo;
		this.menuId = menuId;
	}
	@Override
	public String toString() {
		return "MisFunction [functionId=" + functionId + ", functionName="
				+ functionName + ", functionClass=" + functionClass
				+ ", functionMemo=" + functionMemo + ", menuId=" + menuId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((functionClass == null) ? 0 : functionClass.hashCode());
		result = prime * result
				+ ((functionId == null) ? 0 : functionId.hashCode());
		result = prime * result
				+ ((functionMemo == null) ? 0 : functionMemo.hashCode());
		result = prime * result
				+ ((functionName == null) ? 0 : functionName.hashCode());
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
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
		MisFunction other = (MisFunction) obj;
		if (functionClass == null) {
			if (other.functionClass != null)
				return false;
		} else if (!functionClass.equals(other.functionClass))
			return false;
		if (functionId == null) {
			if (other.functionId != null)
				return false;
		} else if (!functionId.equals(other.functionId))
			return false;
		if (functionMemo == null) {
			if (other.functionMemo != null)
				return false;
		} else if (!functionMemo.equals(other.functionMemo))
			return false;
		if (functionName == null) {
			if (other.functionName != null)
				return false;
		} else if (!functionName.equals(other.functionName))
			return false;
		if (menuId == null) {
			if (other.menuId != null)
				return false;
		} else if (!menuId.equals(other.menuId))
			return false;
		return true;
	}
}
