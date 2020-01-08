package com.st.ats.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


import lombok.Data;
/**
 * This class is able to capture all data comes in VehicleRegistrationDtls Ui 
 * and send in service to store in database 
 * and used that class refrence in VehicleSummary class to get all details related to owner
 * 
 * @author Rituraj
 *
 */
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleRegistrationDtls {

	private Integer vehicleRegId;
	
	private String vehicleRegNumber;
	
	private String  regCenter;
	
	private Date  regDate;
	
}
