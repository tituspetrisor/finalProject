package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageTest extends TestBase {

    @Test

    public void homePage() {

        Header header = PageFactory.initElements(driver, Header.class);

        String womenButton = header.getWomenButton().getText();
        String menButton = header.getMenButton().getText();

        String expectedWomen = "WOMEN";
        String expectedMen = "MEN";

        assertThat("Expected Women", expectedWomen, is(womenButton));
        assertThat("Expected Men", expectedMen, is(expectedMen));
        System.out.println("The homepage is working.");
        driver.quit();

    }


}
