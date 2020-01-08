package com.st.ats.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.ats.constant.ATSConstants;
import com.st.ats.model.AtsUser;
import com.st.ats.properties.AppProperties;
import com.st.ats.service.AtsUserService;

/**
 * this controller used to handll user sign up related request
 *
 * @author Rituraj
 *
 */
@Controller
@RequestMapping("/userReg")
public class UserRegController {
	/**
	 * Enable logging for this class
	 */
	private static final Logger log = LoggerFactory.getLogger(UserRegController.class);
	/**
	 * injecting service class object for performing business operations
	 */
	@Autowired
	private AtsUserService userService;
	/**
	 * inject temporary cache class object to get messages for response to user
	 */
	@Autowired
	private AppProperties prop;

	/**
	 * this method is used to populate user registration page with form backing
	 * object
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping("/index")
	public String signUpIndex(Model model) {
		log.info("form UserRegController signUpIndex() method execution starts");
		model.addAttribute(ATSConstants.MODE_KEY_FOR_ATSUSER, new AtsUser());
		String str = (String) model.getAttribute(ATSConstants.MODE_KEY_FOR_SUCC_MSG);
		if (str != null) {
			log.info("form UserRegController signUpIndex() if block ");
			model.addAttribute(ATSConstants.MODE_KEY_FOR_SUCC_MSG, str);
		}
		log.info("form UserRegController signUpIndex() method execution Ends");
		return ATSConstants.LOG_VIEW_FOR_USER_REG_PAGE;
	}

	/**
	 * this method is used to capture user data as model attribute object and send
	 * service layer to perform some business operations
	 * 
	 * @param atsUser
	 * @param attributes
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handleSignUpBtn(@ModelAttribute("atsUserMod") AtsUser atsUser, RedirectAttributes attributes)
			throws Exception {
		log.info("form UserRegController handleSignUpBtn() method execution starts");
		Integer msg = userService.saveUserDtls(atsUser);
		attributes.addFlashAttribute(ATSConstants.MODE_KEY_FOR_SUCC_MSG,
				prop.getMessages().get(ATSConstants.MODE_KEY_FOR_SUCC_MSG));
		log.info("form UserRegController handleSignUpBtn() method execution ends" + msg);
		return ATSConstants.REDIRECT_VIEW_FOR_PRG_PATTERN;
	}

	/**
	 * here method is used to handle sign request and check some condition based on
	 * condition return view and message
	 * 
	 * @param atsUser
	 * @param attributes
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/handleSignIn", method = RequestMethod.POST)
	public String handleSingInBtn(@ModelAttribute("atsUserMod") AtsUser atsUser, RedirectAttributes attributes,
			Model model) {
		log.info("form UserRegController handleSingInBtn() method execution starts");
		String email = prop.getMessages().get(ATSConstants.KEY_SUPER_ADMIN_MAIL);
		String pwd = prop.getMessages().get(ATSConstants.KEY_SUPER_ADMIN_PWD);
		if (atsUser != null && atsUser.getEmail() != null) {
			log.info("form UserRegController handleSingInBtn() if block starts");
			if (email.equals(atsUser.getEmail()) && pwd.equals(atsUser.getPazzword())) {
				model.addAttribute(ATSConstants.MODE_KEY_FOR_ROLE, ATSConstants.KEY_FOR_ADMIN_ROLL_NAME);
				return ATSConstants.LOG_VIEW_FOR_USER_DASHBOARD;
			}
			AtsUser user = userService.isUserExist(atsUser.getEmail(), atsUser.getPazzword());
			if (user.getUserId() != null) {
				log.info("form UserRegController handleSingInBtn() if block starts for check id");
				if (user.getStatus().equalsIgnoreCase("LOCK")) {
					log.info("form UserRegController handleSingInBtn() if block start for check status");
					attributes.addFlashAttribute(ATSConstants.MODE_KEY_FOR_MSG,
							prop.getMessages().get(ATSConstants.PROP_KEY_FOR_UN_LOCK_MSG));
					log.info("form UserRegController handleSingInBtn() if block end for check status");
				} else {
					if (user.getActiveSwitch() != 'Y') {
						attributes.addFlashAttribute(ATSConstants.MODE_KEY_FOR_MSG,
								prop.getMessages().get(ATSConstants.PROP_KEY_FOR_DEACTIVE_MSG));
					} else {
						log.info("form UserRegController handleSingInBtn() else block starts ");
						if (user.getRoleType() != null) {
							log.info("form UserRegController handleSingInBtn() if block starts ");
							model.addAttribute(ATSConstants.MODE_KEY_FOR_ROLE, user.getRoleType());
							log.info("form UserRegController handleSingInBtn() method execution ends");
							return ATSConstants.LOG_VIEW_FOR_USER_DASHBOARD;
						}
						log.info("form UserRegController handleSingInBtn() else block ends");
					}
				}
			} else {
				log.info("form UserRegController handleSingInBtn() else block starts ");
				attributes.addFlashAttribute(ATSConstants.MODE_KEY_FOR_MSG,
						prop.getMessages().get(ATSConstants.PROP_KEY_FOR_SIGN_FAILED_MSG));
			}
			log.info("form UserRegController handleSingInBtn() if block ends");
		}
		log.info("form UserRegController handleSingInBtn() method execution ends");
		return ATSConstants.REDIRECT_VIEW_FOR_PRG_PATTERN_HOME_PG;
	}

	/**
	 * this method is used to capture Ajax call .when user creating account we need
	 * to check that mail id is unique or already exist
	 * 
	 * @param email
	 * @return String
	 */
	@RequestMapping(value = "/uniqueEmail")
	public @ResponseBody String isEmailUnique(@RequestParam("email") String email) {
		if (email != null) {
			Integer val = userService.findUserByEmail(email.trim());
			System.out.println(val);
			if (val >= 1) {
				return "Duplicate";
			} else {
				return "Unique";
			}
		}
		return null;

	}

}
