package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLogintest {

    @Test
    public void positiveLogintest(){
//        Bir test method olustur positiveLoginTest()
//        https://qa-environment.concorthotel.com/ adresine git

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
//        login butonuna bas
        qaConcortPage.ilkLoginLinki.click();
//        test data username: manager ,
        qaConcortPage.usenameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsarname"));
//                test data password : Manager1!
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.login.click();
//                Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(qaConcortPage.listofUsers.isDisplayed());
        Driver.closeDriver();


    }

}
