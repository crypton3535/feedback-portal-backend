package org.csspec.feedback.api.repo;

import org.csspec.feedback.db.Responses;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Jatinder Dhawan on 10/19/2016.
 */
public interface ResponsesRepository extends MongoRepository<Responses,String> {
}
