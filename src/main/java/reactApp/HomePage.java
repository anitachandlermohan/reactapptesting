package reactApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(xpath = "//*[@id=\"root\"]/div/ul/li[10]/a")
	private WebElement linkToForm;
	
	public void clickLinkToForm() {
		linkToForm.click();
	}
}
