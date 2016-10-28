package org.csspec.feedback.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponsesController {
    @Autowired
    private ResponsesController responsesController;

    @Autowired
    private MongoOperations mongo;


}
