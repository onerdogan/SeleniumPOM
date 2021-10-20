package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C05_NegativeTestConfigReader extends TestBase {

    @Test
    public void test(){
//        https://www.concorthotel.com/ adresine git
//        login butonuna bas
//        test data username: manager1 ,
//                test data password : manager1!
//                Degerleri girildiginde sayfaya girilemedigini test et


        driver.get(ConfigReader.getProperty("CHUrl"));
        ConcortHotelPage concortHotelPage =new ConcortHotelPage(driver);
        concortHotelPage.ilkLoginLinki.click();
        concortHotelPage.usenameKutusu.sendKeys(ConfigReader.getProperty("CHInvalidUsarname"));
        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHInvalidPassword"));
        concortHotelPage.login.click();
        Assert.assertTrue(concortHotelPage.yanlisLoginYazisi.isDisplayed());

    }
}
