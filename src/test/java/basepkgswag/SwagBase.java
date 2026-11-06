package basepkgswag;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import swagpagepkg.SwagLoginPage;
import swagpagepkg.SwagHomePage;
import swagpagepkg.SwagCartPage;
import swagpagepkg.SwagCheckoutPage;
import swagpagepkg.SwagPaymentPage;

public class SwagBase {

    public static WebDriver driver;

    public SwagLoginPage loginobj;
    public SwagHomePage homepageobj;
    public SwagCartPage cartobj;
    public SwagCheckoutPage checkoutobj;
    public SwagPaymentPage paymentobj;

    public static ExtentSparkReporter reporter;
    public static ExtentReports extent;
    public static ExtentTest test;


    @BeforeTest
    public void setup() {

        reporter = new ExtentSparkReporter("./Reports/myreport1.html");

        reporter.config().setDocumentTitle("Automationreport");
        reporter.config().setReportName("functional test");
        reporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Hostname", "localhost");
        extent.setSystemInfo("OS", "Windows10");
        extent.setSystemInfo("Tester Name", "abc");
        extent.setSystemInfo("Browser Name", "chrome");

        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();
    }


    @BeforeMethod
    public void mthd(Method method) {

        loginobj = new SwagLoginPage(driver);

        homepageobj = new SwagHomePage(driver);

        cartobj = new SwagCartPage(driver);

        checkoutobj = new SwagCheckoutPage(driver);

        paymentobj = new SwagPaymentPage(driver);

        test = extent.createTest(method.getName());
    }


    @AfterMethod
    public void aftrmthd(ITestResult result) throws Exception {

        if (result.getStatus() == ITestResult.FAILURE) {

            test.log(Status.FAIL,
                    "Test case failed is " + result.getName());

            test.log(Status.FAIL,
                    "Test case failed is " + result.getThrowable());

            String screenshotpath =
                    screenshotmethod(driver, result.getName());

            test.addScreenCaptureFromPath(screenshotpath);
        }

        else if (result.getStatus() == ITestResult.SUCCESS) {

            test.pass("Test passed : " + result.getName());
        }

        else if (result.getStatus() == ITestResult.SKIP) {

            test.skip("Test skipped : " + result.getName());
        }
    }


    private String screenshotmethod(WebDriver driver, String name)
            throws Exception {

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        String destination =
                System.getProperty("user.dir")
                + "/Screenshot/" + name + ".png";

        FileHandler.copy(src, new File(destination));

        return destination;
    }


    @AfterTest
    public void endReport() {

        extent.flush();

        driver.quit();
    }
}