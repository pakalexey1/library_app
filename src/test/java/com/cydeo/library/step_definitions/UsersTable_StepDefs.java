package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.pages.UsersPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class UsersTable_StepDefs {

    LoginPage loginPage = new LoginPage();
    UsersPage usersPage = new UsersPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
        loginPage.login("librarian22@library", "JUXl6dnx");
    }

    @Given("I click on {string} link")
    public void i_click_on_link(String link) {

        wait.until(ExpectedConditions.visibilityOf(usersPage.dashboardLink));

        switch (link.toLowerCase()){
            case "dashboard":
                usersPage.dashboardLink.click();
                break;
            case "users":
                usersPage.usersLink.click();
                break;
            case "books":
                usersPage.booksLink.click();
                break;
        }
    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedHeaders) {
        wait.until(ExpectedConditions.visibilityOf(usersPage.usersTableHeader.get(0)));

        List<String>actualHeaders = new ArrayList<>();
        for (WebElement each : usersPage.usersTableHeader){
            actualHeaders.add(each.getText());
        }

        Assert.assertEquals(expectedHeaders, actualHeaders);
    }

}
