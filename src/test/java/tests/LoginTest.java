package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

public class LoginTest extends BaseTest{

     LoginPage loginPage;

    @BeforeMethod
    public void localSetuo(){

        loginPage = new LoginPage(driver);
    }


@Test
    public void loginUserTest(){

   loginPage.goToLoginForm()
           .loginUser("rick.grimes75@gmail.com", "Rickg1975");
    Assert.assertTrue(loginPage.isUserLoggedIn());


}





}
