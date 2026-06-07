package com.ilearn.userservice.model;

public class VoterDTO {
	
	private Long id;
    private Long userId;
    private String targetType;
    private Long targetId;
    private String voteType;   
    
    public VoterDTO() {
    }
    
	public VoterDTO(Long id, Long userId, String targetType, Long targetId, String voteType) {
		super();
		this.id = id;
		this.userId = userId;
		this.targetType = targetType;
		this.targetId = targetId;
		this.voteType = voteType;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	public Long getTargetId() {
		return targetId;
	}
	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}
	public String getVoteType() {
		return voteType;
	}
	public void setVoteType(String voteType) {
		this.voteType = voteType;
	}
	
	@Override
	public String toString() {
		return "VoterDTO [id=" + id + ", userId=" + userId + ", targetType=" + targetType + ", targetId=" + targetId
				+ ", voteType=" + voteType + "]";
	}
    
      
    
}
