package com.qa.Gateway.persistence.domain;


public class Cohort {
	
    private Object _id;
	private Long cohortId;
	private String cohortName;
	private String trainerName;
	private int week;
	private String cohortDescription;
	
	public Cohort() {
		
	}
	
	public Cohort( String cohortName, String trainerName, int week, String cohortDescription ) {
		this.cohortName = cohortName;
		this.trainerName = trainerName;
		this.week = week;
		this.cohortDescription = cohortDescription;
	}

	public Long getCohortId() {
		return cohortId;
	}

	public void setCohortId(Long cohortId) {
		this.cohortId = cohortId;
	}

	public String getCohortName() {
		return cohortName;
	}

	public void setCohortName(String cohortName) {
		this.cohortName = cohortName;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public String getCohortDescription() {
		return cohortDescription;
	}

	public void setCohortDescription(String cohortDescription) {
		this.cohortDescription = cohortDescription;
	}
	
	public Object get_id() {
		return _id;
	}

	public void set_id(Object _id) {
		this._id = _id;
	}
	
	
	
}
