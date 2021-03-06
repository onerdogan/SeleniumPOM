package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class QAConcortPage {

   public WebDriver driver;


    public QAConcortPage(){

        PageFactory.initElements(Driver.getDriver(),this);
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

    @FindBy(xpath = "(//span[@class='title'])[3]")
  public WebElement management;

    @FindBy(partialLinkText = "Hotel List")
   public WebElement hotelList;

    @FindBy(xpath = "//span[@class='hidden-480']")
 public WebElement addHotel;

    @FindBy(id="Code")
 public WebElement addhotelCode;

    @FindBy(id="IDGroup")
    public WebElement dropDownGroup;

    @FindBy(id="btnSubmit")
    public WebElement save;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement succesfully;

    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement okButton;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRooms;

    @FindBy(xpath = "//*[text()='Add Hotelroom ']")
    public WebElement addHotelRoom;

    @FindBy(id="IDHotel")
    public WebElement addRoomIdDropdown;

    @FindBy(id="IDGroupRoomType")
    public WebElement addRoomType;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement addRoomSave;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement addRoomSuccsfull;

    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement okAddRoom;

    @FindBy(linkText = "Hotelrooms")
    public WebElement addHotelrooms;

    @FindBy(xpath = "//*[text()='List Of Hotelrooms']")
    public WebElement listofHotelrooms;

    @FindBy(xpath = "//thead/tr[1]/th")
    public List<WebElement> basliklarListesi;

    @FindBy(xpath = "//tbody")
    public WebElement tbodyAll;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> rowList;

    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement firstRow;

@FindBy(xpath = "//tbody/tr//td[4]")
public List<WebElement> forthColumlist;

@FindBy(xpath = "//tbody//tr[1]//td")
public List<WebElement> columList;




    public void ConcortHotelLogin() {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();

        qaConcortPage.usenameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsarname"));

        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.login.click();
    }

    public String printData(int satir, int sutun) {
        //ornekteki 3. satir 5. sutun daki element
        //xpath=//tbody//tr[3]//td[5]
        String xpath="//tbody//tr["+satir+"]//td["+sutun+"]";
        //System.out.println(xpath);
        //satir no: 3, sutun no:5
        System.out.println("satir; "+satir+" sutun:"+sutun);

        //@Findby notasyonu parametreli tasimadigi icin onceki yontemle locate etcez
       // WebElement istenenData=Driver.getDriver().findElement(By.xpath(xpath));
        String istenenData=Driver.getDriver().findElement(By.xpath(xpath)).getText();
        System.out.println("satir; "+satir+" sutun:"+sutun+"'deki data ; "+istenenData);

        return istenenData;
    }
}
