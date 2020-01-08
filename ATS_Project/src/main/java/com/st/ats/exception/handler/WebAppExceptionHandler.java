package com.st.ats.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * this used global exception handler for 
 * any type of exception comes in our web application or C2B application 
 * side  
 * 
 * @author Rituraj
 *
 */
@ControllerAdvice
public class WebAppExceptionHandler {
	
	
	/**
	 * this handler is used to handle exception when in mail sending time some issue 
	 * 
	 * @return String 
	 */
	@ExceptionHandler(MailSendingIssueException.class)
	public String mailIssueExce(){
		
		
		return "errorPage";
	}
	/**
	 * this use to capable handle All other exception in web application
	 * 
	 * @return String
	 */
	@ExceptionHandler(Exception.class)
	public String  ALlerrorPage() {
		
		return "errorPage";
	}
}
