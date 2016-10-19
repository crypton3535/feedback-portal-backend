package org.csspec.feedback.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

public class TeacherFeedback {

    @JsonProperty("teacherId")
    @Getter @Setter private String teacherId;

    @JsonProperty("responses")
    @Getter @Setter private List<AcceptedSingleResponse> responses = new ArrayList<AcceptedSingleResponse>();

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
}
