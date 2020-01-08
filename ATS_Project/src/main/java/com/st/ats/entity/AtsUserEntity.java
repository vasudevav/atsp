package com.st.ats.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
/**
 * this is Entity class for ats user which is bind repository to send data in database
 * 
 * @author Rituraj
 *
 */
@Data
@Entity
@Table(name="ATS_USER_TAB")
public class AtsUserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Ats_id_gen")
	@SequenceGenerator(name ="Ats_id_gen",allocationSize =1,initialValue =101,sequenceName = "ATS_USER_SEQ")
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="First_NAME",length = 30)
	private String fname;
	
	@Column(name="Last_Name",length = 30)
	private String lname;
	
	@Column(name="EMAIL",length = 50)
	private String email;
	
	@Column(name="password",length = 200)
	private String pazzword;
	
	@Column(name="gender",length = 10)
	private String gender;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DOB")
	private Date  dob;
	
	@Column(name="PHNO")
	private Long phno;
	
	@Column(name="SSN_Id",length = 11)
	private String zzn;
	
	@Column(name="Role_Name",length = 10)
	private String roleType;
	
	@Column(name="acc_Status",length = 8)
	private String  status;
	
	@Column(name="active_SW",length = 1)
	private Character activeSwitch;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_DT")
	@CreationTimestamp
	private Date createDate;
	
	@UpdateTimestamp
	@Column(name="Update_DT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
}
