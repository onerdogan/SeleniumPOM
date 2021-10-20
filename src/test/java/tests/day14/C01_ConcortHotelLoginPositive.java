package tests.day14;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import pages.OdevPage;
import utilities.TestBase;

public class C01_ConcortHotelLoginPositive extends TestBase {
    @Test
    public void positiveLoginTest(){
//        1 ) Bir Class olustur : PositiveTest
//        2) Bir test method olustur positiveLoginTest()
//        https://www.concorthotel.com/ adresine git
//        login butonuna bas
//        test data username:  ,
//                test data password :
//                Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        driver.navigate().to("https://www.concorthotel.com/");
        ConcortHotelPage concortHotelPage =new ConcortHotelPage(driver);
        concortHotelPage.ilkLoginLinki.click();
        concortHotelPage.usenameKutusu.sendKeys("manager"+ Keys.TAB);
        concortHotelPage.passwordKutusu.sendKeys("Manager1!"+Keys.TAB);
        concortHotelPage.login.click();
        Assert.assertTrue(concortHotelPage.listofUsers.isDisplayed());
    }
}
