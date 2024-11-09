package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By userNameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginButton = By.id("log-in");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String userName) {
        driver.findElement(userNameLocator).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public HomePage clickLoginWithValidCredentials(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

}
