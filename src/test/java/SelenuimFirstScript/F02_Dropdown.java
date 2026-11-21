package SelenuimFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class F02_Dropdown {

    WebDriver driver;

    @BeforeMethod
    void SetUp ()
    {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");


    }

    @Test
    void SelectOptionByText()
    {
        // 1 - click Dropdown link in homePage

       WebElement DropButton = driver.findElement(By.xpath("//a[text()=\"Dropdown\"]"));
       DropButton.click();

       // 2 - select Option 1
       // Select , SelectByVisibleText
        WebElement DropdownLoc =driver.findElement(By.id("dropdown"));
        Select Sel = new Select(DropdownLoc);
        Sel.selectByVisibleText("Option 1");

       WebElement OptionOneLoc = driver.findElement(By.cssSelector("option[value=\"1\"]"));
       boolean actual = OptionOneLoc.isSelected();
        Assert.assertTrue(actual);



    }
    @Test
    void SelectOptionByIndex()
    {
        // 1 - click Dropdown link in homePage

        WebElement DropButton = driver.findElement(By.xpath("//a[text()=\"Dropdown\"]"));
        DropButton.click();

        // 2 - select Option 2
        // Select , SelectByIndex
        WebElement DropdownLoc =driver.findElement(By.id("dropdown"));
        Select Sel = new Select(DropdownLoc);
        Sel.selectByIndex(2);

        // 3- Assert Selecting Option

        WebElement OptionOneLoc = driver.findElement(By.cssSelector("option[value=\"2\"]"));
        boolean actual = OptionOneLoc.isSelected();
        Assert.assertTrue(actual);



    }

    @Test
    void handleDropdown ()
    {
        // 1 - click Dropdown link in homePage

        WebElement DropButton = driver.findElement(By.xpath("//a[text()=\"Dropdown\"]"));
        DropButton.click();

        // Find Elements  , ChromeDriver

        List<WebElement> Eles = driver.findElements(By.tagName("option"));
        Eles.get(1).click();

        WebElement OptionLoc = driver.findElement(By.cssSelector("option[value=\"1\"]"));
        boolean actual = OptionLoc.isSelected();
        Assert.assertEquals(actual , true);   // HardAssertion

        System.out.println("End Of Test Case");



    }
    @Test
    void handleDropdown2 ()
    {
        // 1 - click Dropdown link in homePage

        WebElement DropButton = driver.findElement(By.xpath("//a[text()=\"Dropdown\"]"));
        DropButton.click();

        // Find Elements  , ChromeDriver

        List<WebElement> Eles = driver.findElements(By.tagName("option"));
        Eles.get(1).click();

        WebElement OptionLoc = driver.findElement(By.cssSelector("option[value=\"1\"]"));
        boolean actual = OptionLoc.isSelected();

        // SoftAssertion assertTrue , assertEquals in Class softAssert

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(!actual , "first Assertion");
        soft.assertTrue(actual , "second Assertion");

        System.out.println("End Of Test Case");

        soft.assertAll();



    }

    @AfterMethod
    void CleanUp()
    {



    }
}
