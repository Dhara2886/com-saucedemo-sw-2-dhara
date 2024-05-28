package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
/*
Create the package ‘testsuite’ and create the
following class inside the ‘testsuite’ package.
1. LoginTest
 */
public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
//1. User should log in successfully with valid credentials
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals("Products", actualText);
    }
//2. Verify that six products are displayed on page
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        int numberOfExpectedProductsOnPage = 6;
        List<WebElement> actualNumberOfTotalProductsDisplayed = driver.findElements(By.cssSelector("div.inventory_item"));
        Assert.assertEquals(numberOfExpectedProductsOnPage,actualNumberOfTotalProductsDisplayed.size());
    }

    @After
    public void closeBrowser() {
    }
}
