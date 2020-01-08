package com.st.ats.constant;
/**
 * 
 * This  interface is used to declare application related  String as a constants
 * @author Rituraj
 *
 */
public interface ATSConstants {
	/**
	 * this is used modelattribute for atsUser class 
	 */
	public static final String MODE_KEY_FOR_ATSUSER = "atsUserMod";
	
	public static final String MODE_KEY_FOR_ROLE = "role";
	/**
	 * this is used modelattribute for atsUserHelper  
	 */
	public static final String MODE_KEY_FOR_USER_HELPER = "userhelper";
	/**
	 * this is used as key to send msg from controller to ui 
	 */
	public static final String MODE_KEY_FOR_MSG = "msg";
	/**
	 * this is used as key to send success msg from controller to ui
	 */
	public static final String MODE_KEY_FOR_SUCC_MSG = "succMsg";
	
	
	public static final String MODE_KEY_FOR_VHCL_SUMMARY="vhclSummary";
	
	
	public static final String MODE_KEY_FOR_ROLE_LIST="roleList";
	
	
	/**
	 * this is used for logical view name for home page or front page of application
	 */
	public static final String LOG_VIEW_FOR_HOME_PAGE = "homePage";
	/**
	 * this is used for logical view name for user Dashboard page
	 */
	public static final String LOG_VIEW_FOR_USER_DASHBOARD = "userDashboard";
	/**
	 * use for logical view name for User Registration page
	 */
	public static final String LOG_VIEW_FOR_USER_REG_PAGE = "userRegPage";
	/**
	 * this is use as logical view name  for Password creation page
	 */
	public static final String LOG_VIEW_FOR_USER_PWD_PAGE = "passwordCreation";
	/**
	 * this is use for logical view name for forgot password page
	 */
	public static final String LOG_VIEW_FOR_FOGOT_PWD_PAGE = "forgotPassword";
	
	
	public static final String LOG_VIEW_FOR_PURCHASE_TAG = "searchVehicle";

	
	public static final String LOG_VIEW_FOR_ADMIN_REG="adminRegPage";
	
	
	public static final String LOG_VIEW_FOR_AGENCY_LIST="viewAgency";
	
	public static final String LOG_VIEW_FOR_USER_LIST="viewUsers";
	
	
	public static final String LOG_VIEW_FOR_ADMIN_LIST="viewAdmin";
	
	public static final String LOG_VIEW_FOR_ALL_ACCOUNT="viewAllAccs";
	
	/**
	 * this is use to redirect from forgot pwd page to pwd creation page with one query parameter
	 */

	public static final String REDIRECT_VIEW_FOR_PRG_PATTERN_EMAIL = "redirect:index?email=";
	/**
	 * this is use as redirection to avoid DoublePosting problem by using Post-Redirect-Get 
	 */
	public static final String REDIRECT_VIEW_FOR_PRG_PATTERN = "redirect:index";
	
	public static final String REDIRECT_VIEW_FOR_PRG_PATTERN_HOME_PG = "redirect:/atsuser/index";
	/**
	 * this is used to redirect for forgot page here also follow P-R-G pattern
	 */
	public static final String REDIRECT_VIEW_FOR_FRGT_PGE_PRG_PATTERN = "redirect:forPage";
	/**
	 * using as reading value from cache or map object that we store from yml file  
	 */
	public static final String PROP_KEY_FOR_BOARD_MSG = "userboard";	
	/**
	 * using as reading value from cache or map object that we store from yml file  
	 */
	public static final String PROP_KEY_FOR_UN_LOCK_MSG = "unlockMsg";
	/**
	 * using as reading value from cache or map object that we store from yml file  
	 */
	public static final String PROP_KEY_FOR_SIGN_FAILED_MSG = "signFailed";
	/**
	 * using as reading value from cache or map object that we store from yml file  
	 */
	public static final String PROP_KEY_FOR_MAIL_SUBJECT = "mailSubject";
	/**
	 * using as reading value from cache or map object that we store from yml file  
	 */
	public static final String PROP_KEY_FOR_TEMP_PWD_FAIL = "tempPwdFail";
	/**
	 * using as reading value from cache or map object that we store from yml file  
	 */
	public static final String PROP_KEY_FOR_FORGOT_PAGE_FAIL = "frgtFail";
	/**
	 * using as reading value from cache or map object that we store from yml file  
	 */
	public static final String PROP_KEY_FOR_FORGOT_PAGE_ML_SENT = "frgmailSent";

	
	public static final String PROP_KEY_FOR_DEACTIVE_MSG="deactive";
	
	/**
	 * this is used to insert role as user when any one register in our application
	 * for separating admin and user and agency   
	 */
	public static final String KEY_FOR_USER_ROLL_NAME = "USER";
	
	public static final String KEY_FOR_ADMIN_ROLL_NAME = "ADMIN";
	
	public static final String KEY_SUPER_ADMIN_MAIL="adminMail";
	
	public static final String KEY_SUPER_ADMIN_PWD="adminPwd";
	
	
	public static final String KEY_FOR_REST_API_URL="restApiUrl";
	
	public static final String PROP_KEY_FOR_VHCL_REG_FAILED="vhclregnumfail";
	
	public static final String PROP_KEY_FOR_VHCL_REG_FOUND="vhclregFound";
	
	
	public static final String PROP_KEY_AGENCY_NOT_FOUND="agencyNotFnd";
	
	
	
	
	
}
