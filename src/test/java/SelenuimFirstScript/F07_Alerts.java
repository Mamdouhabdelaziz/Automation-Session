package SelenuimFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class F07_Alerts {
    WebDriver driver ;



    @BeforeMethod
    void Setup ()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");



    }
    @Test
    void HandleAlert()
    {
        WebElement clickForJsAlertLoc = driver.findElement(By.cssSelector("button[onclick=\"jsAlert()\"]"));
        clickForJsAlertLoc.click();


        driver.switchTo().alert().accept();
       WebElement MsgLoc = driver.findElement(By.id("result"));
      boolean actual = MsgLoc.getText().contains("You successfully clicked an alert");

        Assert.assertTrue(actual);

    }
    @Test
    void HandleConfirm ()
    {
        WebElement clickForJsAlertLoc = driver.findElement(By.cssSelector("button[onclick=\"jsConfirm()\"]"));
        clickForJsAlertLoc.click();

       String S = driver.switchTo().alert().getText();
       if (S.equals("I am a JS Confirm"))
       {
           driver.switchTo().alert().accept();

       }
       else
       {

           driver.switchTo().alert().dismiss();
       }

       WebElement AssLoc =driver.findElement(By.id("result"));
      boolean actual= AssLoc.getText().contains("You clicked: Ok");
      Assert.assertTrue(actual);


    }
    @Test
    void HandlePrompt ()
    {

        WebElement clickForJsAlertLoc = driver.findElement(By.cssSelector("button[onclick=\"jsPrompt()\"]"));
        clickForJsAlertLoc.click();

        String S = "Mamdouh Abdelaziz";
        driver.switchTo().alert().sendKeys(S);
        driver.switchTo().alert().accept();

        WebElement ResLoc = driver.findElement(By.id("result"));
      boolean actual =  ResLoc.getText().contains(S);
      Assert.assertTrue(actual);

    }

}
