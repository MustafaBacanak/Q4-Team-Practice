package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {

    //  driver objesini olustur.
    protected static WebDriver driver;

    //  setUp
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--accept-cookies");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //  tearDown
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        driver.quit();
    }

    //    MULTIPLE WINDOW
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    //    MULTIPLE WINDOW URL
    public static void switchToWindowUrl(String targetUrl) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().equals(targetUrl)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    //    MULTIPLE WINDOW INDEX
    public static void switchToWindowIndex(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

    public static WebElement findId(String key){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(key)));
        return element;
    }
    public static WebElement findCss(String key){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(key)));
        return element;
    }

    public static WebElement findXPath(String key){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(key)));
        return element;
    }

    // RESUABLE METHOD :Dropdown icin tekrar tekrar kullanabilecegimiz method olusturalim
    public void selectFromDropDown(WebElement dropdown, String secenek) {

        List<WebElement> options = dropdown.findElements(By.tagName("option"));//Tum option'lari return eder
        for (WebElement w : options) {
            if (w.getText().equals(secenek)) {
                w.click();
                break;
            }
        }
    }

    public static void clickWithText(String key, String text){

        List<WebElement> elements = driver.findElements(By.cssSelector(key));
//        for (int i = 0; i < elements.size(); i++) {
//            if (elements.get(i).getText().equals(text)){
//                elements.get(i).click();
//            }
//        }
        for (WebElement w : elements){
            if ((w.getText()).equals(text)){
                w.click();
            }
        }

    }
}



