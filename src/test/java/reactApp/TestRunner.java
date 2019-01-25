package reactApp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import reactApp.Constants;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:")
public class TestRunner {
	
	static ExtentReports extent;
	static ExtentTest test;
	WebDriverWait wait;
	
	@BeforeClass
	public static void setUp() {
	extent = new ExtentReports(Constants.REPORT_URL,true);
	test = extent.startTest("first test");
	test.log(LogStatus.INFO, "Browser started"); 
		
	}
	@AfterClass
	public static void tearDown() {
		extent.flush();
		
	}
	

}