package SelenuimFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

public class F04_Hover {

    WebDriver driver ;

    @BeforeMethod
    void Setup ()
    {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        driver.manage().window().maximize();
//        driver.manage().window().fullscreen();
//        driver.manage().window().setSize(new Dimension(1024,768));


    }
    @Test
    void Hover ()
    {
        // movetoelement , Actions     Non Static

        Actions act = new Actions(driver);
        WebElement imgLoc = driver.findElement(By.xpath("//img[@src=\"/img/avatar-blank.jpg\"][1]"));
        act.moveToElement(imgLoc).perform();

        WebElement LinkLoc = driver.findElement(By.cssSelector("a[href=\"/users/1\"]"));
        LinkLoc.click();


        SoftAssert S = new SoftAssert();
       boolean actual = driver.findElement(By.tagName("h1")).isDisplayed();
        S.assertTrue(actual);
        boolean actual2 = driver.getCurrentUrl().contains("users/1");
        S.assertTrue(actual2);
        S.assertAll();


     }

}
