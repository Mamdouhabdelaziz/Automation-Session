package SelenuimFirstScript;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class F01_Login {
    WebDriver driver ;
    String HEROKUAPP_URL = "https://the-internet.herokuapp.com/login";
    String UserName  = "tomsmith";
    String ValidPassWord = "SuperSecretPassword!";
    String InvalidPassword = "12345";

    @BeforeMethod
    void SetUp ()
    {
        //1- Open Browser And URL
        // Chromedriver   , get , navigate.to
         driver = new ChromeDriver();  // open Browser
        driver.get(HEROKUAPP_URL);                // open URL

    }

    @Test(priority = 0)
    @Feature("Login Feature")
    @Epic("Authentication Epic")
    @Description("test that with valid cred ")
    @Severity(SeverityLevel.CRITICAL)

    void validLogin()
    {


        // driver.navigate().to();
        // driver.navigate().back();
        // driver.navigate().forward();
        // driver.navigate().refresh();
Allure.step("User Enter A Valid Username");
        // 1- Enter Username
        WebElement UsernameField =  driver.findElement(By.id("username"));
       UsernameField.sendKeys(UserName);
Allure.step("User Enter A Valid Password");
        // 2- Enter Password
        WebElement PasswordField =  driver.findElement(By.cssSelector("input[name=\"password\"]"));
        PasswordField.sendKeys(ValidPassWord);
Allure.step("User Click A Login Button");
        // 3-Click Login Button

        WebElement LoginButton = driver.findElement(By.className("fa-sign-in"));
        LoginButton.click();
Allure.step("Verify User could login with valid credentials");
        String ExpectedMsg = "You logged into a secure area!";
        WebElement MsgField = driver.findElement(By.className("flash"));
        boolean ActualMsg = MsgField.getText().contains("You logged into a secure area!");
        Assert.assertEquals(ActualMsg , true , "The text is not Exist");
       // Assert.assertTrue(ActualMsg , "Is Displayed once failed");
      WebElement LogOutButton =  driver.findElement(By.className("icon-signout"));
       boolean Actual = LogOutButton.isDisplayed();
       Assert.assertTrue(Actual);





    }

    @Test(priority = 1)
    @Feature("Login Feature")
    @Epic("Authentication Epic")
    @Description("test that with invalid credentials ")
    @Severity(SeverityLevel.BLOCKER)
    void  InvalidLogin()
    {
        Allure.step("User Enter A Valid Username");
        // 1- Enter Username
        WebElement UsernameField =  driver.findElement(By.id("username"));
        UsernameField.sendKeys(UserName);

        Allure.step("User Enter A inValid Password");


        // 2- Enter Password
        WebElement PasswordField =  driver.findElement(By.cssSelector("input[name=\"password\"]"));
        PasswordField.sendKeys(InvalidPassword);

        Allure.step("User Click A Login Button");

        // 3-Click Login Button

        Allure.step("Verify User couldn't login with invalid credentials");

        WebElement LoginButton = driver.findElement(By.className("fa-sign-in"));
        LoginButton.click();

        WebElement errorMsgField = driver.findElement(By.className("error"));
       boolean actual =  errorMsgField.getText().contains("Your username is invalid!");
       Assert.assertEquals(actual , true);



    }
    @AfterMethod
    void CleanUp()
    {




    }




}
