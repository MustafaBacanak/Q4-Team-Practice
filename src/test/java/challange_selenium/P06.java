package challange_selenium;

    //    Given kullanici "https://editor.datatables.net/" sayfasina gider
    //    Then new butonuna basar
    //    And editor firstname kutusuna "<firstName>" bilgileri girer
    //    And editor lastname kutusuna "<lastName>" bilgileri girer
    //    And editor position kutusuna "<position>" bilgileri girer
    //    And editor office kutusuna "<office>" bilgileri girer
    //    And editor extension kutusuna "<extension>" bilgileri girer
    //    And editor startdate kutusuna "<startDate>" bilgileri girer
    //    And editor salary kutusuna "<salary>" bilgileri girer
    //    When Create tusuna basar
    //    Then Kullanıcının eklendiğini doğrular.
    //    And Eklediği kullanıcı kaydını siler
    //    Then Kullanıcinin silindiğini doğrular.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P06 {
    static WebDriver driver;
    static String gorunum;
    static String x;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void theEnd(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {

        //    Given kullanici "https://editor.datatables.net/" sayfasina gider
        driver.get("https://editor.datatables.net/");

        //    Then new butonuna basar
        driver.findElement(By.cssSelector(".buttons-create")).click();

        //    And editor firstname kutusuna "<firstName>" bilgileri girer
        driver.findElement(By.id("DTE_Field_first_name")).sendKeys("Mustafa");

        //    And editor lastname kutusuna "<lastName>" bilgileri girer
        driver.findElement(By.id("DTE_Field_last_name")).sendKeys("Bacanak");

        //    And editor position kutusuna "<position>" bilgileri girer
        driver.findElement(By.id("DTE_Field_position")).sendKeys("QA");

        //    And editor office kutusuna "<office>" bilgileri girer
        driver.findElement(By.id("DTE_Field_office")).sendKeys("Free");

        //    And editor extension kutusuna "<extension>" bilgileri girer
        driver.findElement(By.id("DTE_Field_extn")).sendKeys("Free");
        Thread.sleep(1000);

        //    And editor startdate kutusuna "<startDate>" bilgileri girer
        driver.findElement(By.id("DTE_Field_start_date")).sendKeys("2022-12-25");

        //    And editor salary kutusuna "<salary>" bilgileri girer
        driver.findElement(By.id("DTE_Field_salary")).sendKeys("10000");

        //    When Create tusuna basar
        driver.findElement(By.cssSelector(".btn")).click();
        Thread.sleep(1000);

        //    Then Kullanıcının eklendiğini doğrular.
        driver.findElement(By.cssSelector("input[type='search']")).sendKeys("Mustafa Bacanak");
        gorunum = driver.findElement(By.xpath("//*[text()='Mustafa Bacanak']")).getText();
        Assert.assertEquals("Mustafa Bacanak", gorunum);
        Thread.sleep(1000);

        //    And Eklediği kullanıcı kaydını siler
        driver.findElement(By.xpath("//*[text()='Mustafa Bacanak']")).click();
        Thread.sleep(200);
        driver.findElement(By.xpath("//*[text()='Delete']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".btn")).click();
        Thread.sleep(1000);

        //    Then Kullanıcinin silindiğini doğrular.
        driver.findElement(By.cssSelector("input[type='search']")).clear();
        driver.findElement(By.cssSelector("input[type='search']")).sendKeys("Mustafa Bacanak");
        WebElement result = driver.findElement(By.cssSelector(".dataTables_empty"));
        Assert.assertTrue(result.isDisplayed());

        // Şu da farklı bir bakış açısı olarak burda drsun :)

        //           try {
        //               driver.findElement(By.cssSelector(".sorting_1"));
        //           }
        //           catch (Exception e){
        //                x = null;
        //           }
        //           Assert.assertNull(x);
    }
}

