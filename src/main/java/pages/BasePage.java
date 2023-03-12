package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final Logger log = LogManager.getLogger(BasePage.class.getName());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    protected WebElement getElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    protected void clickOnElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    protected void typeIn(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    protected String getTextFromElement(By locator) {
        return getElement(locator).getText();
    }

    protected void hover(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = getElement(locator);
        actions.moveToElement(element)
                .build()
                .perform();
    }

    protected void hoverAndClick(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = getElement(locator);
        actions.moveToElement(element)
                .click()
                .build()
                .perform();
    }


    protected boolean matchesExpectedText(By locator, String expectedText) {
        WebElement element = getElement(locator);
        if (element.equals(expectedText)) {
            log.info("PASSED - text found in element" + element.getText() + " MATCHES expected text" + expectedText);
            return true;
        }else {
            log.error("FAILED - text found in element" + element.getText() + " DOES NOT MATCHES expected text" + expectedText);
    }
return false;





   // protected boolean isElementVisible(By locator){
       // List<WebElement> list = driver.findElements(locator);
       // if (!list.isEmpty() && (list.get(0)!=null)){
           // return list.get(0).isDisplayed();
        }

        //return false;

    }




