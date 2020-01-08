package com.st.ats.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.st.ats.entity.AtsUserEntity;

/**
 * this  repository is used  for perform database side operation for atsuser data 
 * 
 * @author Rituraj
 *
 */
public interface AtsUserTabRepository extends  JpaRepository<AtsUserEntity, Integer>{
	
	/**
	 *This method is used to get user Data based on email and password 
	 * 
	 * @param email
	 * @param password
	 * @return Optional
	 */
	@Query("select at from AtsUserEntity at where at.email=:email and at.pazzword=:password")
	public Optional<AtsUserEntity> getUserData(String email,String password);
	
	/**
	 *This method is used to get user Data based on email  
	 * @param email
	 * @return Optional
	 */
	@Query("select count(1) from AtsUserEntity at where at.email=:email")
	public Integer findAtsUserByEmail(String email);
	

	/**
	 * This method is used to get user Data based on email and Phone number
	 * @param email
	 * @param phno
	 * @return Optional
	 */
	@Query("select at from AtsUserEntity at where at.email=:email and at.phno=:phno")
	public Optional<AtsUserEntity> findAtsUserByEmailAndPhno(String email,Long phno);
	
	/**
	 * This method is used to update the user data or unlock user account to set status 
	 * @param pazzword
	 * @param email
	 * @return Integer
	 */
	@Transactional
	@Modifying
	@Query("update AtsUserEntity  at set at.pazzword=:pazzword,at.status='UNLOCK' where at.email=:email")
	public Integer updatePassWord(String pazzword,String email);
	
	
	@Query("select at from AtsUserEntity at where at.status='UNLOCK'")
	public List<AtsUserEntity> findAllUnlockUser();
	@Query("select at from AtsUserEntity at where at.roleType=:role and at.status='UNLOCK'")
	public List<AtsUserEntity> findBasedOnRoles(String role);
	
	@Query("select at from AtsUserEntity at where at.roleType=:role and at.status='UNLOCK' and at.activeSwitch='N' ")
	public List<AtsUserEntity> findDeActiveBasedOnRoles(String role);
	
	@Query("select at from AtsUserEntity at where at.roleType=:role and at.status='UNLOCK' and at.activeSwitch='Y' ")
	public List<AtsUserEntity> findActiveBasedOnRoles(String role);

	@Transactional
	@Modifying
	@Query("update AtsUserEntity  at set at.activeSwitch='N' where at.userId=:uid")
	public Integer deactivateBasedOnRole(Integer uid);
	
	@Transactional
	@Modifying
	@Query("update AtsUserEntity  at set at.activeSwitch='Y' where at.userId=:uid")
	public Integer activateBasedOnRole(Integer uid);
}
