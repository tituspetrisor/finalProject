package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EditItemFromWishlist extends TestBase{
    @Test

    public void editItem(){
        Header header = PageFactory.initElements(driver, Header.class);
        header.logIn(driver);

        String keyword = "My Wishlist";
        String bookTitle = "A Tale of Two Cities ";
        String numberOfQuantity = "21";
        String updateOrCompare = "Update Wishlist";
        header.clickOnDashboardPages(driver, keyword).click();
        header.editItemWishlist(driver, numberOfQuantity, updateOrCompare);

        String succesfulMessage = bookTitle + "has been updated in your wishlist.";
        String expectedMessage = driver.findElement(By.xpath("//div//li[@class = 'success-msg']")).getText();

        assertThat("Expect to update wishlist", succesfulMessage, is(expectedMessage));

        driver.quit();
    }
}
