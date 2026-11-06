package swagtestpkg;

import org.testng.annotations.Test;

import basepkgswag.SwagBase;

public class SwagCartTest extends SwagBase {

    @Test(priority = 4)
    public void cartTest()
    {
        cartobj.cartmethod();
    }

    @Test(priority = 5)
    public void checkoutTest()
    {
        cartobj.checkoutmethod();
    }
}