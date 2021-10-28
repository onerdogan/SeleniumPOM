package tests.day16;

import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class D18_WebTables {
    //
//
//● Bir class oluşturun : D18_WebTables
//● login() metodun oluşturun ve oturum açın.
//            ● http://qa-environment.koalaresorthotels.com /admin/HotelRoomAdmin adresine gidin
    @Test
    public void test() {

        KoalaResortPage koalaResortPage=new KoalaResortPage();
        Driver.getDriver().get(ConfigReader.getProperty("KRHUrl"));
        koalaResortPage.login1.click();
        koalaResortPage.username.sendKeys(ConfigReader.getProperty("KRHUsername"));
        koalaResortPage.password.sendKeys(ConfigReader.getProperty("KRHPassword"));
        koalaResortPage.login2.click();
//            ○ Username : manager
//○ Password : Manager2!
//            ● table() metodu oluşturun
//○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
//○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
//            ● printRows() metodu oluşturun //tr
//○ table body’sinde bulunan toplam satir(row) sayısını bulun.
//            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
//            ○ 4.satirdaki(row) elementleri konsolda yazdırın.
//            ● printCells() metodu oluşturun //td
//○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
//            ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
//            ● printColumns() metodu oluşturun
//○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
//            ○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
//            ○ 5.column daki elementleri konsolda yazdırın.


    }
}