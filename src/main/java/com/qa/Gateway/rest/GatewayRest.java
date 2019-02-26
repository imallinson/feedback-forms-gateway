package com.qa.Gateway.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	@Value("${url.accounts}")
	private String accountURL;

	@Value("${path.genAddAccount}")
	private String addAccount;

	@PostMapping("${path.getAddAccount}")
	public Account addAccount(@RequestBody Account account) {
		return requestAddAccount(account);
	}

	private Account requestAddAccount(Account account) {
		Account response = restTemplate.postForObject(accountURL + addAccount, account, Account.class);
		return response;
	}

	// GatewayAPI --> FeedbackFormAPI [Post Request]

	@Value("${url.feedbackForm}")
	private String feedbackFormURL;

	@Value("${path.genAddFeedbackForm}")
	private String addFeedbackForm;

	@PostMapping("${path.getAddFeedbackForm}")
	public FeedbackForm addFeedbackForm(@RequestBody FeedbackForm feedbackForm) {
		return requestAddFeedbackForm(feedbackForm);
	}

	private FeedbackForm requestAddFeedbackForm(FeedbackForm feedbackForm) {
		FeedbackForm response = restTemplate.postForObject(feedbackFormURL + addFeedbackForm, feedbackForm,
				FeedbackForm.class);
		return response;
	}

	// GatewayAPI --> CohortAPI [POST Request]

	@Value("${url.cohort}")
	private String cohortURL;

	@Value("${path.genAddCohort}")
	private String addCohort;

	@PostMapping("${path.getAddCohort}")
	public Cohort addCohort(@RequestBody Cohort cohort) {
		return requestAddCohort(cohort);
	}

	private Cohort requestAddCohort(Cohort cohort) {
		Cohort response = restTemplate.postForObject(cohortURL + addCohort, cohort, Cohort.class);
		return response;
	}

	// GatewayAPI --> RetriverAPI ---> DB(Account)[ GET, PUT, DELETE - Requests ]

	@Value("${url.retriever}")
	private String retrieverURL;

	@Value("${path.genAccounts}")
	private String getAccounts;

	@GetMapping("${path.getAccounts}")
	public Account[] getAccounts() {
		return requestGetAccount();
	}

	private Account[] requestGetAccount() {
		Account[] response = restTemplate.getForObject(retrieverURL + getAccounts, Account[].class);
		return response;
	}

	@Value("${path.genAccountByAccountID}")
	private String getAccountByAccountID;

	@GetMapping("${path.getAccountByAccountID}")
	public Account getAccountByAccountID(@PathVariable Long id) {
		return requestGetAccountByAccountID(id);
	}

	private Account requestGetAccountByAccountID(Long id) {
		Account response = restTemplate.getForObject(retrieverURL + getAccountByAccountID + id, Account.class);
		return response;
	}

	@Value("${path.genAccountsByCohortID}")
	private String getAccountsByCohortID;

	@GetMapping("${path.getAccountsByCohortID}")
	public Account[] getAccountsByCohortID(@PathVariable Long id) {
		return requestGetAccountsByCohortID(id);
	}

	private Account[] requestGetAccountsByCohortID(Long id) {
		Account[] response = restTemplate.getForObject(retrieverURL + getAccountsByCohortID + id, Account[].class);
		return response;
	}

	@Value("${path.genAccountByEmail}")
	private String genAccountByEmail;

	@GetMapping("${path.getAccountByEmail}")
	public Account getAccountByEmail(@PathVariable String email) {
		return requestGetAccountByEmail(email);
	}

	private Account requestGetAccountByEmail(String email) {
		Account response = restTemplate.getForObject(retrieverURL + genAccountByEmail + email, Account.class);
		return response;
	}

	@Value("${path.genUpdateAccount}")

	private String genUpdateAccount;

	@PutMapping("${path.getUpdateAccount}")
	public ResponseEntity<String> getUpdateAccountBy_id(@RequestBody Account account, @PathVariable String id) {
		return requestUpdateAccountBy_id(account, id);
	}

	private ResponseEntity<String> requestUpdateAccountBy_id(Account account, String id) {
		HttpEntity<Account> entity = new HttpEntity<Account>(account);
		return restTemplate.exchange(retrieverURL + genUpdateAccount + id, HttpMethod.PUT, entity, String.class);
	}

	// GatewayAPI --> RetriverAPI ---> DB(FeedbackForm)[ GET, PUT, DELETE - Requests
	// ]

	@Value("${path.genAllFeedbackForms}")
	private String genAllFeedbacksPath;

	@GetMapping("${path.getAllFeedbacks}")
	public FeedbackForm[] getAllFeedbackForms() {
		return requestGetAllFeedbackForms();
	}

	private FeedbackForm[] requestGetAllFeedbackForms() {
		FeedbackForm[] response = restTemplate.getForObject(retrieverURL + genAllFeedbacksPath, FeedbackForm[].class);
		return response;
	}

	@Value("${path.genFeedbackFormByID}")
	private String genFeedbackFormByID;

	@GetMapping("${path.getFeedbackFormByID}")
	public FeedbackForm getFeedbackFormByID(@PathVariable Long feedbackID) {
		return requestGetFeedbackFormByID(feedbackID);
	}

	private FeedbackForm requestGetFeedbackFormByID(Long feedbackID) {
		FeedbackForm response = restTemplate.getForObject(retrieverURL + genFeedbackFormByID + feedbackID,
				FeedbackForm.class);
		return response;
	}

	@Value("${path.genFeedbackFormsByAccountID}")
	private String genFeedbackFormsByAccountID;

	@GetMapping("${path.getFeedbackFormsByAccountID}")
	public FeedbackForm[] getFeedbackFormsByAccountID(@PathVariable Long accountID) {
		return requestGetFeedbackFormsByAccountID(accountID);
	}

	private FeedbackForm[] requestGetFeedbackFormsByAccountID(Long accountID) {
		FeedbackForm[] response = restTemplate.getForObject(retrieverURL + genFeedbackFormsByAccountID + accountID,
				FeedbackForm[].class);
		return response;
	}

	// GatewayAPI --> RetriverAPI ---> DB(Cohort)[ GET, PUT, DELETE - Requests ]

	@Value("${path.genCohorts}")
	private String genCohorts;

	@GetMapping("${path.getCohorts}")
	public Cohort[] getCohorts() {
		return requestGetCohorts();
	}

	private Cohort[] requestGetCohorts() {
		Cohort[] response = restTemplate.getForObject(retrieverURL + genCohorts, Cohort[].class);
		return response;
	}

	@Value("${path.genCohortbyID}")
	private String genCohortbyID;

	@GetMapping("${path.getCohortbyID}")
	public Cohort getCohortbyID(@PathVariable Long id) {
		return requestGetCohortbyID(id);
	}

	private Cohort requestGetCohortbyID(Long CohortID) {
		Cohort response = restTemplate.getForObject(retrieverURL + genCohortbyID + CohortID, Cohort.class);
		return response;
	}

	@Value("${path.genUpdateWeekNumber}")
	private String genUpdateWeekNumber;

	@PutMapping("${path.getUpdateWeekNumber}")
	public ResponseEntity<Long> getUpdateWeekNumber(@PathVariable Long cohortID) {
		return requestUpdateWeekNumber(cohortID);
	}

	private ResponseEntity<Long> requestUpdateWeekNumber(Long cohortID) {
		Cohort cohort = new Cohort();
		HttpEntity<Cohort> entity = new HttpEntity<Cohort>(cohort);

		return restTemplate.exchange(retrieverURL + genUpdateWeekNumber + cohortID, HttpMethod.PUT, entity,
				Long.class);

	}

}
