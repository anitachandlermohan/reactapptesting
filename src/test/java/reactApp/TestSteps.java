package reactApp;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reactApp.Constants;
import reactApp.TestRunner;

public class TestSteps {
	ChromeDriver driver;
	ExtentReports extent;
	ExtentTest test;
	WebDriverWait wait;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_URL);
		extent = TestRunner.extent;
		test = extent.startTest("react app testing ");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
		test.log(LogStatus.INFO, "navigated to home");
	}
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
		
	}
	 
	@Given("^I navigate to the React Application$")
	public void i_navigate_to_the_React_Application() {
	driver.manage().window().maximize();
	driver.get(Constants.HOME_PAGE_URL);
	}

	@When("^I click the Link to Automated Testing Exercise Form$")
	public void i_click_the_Link_to_Automated_Testing_Exercise_Form()  {
	   HomePage home = PageFactory.initElements(driver, HomePage.class);
	   home.clickLinkToForm();
	}

	@When("^I fill click the \"([^\"]*)\" dropdown menu$")
	public void i_fill_click_the_dropdown_menu(String arg1)  {
	    FormPage form = PageFactory.initElements(driver, FormPage.class);
	    form.selectCountry(arg1);
	}

	@When("^I fill out the email field with \"([^\"]*)\"$")
	public void i_fill_out_the_email_field_with(String arg1){
		FormPage form = PageFactory.initElements(driver, FormPage.class);
		form.enterEmail(arg1);
	}

	@When("^I fill out the first password field with \"([^\"]*)\"$")
	public void i_fill_out_the_first_password_field_with(String arg1)  {
		FormPage form = PageFactory.initElements(driver, FormPage.class);
		form.enterPassword(arg1);
	}

	@When("^I fill out the second password field with \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with(String arg1) {
		FormPage form = PageFactory.initElements(driver, FormPage.class);
		form.confirmPassword(arg1);
		form.submitForm(wait);
	}

	@Then("^I should see a Success! Message$")
	public void i_should_see_a_Success_Message()  {
		FormPage form = PageFactory.initElements(driver, FormPage.class);
		assertEquals("wrong password", "Success!", form.returnStatus());
	    test.log(LogStatus.PASS, "success!");
	} 

	@When("^I fill out the second password field with the wrong password \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with_the_wrong_password(String arg1) {
		FormPage form = PageFactory.initElements(driver, FormPage.class);
		form.confirmPassword(arg1);
		form.submitForm(wait);
	} 

	@Then("^I should see a message stating that the passwords do not match\\.$")
	public void i_should_see_a_message_stating_that_the_passwords_do_not_match() {
		FormPage form = PageFactory.initElements(driver, FormPage.class); 
		assertEquals("passwords shouldn't match", "The passwords do not match", form.returnStatus());
		test.log(LogStatus.PASS, "passwords dont match!");
	} 

}
