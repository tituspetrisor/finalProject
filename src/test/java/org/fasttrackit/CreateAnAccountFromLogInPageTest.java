package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CreateAnAccountFromLogInPageTest extends TestBase {
    @Test

    public void createAccountFromLogInPage() {

        Header header = PageFactory.initElements(driver, Header.class);

        String keyword = "Log In";
        header.createAccountFromLogInPage("tituadsd.p@yahoo.com","TestRegister", "Titus", "Petrisor",driver);

        String expectedMessage = "Thank you for registering with Madison Island.";
        String succesfulMessage = header.getSuccessfulmessage().getText();

        assertThat("Expected a succesful message", expectedMessage, is(succesfulMessage));

    }
}
