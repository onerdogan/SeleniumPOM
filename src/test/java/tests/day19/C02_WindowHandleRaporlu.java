package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_WindowHandleRaporlu extends TestBaseRapor {

    @Test
    public void test() throws InterruptedException {
        extentTest=extentReports.createTest("window handle test","yeni sayfadada New Window test eder");


        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        extentTest.info("istenen adrese gidildi");
Thread.sleep(1000);
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        extentTest.info("link tiklanti");

        ReusableMethods.switchToWindow("New Window");
        extentTest.info("test edilecek yazi locate edildi");

        WebElement newWindow=Driver.getDriver().findElement(By.tagName("h3"));
        extentTest.info("test edecegimiz yazi locate edidi");

        Assert.assertTrue(newWindow.isDisplayed());
        extentTest.pass("yazinin gorunur oldugu test edildi");
        ReusableMethods.waitFor(2);

    }
    }

