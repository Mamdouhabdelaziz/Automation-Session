package SelenuimFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class F11_Frames {
    WebDriver driver;

    @BeforeMethod
    void Setup ()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");



    }
    @Test
    void HandleFrames ()
    {
       WebElement TopFrameLoc = driver.findElement(By.name("frame-top"));
       driver.switchTo().frame("frame-top");

       WebElement LeftTopFrameLoc = driver.findElement(By.name("frame-left"));
       driver.switchTo().frame(LeftTopFrameLoc);

      String S = driver.findElement(By.tagName("body")).getText();
        System.out.println(S);

        driver.switchTo().parentFrame();  // Top Frame

       WebElement MiddleTopFrame = driver.findElement(By.name("frame-middle"));
       driver.switchTo().frame(MiddleTopFrame);

       String M = driver.findElement(By.id("content")).getText();
        System.out.println(M);

        driver.switchTo().defaultContent();

        WebElement BottomFrame = driver.findElement(By.name("frame-bottom"));
        driver.switchTo().frame(BottomFrame);
       String H = driver.findElement(By.tagName("body")).getText();
        System.out.println(H);





    }
}
