package practise;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GMIBankPage;

public class Test1GMIBankPositiveTest {

    @Test
    public void SignInTesti() throws InterruptedException {
        GMIBankPage gmiBankPage=new GMIBankPage();
        gmiBankPage.GMIBanklogin();
        Assert.assertTrue(gmiBankPage.girisOnay.isDisplayed());

    }
    @Test
    public  void singOutLink(){
        GMIBankPage gmiBankPage=new GMIBankPage();
        gmiBankPage.ilkGirisButonu.click();
    gmiBankPage.signoutButonu.click();

    }
}
