package com.xx.sm.framework.model.dao.impl;

import java.util.List;

import com.xx.sm.framework.model.entity.MenuBean;

public interface IMenuDAO {
	public List<MenuBean> queryBySql(String sql);
}
