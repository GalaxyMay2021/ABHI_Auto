package pageClass;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;
import utilities.TestUtil;
import utilities.Utility;

public class Policy_Details_Notifications extends BaseClass
{
	@FindBy(xpath="//div[@data-tab='9']")
	WebElement type_message;
	
	@FindBy(xpath="//a[@title]")
	WebElement policy_status;
	
	@FindBy(xpath="//span[contains(text(), '80D Certificate')]")
	WebElement _80DCertificate;	
	
	Utility ul = new Utility();
	
	public Policy_Details_Notifications()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enter_PolicyDetails_Option() throws IOException, ParseException, InterruptedException
	{
		
		List<JSONObject> jcred = ul.GetJsonData(System.getProperty("user.dir") + "/src/main/java/testData/testdata.json", "Details");		
		 JSONObject jo = jcred.get(0);		 
		 String enter_PolicyDetails_option = (String) jo.get("Policy_Details");
		 String enter_PolicyStatus_option = (String) jo.get("Policy_Status");
		 type_message.sendKeys(enter_PolicyDetails_option);
		 type_message.sendKeys(Keys.ENTER);
		 WebDriverWait wait = new  WebDriverWait(driver, TestUtil.EXPLICIT_WAIT);
		 wait.until(ExpectedConditions.visibilityOf(_80DCertificate));
		 if(_80DCertificate.isDisplayed())
		 {
			 type_message.sendKeys(enter_PolicyStatus_option);
			 type_message.sendKeys(Keys.ENTER);			 
		 }
	}
	
	public void verify_PolicyStatus_Link() throws InterruptedException
	{
		WebDriverWait wait = new  WebDriverWait(driver, TestUtil.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(policy_status));
		if(policy_status.isDisplayed())
		{
			policy_status.click();
			Thread.sleep(15000);
			driver.close();
			Thread.sleep(5000);
			
		}
		BaseClass.closebrowser();
	}
	
	

}
