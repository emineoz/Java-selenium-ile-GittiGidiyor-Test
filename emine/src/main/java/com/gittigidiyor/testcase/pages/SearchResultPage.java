package com.gittigidiyor.testcase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class SearchResultPage extends BasePage {

    By selectfiltre = By.xpath("//*[@id=\"Ücretsiz Kargo\"]/div");
   // By filtremessage = By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div/div[1]/div/div/div/div[1]/div[2]/div/div/button/span");


    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public By randomSelectProductBy() {
        Random random = new Random();
        int rand = random.nextInt(31) + 1;
        return By.cssSelector("#\\32  > li:nth-child(" + rand + ")");
    }

    public void choosePage(String pageNumber) {

        webDriver.get(webDriver.getCurrentUrl() + "&sf=" + pageNumber);
    }

    public String selectfiltre() {

        By filtremessage = By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div/div[1]/div/div/div/div[1]/div[2]/div/div/button/span");
        click(selectfiltre, 10);
         System.out.println("filtre message:" + getText(filtremessage));
        return webDriver.findElement(filtremessage).getText();

    }

        public ProductDetailsPage goToProductDetails () {
            click(randomSelectProductBy(), 10);
            return new ProductDetailsPage(webDriver);
        }


    }

