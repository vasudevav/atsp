package com.st.ats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.ats.constant.ATSConstants;
import com.st.ats.domain.VehicleSummary;
import com.st.ats.properties.AppProperties;
import com.st.ats.service.TagService;

@Controller
@RequestMapping("/tag")
public class TagController {

	@Autowired
	private AppProperties props;

	@Autowired
	private TagService tagService;

	@GetMapping("/index")
	public String loadPurchasetagForm() {
		return ATSConstants.LOG_VIEW_FOR_PURCHASE_TAG;
	}

	@PostMapping("/searchVhclDtls")
	public String handleSearchButton(@RequestParam("regNum") String regNum, RedirectAttributes model) {
		if (regNum != null) {
			VehicleSummary vehicleSummary = tagService.invokeRestApi(regNum);
			if (vehicleSummary != null) {
				model.addFlashAttribute(ATSConstants.MODE_KEY_FOR_MSG,
						props.getMessages().get(ATSConstants.PROP_KEY_FOR_VHCL_REG_FOUND));
				
			model.addFlashAttribute(ATSConstants.MODE_KEY_FOR_VHCL_SUMMARY, vehicleSummary);
			} else {
				model.addFlashAttribute(ATSConstants.MODE_KEY_FOR_MSG,
						props.getMessages().get(ATSConstants.PROP_KEY_FOR_VHCL_REG_FAILED));
			}
		}
		return ATSConstants.REDIRECT_VIEW_FOR_PRG_PATTERN;
	}

}
