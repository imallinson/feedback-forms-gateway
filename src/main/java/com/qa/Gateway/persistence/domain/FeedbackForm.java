package com.qa.Gateway.persistence.domain;

public class FeedbackForm {

	private Long feedbackID;
	private Long cohortID;
	private Long accountID;
	private int week;
	private int score;
	private String question1;
	private String question2;
	private String question3;
	private String question4;
	
	public FeedbackForm() {
		
	}
	
	public FeedbackForm(Long cohortID, Long accountID, int week, int score, String question1, String question2, String question3, String question4) {
		this.cohortID = cohortID;
		this.accountID = accountID;
		this.week = week;
		this.score = score;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
	}

	public Long getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(Long feedbackID) {
		this.feedbackID = feedbackID;
	}

	public Long getCohortID() {
		return cohortID;
	}

	public void setCohortID(Long cohortID) {
		this.cohortID = cohortID;
	}

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getQuestion4() {
		return question4;
	}

	public void setQuestion4(String question4) {
		this.question4 = question4;
	}
	
}
