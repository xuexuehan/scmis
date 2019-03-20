package com.xx.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xx.sm.framework.model.entity.MenuBean;
import com.xx.sm.framework.model.util.DBUtil;

public class IMenuDAOImpl implements IMenuDAO {

	public List queryBySql(String sql) {
		ResultSet rs = null;
		List list = new ArrayList();
		DBUtil dbUtil = new DBUtil();
		rs = dbUtil.query(sql);
		try {
			while(rs.next()) {
				MenuBean menuBean = new MenuBean();
				menuBean.setMenuId(rs.getString(1));
				menuBean.setMenuName(rs.getString(2));
				menuBean.setMenuMemo(rs.getString(3));
				list.add(menuBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
