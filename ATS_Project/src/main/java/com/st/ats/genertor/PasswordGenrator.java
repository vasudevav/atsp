package com.st.ats.genertor;

import java.util.UUID;
/**
 * this class is used to create temporary password  
 * 
 * @author Rituraj
 */
public class PasswordGenrator {

	/**
	 *private constructor is used to avoid creating 
	 *object for this class	
	 */
	private PasswordGenrator() {}
	
	/**
	 * this method is used  for generating temporary password
	 * 
	 * @return String 
	 */
	public   static String getPass() {
		String pazzword = UUID.randomUUID().toString().replaceAll("-", "").substring(0,10);
		return pazzword;
	}
}
