package org.csspec.feedback.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Course {

    @Id
    @JsonProperty("CourseId")
    @Getter @Setter private String courseId;

    @JsonProperty("CourseName")
    @Getter @Setter private String courseName;

    @JsonProperty("DepartmentId")
    @Getter @Setter private String departmentId;

    @JsonProperty("CourseDescription")
    @Getter @Setter private String courseDescription;

    @JsonProperty("CourseCredits")
    @Getter @Setter private int courseCredits;

    public Course() {};

    public String getCourseName() {
        return this.courseName;
    }

    public String toString() {
        String answer = "{CourseId : "+this.courseId +
                           "\nCourseName : "+this.courseName +
                           "\nDepartmentId : "+this.departmentId +
                           "\nCourseDescription : "+this.courseDescription;
        return answer;
    }



    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return this.courseId;
    }
}
