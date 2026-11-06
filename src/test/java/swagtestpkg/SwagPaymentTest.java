package swagtestpkg;

import java.io.IOException;

import org.testng.annotations.Test;

import basepkgswag.SwagBase;

public class SwagPaymentTest extends SwagBase {


    @Test(priority = 8)
    public void screenshotTest() throws IOException
    {
        paymentobj.screenshotmethod();
    }

    @Test(priority = 9)
    public void finishTest()
    {
        paymentobj.finishmethod();
    }
}
