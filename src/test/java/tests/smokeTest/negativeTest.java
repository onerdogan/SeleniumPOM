package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class negativeTest {

//    1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
//3 Farkli test Methodunda 3 senaryoyu test et
// - yanlisSifre
// - yanlisKulllanici
// - yanlisSifreKullanici
//    test data yanlis username: manager1 , yanlis password : manager1!
//            2) https://qa-environment.concorthotel.com/ adresine git
//            3) Login butonuna bas
//4) Verilen senaryolar ile giris yapilamadigini test et



      @Test(priority = -1)
              public void yanlisSifre() {


          Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
          QAConcortPage qaConcortPage = new QAConcortPage();
          qaConcortPage.ilkLoginLinki.click();
          qaConcortPage.usenameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsarname"));
          qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidPassword"));
          qaConcortPage.login.click();
          Assert.assertTrue(qaConcortPage.yanlisLoginYazisi.isDisplayed());
      }
          @Test(dependsOnMethods = "yanlisSifre")
          public void yanlisKullanici(){

              QAConcortPage qaConcortPage = new QAConcortPage();
              qaConcortPage.usenameKutusu.clear();
              qaConcortPage.usenameKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidUsarname"));
              qaConcortPage.passwordKutusu.clear();
              qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
              qaConcortPage.login.click();
              Assert.assertTrue(qaConcortPage.yanlisLoginYazisi.isDisplayed());
     }
     @Test(dependsOnMethods = "yanlisSifre")
    public void yanlissifreKullacici(){
         QAConcortPage qaConcortPage = new QAConcortPage();
         qaConcortPage.usenameKutusu.clear();
         qaConcortPage.usenameKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidUsarname"));
         qaConcortPage.passwordKutusu.clear();
         qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidPassword"));
         qaConcortPage.login.click();
         Assert.assertTrue(qaConcortPage.yanlisLoginYazisi.isDisplayed());
         Driver.closeDriver();


     }

}
