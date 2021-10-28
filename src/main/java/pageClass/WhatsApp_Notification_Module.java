package pageClass;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import baseClass.BaseClass;
import org.junit.Assert;
import utilities.Utility;

public class WhatsApp_Notification_Module extends BaseClass
{
	@FindBy(xpath="//div[@data-tab='3']")
	WebElement search_ABC;
	
	@FindBy(xpath="//div[@data-tab='9' and @role='textbox']")
	WebElement type_message;
	
	@FindBy(xpath="//*[contains (text(), 'Language has been changed to')]")
	WebElement Language_Text;
	
	
	
	Utility ul = new Utility();
	
	public WhatsApp_Notification_Module()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void bhasha_Badalo() throws IOException, ParseException, InterruptedException
	{
		
		List<JSONObject> jcred = ul.GetJsonData(System.getProperty("user.dir") + "/src/main/java/testData/testdata.json", "Language_Details");
		// For single value entered use below method
		 JSONObject jo = jcred.get(0);
		 //String abc_text = (String) jo.get("WhatsApp_Text");
		 String enter_option = (String) jo.get("Change_Language");
		 String enter_option1 = (String) jo.get("Option_Selection");
		 type_message.sendKeys("HI");
		 type_message.sendKeys(Keys.ENTER);
		 Thread.sleep(10000);
		 type_message.sendKeys(enter_option);
		 type_message.sendKeys(Keys.ENTER);		 
		 Thread.sleep(5000);
		 type_message.sendKeys(enter_option1);
		 type_message.sendKeys(Keys.ENTER);		 
		 Thread.sleep(5000);
		 //verify_language();		 
		// int cc = Integer.parseInt((String) jo.get("Username"));
		 
		//Using for Iteration
		/*for (JSONObject tt : xx)
		{
			String aa = (String) tt.get("Username");
			String bb = (String) tt.get("Password");
			
			
		}*/
	}
	
	public void enter_ABHI_Text() throws IOException, ParseException, InterruptedException
	{
		List<JSONObject> jcred = ul.GetJsonData(System.getProperty("user.dir") + "/src/main/java/testData/testdata.json", "Language_Details");
		JSONObject jo = jcred.get(0);
		String abc_text = (String) jo.get("WhatsApp_Text");
		search_ABC.sendKeys(abc_text);
		search_ABC.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
	}
	
	public void verify_WhatsApp_Title() throws InterruptedException
	{
		String ExpectedTitle = "WhatsApp";
		Thread.sleep(15000);
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		Assert.assertEquals(ActualTitle, ExpectedTitle);		
	}
	
	public void verify_language() throws IOException, ParseException, InterruptedException
	{
		List<JSONObject> jcred = ul.GetJsonData(System.getProperty("user.dir") + "/src/main/java/testData/testdata.json", "Language_Details");
		JSONObject jo = jcred.get(0);
		String language = (String) jo.get("Language");		
		String Expectedtext = "Language has been changed to "+language;
		Thread.sleep(10000);
		String Actualtext = Language_Text.getText();
		Assert.assertEquals(Actualtext, Expectedtext);					
		//BaseClass.closebrowser();
	}
	
	
	
}
