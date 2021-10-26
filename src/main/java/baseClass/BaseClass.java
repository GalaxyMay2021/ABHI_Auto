package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import utilities.TestUtil;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static String project_location;
	//public static WiniumDriver windriver;

	public static String printCurrentWorkingDir() {
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		path = path.substring(0, path.length() - 1);
		System.out.println(path);
		return path;
	}

	public BaseClass()
	{
		try {
			prop = new Properties();
			// FileInputStream fis = FileInputStream("D:/Eclipse_Workspace/WhatsApp_Web/src/main/java/configuration/Config.properties");
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/configuration/Config.properties");
			prop.load(fis);
		}

		catch (IOException iex) {
			iex.getMessage();
		}
	}

	public static void initialization()
	{
		String browsername = prop.getProperty("Browser");
		//project_Location = prop.getProperty(browsername)
		if (browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browsername.equals("fireFox"))
		{
			System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("Url"));
	}

	public static void closebrowser() 
	{
		driver.quit();
	}
}
