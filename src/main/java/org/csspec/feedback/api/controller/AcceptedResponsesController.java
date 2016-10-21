package org.csspec.feedback.api.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.csspec.feedback.api.repo.*;
import org.csspec.feedback.db.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

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
        teacherFeedback.setCourseId(acceptedResponses.getCourseId());
        teacherFeedback.setResponses(responses.subList(5,15));

        /* Oh yeah, Chal ab database k ander. */
        courseFeedbackRepository.save(courseFeedback);
        teacherFeedbackRepository.save(teacherFeedback);
        feedbackStatusRepository.save(feedbackStatus);

        return new ResponseEntity<Object>(Collections.singletonMap("message", "response accepted"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/feedback/results/teachers/{teacherId}", method = RequestMethod.GET)
    public List<Map<String,Object>> getFeedbackOfTeacher(@PathVariable String teacherId) {
        List<Map<String,Object>> answerList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        List<Course> courses = new ArrayList<>();
        final String uri = "http://localhost:8080/academic/courses/faculty/"+teacherId;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
       // System.out.println(result);
        try{courses = mapper.readValue(result,new TypeReference<List<Course>>(){});}catch(IOException e) {
            System.out.println(e);
        }
        System.out.println("--------------------------");
        System.out.println(courses.size()+ " "+courses.get(0).getClass().getName());
        for(int i =0;i<courses.size();i++) {
            System.out.println(courses.get(i));
            answerList.add(oneTeacherOneCourseFeedback(teacherId, courses.get(i).getCourseId()));
        }
        return answerList;
    }

    public Map<String, Object> oneTeacherOneCourseFeedback(String teacherId, String courseId) {
        Map<String, Object> map = new HashMap();
        map.put("teacherId",teacherId);
        map.put("courseId",courseId);

        System.out.println("Map now is "+map);
        List<Map<String, Object>> arrayList = new ArrayList<>();
        for(int i = 1;i<=10;i++) {
            Map<String,Object> leveltwo = new HashMap<>();
            leveltwo.put("questionId",i+5);
            leveltwo.put("average",getAverageResponse(teacherId,courseId,i));
            arrayList.add(leveltwo);
            System.out.println("Array List now has " + arrayList.size()+" values.");
            //System.out.println(getAverageResponse(teacherId, courseId, i));
        }
        map.put("responses",arrayList);
        System.out.println("Final map is "+map);
        return map;
    }

    public double getAverageResponse(String teacherId, String courseId, int n) {
        System.out.println("Get average for " + teacherId + " and " + courseId+" question "+n);
        List<TeacherFeedback> listOne = teacherFeedbackRepository.findAll();//(Query.query(Criteria.where("teacherId").is(teacherId).andOperator(Criteria.where("courseId").is(courseId)))); //(Query.query(Criteria.where("teacherId").is(teacherId).andOperator(Criteria.where("courseId").is(courseId))), TeacherFeedback.class);
       //   List<TeacherFeedback> lstOne = teacherFeedbackRepository.findAll();//Query.query(Criteria.where("teacherId").is(teacherId).andOperator(Criteria.where("courseId").is(courseId))));
        int sum = 0;
        System.out.println(listOne.size());
        System.out.println(listOne);
        for(int i=0;i<listOne.size();i++) {
            List<AcceptedSingleResponse> tempList = new ArrayList<>();
            tempList = listOne.get(i).getResponses();
            sum = sum + getRating(tempList.get(n-1).getResponse());
        }
        System.out.println("To return : "+ sum+" "+listOne.size());
        return (double)sum/listOne.size();
    }

    public int getRating(String abc) {
        if(abc.equals("A")) {
            return 5;
        } else if(abc.equals("B")) {
            return 4;
        } else if(abc.equals("C")) {
            return 3;
        } else if(abc.equals("D")) {
            return 2;
        } else if(abc.equals("E")) {
            return 1;
        }
        return 0;
    }


}
