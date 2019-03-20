package com.xx.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.xx.sm.framework.model.entity.MisUser;
import com.xx.sm.framework.model.util.DBUtil;

public class IMisUserDAOImpl implements IMisUserDAO {

	@Override
	public MisUser findByName(String name) {
		MisUser misUser = null;
		String sql = "select * from misuser where userName = '" + name + "'";
		DBUtil dbUtil = new DBUtil();
		ResultSet rs = dbUtil.query(sql);
		try {
			while(rs.next()) {
				misUser = new MisUser();
				misUser.setUserId(rs.getString(1));
				misUser.setUserName(rs.getString(2));
				misUser.setUserPassword(rs.getString(3));
				misUser.setUserMemo(rs.getString(4));
				misUser.setRoleId(rs.getString(5));
				misUser.setAddressId(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return misUser;
	}

	@Override
	public boolean add(MisUser misUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(MisUser misUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MisUser> findByLike(MisUser misUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
