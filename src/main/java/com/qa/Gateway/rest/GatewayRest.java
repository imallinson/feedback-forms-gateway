package com.qa.Gateway.rest;

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
import com.qa.Gateway.persistence.domain.FeedbackForm;


@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class GatewayRest {

    @Autowired
    private RestTemplate restTemplate;
    
    // Communication with Account MicroService
    
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
    
    
    // Communication with FeedbackForm MicroService
    
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
}
