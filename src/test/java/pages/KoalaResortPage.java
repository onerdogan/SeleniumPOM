package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KoalaResortPage {

    public WebDriver driver;

    public KoalaResortPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

        @FindBy(linkText = "Log in")
    public WebElement login1;

    @FindBy(id="UserName")
    public WebElement username;

    @FindBy(id="Password")
    public WebElement password;

    @FindBy(id="btnSubmit")
    public WebElement login2;


}
