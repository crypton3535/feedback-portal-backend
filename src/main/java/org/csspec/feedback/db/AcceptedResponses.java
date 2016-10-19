package org.csspec.feedback.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class AcceptedResponses {
    @JsonProperty("userId")
    @Getter @Setter private String userId;

    @JsonProperty("courseId")
    @Getter @Setter private String courseId;

    @JsonProperty("teacherId")
    @Getter @Setter String teacherId;

    @JsonProperty("responses")
    @Getter @Setter private List<AcceptedSingleResponse> responses = new ArrayList<AcceptedSingleResponse>();

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

    public AcceptedResponses() {
        this.courseId = "sdcs";
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
}