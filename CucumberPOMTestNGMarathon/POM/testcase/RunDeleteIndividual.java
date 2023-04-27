package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class RunDeleteIndividual extends BaseClass{
	
	@BeforeTest
	public void setFilename()
	{
		fileName = "DeleteIndividuals";
	}
	
	@Test(dataProvider = "sendData")
	public void runDeleteIndividual(String uName, String pWord, String iName) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(uName).enterPassword(pWord).clickLogin().clickAppLauncherIcon().clickViewAllLink()
		.clickViewIndividualsLink().searchIndividualDelete(iName).chooseDeleteaction().clickDelete()
		.verifyDeleteaction(iName);
		
	}

}
