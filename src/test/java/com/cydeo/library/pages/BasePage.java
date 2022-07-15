package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = about:blank
public abstract class BasePage {
    // No page elements added

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "a[href='#dashboard']")
    public WebElement dashboardLink;

    @FindBy(css = "a[href='#users']")
    public WebElement usersLink;

    @FindBy(css = "a[href='#books']")
    public WebElement booksLink;

    @FindBy(css = "#navbarDropdown")
    public WebElement userNameLink;
}