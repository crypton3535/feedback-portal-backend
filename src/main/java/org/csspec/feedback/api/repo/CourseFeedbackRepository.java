package org.csspec.feedback.api.repo;

import org.csspec.feedback.db.CourseFeedback;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourseFeedbackRepository extends MongoRepository<CourseFeedback,String> {
    public List<CourseFeedback> getCourseFeedbackByTeacherIdAndCourseId(String teacherId, String courseId);
}
