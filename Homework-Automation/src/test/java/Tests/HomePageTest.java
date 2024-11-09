package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest extends BaseTest{
    @Test
    public void TransactionsAreComplete(){
        driver.get("https://demo.applitools.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Hola");
        loginPage.setPassword("123");
        HomePage homePage = loginPage.clickLoginWithValidCredentials();
        var transactionsItems = homePage.getTransactions();
        List<String> expectedMenuItems = Arrays.asList(
                "Starbucks coffee", "Stripe Payment Processing",
                "MailChimp Services", "Shopify product",
                "Ebay Marketplace", "Templates Inc"
        );
        assertEquals(6, expectedMenuItems.size(), "Number of transactions is not correct");
        assertEquals(transactionsItems, expectedMenuItems, "Transactions are not correctly loaded");

    }
}
