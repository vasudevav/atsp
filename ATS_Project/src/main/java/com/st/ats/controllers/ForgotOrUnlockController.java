package com.st.ats.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.ats.constant.ATSConstants;
import com.st.ats.model.AtsUser;
import com.st.ats.model.AtsUserHelper;
import com.st.ats.properties.AppProperties;
import com.st.ats.service.AtsUserService;

/**
 * 
 * this controller is used to handle request like unlock account or forgot
 * password or password creation
 * 
 * @author Rituraj
 *
 */
@Controller
@RequestMapping("/unlock")
public class ForgotOrUnlockController {
	/**
	 * enabling logging for this class
	 */
	private static final Logger log = LoggerFactory.getLogger(ForgotOrUnlockController.class);
	/**
	 * inject service object for perform bussiness operation
	 */
	@Autowired
	private AtsUserService service;
	/**
	 * inject temporary cache object for getting messages
	 */
	@Autowired
	private AppProperties props;

	/**
	 * this method is used to populate the page for password creation
	 * 
	 * @param email
	 * @param model
	 * @return String
	 */
	@GetMapping("/index")
	public String index(@RequestParam("email") String email, Model model) {
		log.info("index method from ForgotOrUnlockController  execution starts");
		AtsUserHelper atsUserHelper = new AtsUserHelper();
		atsUserHelper.setEmail(email);
		model.addAttribute(ATSConstants.MODE_KEY_FOR_USER_HELPER, atsUserHelper);
		log.info("index method from ForgotOrUnlockController  execution ends");
		return ATSConstants.LOG_VIEW_FOR_USER_PWD_PAGE;
	}

	/**
	 * this method is used to handle post request and capture data for unlock
	 * account or reset password
	 * 
	 * @param helper
	 * @param redirect
	 * @param model
	 * @return String
	 */
	@PostMapping("/pwdCreate")
	public String handleUnlockBtn(@ModelAttribute("userhelper") AtsUserHelper helper, RedirectAttributes redirect,
			Model model) {
		log.info("handleUnlockBtn method from ForgotOrUnlockController  execution starts");
		if (helper != null) {
			log.info("handleUnlockBtn method if block exceution starts for check mail exist or not");
			final String email = helper.getEmail();
			final String tempPwd = helper.getTempPwd();
			final String password = helper.getPazzword();
			AtsUser atsUser = service.isUserExist(email, tempPwd);
			if (atsUser.getUserId() != null) {
				log.info("handleUnlockBtn method if block exceution starts for unlock record");
				Integer val = service.updateUser(password, email);
				if (val >= 1) {
					log.info(
							"handleUnlockBtn method if block exceution starts for set model key when user acc unlocked");
					model.addAttribute(ATSConstants.MODE_KEY_FOR_ROLE,atsUser.getRoleType());
				}
				log.info("handleUnlockBtn method if block exceution ends for unlock record");
			} else {
				log.info("handleUnlockBtn method else block exceution starts for send model attr");
				redirect.addFlashAttribute(ATSConstants.MODE_KEY_FOR_MSG,
						props.getMessages().get(ATSConstants.PROP_KEY_FOR_TEMP_PWD_FAIL));
				log.info("handleUnlockBtn method from ForgotOrUnlockController  execution ends");
				return ATSConstants.REDIRECT_VIEW_FOR_PRG_PATTERN_EMAIL + helper.getEmail();
			}
			log.info("handleUnlockBtn method if block exceution ends for check mail exist or not");
		}
		
		log.info("handleUnlockBtn method from ForgotOrUnlockController  execution ends");
		return ATSConstants.LOG_VIEW_FOR_USER_DASHBOARD;
	}

	/**
	 * this method is used to populated page for forgot password request
	 *
	 * @param model
	 * @return String
	 */
	@GetMapping("/forPage")
	public String forgotPwdPage(Model model) {
		log.info("forgotPwdPage method from ForgotOrUnlockController  execution starts");
		model.addAttribute(ATSConstants.MODE_KEY_FOR_ATSUSER, new AtsUser());
		log.info("forgotPwdPage method from ForgotOrUnlockController  execution ends");
		return ATSConstants.LOG_VIEW_FOR_FOGOT_PWD_PAGE;
	}

	/**
	 * this method is used to handle forgot password request and capture data and
	 * check it some condition and redirect for password creation page because
	 * forgot password and password creation same process
	 * 
	 * @param atsUser
	 * @param attributes
	 * @return String
	 * @throws Exception
	 */
	@PostMapping("/handleResetPwd")
	public String handleforgotPwd(@ModelAttribute("atsUserMod") AtsUser atsUser, RedirectAttributes attributes)
			throws Exception {
		log.info("handleforgotPwd method from ForgotOrUnlockController  execution starts");
		if (atsUser != null) {
			log.info("handleforgotPwd method if block  execution starts for fetching User Data");
			AtsUser user = service.findUserByEmailAndPhone(atsUser.getEmail(), atsUser.getPhno());
			if (user != null) {
				log.info("handleforgotPwd method if block  execution starts for checking status");
				if (user.getStatus().equalsIgnoreCase("LOCK")) {
					attributes.addFlashAttribute(ATSConstants.MODE_KEY_FOR_MSG,
							props.getMessages().get(ATSConstants.PROP_KEY_FOR_UN_LOCK_MSG));
				} else {
					if (user.getActiveSwitch() != 'Y') {
						attributes.addFlashAttribute(ATSConstants.MODE_KEY_FOR_MSG,
								props.getMessages().get(ATSConstants.PROP_KEY_FOR_DEACTIVE_MSG));
					}else {
					log.info("handleforgotPwd method else block  execution starts for checking status");
					Integer val = service.resetPwd(user);
					if (val >= 1) {
						log.info("handleforgotPwd method if  block  execution");
						attributes.addFlashAttribute(ATSConstants.MODE_KEY_FOR_MSG,
								props.getMessages().get(ATSConstants.PROP_KEY_FOR_FORGOT_PAGE_ML_SENT));
					}
					log.info("handleforgotPwd method if block  execution starts for checking starts");
				}
				}	
			} else {
				log.info("handleforgotPwd method else block  execution");
				attributes.addFlashAttribute(ATSConstants.MODE_KEY_FOR_MSG,
						props.getMessages().get(ATSConstants.PROP_KEY_FOR_FORGOT_PAGE_FAIL));
			}
		}
		log.info("handleforgotPwd method from ForgotOrUnlockController  execution ends");
		return ATSConstants.REDIRECT_VIEW_FOR_FRGT_PGE_PRG_PATTERN;
	}

}
