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
	
	@Given("^User enters Policy kit option in chat window$")
	public void enter_PolicyKit()
	{
		System.out.println("Enter Policy Kit number in chat window.");
	}
	
	@Then("^Allow user to download Policy kit pdf file$")
	public void click_Policy_PdfFile() throws InterruptedException, IOException, ParseException
	{
		policy = new Policy_Details_Notifications();
		policy.enter_PolicyKit_Option();
		System.out.println("Test Case Passed!");
	}
	
	@Given("^User enters E-card option in chat window$")
	public void enter_Ecard_option()
	{
		System.out.println("Enter E-card number in chat window.");
	}
	
	@Then("^Allow user to download E-card pdf file$")
	public void click_EcardPdfFile() throws InterruptedException, IOException, ParseException
	{
		policy = new Policy_Details_Notifications();
		policy.get_Ecard_Details();
		System.out.println("Test Case Passed!");
	}
	
	@Given("^User enters 80D certificate option in chat window$")
	public void enter_80DCert()
	{
		System.out.println("Enter 80D certificate number in chat window.");
	}
	
	@Then("^Allow user to download 80D certificate pdf file$")
	public void click_80DCertPdfFile() throws InterruptedException, IOException, ParseException
	{
		policy = new Policy_Details_Notifications();
		policy.get_80DCertificate();
		System.out.println("Test Case Passed!");
	}
}
