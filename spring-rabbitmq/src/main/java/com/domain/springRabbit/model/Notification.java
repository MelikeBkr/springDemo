package com.domain.springRabbit.model;

import java.io.Serializable;
import java.util.Date;

//The reason for using the Serializable interface is that it can be serialized and properly sent to the queue
// and detected by java when it returns from the queue.
public class Notification implements Serializable
{

    private String notificationId;
    private Date creationDate;
    private Boolean isSeen;
    private String message;

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setSeen(Boolean seen) {
        isSeen = seen;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Boolean getSeen() {
        return isSeen;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", creationDate=" + creationDate +
                ", isSeen=" + isSeen +
                ", message='" + message + '\'' +
                '}';
    }
}
