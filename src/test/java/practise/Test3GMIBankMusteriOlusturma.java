package practise;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GMIBankPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Test3GMIBankMusteriOlusturma {

    @Test
    public void test() throws InterruptedException {

        GMIBankPage gmiBankPage = new GMIBankPage();
        gmiBankPage.GMIBanklogin();
        gmiBankPage.myOperations.click();
        gmiBankPage.manageCustomers.click();
        gmiBankPage.ilkMusteriEdit.click();
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        gmiBankPage.firstnameElement.clear();
        gmiBankPage.firstnameElement.click();
        String firstname = faker.name().firstName();
        System.out.println(firstname);
        actions.sendKeys(firstname).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().nameWithMiddle()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("MobilNumber")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("PhoneNumber")).
                sendKeys(Keys.TAB).
                sendKeys(faker.address().zipCode()).
                sendKeys(Keys.TAB).
                sendKeys(faker.address().fullAddress()).
                sendKeys(Keys.TAB).
                sendKeys(faker.address().city()).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("SSNNumber"));

        Select select=new Select(gmiBankPage.countruDropdown);
        select.selectByVisibleText("USA");
        actions.sendKeys(Keys.TAB).
                sendKeys(faker.address().state()).perform();

        gmiBankPage.editSaveButton.click();

        Thread.sleep(3000);
        System.out.println(gmiBankPage.ilkmusteriName.getText());
        Assert.assertEquals(firstname,gmiBankPage.ilkmusteriName.getText(),"tutmadi");


        System.out.println(gmiBankPage.tumBody.getText());
        Assert.assertTrue(gmiBankPage.tumBody.getText().contains(firstname));
    }

}
