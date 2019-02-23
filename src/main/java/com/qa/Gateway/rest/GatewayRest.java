package com.qa.Gateway.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.Gateway.persistence.domain.Account;
import com.qa.Gateway.persistence.domain.Cohort;
import com.qa.Gateway.persistence.domain.FeedbackForm;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class GatewayRest {

    @Autowired
    private RestTemplate restTemplate;
    
    // GatewayAPI --> AccountAPI [Post Request]
    
    @Value ("${url.accounts}")
    private String accountURL;
    
    @Value ("${path.genAddAccount}")
    private String addAccount;
    
    @PostMapping("${path.getAddAccount}")
    public Account addAccount(@RequestBody Account account) {
    	return requestAddAccount(account);
    }
   
    private Account requestAddAccount(Account account){
    	Account response = restTemplate.postForObject(accountURL + addAccount, account, Account.class);
    	return response;
    }
    
    // GatewayAPI --> FeedbackFormAPI [Post Request]
    
    @Value ("${url.feedbackForm}")
    private String feedbackFormURL;
    
    @Value ("${path.genAddFeedbackForm}")
    private String addFeedbackForm;

    @PostMapping("${path.getAddFeedbackForm}")
    public FeedbackForm addFeedbackForm(@RequestBody FeedbackForm feedbackForm) {
    	return requestAddFeedbackForm(feedbackForm);
    }
    
    private FeedbackForm requestAddFeedbackForm(FeedbackForm feedbackForm){
    	FeedbackForm response = restTemplate.postForObject(feedbackFormURL + addFeedbackForm, feedbackForm, FeedbackForm.class);
    	return response;
    }
    
    // GatewayAPI --> CohortAPI [POST Request]
    
    @Value ("${url.cohort}")
    private String cohortURL;
    
    @Value ("${path.genAddCohort}")
    private String addCohort;
    
    @PostMapping("${path.getAddCohort}")
    public Cohort addCohort(@RequestBody Cohort cohort) {
    	return requestAddCohort(cohort);
    }
    
    private Cohort requestAddCohort(Cohort cohort ){
    	Cohort response = restTemplate.postForObject(cohortURL + addCohort, cohort, Cohort.class);
    	return response;
    }
    
    // GatewayAPI --> RetriverAPI ---> DB(Account)[ GET, PUT, DELETE - Requests ]
    
    @Value ("${url.retriever}")
    private String retrieverURL;
    
    @Value ("${path.genAccounts}")
    private String getAccounts;
    
    @GetMapping("${path.getAccounts}")
    public Account[] getAccounts() {
    	return requestGetAccount();
    }
    
    private Account[] requestGetAccount(){
    	Account[] response = restTemplate.getForObject(retrieverURL + getAccounts, Account[].class);
    	return response;
    }

    
    

}
