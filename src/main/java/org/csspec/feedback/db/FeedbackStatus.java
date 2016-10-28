package org.csspec.feedback.db;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeedbackStatus {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("courseId")
    private String courseId;

    @JsonProperty("teacherId")
    private String teacherId;

    public FeedbackStatus(String userId, String courseId, String teacherId) {
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.userId = userId;
    }

    public FeedbackStatus(){
        this.courseId = null;
        this.userId = null;
        this.teacherId = null;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public String getTeacherId() {
        return this.teacherId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}