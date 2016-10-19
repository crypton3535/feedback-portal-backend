package org.csspec.feedback.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class SingleResponse {
    @JsonProperty("OptionOne")
    @Getter @Setter private int optionOne;

    @JsonProperty("OptionTwo")
    @Getter @Setter private int optionTwo;

    @JsonProperty("OptionThree")
    @Getter @Setter private int optionThree;

    @JsonProperty("OptionFour")
    @Getter @Setter private int optionFour;

    @JsonProperty("OptionFive")
    @Getter @Setter private int optionFive;

    SingleResponse() {
        this.optionOne = this.optionTwo = this.optionThree = this.optionFour = this.optionFive = 0;
    }

    public int getOptionOne(){
        return this.optionOne;
    }
    public void setOptionOne(int value) {this.optionOne = value;}

    public int getOptionTwo(){
        return this.optionTwo;
    }
    public void setOptionTwo(int value) {this.optionOne = value;}

    public int getOptionThree(){
        return this.optionThree;
    }
    public void setOptionThree(int value) {this.optionOne = value;}

    public int getOptionFour(){
        return this.optionFour;
    }
    public void setOptionFour(int value) {this.optionOne = value;}

    public int getOptionFive(){
        return this.optionFive;
    }
    public void setOptionFive(int value) {this.optionOne = value;}
}