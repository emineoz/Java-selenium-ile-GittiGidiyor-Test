package com.gittigidiyor.testcase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage{
    private By priceInTheBasketBy = By.xpath("//*[@id=\"cart-price-container\"]/div[3]/p");
    private By numberOfProductsBy = By.cssSelector("option[value='2']");
    private By totalProductBy = By.xpath("//*[@id=\"submit-cart\"]/div/div[2]/div[2]/div/div[1]/div/div[5]/div[1]/div/ul/li[1]/div[1]");
    private By deleteProductBy = By.cssSelector("a[title='Sil']");
    private By emptyBasketBy = By.cssSelector(".gg-w-22.gg-d-22.gg-t-21.gg-m-18>:nth-child(1)");

    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String priceInTheBasket(){
        //System.out.println("product price in the basket:"+getText(priceInTheBasketBy));
        return webDriver.findElement(priceInTheBasketBy).getText();

    }

    public void setNumberOfProducts() {
        click(numberOfProductsBy,10);
    }

    public String getTotalProduct(){
        System.out.println("product number:"+getText(totalProductBy));

        return webDriver.findElement(totalProductBy).getText();
    }

    public void deleteProduct(){
        click(deleteProductBy,10);
    }

    public String isEmpty(){
        return webDriver.findElement(emptyBasketBy).getText();
    }
}
