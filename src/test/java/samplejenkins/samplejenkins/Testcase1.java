package samplejenkins.samplejenkins;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import static UtilPage.Homepage.*;
import io.github.bonigarcia.wdm.WebDriverManager;

class Testcase1 
{
	 
	 
	@Test
	void test() throws IOException 
	{
		
		String path="D:\\NeareshItEclipse\\samplejenkins\\target\\extentions_reports.html";
		reports= new ExtentReports(path);
		test=reports.startTest("starting reports");
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		test.log(LogStatus.INFO,"Browser launch successfully");
		
		driver.manage().window().maximize();
		
		driver.get("https://www.apsrtconline.in/oprs-web/guest/home.do?h=1");
		test.log(LogStatus.INFO,"URL invoke successfully");
		String text=driver.findElement(By.xpath("//h1[normalize-space(text()='Search for bus tickets!')]")).getText();
		if(text.equals("Search for bus tickets!"))
		{
			test.log(LogStatus.PASS,"Related Text match successfully"+test.addScreenCapture(CaptureScreen("APSRTC.png")));
		}
		driver.close();
		test.log(LogStatus.INFO,"Brower closed");
		
		reports.endTest(test);
		reports.flush();
		reports.close();
		new ChromeDriver().get(path);
		
	}
	
	

}
