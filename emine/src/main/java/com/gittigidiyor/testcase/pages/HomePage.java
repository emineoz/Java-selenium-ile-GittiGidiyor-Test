package com.gittigidiyor.testcase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    By mainScreen = By.className("f2lc5a-0");
    By closeCookiesButtonBy = By.xpath("//*[@id=\"__next\"]/main/div[3]/section[1]/section[2]/a/span");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getHomePageTitle(){
        return webDriver.getTitle();
    }

    public void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainScreen));
    }

    public void closeCookiesPopUp(){
        click(closeCookiesButtonBy,10);
    }
}
