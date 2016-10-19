package org.csspec.feedback.api.controller;

import org.csspec.feedback.api.repo.*;
import org.csspec.feedback.db.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class AcceptedResponsesController {
    @Autowired
    private AcceptedResponsesRepository acceptedResponsesRepository;

    @Autowired
    private ResponsesRepository responsesRepository;

    @Autowired
    private MongoOperations mongo;

    @Autowired
    private FeedbackStatusRepository feedbackStatusRepository;

    @Autowired
    private CourseFeedbackRepository courseFeedbackRepository;

    @Autowired
    private TeacherFeedbackRepository teacherFeedbackRepository;

    @RequestMapping(value = "/feedback/response/submit", method = RequestMethod.POST)
    public ResponseEntity<?> storeResponses(@RequestBody AcceptedResponses acceptedResponses) {
        FeedbackStatus feedbackStatus = new FeedbackStatus(acceptedResponses.getUserId(), acceptedResponses.getCourseId(),acceptedResponses.getTeacherId());

        List<AcceptedSingleResponse> responses = acceptedResponses.getResponses();

        System.out.println(responses.size());
        CourseFeedback courseFeedback = new CourseFeedback();
        courseFeedback.setCourseId(acceptedResponses.getCourseId());
        courseFeedback.setResponses(responses.subList(0,4));

        TeacherFeedback teacherFeedback = new TeacherFeedback();
        teacherFeedback.setTeacherId(acceptedResponses.getTeacherId());
        teacherFeedback.setResponses(responses.subList(5,14));

        /* Oh yeah, Chal ab database k ander. */
        courseFeedbackRepository.save(courseFeedback);
        teacherFeedbackRepository.save(teacherFeedback);
        feedbackStatusRepository.save(feedbackStatus);

        return new ResponseEntity<Object>(Collections.singletonMap("message", "response accepted"), HttpStatus.CREATED);
    }


}
