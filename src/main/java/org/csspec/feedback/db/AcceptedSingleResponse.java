package org.csspec.feedback.db;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AcceptedSingleResponse {

    @JsonProperty("questionId")
    private String questionId;

    @JsonProperty("response")
    private String response;

    public AcceptedSingleResponse() {
    }
    public String getQuestionId() {
        return this.questionId;
    }
    public String getResponse() {
        return this.response;
    }

    @Override
    public String toString() {
        return "{ QuestionId : "+this.questionId+", Response"+this.response+"}\n";
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
    public void setResponse(String response) {
        this.response = response;
    }
}
