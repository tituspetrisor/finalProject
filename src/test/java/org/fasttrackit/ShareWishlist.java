package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ShareWishlist extends TestBase {
    @Test
    public void shareWishlist(){
        Header header = PageFactory.initElements(driver, Header.class);
        header.logIn(driver);

        String keyword = "My Wishlist";
        String emails = "titus.petrisor@yahoo.com";
        String message = "This product is nice";
        header.clickOnDashboardPages(driver, keyword).click();
        driver.findElement(By.xpath("//div[@class = 'buttons-set buttons-set2']//button[@name = 'save_and_share']")).click();
        header.shareYourWishlist(driver, emails, message);

        String succesfulMessage = "Your Wishlist has been shared.";
        String expectedMessage = driver.findElement(By.xpath("//div//li[@class = 'success-msg']")).getText();

        assertThat("Expected Wishlist shared", succesfulMessage, is(expectedMessage));
        driver.quit();

    }
}
