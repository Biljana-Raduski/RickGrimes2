package tests;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {


    protected WebDriver driver;
    protected SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)

    public void setup() {
        driver = DriverManager.getDriver();
        softAssert = new SoftAssert();
        driver.get("https://practicesoftwaretesting.com/#/");



        }
    }



