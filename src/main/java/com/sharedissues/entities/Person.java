package com.sharedissues.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.sharedissues.all.common.Common;

@Entity
@Table(name="person")
public class Person implements Serializable{
	
	@Id
	private String email;
	
	@Column(name="user_salutation")
	private String userSalutation;
	
	@Column(name="person_uuid")
	private String personUuid;
	
	@Column(name="password")
	private String password;
	

	@Column(name="user_roles")
	private String roles;
	
	@Column(name="user_account_enabled")
	private boolean userAccountEnabled = true;
	
	@Column(name="user_first_name")
	private String firstName;
	
	@Column(name="user_last_name")
	private String lastName;
	
	
	private String telephone;
	
	private String country;
	
	private String city;
	
	@Column(name="user_profile_picture")
	private String profilePicture;
	
	@Transient
	private List<String> pictures;
	
	@Transient
	private List<String> rolesAsList;
	
	private String address;
	
	private String zipCode;
	
	@Column(name="user_secret_question")
	private String cecretQuestion;
	
	@Column(name="user_secret_answer")
	private String secretAnswer;

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	Add new property to update domain model 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	
	public Person(){
		this.personUuid = Common.getUuid();
	}
	
	public List<String> getRolesAsList() {
		List roleList = new ArrayList<String>();
		if(roles!=null && roles !=""){
			String[] rls = roles.split(":");
			for(String s: rls){
				if(s!=null || s.length()>2){
					roleList.add(s);
				}
			}
		}
		return roleList;
	}
	public void addRole(String rle){
		if(roles==null){
			roles = rle;
		}else{
			roles += ":"+rle;
		}
		
	}
	
	public String getUserSalutation() {
		return userSalutation;
	}

	public void setUserSalutation(String userSalutation) {
		this.userSalutation = userSalutation;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password  = password;
	}

	public String getRoles(){
		return roles;
	}
	

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public boolean isUserAccountEnabled() {
		return userAccountEnabled;
	}

	public void setUserAccountEnabled(boolean userAccountEnabled) {
		this.userAccountEnabled = userAccountEnabled;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCecretQuestion() {
		return cecretQuestion;
	}

	public void setCecretQuestion(String cecretQuestion) {
		this.cecretQuestion = cecretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}
	
	public String getPersonUuid() {
		return personUuid;
	}

	public void setPersonUuid(String personUuid) {
		this.personUuid = personUuid;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public List<String> getPictures() {
		return pictures;
	}

	public void setPictures(List<String> pictures) {
		this.pictures = pictures;
	}
	
	
}
