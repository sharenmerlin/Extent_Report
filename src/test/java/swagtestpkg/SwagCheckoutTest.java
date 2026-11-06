package swagtestpkg;

import org.testng.annotations.Test;

import basepkgswag.SwagBase;

public class SwagCheckoutTest extends SwagBase {

    @Test(priority = 6)
    public void checkoutDetailsTest() {

        checkoutobj.checkoutdetails(
                "Sharen",
                "Merlin",
                "N6A123");
    }

    @Test(priority = 7)
    public void continueTest() {

        checkoutobj.continuemethod();
    }
}