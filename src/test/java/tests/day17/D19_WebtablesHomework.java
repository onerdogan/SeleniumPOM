package tests.day17;

import org.testng.annotations.Test;
import pages.D19HomeworkPage;
import utilities.ConfigReader;
import utilities.Driver;

public class D19_WebtablesHomework {
    @Test
    public void test(){


//        “https://demoqa.com/webtables” sayfasina gidin
        D19HomeworkPage d19HomeworkPage=new D19HomeworkPage();
        Driver.getDriver().get(ConfigReader.getProperty("DemogaUrl"));
//        2. Headers da bulunan department isimlerini yazdirin
        System.out.println(d19HomeworkPage.sixthOne.getText());
        System.out.println(d19HomeworkPage.sixthTwo.getText());
        System.out.println(d19HomeworkPage.sixthThree.getText());
//        3. sutunun basligini yazdirin
        System.out.println(d19HomeworkPage.sixthColumHeader.getText());
//
//        4. Tablodaki tum datalari yazdirin
      System.out.println(d19HomeworkPage.tableAll.getText());
//        5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println(d19HomeworkPage.allCell.size());
//        6. Tablodaki satir sayisini yazdirin
        System.out.println(d19HomeworkPage.allRows.size());
//
//        7. Tablodaki sutun sayisini yazdirin
        System.out.println(d19HomeworkPage.allColums.size());
//
//        8. Tablodaki 3.kolonu yazdirin
//
//        9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
//
//        10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
//        girdigimde bana datayi yazdirsin


        System.out.println(d19HomeworkPage.tableHeader.getText());


    }
}
