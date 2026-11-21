package Payment;

import org.testng.annotations.*;

public class Checkout {



    @BeforeClass
    void SetUpClass()
    {

        System.out.println("Before Class CheckOut");

    }
    @BeforeMethod
    void SetUpMethod ()
    {
        System.out.println("Before Method CheckOut");

    }


    @AfterClass
    void CloseClass()
    {

        System.out.println("After Class CheckOut");

    }
    @AfterMethod
    void CloseMethod ()
    {
        System.out.println("After Method CheckOut");

    }
    @Test
    void TC_C ()
    {

        System.out.println("TC_C CheckOut");
    }
    @Test
    void TC_D ()
    {

        System.out.println("TC_D CheckOut");
    }

}
