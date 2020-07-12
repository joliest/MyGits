package com.jobhunter.components;

import java.util.ArrayList;

public class Profile {
	private String firstName;
	private String lastName;
	private String middleName;
	private String jobTitle;
	private String address;
	private String mobileNumber;
	private String desiredJobTitle;
	private String jobPreference;
	private String jobType;
	private String skills;
	private String company;
	private ArrayList<AccountWorkExperience> workExperiences;
	private ArrayList<AccountEducation> educations;
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
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getDesiredJobTitle() {
		return desiredJobTitle;
	}
	public void setDesiredJobTitle(String desiredJobTitle) {
		this.desiredJobTitle = desiredJobTitle;
	}
	public String getJobPreference() {
		return jobPreference;
	}
	public void setJobPreference(String jobPreference) {
		this.jobPreference = jobPreference;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public ArrayList<AccountWorkExperience> getWorkExperiences() {
		return workExperiences;
	}
	public void setWorkExperiences(ArrayList<AccountWorkExperience> workExperiences) {
		this.workExperiences = workExperiences;
	}
	public ArrayList<AccountEducation> getEducations() {
		return educations;
	}
	public void setEducations(ArrayList<AccountEducation> educations) {
		this.educations = educations;
	}
	
	
}
