package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AdminHomePage;
import pageObjects.LoginPage;
import testBase.BaseClase;
import utilities.DataProviders;

public class LoginTest extends BaseClase {

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void verify_correctlogin(String email, String password, String status) throws InterruptedException {
		logger.info("***Starting test case verify_correctlogin***");

		LoginPage lp = new LoginPage(driver);
		//lp.clearField();
		lp.refreshPage();
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickSubmit();

		AdminHomePage ahp = new AdminHomePage(driver);
		boolean targetPage = ahp.isAdminHomepage();

		if (status.equalsIgnoreCase("Correct")) // Login success
		{
			if (targetPage == true) {           // test pass
				ahp.clickArowLogout();
				ahp.clickBtnLogout();
				Assert.assertTrue(true);
			}

			else {
				Assert.assertTrue(false);          // test fail
			}
			
		}
		if (status.equalsIgnoreCase("Incorrect")) // Login failed
		{
			if (targetPage == true) {             // test fail
				ahp.clickArowLogout();
				ahp.clickBtnLogout();
				Assert.assertTrue(false);
			}

			else {
				Assert.assertTrue(true);           // test pass
			}
		}

	}
}
