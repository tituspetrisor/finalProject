package org.fasttrackit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteMenu {

    @FindBy(css = "h1")
    private WebElement getCheckPage;

    public WebElement getLinkName(String linkName, WebDriver driver){
        return driver.findElement(By.linkText(linkName.toUpperCase()));
    }

    public void clickOnLink(String linkName, WebDriver driver){
        getLinkName(linkName.toUpperCase(), driver).click();

    }
    public void getPageTitle(WebDriver driver){
        driver.findElement(By.xpath("//div[@class = 'page-title category-title']")).getText();

    }
    public String getPageTitleFromH (){
        return getCheckPage.getText();
    }

}
