package org.csspec.feedback.db;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


public class AcceptedSingleResponse {
    @JsonProperty("questionId")
    @Setter @Getter private String questionId;

    @JsonProperty("response")
    @Setter @Getter private String response;

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
        return "{ QuestionId : "+this.questionId+",\nReponse"+this.response+"}\n";
    }
}
