package pages;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

import java.util.Locale;

public class RegisterPage extends BasePage{

    By signInLink = By.xpath("//a[text()=\"Sign in\"]");
    By registerYourAcoountLink = By.xpath("//a[text()=\"Register your account\"]");
    By firstNameField = By.id("first_name");
    By lastNameField = By.id("last_name");
    By dateOfBirthField = By.id("dob");
    By addressField = By.id("address");
    By postcodeField = By.id("postcode");
    By cityField = By.id("city");
    By stateField = By.id("state");
    By countryField = By.id("country");
    By phoneNumberField = By.id("phone");
    By emailField = By.xpath("//input[@id='email']");
    By passwordField = By.xpath("//input[@id='password']");
    By registerButton = By.xpath("//button[text()=\"Register\"]");
    By loginEmailField = By.id("email");
    By loginPasswordField = By.id("password");
    By loginButton = By.xpath("//input[@type=\"submit\"]");
    By usermenu = By.id("user-menu");
    By myAccountPageTitle = By.cssSelector("h1[data-test='page-title']");
    By myMenuProfile = By.cssSelector("a[data-test='nav-profile']");

    private String username;
    private String password;

    private static final Logger log = LogManager.getLogger(RegisterPage.class.getName());

    Faker faker = new Faker(new Locale("en-US"));
    public RegisterPage(WebDriver driver) {
        super(driver);
    }




    public RegisterPage registerUser(){
        //clickOnElement(signInLink);
        //clickOnElement(registerYourAcoountLink);

        log.info("Username: " + username);
        log.info("Password: " + password);
        typeIn(firstNameField, "Rick");
        typeIn(lastNameField, "Grimes");

        typeIn(dateOfBirthField, "05151975" );
        typeIn(addressField, "Oak Street");
        typeIn(postcodeField, "123456");
        typeIn(cityField, "Atlanta");
        typeIn(stateField, "Georgia");
        clickOnElement(countryField);
        Select countryDropdown = new Select(driver.findElement(countryField));
        countryDropdown.selectByVisibleText("United States of America (the)");
        typeIn(phoneNumberField, "456879");
        typeIn(emailField, "rick.grimes75@gmail.com");
        typeIn(passwordField, "Rickg1975");
        clickOnElement(registerButton);
        Utils.waitForSeconds(2);
        return this;

    }

     public RegisterPage goToRegisterPage(){
        clickOnElement(signInLink);
        clickOnElement(registerYourAcoountLink);
        return this;
     }


     public boolean isUserRegistered(){
        return matchesExpectedText(myAccountPageTitle,"My account") &&
                matchesExpectedText(myMenuProfile,"Profile");
     }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
