package com.xx.sm.framework.model.dao.impl;

import java.util.List;

import com.xx.sm.framework.model.entity.MisUser;

public interface IMisUserDAO {
	public boolean add(MisUser misUser);
	public boolean remove(String id);
	public boolean modify(MisUser misUser);
	public MisUser findByName(String name);
	public List<MisUser> findByLike(MisUser misUser);
	
	
}
