package cross_browser_test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTCs {

    WebDriver driver;

    @BeforeMethod
    @Parameters({"browser", "websiteURL"})
    public void setUp(String browser, String websiteURL) {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }

        driver.get(websiteURL);
        driver.manage().window().maximize();
    }
    @Test
    void CrossBrowser()
    {
        System.out.println("TC1");

    }
}