package org.csspec.feedback.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class FeedbackTemplate {

    @JsonProperty("feedbackId")
    private String feedbackId;

    @JsonProperty("adminId")
    private List<String> adminId;

    @JsonProperty("description")
    private String description;

    @JsonProperty("isOfficial")
    private int isOfficial;
/*  1 for official feedbacks and 0 for non-official feedbacks,
    later enum could be added for different societies for directly finding their org.csspec.feedback forms
 */
    @JsonProperty("questionList")
    private List<Question> question = new ArrayList<Question>();

    public List<Question> getQuestionList() {
        return this.question;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public List<String> getAdminId() {
        return adminId;
    }

    public void setAdminId(List<String> adminId) {
        this.adminId = adminId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(int isOfficial) {
        this.isOfficial = isOfficial;
    }
}