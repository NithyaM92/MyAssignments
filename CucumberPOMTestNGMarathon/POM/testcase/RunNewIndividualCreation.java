package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class RunNewIndividualCreation extends BaseClass {
	
	@BeforeTest
	public void setFilename()
	{
		fileName = "CreateIndividuals"; 
	}
	
	@Test(dataProvider = "sendData")
	public void runNewIndiviudal(String uName, String PWord, String lName)
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(uName).enterPassword(PWord).clickLogin().clickAppLauncherIcon()
		.clickViewAllLink().clickViewIndividualsLink().clickIndividualdropdown()
		.clickNewIndividual().enterLastNameinForm(lName).clickSave().verifyNewIndividual(lName);
		
		
	}
	
}
