package org.csspec.feedback.db;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class AcceptedResponses {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("courseId")
    private String courseId;

    @JsonProperty("teacherId")
    private String teacherId;

    @JsonProperty("responses")
    private List<AcceptedSingleResponse> responses = new ArrayList<AcceptedSingleResponse>();

    public List<AcceptedSingleResponse> getResponses() {
        return this.responses;
    }

    public String getCourseId() {
        return this.courseId;
    }
    public String getUserId(){
        return this.userId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public AcceptedResponses(){
    }
    @Override
    public String toString() {
        String abc = "{CourseId : "+courseId+ ",\nUserId : "+ userId+",Responses : [\n";
        for(int i=0;i<responses.size();i++) {
            abc = abc + responses.get(i);
        }
        abc = abc + "\n";
        return abc;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}