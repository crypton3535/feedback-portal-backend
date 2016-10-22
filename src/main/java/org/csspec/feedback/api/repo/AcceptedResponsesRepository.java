package org.csspec.feedback.api.repo;

import org.csspec.feedback.db.AcceptedResponses;
import org.csspec.feedback.db.TeacherFeedback;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Jatinder Dhawan on 10/16/2016.
 */
public interface AcceptedResponsesRepository extends MongoRepository<AcceptedResponses,String>,AcceptedResponsesOperation {
    public void updateResponseTable(String feedbackId, String questionId, int response);
}
