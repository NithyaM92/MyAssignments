package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class RunEditIndividual extends BaseClass {

	@BeforeTest
	public void setFilename()
	{
		fileName = "EditIndividual" ;
	}
	
	@Test (dataProvider = "sendData")
	public void runEditIndividual(String uName, String pWord, String iName, String fName, String res) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(uName).enterPassword(pWord).clickLogin().clickAppLauncherIcon()
		.clickViewAllLink().clickViewIndividualsLink().searchIndividualforEdit(iName)
		.chooseEditaction().enterFirstName(fName).chooseSalutation(res).clickSaveforEdit().verifyEditaction(fName);
	}
	
}
