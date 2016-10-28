package org.csspec.feedback.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiController {
    @RequestMapping(value = "/feedback/api", method = RequestMethod.GET)
    public List<Map<String,String>> getAllIdentityApi() {
        List<Map<String,String>> answer = new ArrayList<>();
        String apimethods[] = {
                "POST /feedback/response/submit",
                "GET /feedback/results/teachers/{teacherId}",
                "GET /feedback/results/courses/{courseId}",
                "GET /feedback/status/{courseId}/{userId}",
                "POST /feedback/new",
                "GET /feedback/template/{templateId}"
        };
        String description[] = {
                "Stores a new response.",
                "Get feedback results of a teacher.",
                "Returns the feedback results of a course.",
                "Returns the feedback status of a courseId and userId",
                "Make a new feedback template",
                "Get questions of feedback template with given feedbackId",
        };
        for(int i =0;i< apimethods.length ;i++){
            Map<String,String> temp = new HashMap<>();
            temp.put("call",apimethods[i]);
            temp.put("description",description[i]);
            answer.add(temp);
        }
        return answer;
    }
}
