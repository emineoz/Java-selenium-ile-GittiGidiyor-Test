package com.gittigidiyor.testcase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends BasePage{
    private By ProductPriceBy  = By.id("sp-price-container");
    private By highProductPriceBy = By.xpath("//*[@id=\"cart-price-container\"]/div[3]");
    By addToBasketButtonBy = By.xpath("//*[@id=\"add-to-basket\"]");
    private By goToBasketButtonBy = By.className("robot-header-iconContainer-cart");
    By closealert=By.className("gg-ui-button gg-ui-btn-secondary policy-alert-v2-buttons");
    public ProductDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }


    public String productPrice(){
       // String productPrice = webDriver.findElement(ProductPriceBy).getText();
        System.out.println("product price:"+getText(ProductPriceBy));
        return getText(ProductPriceBy);

    }

    public void addToBasket(){
        // click(closealert,20);
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
      /*  wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"add-to-basket\"]")));*/
        click(addToBasketButtonBy,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/div/div/div/div[2]/div[1]/h3")));

    }
    public BasketPage goToBasket(){
        click(goToBasketButtonBy,10);
        return new BasketPage(webDriver);
    }
}
