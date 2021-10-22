package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;


public abstract class TestBase {
    protected static WebDriver driver;
    // abstract yaparak bu class'dan obje olusturulmasinin onune geceriz

    static public String getSecondHandle() {
        String firstHandle = driver.getWindowHandle();
        Set<String> handlesAll = driver.getWindowHandles();
        String secondHandle = "";
        for (String each : handlesAll
        ) {
            if (!each.equals(firstHandle)) {
                secondHandle = each;
            }
        }
        return secondHandle;
    }

    // biz test base class'i sadece extends ile inherit ederek kullanacagiz
    // dolayisiyla olusturdugumuz driver variable'i icin protected access modifier'i seciyoruz
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown(){
        driver.close();

    }
}



