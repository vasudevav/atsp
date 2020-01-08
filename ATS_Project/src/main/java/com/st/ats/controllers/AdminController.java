package com.st.ats.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.st.ats.constant.ATSConstants;
import com.st.ats.model.AtsUser;
import com.st.ats.properties.AppProperties;
import com.st.ats.service.AdminService;
import com.st.ats.service.AtsUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	/**
	 * injecting service class object for performing business operations
	 */
	@Autowired
	private AtsUserService userService;
	/**
	 * inject temporary cache class object to get messages for response to user
	 */
	@Autowired
	private AdminService adminService;

	@Autowired
	private AppProperties prop;

	@RequestMapping("/index")
	public String loadRegPage(Model model, HttpServletRequest req) {
		AtsUser atsUser = new AtsUser();
		String roleType = req.getParameter("role");
		if (roleType != null) {
			atsUser.setRoleType(roleType);
		}
		model.addAttribute(ATSConstants.MODE_KEY_FOR_ATSUSER, atsUser);
		return ATSConstants.LOG_VIEW_FOR_ADMIN_REG;
	}

	@PostMapping("/register")
	public String handleRegisterBtn(@ModelAttribute("atsUserMod") AtsUser atsUser, RedirectAttributes attributes)
			throws Exception {
		userService.saveUserDtls(atsUser);
		attributes.addFlashAttribute(ATSConstants.MODE_KEY_FOR_SUCC_MSG,
				prop.getMessages().get(ATSConstants.MODE_KEY_FOR_SUCC_MSG));
		return ATSConstants.REDIRECT_VIEW_FOR_PRG_PATTERN;
	}

	@RequestMapping("unlockAccs")
	public String AllUnlockAccounts(Model model) {
		List<AtsUser> list = adminService.findAllUnlockUser();
		if (list != null) {
			model.addAttribute(ATSConstants.MODE_KEY_FOR_ROLE_LIST, list);
		} else {
			String txtMsg = prop.getMessages().get(ATSConstants.PROP_KEY_AGENCY_NOT_FOUND);
			txtMsg = txtMsg.replace("{role}", "");
			model.addAttribute(ATSConstants.MODE_KEY_FOR_MSG, txtMsg);
		}
		return this.retViewNamebasedOnRole("");
	}

	@RequestMapping("/findAgencies/{role}")
	public String handleViewAdmin(@PathVariable("role") String role, Model model) {
		List<AtsUser> list = adminService.findBasedOnRoles(role);
		if (list != null) {
			model.addAttribute(ATSConstants.MODE_KEY_FOR_ROLE_LIST, list);
		} else {
			String txtMsg = prop.getMessages().get(ATSConstants.PROP_KEY_AGENCY_NOT_FOUND);
			txtMsg = txtMsg.replace("{role}", role);
			model.addAttribute(ATSConstants.MODE_KEY_FOR_MSG, txtMsg);
		}
		return this.retViewNamebasedOnRole(role);
	}

	@GetMapping("/deactvRole")
	public String deactiveBasedOnRole(HttpServletRequest req, Model model) {
		String uid = req.getParameter("uid");
		String role = req.getParameter("role");
		if (null == role) {
			role = "";
		}
		List<AtsUser> list = adminService.deactivateBasedOnRole(Integer.parseInt(uid), role);
		if (list != null) {
			model.addAttribute(ATSConstants.MODE_KEY_FOR_ROLE_LIST, list);
		} else {
			String txtMsg = prop.getMessages().get(ATSConstants.PROP_KEY_AGENCY_NOT_FOUND);
			txtMsg = txtMsg.replace("{role}", role);
			model.addAttribute(ATSConstants.MODE_KEY_FOR_MSG, txtMsg);
		}
		return this.retViewNamebasedOnRole(role);
	}

	@GetMapping("/actvRole")
	public String activeBasedOnRole(HttpServletRequest req, Model model) {
		String uid = req.getParameter("uid");
		String role = req.getParameter("role");
		if (null == role) {
			role = "";
		}
		List<AtsUser> list = adminService.activateBasedOnRole(Integer.parseInt(uid), role);
		if (list != null) {
			model.addAttribute(ATSConstants.MODE_KEY_FOR_ROLE_LIST, list);
		} else {
			String txtMsg = prop.getMessages().get(ATSConstants.PROP_KEY_AGENCY_NOT_FOUND);
			txtMsg = txtMsg.replace("{role}", role);
			model.addAttribute(ATSConstants.MODE_KEY_FOR_MSG, txtMsg);
		}
		return this.retViewNamebasedOnRole(role);
	}

	@RequestMapping("/activateUsers")
	public @ResponseBody String getActiveBasedOnRole(@RequestParam("role") String role) throws Exception {
		List<AtsUser> list = adminService.findActiveBasedOnRoles(role);
		ObjectMapper mapper = new ObjectMapper();
		String activateList = mapper.writeValueAsString(list);
		return activateList;
	}

	@RequestMapping("/deActivateUsers")
	public @ResponseBody String getDeActiveBasedOnRole(@RequestParam("role") String role) throws Exception {
		List<AtsUser> list = adminService.findDeActiveBasedOnRoles(role);
		ObjectMapper mapper = new ObjectMapper();
		String activateList = mapper.writeValueAsString(list);
		return activateList;
	}

	@RequestMapping("/AllUserWithRole")
	public @ResponseBody String allUnlockuser(@RequestParam("role") String role) throws Exception {
		List<AtsUser> list = adminService.findBasedOnRoles(role);
		ObjectMapper mapper = new ObjectMapper();
		String activateList = mapper.writeValueAsString(list);
		return activateList;
	}

	private String retViewNamebasedOnRole(String role) {
		if (null != role && "".equals(role)) {
			return ATSConstants.LOG_VIEW_FOR_ALL_ACCOUNT;
		}

		if (role.equals("ADMIN")) {
			return ATSConstants.LOG_VIEW_FOR_ADMIN_LIST;
		} else if (role.equals("USER")) {
			return ATSConstants.LOG_VIEW_FOR_USER_LIST;
		} else {
			return ATSConstants.LOG_VIEW_FOR_AGENCY_LIST;
		}
	}

}
