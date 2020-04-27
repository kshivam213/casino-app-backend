package com.roulette.user.interfaces;

import com.roulette.models.AppResponse;
import com.roulette.user.models.UserModel;

public interface UserInterface {
	
	public AppResponse registerUser(UserModel userModel);
	public AppResponse enterCasino(UserModel userModel);
	public AppResponse rechargeBalance(UserModel userModel);
	public AppResponse listAllBettableGame(Long userId);
	public AppResponse betOnGame(UserModel userModel);
	public AppResponse cashOut(Long userId);
	
}
