package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// page_url = https://library2.cydeo.com/#dashboard
public class LandingPage {

    public LandingPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user_count")
    public WebElement userCount;

    // No page elements added


}