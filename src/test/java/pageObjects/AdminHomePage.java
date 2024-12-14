package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminHomePage extends BasePage {

	public AdminHomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[text()='Hi, Admin User']") // Admin Homepage heading
	WebElement msgHeading;

	@FindBy(xpath = "//*[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk']//*[@width='17' and @height='17']")
	WebElement arowLogout;

	@FindBy(xpath = "//*[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium font-aspekta-400 css-1fnfyr6']")
	WebElement btnLogout;

	public boolean isAdminHomepage() {
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}

	}

	public void clickArowLogout() {
		arowLogout.click();
	}

	public void clickBtnLogout() {
		btnLogout.click();
	}
}
