package SelenuimFirstScript;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class F05_Waits {
    WebDriver driver ;

    // unconditional wait  Thread.sleep (3000)
    // conditional waits : implicit , explicit , fluent


    @BeforeMethod
    void Setup ()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));



    }

    @Test
    void testA () {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Explicit wait

//       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
//        wait.until(ExpectedConditions.presenceOfElementLocated(a[href="/users/1"]));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement()))


    }
    @Test
    void TestFluentWait()
    {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Element was not Found after 10 sec with polling period 2 sec");
        WebElement Ele = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
    }




}
