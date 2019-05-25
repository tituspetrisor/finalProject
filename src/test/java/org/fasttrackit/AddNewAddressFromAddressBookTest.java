package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddressFromAddressBookTest extends TestBase {

    @Test
    public void addNewAddress() {
        Header header = PageFactory.initElements(driver, Header.class);
        header.logIn(driver);

        String keyword = "Address Book";
        header.clickOnDashboardPages(driver, keyword).click();
        driver.findElement(By.xpath("//button[@title = 'Add New Address']")).click();
        String phoneNumber = "0744555698";
        String street = "16598 4th west";
        String city = "New York";
        String regionNumber = "41";
        String zipCode = "11222";
        header.fillinAddressInformation(driver, phoneNumber, street, city, regionNumber, zipCode);

        String succesMessage = "The address has been saved.";
        String expectedMessage = driver.findElement(By.xpath("//div//li[@class = 'success-msg']")).getText();

        driver.quit();


    }
}
