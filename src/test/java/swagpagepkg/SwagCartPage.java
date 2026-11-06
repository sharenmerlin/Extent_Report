package swagpagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagCartPage {
	
	WebDriver driver;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    WebElement cart;

    @FindBy(xpath = "//*[@id='header_container']/div[2]/span")
    WebElement title;

    @FindBy(xpath = "//*[@id='checkout']")
    WebElement checkout;

    public SwagCartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Click cart
    public void cartmethod()
    {
        cart.click();
    }

    // Get cart page title
    public String titlemethod()
    {
        return title.getText();
    }

    // Click checkout
    public void checkoutmethod()
    {
        checkout.click();
    }
	
	

}
