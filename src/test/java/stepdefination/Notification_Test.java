package stepdefination;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;

import baseClass.BaseClass;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.WhatsApp_Notification_Module;

public class Notification_Test extends BaseClass
{
    @Before
    public void setup()
    {System.out.println("start");};
    
    @After
    public void tearDown(Scenario scenario)
    {
    	if (scenario.isFailed())
    	{
    		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    		scenario.attach(screenshot, "image/png", "please find below screenshot");
    		BaseClass.closebrowser();
    	}
    }
    
	WhatsApp_Notification_Module whtsApp;
	
	@Given("^Launch WhatsApp_Web url$")
	public void whtsApp_Web() throws IOException, ParseException, InterruptedException
	{
		initialization();
		whtsApp = new WhatsApp_Notification_Module();
		whtsApp.verify_WhatsApp_Title();
	}
	
	@When("^Enter Aditya Birla name in search text box$")
	public void enter_ABHI_Text() throws IOException, ParseException, InterruptedException
	{
		whtsApp = new WhatsApp_Notification_Module();
		whtsApp.enter_ABHI_Text();
	}
	
	@And("^Enter option in chat window$")
	public void enter_Option() throws IOException, ParseException, InterruptedException
	{
		whtsApp = new WhatsApp_Notification_Module();
		whtsApp.bhasha_Badalo();
	}
	
	@Then("^Auto response should appearing with respect to enter option$")
	public void verify_Response() throws IOException, ParseException, InterruptedException
	{
		whtsApp = new WhatsApp_Notification_Module();
		whtsApp.verify_language();
		System.out.println("Test Case Passed!");
	}
}





