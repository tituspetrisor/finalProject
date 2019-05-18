package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class RegisterTest extends TestBase {
    @Test
    public void registerTestForUsers() {


        Header header = PageFactory.initElements(driver, Header.class);
        String keyword = "Register";

        header.createAccount("titasdaasd.p@yahoo.com","TestRegister", "Titus", "Petrisor",driver);

    }
}
