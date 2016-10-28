package org.csspec.feedback.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;


public class Question {

    enum QuestionType {multiple, text, level };

    @JsonProperty("questionId")
    private String questionId;

    @JsonProperty("statement")
    private String statement;

    @JsonProperty("type")
    private String type;

    @JsonProperty("options")
    private List<QuestionOptions> options = new ArrayList<>();

    @JsonProperty("text")
    private String text;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<QuestionOptions> getOptions() {
        return options;
    }

    public void setOptions(List<QuestionOptions> options) {
        this.options = options;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
