package SelenuimFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class F06_AddToCartExample {

    WebDriver driver ;
    @BeforeMethod
    void Setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();




    }
    @Test
    void AddProductTocart()
    {
        // Launch Browser And Navigate
        driver.get("https://automationexercise.com/");

        // Verify Homepage is Visible
        SoftAssert Soft = new SoftAssert();
       boolean actual = driver.findElement(By.cssSelector("h2[class='title text-center']")).isDisplayed();
       Soft.assertTrue(actual , "Home Page is not Visible");

       // Click Product
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/products']"))).click();

        // Verify ProductPage
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".features_items")));

        //Hover over Frist product and Add to Cart

        Actions act = new Actions(driver);

       WebElement firstproduct= driver.findElement(By.xpath("//img[@src=\"/get_product_picture/1\"]"));

       act.moveToElement(firstproduct).perform();

       WebElement LinkFirstProduct = driver.findElement(By.cssSelector("a[data-product-id='1'].add-to-cart"));
       LinkFirstProduct.click();
        // Click Continue Shipping

       WebElement ContShoppingButt = driver.findElement(By.cssSelector("button[data-dismiss='modal']"));
       wait.until(ExpectedConditions.visibilityOf(ContShoppingButt)).click();







    }





}
