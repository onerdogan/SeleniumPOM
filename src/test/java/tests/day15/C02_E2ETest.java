package tests.day15;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_E2ETest {

    @Test
    public void test() throws InterruptedException {
//        1. Tests packagenin altına class olusturun: D17_CreateHotel
//        2. Bir metod olusturun: createHotel
//        3. https://qa-environment.concorthotel.com/ adresine git.
//        4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.
//        a. Username : manager
//        b. Password  : Manager1!
//                5. Login butonuna tıklayın.
//        6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
//        7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
//        8. Save butonuna tıklayın.
//        9. “Hotel was inserted successfully” textinin göründüğünü test edin.
//        10. OK butonuna tıklayın.
//

        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();

        qaConcortPage.management.click();
        qaConcortPage.hotelList.click();
        qaConcortPage.addHotel.click();

        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();

        actions.
                click(qaConcortPage.addhotelCode).
                sendKeys(faker.address().zipCode()).
                sendKeys(Keys.TAB).sendKeys(faker.gameOfThrones().character()).
                sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress()).
                sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone()).
                sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).perform();

        Select select=new Select(qaConcortPage.dropDownGroup);
        select.selectByValue("1");
        Thread.sleep(2000);
        qaConcortPage.save.click();
         //Driver.getDriver().switchTo().alert();
        System.out.println(qaConcortPage.succesfully.getText());
        Thread.sleep(2000);
        Assert.assertTrue(qaConcortPage.succesfully.isDisplayed());

        Thread.sleep(5000);
        qaConcortPage.okButton.click();


    }
}
