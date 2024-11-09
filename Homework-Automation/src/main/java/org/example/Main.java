package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
//Homework:
//Open https://demo.applitools.com/
//Login (any user and password are accepted. Ex myName, 123)
//Print Total balance and Credit available amount (only $xxxx, exclude percentage)
//Print the recent transactions with Description, Status and Amount for each one.
//tagName:not(.class_name)
//div:not(.inventory_item_label)

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.applitools.com/");

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("Hola");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("Mundo");

        WebElement btnSignIn = driver.findElement(By.id("log-in"));
        btnSignIn.click();

        WebElement name = driver.findElement(By.cssSelector("div.logged-user-info-w div.logged-user-name"));
        System.out.println(name + " name");

        WebElement totalBalance = driver.findElement(By.xpath("//div[contains(text(),\"Total Balance\")]/following-sibling::div[@class=\"balance-value\"]/span[not(@class)]"));
        System.out.println("Total Balance: "+ totalBalance.getText());

        WebElement creditAvailable = driver.findElement(By.xpath("//div[contains(text(),\"Credit Available\")]/following-sibling::div[@class=\"balance-value\"]"));
        System.out.println("Credit Available: "+ creditAvailable.getText());

        List<WebElement> transactions = driver.findElements(By.cssSelector("div.table-responsive tbody tr"));
        System.out.println("Total recent transactions: " + transactions.size());

        for(WebElement item: transactions){

            WebElement description = item.findElement(By.cssSelector("td.cell-with-media span:not(.status-pill)"));
            WebElement status = item.findElement(By.cssSelector("td:first-child span:not(.status-pill)"));
            WebElement amount = item.findElement(By.cssSelector("td.text-right span"));
            System.out.println("Description: " + description.getText() + " | Status: " + status.getText() + " | Amount: " + amount.getText());
        }

    }
}