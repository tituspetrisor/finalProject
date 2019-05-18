package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SubscrieOrUnsubscribeTest extends TestBase {

    @Test
    public void subscrieUnsubscribe() {

        Header header = PageFactory.initElements(driver, Header.class);
        header.logIn(driver);

        String notSubcribed = "You are currently not subscribed to any newsletter.";
        String subscribed = "You are currently subscribed to 'General Subscription'.";
        String message = driver.findElement(By.xpath("//div[@class = 'col-2']//p")).getText();

        if (notSubcribed.equals(message)) {
            header.subOrUnsub(driver);

            String succesMessage = "The subscription has been saved.";
            String expectedMessage = driver.findElement(By.xpath("//div//ul/li/span")).getText();
            assertThat("Expected subscribe", succesMessage, is(expectedMessage));
        }else if (subscribed.equals(message)){
            header.subOrUnsub(driver);

            String succesMessag = "The subscription has been removed.";
            String expectedMessage = driver.findElement(By.xpath("//div//ul/li/span")).getText();
            assertThat("Expected unsubscribe", succesMessag, is(expectedMessage));
        }
        driver.quit();


    }
}
