package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OdevPage {

        WebDriver driver;

        public OdevPage(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }

          @FindBy(linkText="Phones & PDAs")
        public WebElement phonesPDAs;


        @FindBy(tagName = "h4")
         public  List<WebElement>  products;

        @FindBy(xpath = "//*[text()='Add to Cart']")
        public List<WebElement> addAllCart;

        @FindBy(xpath = "//div[@class='btn-group btn-block']")
        public WebElement clickTotalButton;

        @FindBy(xpath = "//td[@class='text-left']")
        public List<WebElement> inCard;
}
