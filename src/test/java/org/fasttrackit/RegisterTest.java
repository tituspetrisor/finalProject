package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class RegisterTest extends TestBase {
    @Test
    public void registerTestForUsers() {


        Header header = PageFactory.initElements(driver, Header.class);

        header.registerNewUser("titus.p@yahoo.com","TestRegister", "Titus", "Petrisor",driver);

//        driver.findElement(By.linkText("ACCOUNT")).click();
//        driver.findElement((By.linkText("Register"))).click();
//        driver.findElement(By.id("firstname")).sendKeys("Titus");
//        driver.findElement(By.id("lastname")).sendKeys("Petrisor");
//        driver.findElement(By.className("validate-email")).sendKeys("titus.p@yahoo.com");
//        driver.findElement(By.id("password")).sendKeys("TestRegister");
//        driver.findElement(By.id("confirmation")).sendKeys("TestRegister");
//        driver.findElement(By.id("is_subscribed")).click();
        driver.quit();
    }
}
