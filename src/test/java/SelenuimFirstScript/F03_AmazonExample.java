package SelenuimFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class F03_AmazonExample {
    WebDriver driver ;

    @BeforeMethod
    void SetUp ()
    {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.eg/");


    }
    @Test
    void Search ()
    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement SearchField =  driver.findElement(By.cssSelector("input[name=\"field-keywords\"]"));
        SearchField.sendKeys("Laptop");

        WebElement SearchButton = driver.findElement(By.id("nav-search-submit-button"));
        SearchButton.click();


        SoftAssert soft = new SoftAssert();

      //  List<WebElement> Eles = driver.findElements(By.className("puis-card-container"));
      //  for (int i = 0 ; i< Eles.size() ; i++ ) {
           // boolean actual = Eles.get(i).getText().contains("Laptop");
       //     soft.assertTrue(actual);
      //  }
       // soft.assertAll();



        List<WebElement> Eles = driver.findElements(
                By.className("puis-card-container")
        );

        System.out.println("Total product cards: " + Eles.size());

        for (int i = 0; i < Eles.size(); i++) {

            String productText = Eles.get(i).getText();

            boolean actual = productText
                    .toLowerCase()
                    .contains("laptop");

            soft.assertTrue(
                    actual,
                    "Product card #" + (i + 1)
                            + " does not contain Laptop. Text: "
                            + productText
            );
        }

        soft.assertAll();


    }
}
