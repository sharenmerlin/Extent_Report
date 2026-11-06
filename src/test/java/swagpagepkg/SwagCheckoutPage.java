package swagpagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagCheckoutPage {
	WebDriver driver;

    @FindBy(xpath = "//*[@id=\"first-name\"]")
    WebElement firstname;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    WebElement lastname;

    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    WebElement postalcode;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    WebElement continuebtn;

    public SwagCheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkoutdetails(String fname, String lname, String postal) {
        firstname.sendKeys(fname);
        lastname.sendKeys(lname);
        postalcode.sendKeys(postal);
    }

    public void continuemethod() {
        continuebtn.click();
    }
}
