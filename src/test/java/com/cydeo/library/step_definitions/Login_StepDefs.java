package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class Login_StepDefs {

    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        wait.until(ExpectedConditions.visibilityOfAllElements (loginPage.emailInput));
        loginPage.login(ConfigurationReader.getProperty("librarian_user"), ConfigurationReader.getProperty("librarian_pass"));
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        wait.until(ExpectedConditions.urlContains("dashboard"));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
    }

//    @When("I login as a student")
//    public void i_login_as_a_student() {
//
//    }
//    @Then("books should be displayed")
//    public void books_should_be_displayed() {
//
//    }

    @When("I login as a {string}")
    public void iLoginAsA(String userType) {
        loginPage.dynamicLogin(userType);
    }

    @Then("{string} should be displayed")
    public void shouldBeDisplayed(String expectedUrl) {
        wait.until(ExpectedConditions.urlContains(expectedUrl));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedUrl));
    }
}
