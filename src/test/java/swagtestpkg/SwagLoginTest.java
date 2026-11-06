package swagtestpkg;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basepkgswag.SwagBase;



public class SwagLoginTest extends SwagBase

{

	@Test (priority = 1) 
	
	public void titleverification_mthd()
	{
		String actualtitle = loginobj.titlemethod();
		Assert.assertEquals(actualtitle, "Swag Labs");
	}
	
	@Test (priority = 2) 
	public void  login_validation_method()
	{
		loginobj.loginmethod("standard_user", "secret_sauce");
		
	}
	
	@Test(priority = 3) 
	public void urlValidation()
	{
		String HomeUrl = loginobj.urlmethod();
		System.out.println(HomeUrl);
		//Assert.assertEquals( HomeUrl,"https://www.saucedemo.com/inventory.html");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
		
	}
}

