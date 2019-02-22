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
    
    @Value ("${url.feedbackForm}")
    private String feedbackFormURL;
    
    @Value ("${path.genFeedbackForm}")
    private String genFeedbackFormPath;
    
    @Value ("${path.genAllFeedbackForms}")
    private String genAllFeedbacksPath;
    
    @Value ("${path.genFeedbackFormByID}")
    private String genFeedbackFormByIDPath;
    
    @Value ("${path.genFeedbackFormsByUserID}")
    private String genFeedbackFormsByUserID;
    
    @PostMapping("${path.addFeedbackForm}")
    public FeedbackForm addFeedbackForm(@RequestBody FeedbackForm feedbackForm) {
    	return requestAddFeedbackForm(feedbackForm);
    }
    
    @GetMapping("${path.getAllFeedbacks}")
    public FeedbackForm[] getAllFeedbackForms() {
    	return requestGetAllFeedbackForms();
    }
    
    @GetMapping("${path.getFeedbackFormByID}")
    public FeedbackForm getFeedbackFormByID(@PathVariable Long feedbackID) {
    	return requestGetFeedbackFormByID(feedbackID);
    }
    
    @GetMapping("${path.getFeedbackFormsByUserID}")
    public FeedbackForm[] getFeedbackFormsByUserID(@PathVariable Long userID){
    	return requestGetFeedbackFormsByUserID(userID);
    }
    
    
    private FeedbackForm[] requestGetAllFeedbackForms(){
    	FeedbackForm[] response = restTemplate.getForObject(feedbackFormURL + genAllFeedbacksPath, FeedbackForm[].class);
    	return response;
    }
    
    private FeedbackForm requestAddFeedbackForm(FeedbackForm feedbackForm){
    	FeedbackForm response = restTemplate.postForObject(feedbackFormURL + genFeedbackFormPath, feedbackForm, FeedbackForm.class);
    	return response;
    }
    
    private FeedbackForm requestGetFeedbackFormByID(Long feedbackID) {
    	FeedbackForm response = restTemplate.getForObject(feedbackFormURL + genFeedbackFormByIDPath + feedbackID, FeedbackForm.class);
    	return response;
    }
   
    private FeedbackForm[] requestGetFeedbackFormsByUserID(Long userID) {
    	FeedbackForm[] response = restTemplate.getForObject(feedbackFormURL + genFeedbackFormsByUserID + userID, FeedbackForm[].class);
    	return response;
    }
    
    @Value("${url.account}")
    private String accountURL;
    
    @Value("${path.genAccounts")
    private String genAccounts;
    
    @Value("${path.genCreateAccount}")
    private String genCreateAccount;
    
    @Value("${path.genAccountById}")
    private String genAccountById;
    
    @Value("${path.genDeleteAccount}")
    private String genDeleteAccount;
    
    @Value("${path.path.genUpdateAccount}")
    private String genUpdateAccount;
    
    @GetMapping("${path.getAccounts}")
    public Account[] getAccounts() {
        return requestGetAccounts();
    }
    
    @PostMapping("${path.createAccount}")
    public Account createAccount(@RequestBody Account account) {
    	return requestCreateAccount(account);
    }
    
    @GetMapping("${path.getAccountById}")
    public Account getAccount(@PathVariable Long id) {
        return requestGetAccount(id);
    }
    
    @DeleteMapping("${path.deleteAccount}")
    public Account deleteAccount(@PathVariable Long id) {
        return requestDeleteAccount(id);
    }
    
    @PutMapping("${path.updateAccount}")
    public Account updateAccount(@RequestBody Account account, @PathVariable Long id) {
        return requestUpdateAccount(account, id);
    }

    private Account[] requestGetAccounts() {
    	Account[] response = restTemplate.getForObject(accountURL + genAccounts, Account[].class);
    	return response;
    }
    
    private Account requestCreateAccount(Account account) {
    	Account response = restTemplate.postForObject(accountURL + genCreateAccount, account, Account.class);
    	return response;
    }
    
    private Account requestGetAccount(Long id) {
    	Account response = restTemplate.getForObject(accountURL + genAccountById + id, Account.class);
    	return response;
    }
    
    private Account requestDeleteAccount(Long id) {
    	Account response = restTemplate.getForObject(accountURL + genDeleteAccount + id, Account.class);
    	return response;
    }
    
    private Account requestUpdateAccount(Account account, Long id) {
    	Account response = restTemplate.postForObject(accountURL + genUpdateAccount + id, account, Account.class);
    	return response;
    }
    
}