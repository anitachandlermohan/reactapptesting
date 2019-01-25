package reactApp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {
	WebDriverWait wait;
	Actions action;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/button")
	private WebElement countryButton;
	
	@FindBy(id = "nameInput")
	private WebElement enterEmail;
	
	@FindBy(id = "passInput")
	private WebElement enterPassword;
	
	@FindBy(id = "passInput2")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/button")
	private WebElement submitButton;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/h1")
	private WebElement status;
	@FindBy( xpath = "//*[@id=\"root\"]/div/div/p[10]")
	private WebElement passwordsDontMatch;
	
//	@FindBys({
//		@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[1]"),
//		@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[2]"),
//		@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[3]")})
	
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[1]")
	private WebElement unitedKingdom;
	@FindBy(xpath =  "//*[@id=\"root\"]/div/div/div/div/a[2]")
	private WebElement france;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[3]")
	private WebElement germany;
	
	List<WebElement> countryOptions = new ArrayList<WebElement>();
	
	public void selectCountry(String country) {
		countryOptions.add(unitedKingdom);
		countryOptions.add(france);
		countryOptions.add(germany);
		countryButton.click();
		for(WebElement countryOption : countryOptions) { 
			String countryText = countryOption.getText();
			if(countryText.contains(country)) {
				countryOption.click();
			}
		}
		
		
		
	}
	
	public void enterEmail(String email) {
		enterEmail.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		enterPassword.sendKeys(password);
	}
	
	public void confirmPassword(String password) {
		confirmPassword.sendKeys(password);
		
	}
	public void submitForm(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		submitButton.click();
	}
	 
	public String returnStatus() {
		if(status.getText().equals("Success!")) {
		return status.getText();
	}
		else {
			return passwordsDontMatch.getText();
		}
	}
}
