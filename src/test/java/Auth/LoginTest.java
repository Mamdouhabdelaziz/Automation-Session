package Auth;

import org.testng.annotations.*;

public class LoginTest {



    @BeforeSuite
    void SetUpSuite()
    {
        System.out.println("Before Suite ");

    }
    @BeforeTest
    Void SetUpTest()
    {

        System.out.println("Before Test LoginTest");

        return null;
    }

    @BeforeClass
    void SetUpClass()
    {

        System.out.println("Before Class LoginTest");

    }
    @BeforeMethod
    void SetUpMethod ()
    {
        System.out.println("Before Method LoginTest");

    }
    @AfterSuite
    void CloseSuite()
    {
        System.out.println("After Suite ");

    }
    @AfterTest
    Void CloseTest()
    {

        System.out.println("After Test LoginTest");
        System.out.println("==========================");

        return null;
    }

    @AfterClass
    void CloseClass()
    {

        System.out.println("After Class LoginTest");

    }
    @AfterMethod
    void CloseMethod ()
    {
        System.out.println("After Method LoginTest");

    }
    @Test(priority = 1)
    void TC_A ()
    {

        System.out.println("TC_A LoginTest");
    }
    @Test(priority = 0,invocationCount = 3,enabled = true,dependsOnMethods = {"TC_A"})
    void TC_B ()
    {

        System.out.println("TC_B LoginTest");
    }



}
