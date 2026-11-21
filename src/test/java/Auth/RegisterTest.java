package Auth;

import org.testng.annotations.*;

public class RegisterTest {



    @BeforeClass
    void SetUpClass()
    {

        System.out.println("Before Class RegisterTest");

    }
    @BeforeMethod
    void SetUpMethod ()
    {
        System.out.println("Before Method RegisterTest");

    }



    @AfterClass
    void CloseClass()
    {

        System.out.println("After Class RegisterTest");

    }
    @AfterMethod
    void CloseMethod ()
    {
        System.out.println("After Method RegisterTest");

    }
    @Test
    void TC_C ()
    {

        System.out.println("TC_C RegisterTest");
    }
    @Test
    void TC_D ()
    {

        System.out.println("TC_D RegisterTest");
    }


}
