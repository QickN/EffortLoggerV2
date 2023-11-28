package com.TH16;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Activity {
	String project;
	String lifeCycleStep;
	String effortCategory1;
	String effortCategory2;
	String startTime;
	String endTime;
	String date;
	int id;
//	String user;
//	String userStory;
//	String[] keyWords;
	
	Activity(){	 } //default constructor
	
	Activity(String project, String lifeCycleStep, String effortCategory1, String effortCategory2, LocalTime startTime, LocalTime endTime, LocalDate date, int id){
//			String user, String userStory, String[] keyWords){
		this.project = project;
		this.lifeCycleStep = lifeCycleStep;
		this.effortCategory1 = effortCategory1;
		this.effortCategory2 = effortCategory2;
		this.startTime = startTime.toString().substring(0, 8);
		this.endTime = endTime.toString().substring(0, 8);
		this.date = date.toString();
		this.id = id;
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
		return startTime;		
	}
	public String getEndTime() {
		return endTime;
	}
	public String getDate() {
		return date;
	}
	public int getId() {
		return id;
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
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setId(int i) {
		this.id = i;
	}
	
	@Override
	public String toString() {
		return (getId() + ". " + getDate() + " (" + getStartTime() + "-" + getEndTime() + ") " + getLifeCycleStep() + "; " + getEffortCategory1() + "; " + getEffortCategory2());
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