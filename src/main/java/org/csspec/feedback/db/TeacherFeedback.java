package org.csspec.feedback.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class TeacherFeedback {

    @JsonProperty("teacherId")
    private String teacherId;

    @JsonProperty("courseId")
    private String courseId;

    @JsonProperty("responses")
    private List<AcceptedSingleResponse> responses = new ArrayList<AcceptedSingleResponse>();

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public List<AcceptedSingleResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<AcceptedSingleResponse> responses) {
        this.responses = responses;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "teacherId : "+teacherId+", courseId : "+courseId+", responses "+responses+" ] ";
    }
}
