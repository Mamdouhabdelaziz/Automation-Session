package SelenuimFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class F08_WindowsHandling {
    WebDriver driver ;
    @BeforeMethod
    void Setup ()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");



    }
    @Test
    void Actions()
    {
        String Tittle = driver.getTitle();
        System.out.println(Tittle);
        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        String Handle = driver.getWindowHandle();
        System.out.println(Handle);


    }
    @Test
    void HandleMultipleWindow()
    {

     WebElement ClickHereLoc = driver.findElement(By.xpath("//a[text()='Click Here']"));
     ClickHereLoc.click();

        System.out.println(driver.getCurrentUrl());

        List<String> TabsID = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(TabsID.get(1));
        System.out.println(driver.getCurrentUrl());

       boolean actual = driver.findElement(By.tagName("h3")).isDisplayed();

        Assert.assertTrue(actual);

        driver.close();

        driver.switchTo().window(TabsID.get(0));
        System.out.println(driver.getCurrentUrl());



    }

}



