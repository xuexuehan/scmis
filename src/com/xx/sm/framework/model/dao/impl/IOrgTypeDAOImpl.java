package com.xx.sm.framework.model.dao.impl;
/**
 * @Author:xuexuehan
 * @Time:2019.3.19
 *
 */

import com.xx.sm.framework.model.entity.OrgType;
import com.xx.sm.framework.model.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class




















































































IOrgTypeDAOImpl implements IOrgTypeDAO {
    @Override
    public boolean add(OrgType orgType) {
        boolean flag = false;
        String sql = "insert into orgtype(orgTypeId, orgTypeName, orgTypeMemo)" +
                " values('"+ orgType.getOrgTypeId() +"', '"+ orgType.getOrgTypeName() +"', '"+ orgType.getOrgTypeMemo() +"')";
        System.out.println(sql);
        DBUtil dbUtil = new DBUtil();
        int n = dbUtil.update(sql);
        if(n > 0) {
            return true;
        }
        dbUtil.close();
        return flag;
    }

    @Override
    public boolean remove(String orgTypeId) {
        boolean flag = false;
        String sql = "delete from orgtype where orgTypeId = '"+ orgTypeId +"'";
        System.out.println(sql);
        DBUtil dbUtil = new DBUtil();
        int n = dbUtil.update(sql);
        if(n > 0) {
            return true;
        }
        dbUtil.close();
        return flag;
    }

    @Override
    public boolean modify(OrgType orgType) {
        boolean flag = false;
        String sql = "update orgtype set orgTypeName = '"+ orgType.getOrgTypeName() +"',orgTypeMemo = '" + orgType.getOrgTypeMemo() +"' where orgTypeId = '"+ orgType.getOrgTypeId() +"'";
        System.out.println(sql);
        DBUtil dbUtil = new DBUtil();
        int n = dbUtil.update(sql);
        if(n > 0) {
            return true;
        }
        dbUtil.close();
        return flag;
    }

    @Override
    public OrgType findById(String orgTypeId) {
        OrgType orgType = null;
        String sql = "select * from orgtype where orgTypeId = '"+ orgTypeId +"'";
        System.out.println(sql);
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.query(sql);
        try {
            while (rs.next()) {
                orgType = new OrgType();
                orgType.setOrgTypeId(rs.getString("orgTypeId"));
                orgType.setOrgTypeName(rs.getString("orgTypeName"));
                orgType.setOrgTypeMemo(rs.getString("orgTypeMemo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close();
        }
        return orgType;
    }

    @Override
    public List<OrgType> findByLike(OrgType orgType) {
        List<OrgType> list = new ArrayList<OrgType>();
        String select = "select * from orgtype";
        String where = " where 1=1";
        if(orgType.getOrgTypeId() != null && orgType.getOrgTypeId().length() > 0) {
            where = where + " and orgTypeId like'%"+ orgType.getOrgTypeId() +"%'";
        }
        if(orgType.getOrgTypeName() != null && orgType.getOrgTypeName().length() > 0) {
            where = where + " and orgTypeName like binary '%"+ orgType.getOrgTypeName() +"%'";
        }
        if(orgType.getOrgTypeMemo() != null && orgType.getOrgTypeMemo().length() > 0) {
            where = where + " and orgTypeMemo like'%"+ orgType.getOrgTypeMemo() +"%'";
        }
        String sql = select + where;
        System.out.println(sql);
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.query(sql);
        try {
            while(rs.next()) {
                OrgType tempOrgType = new OrgType();
                tempOrgType.setOrgTypeId(rs.getString(1));
                tempOrgType.setOrgTypeName(rs.getString(2));
                tempOrgType.setOrgTypeMemo(rs.getString(3));
                list.add(tempOrgType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close();
        }
        return list;
    }
}
