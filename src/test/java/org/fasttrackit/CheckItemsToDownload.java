package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CheckItemsToDownload extends TestBase{

    @Test
    public void checkItems(){
        Header header = PageFactory.initElements(driver, Header.class);
        header.logIn(driver);

        String keyword = "My Wishlist";
        String bookTitle = "A Tale of Two Cities";
        header.clickOnDashboardPages(driver, keyword).click();
        header.checkItemsToDownload(driver);

        String succesfulMessage = "Check Items to Download";
        String expectedMessage = driver.findElement(By.xpath("//dl/dt")).getText();
        assertThat("Expected checkd items", succesfulMessage, is(expectedMessage));

        String expectedBookTitle = driver.findElement(By.xpath("//dl/dd")).getText();

        assertThat("Expected book title" , bookTitle, is(expectedBookTitle));


    }
}
