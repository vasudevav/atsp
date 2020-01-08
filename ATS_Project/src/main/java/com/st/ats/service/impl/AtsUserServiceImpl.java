package com.st.ats.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.ats.constant.ATSConstants;
import com.st.ats.entity.AtsUserEntity;
import com.st.ats.genertor.PasswordGenrator;
import com.st.ats.model.AtsUser;
import com.st.ats.repositories.AtsUserTabRepository;
import com.st.ats.service.AtsUserService;
import com.st.ats.utils.ForgotMailSenderUtil;
import com.st.ats.utils.MailSenderUtil;

/**
 * This class is used for implementation AtsUserService to perform business
 * operation or provide body for all methods
 * 
 * @author Rituraj
 *
 */
@Service
public class AtsUserServiceImpl implements AtsUserService {

	/**
	 * enable logging for this class
	 */
	private static final Logger log = LoggerFactory.getLogger(AtsUserServiceImpl.class);

	/**
	 * inject repository object to perform database side operation
	 */
	@Autowired
	private AtsUserTabRepository userRepo;
	/**
	 * injecting mail service object for send mail when user Reg. is happen send
	 * mail
	 */
	@Autowired
	private MailSenderUtil mailSenderUtil;
	/**
	 * injecting forgot mail service object for sending mail for user when he forgot
	 * his password
	 * 
	 */
	@Autowired
	private ForgotMailSenderUtil forgotMailSenderUtil;

	/**
	 * method is used to save user data with some other data which we send manually
	 * 
	 */
	@Override
	public Integer saveUserDtls(AtsUser atsUser) throws Exception {
		log.info("saveDtls method from  Service impl class  is start");
		Integer userId = null;
		AtsUserEntity entity = new AtsUserEntity();
		BeanUtils.copyProperties(atsUser, entity);
		entity.setPazzword(PasswordGenrator.getPass());
		if(atsUser.getRoleType()==null) {
		entity.setRoleType(ATSConstants.KEY_FOR_USER_ROLL_NAME);
		}
		entity.setStatus("LOCK");
		entity.setActiveSwitch('Y');
		AtsUserEntity userEntity = userRepo.save(entity);
		log.info("" + userEntity);
		if (userEntity != null) {
			log.info("saveDtls  method if block execution starts  ");
			mailSenderUtil.sendMail(userEntity.getFname(), userEntity.getLname(), userEntity.getPazzword(),
					userEntity.getEmail());
			userId = userEntity.getUserId();
			log.info("saveDtls  method if block execution ends ");
		}
		log.info("saveDtls method from  Service impl class  is ends");
		return userId;
	}

	/**
	 * method is used cheque user is exist or not based on mail or password
	 * 
	 */
	@Override
	public AtsUser isUserExist(String email, String password) {
		log.info("isuserExist method from AtsUserServiceImpl execution starts");
		AtsUser atsUser = new AtsUser();
		Optional<AtsUserEntity> userData = userRepo.getUserData(email, password);
		if (userData.isPresent()) {
			log.info("isuserExist method if block  execution  starts");
			AtsUserEntity userEntity = userData.get();
			BeanUtils.copyProperties(userEntity, atsUser);
			log.info("isuserExist method if block  execution  ends");
		}
		log.info("isuserExist method from AtsUserServiceImpl execution ends");
		return atsUser;
	}

	/**
	 * this method is used for update user record or unlock account
	 * 
	 */
	@Override
	public Integer updateUser(String password, String email) {
		log.info("updateUser method from AtsUserServiceImpl execution starts");
		Integer updateValue = userRepo.updatePassWord(password, email);
		log.info("updateUser method from AtsUserServiceImpl execution ends");
		return updateValue;
	}

	/**
	 * this is method is used for reset user password and send mail for reset
	 * password
	 * 
	 */
	@Override
	public Integer resetPwd(AtsUser atsUser) throws Exception {
		log.info("reset method from AtsUserServiceImpl execution starts");
		Integer val = null;
		String pass = PasswordGenrator.getPass();
		if (pass != null) {
			log.info("updateUser method  if block execution is started");
			val = userRepo.updatePassWord(pass, atsUser.getEmail());
			forgotMailSenderUtil.sendMail(atsUser.getFname(), atsUser.getLname(), pass, atsUser.getEmail());
			log.info("updateUser method  if block execution is ended");
		}
		log.info("reset method from AtsUserServiceImpl execution ends");
		return val;
	}

	/**
	 * this method is used to get user Data based email and phone number
	 * 
	 */
	@Override
	public AtsUser findUserByEmailAndPhone(String email, Long phno) {
		log.info("findUserByEmailAndPhone method from AtsUserServiceImpl execution  starts");
		AtsUser atsUser = null;
		Optional<AtsUserEntity> userEntity = userRepo.findAtsUserByEmailAndPhno(email, phno);
		if (userEntity.isPresent()) {
			log.info("findUserByEmailAndPhone method if block execution  starts");
			atsUser = new AtsUser();
			AtsUserEntity entity = userEntity.get();
			BeanUtils.copyProperties(entity, atsUser);
			log.info("findUserByEmailAndPhone method if block execution  ends");
		}
		log.info("findUserByEmailAndPhone method from AtsUserServiceImpl execution  completed");
		return atsUser;
	}

	/**
	 * this is used to fetch user data based on email id to check confirmation email
	 * is unique
	 * 
	 */
	@Override
	public Integer findUserByEmail(String email) {
		
		log.info("findUserByEmail method from AtsUserServiceImpl execution  starts");
		Integer status = userRepo.findAtsUserByEmail(email);
		log.info("findUserByEmail method from AtsUserServiceImpl execution  ends");
		return status;
	}
}