package pl.maciejpajak.dto;

import java.time.LocalDateTime;

public class ActivityDto {
    
    private LocalDateTime created;
    private Long userId;
    private String userEmail;
    private Long objectId;
    private String objectName;
    private String action;

    public ActivityDto(LocalDateTime created, Long userId, String userEmail, Long objectId, String objectName,
            String action) {
        super();
        this.created = created;
        this.userId = userId;
        this.userEmail = userEmail;
        this.objectId = objectId;
        this.objectName = objectName;
        this.action = action;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    public String getMessage() {
        return created + " : " + userEmail + " " + action + "ED " + objectName;
    }

}
