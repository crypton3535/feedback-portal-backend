package org.csspec.feedback.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class Question {

    enum QuestionType {multiple, text, level };

    @JsonProperty("questionId")
    @Getter @Setter private String questionId;

    @JsonProperty("statement")
    @Getter @Setter private String statement;

    @JsonProperty("type")
    @Getter @Setter private String type;

    @JsonProperty("options")
    @Getter @Setter private List<QuestionOptions> options = new ArrayList<>();

    @JsonProperty("text")
    @Getter @Setter private String text;
}
