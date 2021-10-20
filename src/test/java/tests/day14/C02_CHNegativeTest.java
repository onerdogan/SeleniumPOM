package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C02_CHNegativeTest extends TestBase {
//    Bir test method olustur NegativeLoginTest()
//    https://www.concorthotel.com/ adresine git
//    login butonuna bas
//    test data username: manager1 ,
//    test data password : manager1!
//    Degerleri girildiginde sayfaya girilemedigini test et
@Test
public void positiveLoginTest(){
    driver.navigate().to("https://www.concorthotel.com/");
    ConcortHotelPage concortHotelPage =new ConcortHotelPage(driver);
    concortHotelPage.ilkLoginLinki.click();
    concortHotelPage.usenameKutusu.sendKeys("m1");
    concortHotelPage.passwordKutusu.sendKeys("m2");
    concortHotelPage.login.click();

    Assert.assertTrue(concortHotelPage.yanlisLoginYazisi.isDisplayed());

}

}
