package com.xx.sm.framework.model.dao.impl;

import com.xx.sm.framework.model.entity.OrgType;

import java.util.List;

public interface IOrgTypeDAO {
    public boolean add(OrgType orgType);
    public boolean remove(String orgTypeId);
    public boolean modify(OrgType orgType);
    public OrgType findById(String orgTypeId);
    public List<OrgType> findByLike(OrgType orgType);
}
