package org.csspec.feedback.api.repo;

import org.csspec.feedback.db.TeacherFeedback;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherFeedbackRepository extends MongoRepository<TeacherFeedback, String> {

}
