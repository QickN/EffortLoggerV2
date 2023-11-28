package com.TH16;

public class Defect {
	String project;
	String defectName;
	String stepWhenInjected;
	String stepWhenRemoved;
	String description;
	String defectCategory;
	String status;
	String fix;
	int id;
	
	Defect(){}
	
	Defect(String project, String defectName, String stepWhenInjected, String stepWhenRemoved, String description, String defectCategory, String status, String fix, int id){
		this.project = project;
		this.defectName = defectName;
		this.stepWhenInjected = stepWhenInjected;
		this.stepWhenRemoved = stepWhenRemoved;
		this.description = description;
		this.defectCategory = defectCategory;
		this.status = status;
		this.fix = fix;
		this.id = id;
	}
	
	public String getProject() {
		return project;
	}
	public String getDefectName() {
		return defectName;
	}
	public String getStepWhenInjected() {
		return stepWhenInjected;
	}
	public String getStepWhenRemoved() {
		return stepWhenRemoved;
	}
	public String getDescription() {
		return description;
	}
	public String getDefectCategory() {
		return defectCategory;		
	}
	public String getStatus() {
		return status;		
	}
	public String getFix() {
		return fix;
	}
	public int getId() {
		return id;
	}
	
	public void setProject(String project) {
		this.project = project;
	}
	public void setDefectName(String defectName) {
		this.defectName = defectName;
	}
	public void setStepWhenInjected(String stepWhenInjected) {
		this.stepWhenInjected = stepWhenInjected;
	}
	public void setStepWhenRemoved(String stepWhenRemoved) {
		this.stepWhenRemoved = stepWhenRemoved;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDefectCategory(String defectCategory) {
		this.defectCategory = defectCategory;		
	}
	public void setStatus(String status) {
		this.status = status;		
	}
	public void setFix(String fix) {
		this.fix = fix;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return (getId() + ". " + getDefectName() + "; detail: " + getDescription() + "; injected: " + getStepWhenInjected() + "; removed: " + 
				getStepWhenRemoved() + "; category: " + getDefectCategory() + "; status:  " + getStatus() + "; fix: " + getFix());
	}
}
