package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestCreateAccount extends TestBase {
    @Test
    public void createAccount(){

        String keyword = "My Account";

        Header header = PageFactory.initElements(driver, Header.class);
        header.getAccountButton().click();
        header.getFieldFromAccountSection(keyword, driver).click();
        driver.findElement(By.xpath("//div[@class = 'buttons-set']//a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Titus");
        driver.findElement(By.id("lastname")).sendKeys("Petrisor");
        driver.findElement(By.id("email_address")).sendKeys("titus.petrisor@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("TestCreateaccount");
        driver.findElement(By.id("confirmation")).sendKeys("TestCreateaccount");
        driver.findElement(By.xpath("//div[@class = 'buttons-set']//button")).click();

        String expectedMessage = driver.findElement(By.xpath("//ul[@class = 'messages']")).getText();
        String correctMessage = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.\n";

        assertThat("Expected succes message" ,correctMessage , containsString(expectedMessage));
    }
}
