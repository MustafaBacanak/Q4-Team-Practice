package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //  tearDown
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        driver.quit();
    }

    //    MULTIPLE WINDOW TITLE
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
    public static void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }
    //    Find and wait ID
    public static WebElement findId(String key){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(key)));
    }

    //    Find and wait Css
    public static WebElement findCss(String key){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(key)));
    }

    //    Find and wait xPath
    public static WebElement findXPath(String key){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(key)));
    }

    //  Js Executer Css
    public static void jsExecuterCss(String key){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement elementName = driver.findElement(By.cssSelector(key));
        js.executeScript("arguments[0].click();",elementName);
    }

    //  Js Executer xPath
    public static void jsExecuterXPath(String key){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement elementName = driver.findElement(By.xpath(key));
        js.executeScript("arguments[0].click();",elementName);
    }

    //    HARD WAIT: @param : second
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickWithText(String key, String text){


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector(key))));

        for (WebElement webElement : element) {
            if (webElement.getText().equals(text)) {
                webElement.click();
            }
        }
//        for (int i = 0; i < element.size(); i++) {
//            if (element.get(i).getText().equals(text)){
//                element.get(i).click();
//            }
//        }
    }
}