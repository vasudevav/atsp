package com.st.ats.service;

import com.st.ats.model.AtsUser;
/**
 * This is used to declare  all methods for service class 
 * 
 * @author Rituraj
 *
 */
public interface AtsUserService {
	
	/**
	 * This method is used to save user data in database
	 * 
	 * @param atsUser
	 * @return Integer
	 * @throws Exception
	 */
	public Integer saveUserDtls(AtsUser atsUser) throws Exception;
	
	/**
	 * this method is used to fetch data based on email id and password  
	 * also used for check that email id and password is exist or not
	 * 
	 * @param email
	 * @param password
	 * @return AtsUser
	 */
	public AtsUser isUserExist(String email,String password);
	
	/**
	 * 
	 * this method is used to update user data or change status from lock to unclock 
	 * 
	 * @param password
	 * @param email
	 * @return Integer
	 */
	public Integer updateUser(String password,String email);
	
	/**
	 * this is used to fetch user data based on email id 
	 * or also used  that method for checking unique email when user register 
	 * 
	 * @param email
	 * @return AtsUser
	 */
	public Integer  findUserByEmail(String email);
	
	/**
	 * this method is used to fetch data based on email id and phone number
	 *  
	 * @param email
	 * @param phno
	 * @return AtsUser
	 */
	public AtsUser findUserByEmailAndPhone(String email ,Long phno);
	
	/**
	 * this method is used to reset user password
	 * 
	 * @param atsUser
	 * @return Inetegr
	 * @throws Exception
	 */
	public  Integer resetPwd(AtsUser atsUser) throws Exception;
	
	
}
