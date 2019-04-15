package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class EditContactInformationFromDashboard extends TestBase{

    @Test
    public void accountDashboard() {

        Header header = PageFactory.initElements(driver, Header.class);
        header.logIn(driver);

        String keyword1 = "Edit";
        header.editLinkButton(keyword1, driver).click();
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys("Titus");
        driver.findElement(By.xpath("//input[@id= 'current_password']")).sendKeys("TestCreateaccount");
        driver.findElement(By.xpath("//div[@class = 'buttons-set']//button")).click();

        String editMessage = "The account information has been saved.";
        String expectedEditMessage = driver.findElement(By.xpath("//li[@class = 'success-msg']")).getText();
        assertThat("Expected information saved", editMessage, containsString(expectedEditMessage));
        driver.quit();

    }
}
