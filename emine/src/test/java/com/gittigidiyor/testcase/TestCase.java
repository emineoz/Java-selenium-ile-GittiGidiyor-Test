package com.gittigidiyor.testcase;

import com.gittigidiyor.testcase.pages.User;
import com.gittigidiyor.testcase.pages.*;
import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.AssertJUnit.*;

public class TestCase extends BaseTest {
    String title = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
    String email = "emineeozz16@gmail.com";
    String password = "E123456";


    @Test
    public void gittiGidiyorTest() throws InterruptedException, IOException {
        LoginPage loginPage;
        String acountname="emineoz787726";

        HomePage homePage = new HomePage(webDriver);
        String webDriverTitle = homePage.getHomePageTitle();
        Log4j.info("Title: " + webDriverTitle);
        assertEquals("Titles did not match",webDriverTitle,title);
        Log4j.info("Titles did match");
        Log4j.info("Go to Login Page");
        loginPage = homePage.getLoginPage();
        Log4j.info("your email: " + email + ", your password: " + password);
        User user = new User(email, password);
        if(email=="emineeozz16@gmail.com" && password=="E123456") {
            WebElement emailbox = webDriver.findElement(By.id("L-UserNameField"));
            WebElement passwordbox = webDriver.findElement(By.id("L-PasswordField"));
            WebElement loginbox = webDriver.findElement(By.id("gg-login-enter"));
            loginbox.click();
            Log4j.info("Email and password is true");


        } else  {
            WebElement emailbox = webDriver.findElement(By.id("L-UserNameField"));
            emailbox.sendKeys(email);
            WebElement passwordbox = webDriver.findElement(By.id("L-PasswordField"));
            passwordbox.sendKeys(password);
            WebElement loginbox = webDriver.findElement(By.id("gg-login-enter"));
            loginbox.click();
            Thread.sleep(10);
            TakesScreenshot screenshot1=(TakesScreenshot) webDriver;
            File image=screenshot1.getScreenshotAs(OutputType.FILE);
            Files.move(image,new File("Screenshot/LoginOrNotLogin.png"));

            assertEquals("Email is not true",email,"emineeozz16@gmail.com");
            assertEquals("Password is not true",password,"E123456");
        }

        loginPage.login(user);
        Log4j.info("Go to Home Page");
        String accountButtonText = homePage.getAccountText();
        Log4j.info("The text written on the My Account button is: " + accountButtonText);
        assertEquals("Account name is not true",acountname,"emineoz787726");
        Log4j.info("Account name is true");
        Thread.sleep(10);
        homePage.closeCookiesPopUp();
        Log4j.info("The word 'bilgisayar' is entered in the search box.");
        SearchResultPage searchResultPage = homePage.search("bilgisayar");
        TakesScreenshot screenshot2=(TakesScreenshot) webDriver;
        File image=screenshot2.getScreenshotAs(OutputType.FILE);
        Files.move(image,new File("Screenshot/UnknownOrKnownProduct.png"));
        searchResultPage.selectfiltre();
        By filtremessage= By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div/div[1]/div/div/div/div[1]/div[2]/div/div/button/span");
        String filtreText=searchResultPage.getText(filtremessage);
        assertEquals("not filtre",filtreText,"Ücretsiz Kargo");
        Log4j.info("Free shipping filter is successful ");
        Log4j.info("Take a screenshot");
        TakesScreenshot screenshota=(TakesScreenshot) webDriver;
        File imagea=screenshota.getScreenshotAs(OutputType.FILE);
        Files.move(imagea,new File("Screenshot/FilterProduct.png"));
        searchResultPage.scrollToPage("7200");
        Log4j.info("The page selected from the search results page opens.");
        searchResultPage.choosePage("2");
        assertTrue("Failed to switch to page 2. ", webDriver.getCurrentUrl().contains("3"));
        Log4j.info("Go to Product details page");
        ProductDetailsPage productDetailsPage = searchResultPage.goToProductDetails();
        Log4j.info("Take a screenshot");
        TakesScreenshot screenshot3=(TakesScreenshot) webDriver;
        File image1=screenshot3.getScreenshotAs(OutputType.FILE);
        Files.move(image1,new File("Screenshot/ProductDetail.png"));
        Log4j.info("Product price information is received.");
        String productPrice = productDetailsPage.productPrice();
        productDetailsPage.scrollToPage("400");
        Thread.sleep(10);
        Log4j.info("The selected product is added to the basket.");
        productDetailsPage.addToBasket();
        Thread.sleep(60);
        Log4j.info("Take a screenshot");
        TakesScreenshot screenshot4=(TakesScreenshot) webDriver;
        File image2=screenshot4.getScreenshotAs(OutputType.FILE);
        Files.move(image2,new File("Screenshot/AddedToBasket.png"));
        Log4j.info("Go to my cart page.");
        BasketPage basketPage = productDetailsPage.goToBasket();
        TakesScreenshot screenshot5=(TakesScreenshot) webDriver;
        File image3=screenshot5.getScreenshotAs(OutputType.FILE);
        Files.move(image3,new File("Screenshot/ProductInBasket.png"));
        Log4j.info(("The product in basket "));
        Log4j.info("The price on the product page is compared with the price of the product in the basket.");
        String productPriceInBasket=basketPage.priceInTheBasket();
        assertEquals("Products price not same",productPrice,productPriceInBasket);
        Log4j.info("product price="+productPrice);
        Log4j.info("product price in basket="+productPriceInBasket);
        Log4j.info("The number of products is increased.");
        basketPage.setNumberOfProducts();
        Thread.sleep(5000);
        assertTrue("There was a problem in increasing the product.",basketPage.getTotalProduct().contains("2  Adet"));
        Log4j.info("The product is deleted from the basket.");
        basketPage.deleteProduct();
        Thread.sleep(2000);
        String basketMessage = "Sepetinizde ürün bulunmamaktadır.";
        Log4j.info("Check if the basket is empty");
        assertEquals(basketMessage, basketPage.isEmpty());

    }

}
