package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class EditContactInformationFromDashboardTest extends TestBase{

    @Test
    public void accountDashboard() {

        Header header = PageFactory.initElements(driver, Header.class);
        header.logIn(driver);

        String keyword = "Edit";
        header.editLinkButton(keyword, driver).click();
        header.insertInformationInFields(driver);

        String editMessage = "The account information has been saved.";
        String expectedEditMessage = driver.findElement(By.xpath("//li[@class = 'success-msg']")).getText();
        assertThat("Expected information saved", editMessage, containsString(expectedEditMessage));
        driver.quit();

    }
}
