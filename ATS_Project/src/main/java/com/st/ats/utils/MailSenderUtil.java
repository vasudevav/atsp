package com.st.ats.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.st.ats.constant.ATSConstants;
import com.st.ats.constant.MailConstants;
import com.st.ats.exception.handler.MailSendingIssueException;
import com.st.ats.properties.AppProperties;

/**
 * this class is used to send mail to user when user registration successful
 * then we send mail with temporary password and also link to create new
 * password
 * 
 * @author Rituraj
 *
 */
@Component
public class MailSenderUtil {

	/**
	 * enable logging for this class by using logger object
	 */
	private static final Logger log = LoggerFactory.getLogger(MailSenderUtil.class);

	/**
	 * inject JavaMailSender object for sending mail
	 */
	@Autowired
	private JavaMailSender mailSender;

	/**
	 * injecting cache object to load all the messages
	 */
	@Autowired
	private AppProperties props;

	/**
	 * this method is used to send mail to user when user details is saved in
	 * database
	 * 
	 * here we load email template and replace place holder with actual value and
	 * add inline image like company logo with temporary password and also link to
	 * create new password and also unlock account
	 * 
	 * 
	 * @param fname
	 * @param lname
	 * @param tempPwd
	 * @param email
	 * @return Boolean
	 * @throws IOException
	 * @throws MailSendingIssueException
	 */
	public Boolean sendMail(String fname, String lname, String tempPwd, String email)
			throws IOException, MailSendingIssueException {
		log.info("MailSenderUtil class sendMail method execution starts");
		boolean flag = false;
		ClassPathResource fileReader = new ClassPathResource(MailConstants.EMAIL_TEMPLATE_FILE);
		File file = fileReader.getFile();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			log.info("MailSenderUtil class  try block  execution for reading template starts");
			String template = "";
			if (bufferedReader != null) {
				log.info("MailSenderUtil class  if block is start for reading content from buffered reader");
				while (bufferedReader.ready()) {
					template = template + bufferedReader.readLine();
				}
				if (template != null && !template.equals("")) {
					log.info("MailSenderUtil class  if block is starts for replace placeholder with actual value");
					template = template.replace(MailConstants.FNAME_PHOLDER, fname);
					template = template.replace(MailConstants.LNAME_PHOLDER, lname);
					template = template.replace(MailConstants.TEMP_PWD_PHOLDER, tempPwd);
					template = template.replace(MailConstants.EMAIL_PHOLDER, email);
					log.info("MailSenderUtil class  if block is ends for replace placeholder with actual value");
				}
				log.info("MailSenderUtil class  if block is ends for reading content from buffered reader");
			}
			try {
				log.info("MailSenderUtil class  try block execution  start for sending mail ");
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, !flag);
				helper.setTo(email);
				helper.setSubject(props.getMessages().get(ATSConstants.PROP_KEY_FOR_MAIL_SUBJECT));
				helper.setText(template, true);
				helper.addInline("logoImage", new File("src\\main\\resources\\static\\images\\atslogo.png"));
				mailSender.send(message);
				flag = true;
				log.info(
						"MailSenderUtil class  try block execution  ends  for sending mail &  mail send  successfully");
			} catch (Exception e) {
				log.error("some exception is occurred while mail sending process is happen");
				e.printStackTrace();
				throw new MailSendingIssueException(MailConstants.ERROR_MSG);
			}
			log.info("MailSenderUtil class  try block execution for reading template ends");
		}
		log.info("MailSenderUtil class  sendMail() method execution completed... ");
		return flag;
	}

}
