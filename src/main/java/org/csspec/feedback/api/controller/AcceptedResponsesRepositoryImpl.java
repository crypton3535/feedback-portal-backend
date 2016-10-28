package org.csspec.feedback.api.controller;

import org.csspec.feedback.api.repo.AcceptedResponsesOperation;
import org.csspec.feedback.api.repo.ResponsesRepository;
import org.csspec.feedback.db.Responses;
import org.csspec.feedback.db.SingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class AcceptedResponsesRepositoryImpl implements AcceptedResponsesOperation {
    @Autowired
    private MongoOperations mongo;

    @Autowired
    private ResponsesRepository responsesRepository;

    @Override
    public void updateResponseTable(String feedbackId, String questionId, int response) {
        Query query = new Query();
        query.addCriteria(Criteria.where("feedbackId").is(feedbackId).and("questionId").is(questionId));
        Responses temp = mongo.findOne(query, Responses.class);
        SingleResponse tempResponse = temp.getResponseList();
        Update update = new Update();
        if(response == 1) { tempResponse.setOptionOne(tempResponse.getOptionOne()+1);}
        else if(response == 2) {tempResponse.setOptionTwo(tempResponse.getOptionTwo()+1 );}
        else if(response == 3) {tempResponse.setOptionThree(tempResponse.getOptionThree()+1 );}
        else if(response == 4) {tempResponse.setOptionFour(tempResponse.getOptionFour()+1 );}
        else if(response == 5) {tempResponse.setOptionFive(tempResponse.getOptionFive()+1 );}
        update.set("responseList",tempResponse);
        mongo.updateFirst(query,update,Responses.class);
    }
}
