package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email, String password,String exp)
	{
		logger.info("*** Starting TC_003_LoginDDT******");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
				
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(email);
		lp.setPassword(password); 
		lp.clickLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
				
		if(exp.equals("Valid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
				
		}
		
		if(exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*** Finished TC_003_LoginDDT******");	
		
	}
	
}









