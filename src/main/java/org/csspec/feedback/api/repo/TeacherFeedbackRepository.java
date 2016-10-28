package org.csspec.feedback.api.repo;

import org.csspec.feedback.db.TeacherFeedback;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
/**
 * Created by Jatinder Dhawan on 10/19/2016.
 */
public interface TeacherFeedbackRepository extends MongoRepository<TeacherFeedback, String> {
    public List<TeacherFeedback> getTeacherFeedbackByTeacherIdAndCourseId(String teacherId, String courseId);

}
