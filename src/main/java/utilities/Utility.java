package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;

public class Utility extends BaseClass
{
	public void click_on_auto_sugg_textBox(WebElement autosuggbox)
	{
		autosuggbox.click();;
	}
	
	public void click_on_auto_sugg_textBox(String partial, WebElement autosuggbox)
	{
		autosuggbox.sendKeys(partial);
	}
	
	public void select_req_from_auto_suggestion(String divList, String reqValue) throws InterruptedException

	{
		Thread.sleep(3000);
		List<WebElement> listItems = driver.findElements(By.xpath(divList));
		System.out.println(listItems.size());
		
		for(int i=0; i< listItems.size(); i++)
		{
			System.out.println(listItems.get(i).getText());
			if(listItems.get(i).getText().equals(reqValue))
			{
				listItems.get(i).click();
				break;
			}
		}
	}
	
	public List<JSONObject> GetJsonData(String JSONPath, String objectDetail) throws IOException, ParseException
	{
		JSONParser jp = new JSONParser();
		FileReader fr = new FileReader(JSONPath);
		JSONObject jobject = (JSONObject) jp.parse(fr);
		JSONArray jsonArray = (JSONArray) jobject.get(objectDetail);
		List<JSONObject> listdata = new LinkedList<JSONObject>();
		if(jsonArray != null)
		{
			for(int i=0; i<jsonArray.size(); i++)
			{
				listdata.add((JSONObject)jsonArray.get(i));
			}
		}
		return listdata;
	}	
}
