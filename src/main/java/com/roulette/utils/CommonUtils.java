package com.roulette.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.roulette.exception.BadRequestException;
import com.roulette.exception.UnauthorizedException;

public class CommonUtils {
		
		private CommonUtils() {}
		/**
		 * Pre condition.
		 * @param status the status
		 * @param message the message
		 */
		public static void preCondition(final boolean status, final String message) {
			if(status) {
				throw new BadRequestException(message);
			}
		}
		
		public static void checkAuthentication(final boolean status, final String message) {
			if(status) {
				throw new UnauthorizedException(message);
			}
		}
		
		
		public static boolean validateEmail(String email) {
			
			boolean isValid = false;
			
			if(email != null && !email.isEmpty()) {
			
				String emailRegex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
				
				Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);		
				Matcher matcher = pattern.matcher(email);
				
				isValid = matcher.matches();
			}
			
			return isValid;
		}
}
 
