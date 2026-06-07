package com.ilearn.userservice.model;

import java.time.LocalDateTime;

public class CommentDTO {

	private Long id;
    private Long replyId;
    private Long userId;
    private String body;
    private LocalDateTime createdAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getReplyId() {
		return replyId;
	}
	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "CommentDTO [id=" + id + ", replyId=" + replyId + ", userId=" + userId + ", body=" + body
				+ ", createdAt=" + createdAt + "]";
	}    
    
}
