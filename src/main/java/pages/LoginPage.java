package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    By loginEmailField = By.id("email");
    By loginPasswordField = By.id("password");
    By loginButton = By.xpath("//input[@type=\"submit\"]");
    By signInLink = By.xpath("//a[text()=\"Sign in\"]");
    By registerYourAcoountLink = By.xpath("//a[text()=\"Register your account\"]");
    By userNameInMenu = By.id("user-menu");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginForm(){
        clickOnElement(signInLink);
        return this;
    }


    public LoginPage loginUser(String username, String password){
       // clickOnElement(signInLink);
       // clickOnElement(registerYourAcoountLink);
        typeIn(loginEmailField, username);
        typeIn(loginPasswordField, password);
        clickOnElement(loginButton);
        return this;

    }


public boolean isUserLoggedIn(){
        return matchesExpectedText(userNameInMenu, " Rick Grimes ");


}



}
