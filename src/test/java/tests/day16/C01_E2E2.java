package tests.day16;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_E2E2 {
    @Test
    public void RoomCreateTest() throws InterruptedException {

//        3. https://qa-environment.concorthotel.com/ adresine gidin.
       QAConcortPage qaConcortPage=new QAConcortPage();
       qaConcortPage.ConcortHotelLogin();
//        4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
//        a. Username : manager  b. Password  : Manager1!
//                5. Login butonuna tıklayın.

//        6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        qaConcortPage.management.click();
        qaConcortPage.hotelRooms.click();
        qaConcortPage.addHotelRoom.click();
//        7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Select select=new Select(qaConcortPage.addRoomIdDropdown);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAAddRoomIdHotel"));
        Faker faker=new Faker();
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).
                sendKeys(faker.address().zipCode()).
                sendKeys(Keys.TAB).sendKeys(faker.name().name()).
                sendKeys(Keys.TAB).sendKeys(faker.address().city()).
                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAAddRoomDescription")).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAAddRoomPrice")).
                perform();
        select=new Select(qaConcortPage.addRoomType);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAAddRoomType"));

        actions.sendKeys(Keys.TAB).sendKeys(String.valueOf(faker.number().numberBetween(1,2))).
                sendKeys(Keys.TAB).sendKeys(String.valueOf(faker.number().numberBetween(1,5))).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.TAB).
                sendKeys(Keys.SPACE). perform();
                Thread.sleep(2000);
                actions.click(qaConcortPage.addRoomSave).perform();
    Thread.sleep(2000);
        Assert.assertTrue(qaConcortPage.addRoomSuccsfull.isDisplayed());

        qaConcortPage.okAddRoom.click();

        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(2000);
        qaConcortPage.addHotelrooms.click();
        Thread.sleep(2000);
        Assert.assertTrue(qaConcortPage.listofHotelrooms.isDisplayed());
//        8. Save butonuna basin.
//        9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
//        10. OK butonuna tıklayın.
//        11. Hotel rooms linkine tıklayın.
//        12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..
        //Driver.closeDriver();

    }


}
