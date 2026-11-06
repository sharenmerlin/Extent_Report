package swagpagepkg;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagHomePage {
	
WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
			WebElement products;
	@FindBy(tagName = "a")List<WebElement> links;
	@FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
			WebElement add_to_cart;
	
	public SwagHomePage(WebDriver driver) 
	{
		
		 this.driver = driver;
	     PageFactory.initElements(driver, this);
		
	}
	
	public String textmethod()
	{
		String actual_text = products.getText();
		return actual_text;
		
	}
	
	public int linkcountmethod()
	{

	int count = links.size();
	return count;
		
	}
	
	public void cart_btn_method()
	{
		add_to_cart.click();
	}

}
