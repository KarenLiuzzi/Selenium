package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest{
    @Test
    public void testSuccessfulLogin(){

        driver.get("https://demo.applitools.com/");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.setUserName("Hola");
        loginPage.setPassword("123");
        HomePage homePage = loginPage.clickLoginWithValidCredentials();

        assertEquals("Jack Gomez", homePage.getUserName());
        assertEquals("https://demo.applitools.com/app.html", driver.getCurrentUrl());

    }

}
