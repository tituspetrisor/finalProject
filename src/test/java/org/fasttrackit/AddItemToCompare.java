package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AddItemToCompare extends TestBase {
    @Test
    public void addItemToCompare() {
        Header header = PageFactory.initElements(driver, Header.class);
        header.logIn(driver);

        String keyword = "My Wishlist";
        String numberOfQuantity = "21";
        String bookTitle = "A Tale of Two Cities ";
        String updateOrCompare = "Add to Compare";

        header.clickOnDashboardPages(driver, keyword).click();
        header.editItemWishlist(driver, numberOfQuantity, updateOrCompare);

        String succesfulMessage = "The product " + bookTitle + "has been added to comparison list.";
        String expectedMessage = driver.findElement(By.xpath("//div//li[@class = 'success-msg']")).getText();
        assertThat("Expect to add comparison list", succesfulMessage, is(expectedMessage));

        driver.quit();
    }
}
