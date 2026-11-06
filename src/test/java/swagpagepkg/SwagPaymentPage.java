package swagpagepkg;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagPaymentPage {
	 WebDriver driver;

	    @FindBy(id = "finish")
	    WebElement finishbtn;

	    public SwagPaymentPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void screenshotmethod() throws IOException {

	        File src = ((TakesScreenshot) driver)
	                .getScreenshotAs(OutputType.FILE);

	        FileUtils.copyFile(src,
	                new File("./MavenProject/Screenshot/payment.png"));
	    }

	    public void finishmethod() {
	    	WebDriverWait wait =
	    	        new WebDriverWait(driver, Duration.ofSeconds(10));

	    	    wait.until(
	    	        ExpectedConditions.elementToBeClickable(By.id("finish"))
	    	    ).click();
	    }

}
