package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class ChangePasswordFromDashboardTest extends TestBase {

    @Test
    public void changePassword(){
        Header header = PageFactory.initElements(driver, Header.class);
        header.logIn(driver);

        String keyword = "Change Password";
        header.editLinkButton(keyword, driver).click();
        header.insertInformationInFields(driver);
        driver.findElement(By.xpath("//div//input[@id = 'password']")).sendKeys("Testcreateaccount");
        driver.findElement(By.xpath("//div//input[@id = 'confirmation']")).sendKeys("Testcreateaccount");
        driver.findElement(By.xpath("//div[@class = 'buttons-set']//button")).click();

        String succesfulMessage = "The account information has been saved.";
        String expectedSuccesfulMessage = driver.findElement(By.xpath("//div[@class= 'dashboard']//span")).getText();
        assertThat("Expected information saved", succesfulMessage, containsString(expectedSuccesfulMessage));
        driver.quit();
        System.out.println("Password was changed");
    }
}
