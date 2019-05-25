package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class ViewOrderFromMyOrders extends TestBase {
    @Test
    public void viewOrder(){
        Header header = PageFactory.initElements(driver, Header.class);
        header.logIn(driver);

        String keyword = "My Orders";
        header.clickOnDashboardPages(driver, keyword).click();
        driver.findElement(By.xpath("//tr//span[@class = 'nobr' ]//a[text() = 'View Order']")).click();

        String succesfulMessage = "ORDER #145000254 - PENDING";
        String expectedMessage = driver.findElement(By.xpath("//div[@class = 'page-title title-buttons']//h1")).getText();

        assertThat("Expected the order number", succesfulMessage, containsString(expectedMessage));



    }
}
