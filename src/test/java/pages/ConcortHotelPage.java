package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConcortHotelPage {



        WebDriver driver;

        public ConcortHotelPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        @FindBy(linkText = "Log in")
        public WebElement ilkLoginLinki;

        @FindBy(id = "UserName")
        public WebElement usenameKutusu;

    @FindBy(id = "Password")
    public WebElement passwordKutusu;

    @FindBy(id = "btnSubmit")
    public WebElement login;

    @FindBy(xpath = "//*[text()='ListOfUsers']")
    public WebElement listofUsers;

    @FindBy (xpath = "//*[.='Try again please']")
    public WebElement yanlisLoginYazisi;


    }
