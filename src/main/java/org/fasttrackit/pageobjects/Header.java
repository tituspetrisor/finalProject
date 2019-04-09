package org.fasttrackit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(className = "search-button")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class = 'account-cart-wrapper']//span[text() = 'Account']")
    private WebElement accountButton;


    @FindBy(xpath = "//button[@id = 'send2']")
    private WebElement loginButton;


    @FindBy(id = "firstname")
    private WebElement accountFields;

    public void insertDate(String keyword) {
        accountFields.sendKeys(keyword);
    }


    public void search(String keyword) {


        searchField.sendKeys(keyword);
        searchButton.click();
    }

    public WebElement editLinkButton(String keyword, WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class = 'col-1']//div[@class = 'box-title']// a[text() = '" + keyword + "']"));
    }

    public WebElement getFieldFromAccountSection(String keyword, WebDriver driver) {
        return driver.findElement(By.xpath("//div[@id = 'header-account']//li[@class = 'first']//a[text() = '" + keyword +
                "']"));
    }

    public void logIn(WebDriver driver) {
        Header header = PageFactory.initElements(driver, Header.class);

        String keyword = "My Account";
        header.getAccountButton().click();
        header.getFieldFromAccountSection(keyword, driver).click();
        driver.findElement(By.xpath("//li//input[@class = 'input-text required-entry validate-email']")).sendKeys("titus.petrisor@yahoo.com");
        driver.findElement(By.xpath("//input[@class = 'input-text required-entry validate-password']")).sendKeys("TestCreateaccount");
        header.getLoginButton().click();


    }

    public WebElement getAccountButton() {
        return accountButton;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getAccountFields() {
        return accountFields;
    }

}