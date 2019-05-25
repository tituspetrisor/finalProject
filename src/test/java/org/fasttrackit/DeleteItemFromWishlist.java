package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DeleteItemFromWishlist extends TestBase {
    @Test
    public void deleteItem() {
        Header header = PageFactory.initElements(driver, Header.class);

        header.logIn(driver);
        String keyword = "My Wishlist";
        header.clickOnDashboardPages(driver, keyword).click();
        String succesfulMessage = "You have no items in your wishlist.";
        String expectedMessage = driver.findElement(By.xpath("//div[@class = 'fieldset']")).getText();
        if(succesfulMessage.equals(expectedMessage)){
            System.out.println("There is not any items in wishlist");
        }else {
            driver.findElement(By.xpath("//td//a[@title = 'Remove Item']")).click();
            header.clickOnPopUpAlert(driver);

            String succMessage = "You have no items in your wishlist.";
            String expectMessage = driver.findElement(By.xpath("//div[@class = 'fieldset']")).getText();
            assertThat("Expect to delete item", succesfulMessage, is(expectedMessage));
            driver.quit();
        }
    }
}
