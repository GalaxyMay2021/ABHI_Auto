package stepdefination;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import baseClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.Policy_Details_Notifications;

public class Policy_Details_Option extends BaseClass
{
	Policy_Details_Notifications policy;
	
	@Given("^User enters Policy Details option in chat window$")
	public void enter_PolicyDetails() throws IOException, ParseException, InterruptedException
	{
		policy = new Policy_Details_Notifications();
		policy.enter_PolicyDetails_Option();
	}
	
	@When("^User enters Policy status option in chat window$")
	public void policy_status()
	{
		System.out.println("User select Policy status option");
	}
	
	@Then("^Hyperlink should generated & User navigate to Policy status webpage$")
	public void verify_Hyperlink() throws InterruptedException
	{
		policy = new Policy_Details_Notifications();
		policy.verify_PolicyStatus_Link();
		System.out.println("Test Case Passed!");
	}
}
