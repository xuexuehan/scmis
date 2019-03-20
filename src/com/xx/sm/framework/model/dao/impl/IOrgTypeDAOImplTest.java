package com.xx.sm.framework.model.dao.impl;

import com.xx.sm.framework.model.entity.OrgType;

import java.util.List;

public class IOrgTypeDAOImplTest {
    public static void main(String[] args) {
        //OrgType orgType = new OrgType("666", "软件测试", "基础课程");
        IOrgTypeDAO orgTypeDAO = new IOrgTypeDAOImpl();
        //orgTypeDAO.add(orgType);

        //OrgType org = new OrgType("888");
        //orgTypeDAO.remove(org.getOrgTypeId());

        //OrgType orgType = orgTypeDAO.findById("888");
        //System.out.println(orgType.toString());

//        OrgType orgType = new OrgType("6", "数据", "");
//        List<OrgType> list = orgTypeDAO.findByLike(orgType);
//        for(OrgType org : list) {
//            System.out.println(org.toString());
//        }

        OrgType orgType = new OrgType();
        orgType.setOrgTypeName("软件开发");
        orgType.setOrgTypeId("555");
        orgTypeDAO.modify(orgType);
    }
}
