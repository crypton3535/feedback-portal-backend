package org.csspec.feedback.db;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionOptions {
    @JsonProperty("label")
    private String label;

    @JsonProperty("value")
    private String value;

    public String getLabel() {
        return label;
    }
    public void setLabel(String label){
        this.label = label;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
