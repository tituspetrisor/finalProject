package org.fasttrackit.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "//div[@class = 'links']//li//a[text() = 'Register']")
    private WebElement registerButton;

    @FindBy(id = "firstname")
    private WebElement accountFields;

    @FindBy(xpath = "//div[@id = 'header-nav']//ol//a[text() = 'Women']")
    private WebElement womenButton;

    @FindBy(xpath = "//div[@id = 'header-nav']//ol//a[text() = 'Men']")
    private WebElement menButton;

    @FindBy(xpath = "//dl[@class = 'item-options']//dd")
    private WebElement bookTitle;


    @FindBy(xpath = "//ul[@class = 'messages']")
    private WebElement successfulmessage;

    public void insertDate(String keyword) {
        accountFields.sendKeys(keyword);
    }

    public void search(String keyword) {
        searchField.sendKeys(keyword);
        searchButton.click();
    }

    public WebElement editLinkButton(String keyword, WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class = 'col-1']//div[@class = 'box']// a[text() = '" + keyword + "']"));
    }

    public WebElement getFieldFromAccountSection(String keyword, WebDriver driver) {
        return driver.findElement(By.xpath("//div[@id = 'header-account']//div[@class = 'links']//li//a[text() =  '" + keyword +
                "']"));
    }

    public WebElement clickOnDashboardPages(WebDriver driver, String keyword) {
        return driver.findElement(By.xpath("//div[@class = 'block-content']//a[text() = '" + keyword + "']"));
    }

    public void logIn(WebDriver driver) {
        Header header = PageFactory.initElements(driver, Header.class);

        String keyword = "My Account";
        header.getAccountButton().click();
        header.getFieldFromAccountSection(keyword, driver).click();
        driver.findElement(By.xpath("//li//input[@class = 'input-text required-entry validate-email']")).sendKeys("titus.petrisor@yahoo.com");
        driver.findElement(By.xpath("//input[@class = 'input-text required-entry validate-password']")).sendKeys("Testcreateaccount");
        header.getLoginButton().click();
    }

    public void createAccount(String email, String password, String firstName, String lastName, WebDriver driver) {
        Header header = PageFactory.initElements(driver, Header.class);

        String keyword = "Register";
        header.getAccountButton().click();
        header.getFieldFromAccountSection(keyword, driver).click();

        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.className("validate-email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmation")).sendKeys(password);
        driver.findElement(By.id("is_subscribed")).click();
        driver.quit();
    }

    public void createAccountFromLogInPage(String email, String password, String firstName, String lastName, WebDriver driver) {
        Header header = PageFactory.initElements(driver, Header.class);

        String keyword = "Log In";
        header.getAccountButton().click();
        header.getFieldFromAccountSection(keyword, driver).click();
        driver.findElement(By.xpath("//div[@class = 'buttons-set']//a")).click();

        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.className("validate-email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmation")).sendKeys(password);
        driver.findElement(By.id("is_subscribed")).click();

        driver.findElement(By.xpath("//div[@class = 'buttons-set']//button")).click();
    }

    public void insertInformationInFields(WebDriver driver) {
        Header header = PageFactory.initElements(driver, Header.class);
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys("Titus");
        driver.findElement(By.xpath("//input[@id= 'current_password']")).sendKeys("Testcreateaccount");
        driver.findElement(By.xpath("//div[@class = 'buttons-set']//button")).click();
    }

    public void subOrUnsub(WebDriver driver) {
        Header header = PageFactory.initElements(driver, Header.class);
        driver.findElement(By.xpath("//div[@class = 'col-2']//a[text() = 'Edit']")).click();
        driver.findElement(By.xpath("//div//input[@id = 'subscription']")).click();
        driver.findElement(By.xpath("//button[@title= 'Save']")).click();
    }

    public void fillinAddressInformation(WebDriver driver, String phoneNumber, String street, String city, String regionNumber, String zipCode) {
        Header header = PageFactory.initElements(driver, Header.class);

        driver.findElement(By.id("telephone")).clear();
        driver.findElement(By.id("telephone")).sendKeys(phoneNumber);
        driver.findElement(By.id("street_1")).clear();
        driver.findElement(By.id("street_1")).sendKeys(street);
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("region_id")).click();
        driver.findElement(By.xpath("//div//select//option[@value = '" + regionNumber + "']")).click();
        driver.findElement(By.id("zip")).clear();
        driver.findElement(By.id("zip")).sendKeys(zipCode);
        driver.findElement(By.xpath("//button[@title= 'Save Address']")).click();

        System.out.println("The address was changed");
    }

    public void shareYourWishlist(WebDriver driver, String emails, String message) {
        driver.findElement(By.xpath("//div[@class = 'input-box']//textarea[@name = 'emails']")).sendKeys(emails);
        driver.findElement(By.xpath("//div[@class = 'input-box']//textarea[@name = 'message']")).sendKeys(message);
        driver.findElement(By.xpath("//button[@title = 'Share Wishlist']")).click();

    }

    public void clickOnPopUpAlert(WebDriver driver) {
        Alert alertOK = driver.switchTo().alert();
        alertOK.accept();
    }

    public void editItemWishlist(WebDriver driver, String numberOfQuantity, String updateOrCompare) {
        driver.findElement(By.xpath("//td//a[@class = 'link-edit button button-secondary']")).click();
        driver.findElement(By.xpath("//div[@class = 'qty-wrapper']//input")).click();
        driver.findElement(By.xpath("//div[@class = 'qty-wrapper']//input")).clear();
        driver.findElement(By.xpath("//div[@class = 'qty-wrapper']//input")).sendKeys(numberOfQuantity);
        driver.findElement(By.xpath("//ul[@class = 'add-to-links']//a[text() = '" + updateOrCompare + "']")).click();

    }

    public String getBookTitle() {
        bookTitle.getText();
        return null;
    }

    public void checkItemsToDownload(WebDriver driver) {
        driver.findElement(By.xpath("//td//a[@class = 'link-edit button button-secondary']")).click();
        driver.findElement(By.xpath("//span[@class = 'label']/label")).click();
        driver.findElement(By.xpath("//div[@class = 'add-to-cart-buttons']//button")).click();
    }

    public void logOut(WebDriver driver) {
        driver.findElement(By.xpath("//div[@class = 'account-cart-wrapper']//a[@class = 'skip-link skip-account']")).click();
        driver.findElement(By.xpath("//div[@class = 'links']//li//a[@title = 'Log Out']")).click();
    }


    public void review(WebDriver driver){
        driver.findElement(By.xpath("//td[@class = 'last']")).click();
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

    public WebElement getWomenButton() {
        return womenButton;
    }

    public WebElement getMenButton() {
        return menButton;
    }

    public WebElement getSuccessfulmessage() {
        return successfulmessage;
    }
}
