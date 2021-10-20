package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C03_PositiveTestConfigReaderIle extends TestBase {
  //1 ) Bir Class olustur : PositiveTest
//        2) Bir test method olustur positiveLoginTest()
//        https://www.concorthotel.com/ adresine git
//        login butonuna bas
//        test data username:  ,
//                test data password :
//                Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
    @Test
    public void positivetestConfig(){
        driver.get(ConfigReader.getProperty("CHUrl"));

        ConcortHotelPage concortHotelPage =new ConcortHotelPage(driver);
        concortHotelPage.ilkLoginLinki.click();
        concortHotelPage.usenameKutusu.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        concortHotelPage.login.click();

        Assert.assertTrue(concortHotelPage.listofUsers.isDisplayed());




    }
}
