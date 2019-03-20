package com.xx.sm.framework.model.dao.impl;

import java.util.List;

import com.xx.sm.framework.model.entity.MisFunction;

public interface IMisFunctionDAO {
	public List<MisFunction> findByMenuId(String menuId);
	public List<MisFunction> findByMenuId(String menuId, String roleName);
	public List<MisFunction> findByMenuIdAndRoleId(String menuId, String roleId);
	public MisFunction findById(String functionId);
}
