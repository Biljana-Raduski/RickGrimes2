package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    RegisterPage registerPage;
    LoginPage loginPage;


    @BeforeMethod
    public void localSetuo(){
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }


    @Test
    public void registerUserTest() {
        registerPage.goToRegisterPage()
                .registerUser();
        loginPage.loginUser(registerPage.getUsername(), registerPage.getPassword());
        Assert.assertTrue(registerPage.isUserRegistered());

    }


}
