package org.csspec.feedback.api.controller;

import org.csspec.feedback.api.repo.FeedbackStatusRepository;
import org.csspec.feedback.db.FeedbackStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
public class FeedbackStatusController {
    @Autowired
    private FeedbackStatusRepository feedbackStatusRepository;
    @Autowired
    private MongoOperations mongo;

    /* Get org.csspec.feedback status of given org.csspec.feedback id for a given user */
    @RequestMapping(value = "/feedback/status/{courseId}/{userId}", method = RequestMethod.GET)
    public Map<String,Boolean> getFeedbackStatus(@PathVariable String courseId, @PathVariable String userId) {
        System.out.println("CourseID: " + courseId + ", UserId:" + userId);
        FeedbackStatus temp  = mongo.findOne(Query.query(Criteria.where("courseId").is(courseId).where("userId").is(userId)),FeedbackStatus.class);
        return Collections.singletonMap("status",temp!=null);
    }
}