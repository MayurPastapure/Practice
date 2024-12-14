package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@type='email']")
	WebElement txtEmail;

	@FindBy(xpath = "//*[@type='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement btnSubmit;

	@FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-body1 font-aspekta-500 css-kzh04t']")
	WebElement msgErrorMessage;

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickSubmit() {
		btnSubmit.click();
	}

	public void clearField() {
		txtEmail.clear();
		txtPassword.clear();
	
	}
	public void refreshPage() {
		driver.navigate().refresh();
	}

	public String getErrorMessage() {
		try {
			return (msgErrorMessage.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
