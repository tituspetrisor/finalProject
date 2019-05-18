package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DeleteAddressFromAddressBook extends TestBase {

    @Test
    public void deleteAddress(){
        Header header = PageFactory.initElements(driver, Header.class);
        header.logIn(driver);

        String keyword = "Address Book";
        header.clickOnDashboardPages(driver, keyword).click();
        driver.findElement(By.xpath("//div[@class = 'col-2 addresses-additional']//a[text() = 'Delete Address']")).click();

        String succesMessage = "The address has been deleted.";
        String expectedMessage = driver.findElement(By.xpath("//div//li[@class = 'success-msg']")).getText();
        assertThat("Expected to delete the address", succesMessage, is(expectedMessage));

    }
}
