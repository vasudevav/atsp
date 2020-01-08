package com.st.ats.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.ats.entity.AtsUserEntity;
import com.st.ats.model.AtsUser;
import com.st.ats.repositories.AtsUserTabRepository;
import com.st.ats.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AtsUserTabRepository repository;
	
	@Override
	public List<AtsUser> findAllUnlockUser() {
		List<AtsUser> entityToModel = null;
		List<AtsUserEntity> users =repository.findAllUnlockUser();
		if (!users.isEmpty())
			entityToModel = convertingEntityToModel(users);
		return entityToModel;
	}

	@Override
	public List<AtsUser> findBasedOnRoles(String role) {
		List<AtsUser> entityToModel = null;
		List<AtsUserEntity> users=null;
		
		if(null!=role && "".equals(role))
			users =repository.findAllUnlockUser();
		else
		 users = repository.findBasedOnRoles(role);
		
		
		if (!users.isEmpty())
			entityToModel = convertingEntityToModel(users);
		return entityToModel;
	}

	@Override
	public List<AtsUser> findDeActiveBasedOnRoles(String role) {
		List<AtsUser> entityToModel = null;
		List<AtsUserEntity> users = repository.findDeActiveBasedOnRoles(role);
		if (!users.isEmpty())
			entityToModel = convertingEntityToModel(users);
		return entityToModel;
	}

	@Override
	public List<AtsUser> findActiveBasedOnRoles(String role) {
		List<AtsUser> entityToModel = null;
		List<AtsUserEntity> users = repository.findActiveBasedOnRoles(role);
		if (!users.isEmpty())
			entityToModel = convertingEntityToModel(users);
		return entityToModel;
	}

	@Override
	public List<AtsUser> deactivateBasedOnRole(Integer uid, String role) {
		List<AtsUser> entityToModel = null;
		Integer flag = repository.deactivateBasedOnRole(uid);
		if (flag != null) {
			entityToModel = this.findBasedOnRoles(role);
		}
		return entityToModel;
	}
	@Override
	public List<AtsUser> activateBasedOnRole(Integer uid, String role) {
		List<AtsUser> entityToModel = null;
		Integer flag = repository.activateBasedOnRole(uid);
		if (flag != null) {
			entityToModel = this.findBasedOnRoles(role);
		}
		return entityToModel;

	}

	private List<AtsUser> convertingEntityToModel(List<AtsUserEntity> lists) {
		List<AtsUser> atsUsers = new ArrayList<>();

		lists.forEach(user -> {
			AtsUser atsUser = new AtsUser();
			BeanUtils.copyProperties(user, atsUser);
			atsUsers.add(atsUser);
		});
		return atsUsers;
	}

}