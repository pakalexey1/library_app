package com.cydeo.library.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BrowserUtils {
    /**
     * A method to pause the thread for certain number of seconds
     */
    public static void waitFor(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * A method that returns a list of text of WebElements
     */
    public static List<String> getElementsText(List<WebElement> elements){
        List<String> elementsText = new ArrayList<>();
        for (WebElement eachElement : elements){
            elementsText.add(eachElement.getText());
        }

        return elementsText;
    }

    public static List<String> getElementsTextWithStream(List<WebElement> elements) {

        return elements.stream().map(x->x.getText()).collect(Collectors.toList());
    }

    /**
     * A method that waits for a provided element to become clickable
     */
    public static WebElement waitForClickability(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for alerIsPresent
     */
    public static void waitForAlertIsPresent(int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),timeout);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Clicks on an element using JavaScript
     */
    public static void clickWithJS(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",element);
    }
    /**
     * Scrolls down to an element using JavaScript
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }


}
