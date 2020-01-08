package com.st.ats.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.st.ats.constant.ATSConstants;
import com.st.ats.entity.AtsUserEntity;

/**
 * 
 * this Controller is used to capture home page related request 
 * 
 * @author Rituraj
 *
 */
@Controller
@RequestMapping("/atsuser")
public class HomePageController {
	
	/**
	 * enabling logging for this class
	 */
	private static final Logger log=LoggerFactory.getLogger(HomePageController.class);
	/**
	 * method is handle get request for populating home page 
	 * of our application
	 * 
	 * @param model
	 * @return String 
	 */
	@RequestMapping("/index")
	public String getForm(Model model) {
		log.info("from HomepageController index() method execution starts");
		model.addAttribute(ATSConstants.MODE_KEY_FOR_ATSUSER, new AtsUserEntity());
		log.info("from HomepageController index() method execution ends");
		return ATSConstants.LOG_VIEW_FOR_HOME_PAGE;
	}
}
