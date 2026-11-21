package SelenuimFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class F10_FileUpload {
    WebDriver driver;

    @BeforeMethod
    void Setup ()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");



    }
    @Test
    void actions ()
    {
       WebElement ChooseFileButton = driver.findElement(By.id("file-upload"));

       String FileName = "New_Text_Document.txt";

       ChooseFileButton.sendKeys("C:\\Users\\Mamdouh\\OneDrive\\Desktop\\" + FileName);
     WebElement UploadButtonLoc =  driver.findElement(By.id("file-submit"));
     UploadButtonLoc.click();

        SoftAssert soft = new SoftAssert();
       boolean Actual1 = driver.findElement(By.tagName("h3")).isDisplayed();
       soft.assertTrue(Actual1);

        boolean Actual2 = driver.findElement(By.id("uploaded-files")).getText().contains(FileName);
        soft.assertTrue(Actual2);

        soft.assertAll();



    }

}
