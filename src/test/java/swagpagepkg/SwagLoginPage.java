package swagpagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLoginPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id='user-name']")
    WebElement Username;

    @FindBy(xpath = "//*[@id='password']")
    WebElement Password;

    @FindBy(xpath = "//*[@id='login-button']")
    WebElement LoginBtn;

    public SwagLoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String titlemethod() {

        String title = driver.getTitle();
        return title;
    }

    public void loginmethod(String un, String pwd) {

        Username.sendKeys(un);
        Password.sendKeys(pwd);
        LoginBtn.click();
    }

    public String urlmethod() {

        String actualurl = driver.getCurrentUrl();
        return actualurl;
    }
}