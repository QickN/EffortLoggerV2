package com.TH16;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Activity {
	String project;
	String lifeCycleStep;
	String effortCategory1;
	String effortCategory2;
	LocalTime startTime;
	LocalTime endTime;
	LocalDate date;
//	String user;
//	String userStory;
//	String[] keyWords;
	
	Activity(){	 } //default constructor
	
	Activity(String project, String lifeCycleStep, String effortCategory1, String effortCategory2, LocalTime startTime, LocalTime endTime, LocalDate date){
//			String user, String userStory, String[] keyWords){
		this.project = project;
		this.lifeCycleStep = lifeCycleStep;
		this.effortCategory1 = effortCategory1;
		this.effortCategory2 = effortCategory2;
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
//		this.user = user;
//		this.userStory = userStory;
//		this.keyWords = keyWords;
	}
	
	public String getProject() {
		return project;
	}
	public String getLifeCycleStep() {
		return lifeCycleStep;
	}
	public String getEffortCategory1() {
		return effortCategory1;
	}
	public String getEffortCategory2() {
		return effortCategory2;
	}
	public String getStartTime() {
		return startTime.toString().substring(0, 8);		
	}
	public String getEndTime() {
		return endTime.toString().substring(0, 8);
	}
	public String getDate() {
		return date.toString();
	}
//	public String getUser() {
//		return user;
//	}
//	public String getUserStory() {
//		return userStory;
//	}
//	public String[] getKeyWords() {
//		return keyWords;
//	}
	
	public void setProject(String project) {
		this.project = project;
	}
	public void setLifeCycleStep(String lifeCycleStep) {
		this.lifeCycleStep = lifeCycleStep;
	}
	public void setEffortCategory1(String effortCategory1) {
		this.effortCategory1 = effortCategory1;
	}
	public void setEffortCategory2(String effortCategory2) {
		this.effortCategory2 = effortCategory2;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return (getDate() + " (" + getStartTime() + "-" + getEndTime() + ") " + getLifeCycleStep() + "; " + getEffortCategory1() + "; " + getEffortCategory2());
	}
//	public void setUser(String user) {
//		this.user = user;
//	}
//	public void setUserStory(String userStory) {
//		this.userStory = userStory;
//	}
//	public void setKeyWords(String[] keyWords) {
//		this.keyWords = keyWords;
//	}
}