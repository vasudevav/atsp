package com.st.ats.constant;

public interface MailConstants {
	
	/**
	 * this is used to replace first_name place holder from mail template 
	 */
	public static final String FNAME_PHOLDER="{FIRST_NAME}";
	/**
	 * this is used to replace last_name place holder from mail template 
	 */
	public static final String LNAME_PHOLDER="{LAST_NAME}";
	/**
	 * this is used to replace temp_pwd place holder from mail template 
	 */
	public static final String TEMP_PWD_PHOLDER="{TEMP_PWD}";
	/**
	 * this is used to replace email_holder place holder from mail template 
	 */	
	public static final String EMAIL_PHOLDER="{EMAIL}";
	/**
	 * this is used to provide email template file  name for resource 
	 */
	public static final String EMAIL_TEMPLATE_FILE="email.txt";
	/**
	 * this is used to provide forgot email template fiel name for resource
	 */
	public static final String FORGOT_EMAIL_TEMPLATE_FILE="forgotemail.txt";
	/**
	 * this is used to return error message if any MailIssueException occurred in
	 * mail utils class 
	 */
	public static final String ERROR_MSG="some isssue occured";
	
	
			
}

