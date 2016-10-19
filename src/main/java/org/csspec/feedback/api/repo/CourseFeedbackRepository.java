package org.csspec.feedback.api.repo;

import org.csspec.feedback.db.CourseFeedback;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseFeedbackRepository extends MongoRepository<CourseFeedback,String> {

}
