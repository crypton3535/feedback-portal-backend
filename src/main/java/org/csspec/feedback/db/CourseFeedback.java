package org.csspec.feedback.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;


public class CourseFeedback {

    @JsonProperty("courseId")
    private String courseId;

    @JsonProperty("teacherId")
    private String teacherId;

    @JsonProperty("responses")
    private List<AcceptedSingleResponse> responses = new ArrayList<AcceptedSingleResponse>();

    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public List<AcceptedSingleResponse> getResponses() {
        return responses;
    }
    public void setResponses(List<AcceptedSingleResponse> responses) {
        this.responses = responses;
    }

    public String getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
