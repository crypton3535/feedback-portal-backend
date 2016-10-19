package org.csspec.feedback.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jatinder Dhawan on 10/19/2016.
 */
public class CourseFeedback {
    @JsonProperty("courseId")
    @Getter @Setter private String courseId;

    @JsonProperty("responses")
    @Getter @Setter private List<AcceptedSingleResponse> responses = new ArrayList<AcceptedSingleResponse>();

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
}
