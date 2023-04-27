package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class RunLogin extends BaseClass {
	
	@BeforeTest
	public void setFileName()
	{
		fileName = "LoginSalesforce";
	}
	
	@Test(dataProvider = "sendData")
	public void runLogin(String uName, String pWord)
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(uName).enterPassword(pWord).clickLogin();
	}

}
