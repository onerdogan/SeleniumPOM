package tests.day16;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_WebTable {

    @Test(groups = "birinciGrup")
    public void test() throws InterruptedException {
//        Bir class oluşturun : C02_WebTables
//● login() metodun oluşturun ve oturum açın.
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
//        4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
//        a. Username : manager  b. Password  : Manager1!
//                5. Login butonuna tıklayın.

        qaConcortPage.management.click();
        qaConcortPage.hotelRooms.click();
        for (WebElement each: qaConcortPage.basliklarListesi){
            System.out.println(each.getText());
        }
        System.out.println("sutun sayisi: "+qaConcortPage.basliklarListesi.size());
    Thread.sleep(2000);
        System.out.println(qaConcortPage.tbodyAll.getText());
        Assert.assertTrue(qaConcortPage.tbodyAll.getText().contains("HAPPY HOTEL"));
        //eger tum tablo body sini hucrelere ayirmadan tek bir string olarak gormek istersek , tek bir Webelement olarak locate edebiliriz
        // bu string icinde istedigimiz aramayi yapabiliriz
        System.out.println("tablodaki satir sayisi: "+qaConcortPage.rowList.size());
        System.out.println(qaConcortPage.firstRow.getText());


        for(int i=0;i<qaConcortPage.rowList.size();i++){
            System.out.println(i+1+". satir: "+qaConcortPage.rowList.get(i).getText());
        }


        for(WebElement each: qaConcortPage.forthColumlist){
            System.out.println(each.getText());

                    }
        System.out.println("sutun sayisi: "+qaConcortPage.columList.size());

//● https://www.concorthotel.com//admin/HotelRoomAdmin adresine gidin


// ○ Username : manager
// ○ Password : Manager1!
//● table() metodu oluşturun
// ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody


// ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
//● printRows() metodu oluşturun //tr



// ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
// ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
// ○ 4.satirdaki(row) elementleri konsolda yazdırın.
//
        Thread.sleep(2000);
//Driver.closeDriver();
    }
}
