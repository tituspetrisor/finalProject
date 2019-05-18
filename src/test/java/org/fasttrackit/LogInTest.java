package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class LogInTest extends TestBase {

    @Test

    public void accountFields() {
        Header header = PageFactory.initElements(driver, Header.class);
        String keyword = "My Account";

        header.logIn(driver);

        String expectedMessage = "From your My Account Dashboard you have the ability to view a snapshot" +
                " of your recent account activity and update your account information. Select a link below to view or edit information.";
        String messageFromAccountPage = driver.findElement(By.xpath("//div[@class = 'welcome-msg']")).getText();
        assertThat("Expected a welcome message", messageFromAccountPage, containsString(expectedMessage));
        System.out.println("Login successful");
        driver.close();


    }
}
