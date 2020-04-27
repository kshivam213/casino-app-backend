package com.roulette.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roulette.dao.UserRepository;
import com.roulette.entity.Users;
import com.roulette.utils.CommonUtils;

@Service
public class UserDaoImpl {

	@Autowired
	private UserRepository userRepo;

	public Users saveUser(Users user) {

		CommonUtils.preCondition(user == null, "User object can't be null for save");
		return userRepo.save(user);
	}

	public Users updateUser(Users user) {

		CommonUtils.preCondition(user == null, "Can't update null object");
		CommonUtils.preCondition(user.getUserId() != null, "Id can't be null for updating user");

		return userRepo.save(user);
	}

	public Users findUserById(Long userId) {
		Users user = userRepo.findOne(userId);
		CommonUtils.preCondition(user == null, "Invalid Id");

		return user;
	}

	public void deleteUser(Users user) {
		userRepo.delete(user);
	}
}
