package Payment;

import org.testng.annotations.*;

public class AddToCart {

    @BeforeTest
    Void SetUpTest()
    {

        System.out.println("Before Test AddToCart");

        return null;
    }

    @BeforeClass
    void SetUpClass()
    {

        System.out.println("Before Class AddToCart");

    }
    @BeforeMethod
    void SetUpMethod ()
    {
        System.out.println("Before Method AddToCart");

    }

    @AfterTest
    Void CloseTest()
    {

        System.out.println("After Test AddToCart");

        return null;
    }

    @AfterClass
    void CloseClass()
    {

        System.out.println("After Class AddToCart");

    }
    @AfterMethod
    void CloseMethod ()
    {
        System.out.println("After Method AddToCart");

    }
    @Test
    void TC_C ()
    {

        System.out.println("TC_C AddToCart");
    }
    @Test
    void TC_D ()
    {

        System.out.println("TC_D AddToCart");
    }

}
