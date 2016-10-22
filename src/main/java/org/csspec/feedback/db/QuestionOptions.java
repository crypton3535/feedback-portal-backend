package org.csspec.feedback.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class QuestionOptions {
    @JsonProperty("label")
    @Getter @Setter private String label;

    @JsonProperty("value")
    @Getter @Setter private String value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
