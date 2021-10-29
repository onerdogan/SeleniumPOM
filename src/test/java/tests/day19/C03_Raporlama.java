package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_Raporlama extends TestBaseRapor {

    @Test
    public void test1(){
        //amazon, nutella, sonuc sayisini 1000 az
        extentTest=extentReports.createTest("amazon nutella testi","nutella sayisi 1000 az olmali");
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("link acildi");

        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys(ConfigReader.getProperty("amazonArananKelime")+ Keys.ENTER);
        extentTest.info("arama cubuguna nutella girildi");

        WebElement sonucYazisi=Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));
        String sonuc=sonucYazisi.getText();
        String sonucArray[]=sonuc.split(" ");
        int sonucSayisi=Integer.parseInt(sonucArray[2]);
        extentTest.info("sonuc yazisi integer haline getirildi");

        Assert.assertTrue(sonucSayisi<1000);
        extentTest.pass("sonuc sayisinin 1000 az oldugu test edildi");

    }

    @Test
    public void test2(){
        //samsun icin 1000 az
        extentTest=extentReports.createTest("amazon samsung testi","samsung sayisi 1000 az olmali");
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("link acikdi");

        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys(("samsung")+ Keys.ENTER);
        extentTest.info("arama cubuguna nutella girildi");

        WebElement sonucYazisi=Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));
        String sonuc=sonucYazisi.getText();
        String sonucArray[]=sonuc.split(" ");
        String sonucAdedi=sonucArray[3];
        sonucAdedi=sonucAdedi.replace(",","");
        System.out.println(sonucAdedi);
        int sonucSayisi=Integer.parseInt(sonucAdedi);
        extentTest.info("sonuc yazisi integer haline getirildi");

        Assert.assertTrue(sonucSayisi<1000);
        extentTest.pass("sonuc sayisinin 1000 az oldugu test edildi");
    }
    @Test
    public void test3(){
        //electronic de java , ilk sonucta java varmi
        extentTest=extentReports.createTest("amazon electronics testi","java aratma");
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("link acikdi");

        Select select=new Select(Driver.getDriver().findElement(By.id("searchDropdownBox")));
        select.selectByVisibleText("Electronics");
        extentTest.info("dropdown acildi electronocs secildi");
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys(("java")+ Keys.ENTER);
        extentTest.info("java aratildi");

                WebElement ikinciUrun=Driver.getDriver().findElement(By.xpath("(//img[@class='s-image'])[2]"));
                Assert.assertTrue(ikinciUrun.getText().contains("java"));
        extentTest.info("ilk urun isminde java varmi test edildi");

    }
}
