package swagtestpkg;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepkgswag.SwagBase;

public class SwagHomeTest extends SwagBase {

    @Test(priority = 1)
    public void textverify()
    {
        String productText = homepageobj.textmethod();

        Assert.assertEquals(productText, "Products");
    }

    @Test(priority = 2)
    public void linkverification()
    {
        int linkcount = homepageobj.linkcountmethod();

        System.out.println("Number of links -----" + linkcount);
    }

    @Test(priority = 3)
    public void cartmethod()
    {
        homepageobj.cart_btn_method();
    }
}