package tests.day13;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.OdevPage;
import utilities.TestBase;

public class Odev extends TestBase {



    @Test
    public void testPOM() throws InterruptedException {
        driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=common/home");
        OdevPage odevPage=new OdevPage(driver);
        //~ click on Phones & PDAs
        odevPage.phonesPDAs.click();
        //~ get the brandName of phones
        System.out.println("brandName of phones: ");
        for(WebElement each: odevPage.products) {


            System.out.println(each.getText());
        }
       // ~ click on add to button for all elements
        for(WebElement each: odevPage.addAllCart){
            each.click();
        }
       // ~ click on black total added cart button

        Thread.sleep(3000);
        odevPage.clickTotalButton.click();

           // ~ get the names of list from the cart
        System.out.println("***name of list from the cart***");
        for (WebElement each: odevPage.inCard){
            System.out.println(each.getText());
        }

        //~ compare the names from displaying list and cart list
        for (WebElement each: odevPage.inCard){
            Assert.assertTrue(each.isDisplayed(),"gorunmedi");
        }
    }
}
