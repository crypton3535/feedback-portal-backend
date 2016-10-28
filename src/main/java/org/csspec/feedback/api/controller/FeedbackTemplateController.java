package org.csspec.feedback.api.controller;

import org.csspec.feedback.api.repo.FeedbackTemplateRepository;
import org.csspec.feedback.db.FeedbackTemplate;
import org.csspec.feedback.db.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@RestController
public class FeedbackTemplateController {
    @Autowired
    private FeedbackTemplateRepository feedbackTemplateRepository;

    /* Make a new feedback form */
    @RequestMapping(value = "/feedback/new", method = RequestMethod.POST)
    public void storeFeedbackTemplate(@RequestBody FeedbackTemplate feedbackTemplate) {
        feedbackTemplateRepository.save(feedbackTemplate);
        System.out.println("Made a new feedbackTemplate");
    }

    /* Get questions of a given org.csspec.feedback id */
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/feedback/template/{templateId}", method = RequestMethod.GET)
    public FeedbackTemplate getFeedbackQuestions(@PathVariable String templateId) {
      /*
        String everything = new String();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Jatinder Dhawan\\IdeaProjects\\Feedback\\src\\main\\java\\org\\csspec\\feedback\\api\\controller\\questions.json"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return everything;
       */
       return feedbackTemplateRepository.getFeedbackTemplateByFeedbackId(templateId);
    }

}
