package tests.day17_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C01_ReadExcel {

    @Test
    public void test() throws IOException {

//        . Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
//        8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStreamm=new FileInputStream(dosyaYolu);

//        9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim

//        10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fileInputStreamm);
//        11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");
//        12. Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(4);
//        13. Cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(1);

        System.out.println(cell);
    }
    @Test
    public void test2() throws IOException {

        // . Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
//        8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStreamm=new FileInputStream(dosyaYolu);

//        9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim

//        10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fileInputStreamm);
//        11. Worksheet objesi olusturun workbook.getSheetAt(index)

//        12. Row objesi olusturun sheet.getRow(index)

//        13. Cell objesi olusturun row.getCell(index)
        Cell cell= workbook.getSheet("Sayfa1").getRow(5).getCell(3);

        System.out.println(cell);
    //secilen hucredeki yazinin Luanda oldugunu test edin
        //Assert.assertEquals(cell,"Luanda");
        //cell'in data turu cell, Luanda ise String
        //cell data turu yazdirilabilir ancak string methodlari ile kullanilamaz.
        //String manipulationyapmak icin cell data turunu stringe cast yapmaliyiz
        Assert.assertEquals(cell.toString(),"Luanda");
        Assert.assertEquals(cell.getStringCellValue(),"Luanda");

        //index'i 3 olan satirdaki index'i 2 olan hucredeki yaziyi buyuk harfke yazdirin
        Cell cell1=workbook.getSheet("Sayfa1").getRow(3).getCell(3);
        System.out.println(cell1.toString().toUpperCase());
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum());//son satirin indexini verir
        System.out.println((workbook.getSheet("Sayfa1").getPhysicalNumberOfRows()));//fiili olarak kullanilan satir sayisini verir

        System.out.println(workbook.getSheet("Sayfa2").getLastRowNum());
        System.out.println((workbook.getSheet("Sayfa2").getPhysicalNumberOfRows()));
        System.out.println(workbook.getSheet("Sayfa2").getFirstRowNum());//5den basladigi icin 5 verdi
    }

    @Test
    public void test3() throws IOException {
        //tablodaki 2 sutunu yazdiralim

        List<String> ikinciSutun=new ArrayList<>();
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStreamm=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStreamm);
        for(int i=0;i<=workbook.getSheet("Sayfa1").getLastRowNum();i++){
            ikinciSutun.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());
        }
        System.out.println(ikinciSutun);
        //A ile bslayan sehirleri listeletin

        List<String> aIleBaslayanSehirler=new ArrayList<>();
        for(String each:ikinciSutun){
            if(each.startsWith("A")){
                aIleBaslayanSehirler.add(each);
            }

        }
        System.out.println(aIleBaslayanSehirler);
        //eger tum datayi bir collectiona cevirmek istersek
        //en uygun yapi map olur, bir sutunu key geriye kalanlari ise virgulle ayrilan value yapmaliyiz
        //key=Turkey, value=Ankara, Turkiye, Ankara
        Map<String,String> ulkelerMap=new HashMap<>();
        String key="";
        String value="";
        for(int i=0;i<=workbook.getSheet("Sayfa1").getLastRowNum();i++){
            ikinciSutun.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());

            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+ ","+
            workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+ ","+
            workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString()+ ",";

            ulkelerMap.put(key,value);

        }
        System.out.println(ulkelerMap);
        //java methodlarini ve collectionu kullanarak, exceldeki datalari manipule edebiliriz

    }
}
