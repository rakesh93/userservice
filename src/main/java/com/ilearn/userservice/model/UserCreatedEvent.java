package com.ilearn.userservice.model;

public class UserCreatedEvent {

    private Long userId;
    private String reason;
    
    public UserCreatedEvent() {}
    
	public UserCreatedEvent(Long userId, String reason) {
		super();
		this.userId = userId;
		this.reason = reason;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}	
	
	@Override
	public String toString() {
		return "UserCreatedEvent [userId=" + userId + ", reason=" + reason + "]";
	}       
    
}
