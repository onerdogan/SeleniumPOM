package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class GMIBankPage {

    public GMIBankPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='svg-inline--fa fa-user fa-w-14 ']")
    public WebElement ilkGirisButonu;

    @FindBy(xpath = "//span[text()='Sign in']")
    public  WebElement signInButonu;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement ikinciSignInButonu;

    @FindBy(xpath = "//*[text()='employee32 employee32']")
    public WebElement girisOnay;

    @FindBy(xpath ="//span[text()='Sign out']" )
    public WebElement signoutButonu;



    public void GMIBanklogin() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("GMIBankUrl"));
        GMIBankPage gmiBankPage=new GMIBankPage();
        Thread.sleep(3000);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(gmiBankPage.ilkGirisButonu).click().perform();
        gmiBankPage.signInButonu.click();
        gmiBankPage.usernameBox.sendKeys(ConfigReader.getProperty("GMIBankValidUsername"));
        gmiBankPage.passwordBox.sendKeys(ConfigReader.getProperty("GMIBankValidPassword"));
        gmiBankPage.ikinciSignInButonu.click();
    }
}
