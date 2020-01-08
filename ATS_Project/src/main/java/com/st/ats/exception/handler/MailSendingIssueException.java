package com.st.ats.exception.handler;
/**
 * this class behaves as custom Exception when any issue occurred in mail sending classes 
 * 
 * @author Rituraj
 *
 */
public class MailSendingIssueException extends Exception {

	
	/**
	 * this is serial version uid for this Exception
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * this is default exception for throw exception without 
	 * any message
	 */
	public MailSendingIssueException() {
	
	}
	/**
	 * this is used to throw exception with message
	 * @param msg
	 */
	public MailSendingIssueException(String msg) {
		super(msg);
	}
	
}
