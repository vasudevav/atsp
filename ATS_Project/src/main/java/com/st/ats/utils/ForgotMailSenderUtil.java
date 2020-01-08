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
 * this class is used to load the forgot email template and set value based on
 * placeholder and send reset password
 * 
 * @author Rituraj
 *
 */
@Component
public class ForgotMailSenderUtil {

	/**
	 * enable logging for this class
	 */
	private static final Logger log = LoggerFactory.getLogger(ForgotMailSenderUtil.class);

	/**
	 * inject javaMailsender object for sending mail
	 */
	@Autowired
	private JavaMailSender mailSender;

	/**
	 * injecting for temporary cache object for getting messages
	 */
	@Autowired
	private AppProperties props;

	/**
	 * This method id used to send mail when user want to forgot his password
	 * 
	 * here we load forgot email template and replace place holder with actual value
	 * and also add inline image for mail, ex: company logo and send mail to user
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
		log.info("ForgotMailSenderUtil class sendMail method execution starts");
		boolean flag = false;
		ClassPathResource fileReader = new ClassPathResource(MailConstants.FORGOT_EMAIL_TEMPLATE_FILE);
		File file = fileReader.getFile();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			log.info("ForgotMailSenderUtil class  try block  execution for reading template starts");
			String template = "";
			if (bufferedReader != null) {
				log.info("ForgotMailSenderUtil class  if block is start for reading content from buffered reader");
				while (bufferedReader.ready()) {
					template = template + bufferedReader.readLine();
				}
				if (template != null && !template.equals("")) {
					log.info(
							"ForgotMailSenderUtil class  if block is starts for replace placeholder with actual value");
					template = template.replace(MailConstants.FNAME_PHOLDER, fname);
					template = template.replace(MailConstants.LNAME_PHOLDER, lname);
					template = template.replace(MailConstants.TEMP_PWD_PHOLDER, tempPwd);
					template = template.replace(MailConstants.EMAIL_PHOLDER, email);
					log.info("ForgotMailSenderUtil class  if block is ends for replace placeholder with actual value");
				}
				log.info("ForgotMailSenderUtil class  if block is ends for reading content from buffered reader");
			}
			try {
				log.info("ForgotMailSenderUtil class  try block execution  start for sending mail ");
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, !flag);
				helper.setTo(email);
				helper.setSubject(props.getMessages().get(ATSConstants.PROP_KEY_FOR_MAIL_SUBJECT));
				helper.setText(template, true);
				helper.addInline("logoImage", new File("src\\main\\resources\\static\\images\\atslogo.png"));
				mailSender.send(message);
				flag = true;
				log.info(
						"ForgotMailSenderUtil class  try block execution  ends  for sending mail &  mail send  successfully");
			} catch (Exception e) {
				log.error("some exception is occurred while mail sending process is happen");
				throw new MailSendingIssueException(MailConstants.ERROR_MSG);
			}
			log.info("ForgotMailSenderUtil class  try block execution for reading template ends");
		}
		log.info("ForgotMailSenderUtil class  sendMail() method execution completed... ");
		return flag;
	}

}
