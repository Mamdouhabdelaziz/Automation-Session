package SelenuimFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class F09_DataProvider {

    WebDriver driver;

    @BeforeMethod
    void Setup ()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");



    }
    @Test(dataProvider = "DP")
    void actions (String UN , String PW)
    {

        WebElement UsernameField =  driver.findElement(By.id("username"));
        UsernameField.sendKeys(UN);

        // 2- Enter Password
        WebElement PasswordField =  driver.findElement(By.cssSelector("input[name=\"password\"]"));
        PasswordField.sendKeys(PW);

        // 3-Click Login Button

        WebElement LoginButton = driver.findElement(By.className("fa-sign-in"));
        LoginButton.click();

       boolean actual = driver.findElement(By.className("icon-signout")).isDisplayed();

        Assert.assertTrue(actual);


    }
    @DataProvider(name = "DP")

    String [][] ProvidedData ()
    {
        String [][] Data = {
        {
            "tomsmith", "SuperSecretPassword!"
        },
        {
            "ahmed ", "123456"
        },
        {
            "Mohamed", "12344"
        }

    };
        return Data;



    }



    }



