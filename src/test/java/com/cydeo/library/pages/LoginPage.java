package com.cydeo.library.pages;

import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://library2.cydeo.com/login.html
public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(css = "button")
    public WebElement signInButton;

    public void login(String username, String password) {
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    public void dynamicLogin(String userType) {
        String username = ConfigurationReader.getProperty(userType + "_user");
        String password = ConfigurationReader.getProperty(userType + "_pass");
        login(username,password);
    }


}