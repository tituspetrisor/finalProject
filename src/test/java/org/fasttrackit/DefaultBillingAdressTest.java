package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DefaultBillingAdressTest extends TestBase {

    @Test
    public void fillingAdress() {
        Header header = PageFactory.initElements(driver, Header.class);
        header.logIn(driver);
        driver.findElement(By.xpath("//div[@class = 'col2-set']//div[@class = 'col-1']//a[text() = 'Edit Address']")).click();

        String phoneNumber = "0715654789";
        String city = "New Jersey";
        String street = "684 east road";
        String regionNumber = "41";
        String zipCode = "10943";
        header.fillinAddressInformation(driver, phoneNumber, street, city, regionNumber, zipCode);

        String succesMessage = "The address has been saved.";
        String expectedMessage = driver.findElement(By.xpath("//div//li[@class = 'success-msg']")).getText();

        assertThat("Expected to change the address", succesMessage, is(expectedMessage));
        driver.quit();

    }
}
