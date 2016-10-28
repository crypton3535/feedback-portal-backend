package org.csspec.feedback.db;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Responses {

    @JsonProperty("feedbackId")
    private String feedbackId;

    @JsonProperty("questionId")
    private String questionId;

    @JsonProperty("responseList")
    private SingleResponse responseList;

    public SingleResponse getResponseList() {
        return this.responseList;
    }

    @Override
    public String toString() {
        return "feedbackId : "+feedbackId+", questionId : "+questionId+", responseList : "+responseList+" ]\n";
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }
    public String getFeedbackId() {
        return this.feedbackId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
    public String getQuestionId() {
        return this.questionId;
    }
    public void setResponseList(SingleResponse responseList) {
        this.responseList = responseList;
    }
}
