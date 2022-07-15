package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LandingPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWithParam_StepDefs {

    LoginPage loginPage = new LoginPage();
    LandingPage landingPage = new LandingPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    @When("I enter username {string}")
    public void i_enter_username(String username) {
       loginPage.emailInput.sendKeys(username);
    }
    @When("I enter password {string}")
    public void i_enter_password(String password) {
       loginPage.passwordInput.sendKeys(password);
    }
    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.signInButton.click();
    }
//    @When("there should be {string} users")
//    public void there_should_be_users(String expectedNumberOfUsers) {
//        wait.until(ExpectedConditions.urlContains("dashboard"));
//        Assert.assertEquals(landingPage.userCount.getText(),expectedNumberOfUsers);
//    }
}
