package VO;

public class FeedbackVO {
private int feedbackID;
private String subject;
private String message;
private LoginVO feedbackFrom;
private String feedbackDate;
private String feedbackTime;


public int getFeedbackID() {
	return feedbackID;
}
public void setFeedbackID(int feedbackID) {
	this.feedbackID = feedbackID;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public LoginVO getFeedbackFrom() {
	return feedbackFrom;
}
public void setFeedbackFrom(LoginVO feedbackFrom) {
	this.feedbackFrom = feedbackFrom;
}
public String getFeedbackDate() {
	return feedbackDate;
}
public void setFeedbackDate(String feedbackDate) {
	this.feedbackDate = feedbackDate;
}
public String getFeedbackTime() {
	return feedbackTime;
}
public void setFeedbackTime(String feedbackTime) {
	this.feedbackTime = feedbackTime;
}
}
