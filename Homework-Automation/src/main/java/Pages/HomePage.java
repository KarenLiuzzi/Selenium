package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private By userNameLocator = By.cssSelector("div.logged-user-name");
    private By transactionsLocator = By.cssSelector("div.table-responsive tbody tr");
    private By descriptionTransactionLocator = By.cssSelector("td.cell-with-media span:not(.status-pill)");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserName(){

        return driver.findElement(userNameLocator).getText();
    }

    public List<String> getTransactions(){
        var transactionsWebElements = driver.findElements(transactionsLocator);
        List<String> transactionsItems = new ArrayList<>();
        for(WebElement transactionItem : transactionsWebElements){
            WebElement description = transactionItem.findElement(descriptionTransactionLocator);
            transactionsItems.add(description.getText());
        }
        return  transactionsItems;
    }
}
