package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class D19HomeworkPage {

    WebDriver driver;

    public D19HomeworkPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(className="rt-resizable-header-content")
    public WebElement tableHeader;

    @FindBy(xpath = "//div[@class='rt-tbody']")
    public WebElement tableAll;

    @FindBy(xpath = "//tbody/tr//td[5]")
    public WebElement fifthcolum;

    @FindBy(xpath = "(//div[@class='rt-td'])[6]")
    public WebElement sixthOne;

    @FindBy(xpath = "(//div[@class='rt-td'])[13]")
    public WebElement sixthTwo;

    @FindBy(xpath = "(//div[@class='rt-td'])[20]")
    public WebElement sixthThree;

    @FindBy(xpath = "(//div[@class='rt-resizable-header-content'])[6]")
    public WebElement sixthColumHeader;

    @FindBy(xpath = "//div[@class='rt-td']")
    public List<WebElement> allCell;

    @FindBy(xpath = "//div[@class='rt-tr-group']")
    public List<WebElement> allRows;

    @FindBy(xpath = "//div[@class='rt-resizable-header-content']")
    public List<WebElement> allColums;



    }

