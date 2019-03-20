package com.xx.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xx.sm.framework.model.entity.MisFunction;
import com.xx.sm.framework.model.util.DBUtil;

public class IMisFunctionDAOImpl implements IMisFunctionDAO {

	@Override
	public List<MisFunction> findByMenuId(String menuId) {
		List<MisFunction> list = new ArrayList<MisFunction>();
		String sql = "select * from misFunction where menuId = '" + menuId + "'";
		DBUtil dbUtil = new DBUtil();
		ResultSet rs = dbUtil.query(sql);
		try {
			while(rs.next()) {
				MisFunction function = new MisFunction();
				function.setFunctionId(rs.getString(1));
				function.setFunctionName(rs.getString(2));
				function.setFunctionClass(rs.getString(3));
				function.setFunctionMemo(rs.getString(4));
				function.setMenuId(rs.getString(5));
				list.add(function);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return list;
	}

	@Override
	public List<MisFunction> findByMenuId(String menuId, String roleName) {
		List<MisFunction> list = new ArrayList<MisFunction>();
		String sql = "select * from misfunction where menuId = '"+ menuId +"' AND" +
				" functionId in (select functionId from auth where roleId in" +
				" (select roleId from misuser where userName = '"+ roleName +"'))";
		DBUtil dbUtil = new DBUtil();
		ResultSet rs = dbUtil.query(sql);
		try {
			while(rs.next()) {
				MisFunction function = new MisFunction();
				function.setFunctionId(rs.getString(1));
				function.setFunctionName(rs.getString(2));
				function.setFunctionClass(rs.getString(3));
				function.setFunctionMemo(rs.getString(4));
				function.setMenuId(rs.getString(5));
				list.add(function);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return list;
	}

	@Override
	public MisFunction findById(String functionId) {
		MisFunction function = null;
		String sql = "select * from misFunction where functionId = '"+ functionId +"'";
		DBUtil dbUtil = new DBUtil();
		ResultSet rs = dbUtil.query(sql);
		try {
			while(rs.next()) {
				function = new MisFunction();
				function.setFunctionId(rs.getString(1));
				function.setFunctionName(rs.getString(2));
				function.setFunctionClass(rs.getString(3));
				function.setFunctionMemo(rs.getString(4));
				function.setMenuId(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return function;
	}

	@Override
	public List<MisFunction> findByMenuIdAndRoleId(String menuId, String roleId) {
		List<MisFunction> list = new ArrayList<MisFunction>();
		String sql = "select * from misFunction where menuId = '" + menuId + "' "
				+ "and functionId in (select functionId from auth where roleId = '" + roleId + "')";
		DBUtil dbUtil = new DBUtil();
		ResultSet rs = dbUtil.query(sql);
		try {
			while(rs.next()) {
				MisFunction function = new MisFunction();
				function.setFunctionId(rs.getString(1));
				function.setFunctionName(rs.getString(2));
				function.setFunctionClass(rs.getString(3));
				function.setFunctionMemo(rs.getString(4));
				function.setMenuId(rs.getString(5));
				list.add(function);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return list;
	}

}
