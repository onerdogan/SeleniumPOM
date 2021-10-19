package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {

    // facebook login sayfasina gidin
// kullanici adi : techproed
// sifre : 12345
// yazdigimizda giris yapamadigimizi test edin
    @Test
    public void testPOM() {
        driver.get("https://www.facebook.com");
        FacebookPage face = new FacebookPage(driver);
        face.mailKutusu.sendKeys("techProed@hotmail.com");
        face.sifreKutusu.sendKeys("12345");
        face.loginTusu.click();
        Assert.assertTrue(face.girilemedi.isDisplayed());
    }
}
