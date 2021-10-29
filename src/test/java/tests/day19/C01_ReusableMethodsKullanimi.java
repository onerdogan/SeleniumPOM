package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_ReusableMethodsKullanimi {
    @Test
    public void test(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkHandle=Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        Set<String> handles=Driver.getDriver().getWindowHandles();
        String ikinciHandle="";
        for(String each:handles){
            if(!each.equals(ilkHandle)){
                ikinciHandle=each;

            }
        }Driver.getDriver().switchTo().window(ikinciHandle);
        System.out.println(Driver.getDriver().getTitle());

        WebElement newWindow=Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindow.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void testReusableile(){

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethods.switchToWindow("New Window");
        WebElement newWindow=Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindow.isDisplayed());
        ReusableMethods.waitFor(2);
        Driver.closeDriver();
    }
}
