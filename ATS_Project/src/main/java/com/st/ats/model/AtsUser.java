package com.st.ats.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
/**
 * this class is used to model class for application 
 * and use for binding with form or behave as ModelAttribute 
 * 
 * @author Rituraj
 *
 */
@Data
public class AtsUser {
	
	private Integer userId;
	private String fname;
	private String lname;
	private String email;
	private String pazzword;
	private String gender;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-dd-MM")
	private Date  dob;
	private Long phno;
	private String zzn;
	private String roleType;
	private String  status;
	private Character activeSwitch;
	
}
