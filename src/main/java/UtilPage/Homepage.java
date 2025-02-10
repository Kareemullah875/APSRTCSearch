package UtilPage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Homepage 
{
	 public static WebDriver driver;
	 public static ExtentReports reports;
	 public static ExtentTest test;
	 
	public static String CaptureScreen(String name) throws IOException
	{
		String Screenshot="D:\\NeareshItEclipse\\samplejenkins\\target\\img.png";
		
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr,new File(Screenshot));
		return Screenshot;
		
	}

}
