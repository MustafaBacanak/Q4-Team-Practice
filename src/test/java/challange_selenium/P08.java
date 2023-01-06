package challange_selenium;

    //    go to url :http://demo.automationtesting.in/Alerts.html
    //    click  "Alert with OK" and click 'click the button to display an alert box:'
    //    "Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
    //    accept Alert(I am an alert box!) and print alert on console
    //    Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
    //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    //    "Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
    //    cancel Alert  (Press a Button !)
    //    Alert'ü kapatın
    //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    //    "Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
    //    and then sendKeys 'TechProEducation' (Please enter your name)
    //    Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
    //    Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
    //    finally print on console this mesaaje "Hello TechproEducation How are you today"

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class P08 {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://demo.automationtesting.in/Alerts.html");
    }
    @After
    public void tearDown() {
        driver.close();
    }
    @Test
    public void iframeTest(){
        driver.findElement(By.xpath("(//button[@onclick='alertbox()'])")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//*[text()='Alert with OK & Cancel ']")).click();
        driver.findElement(By.xpath("(//button[@onclick='confirmbox()'])")).click();
        driver.switchTo().alert().dismiss();
        driver.findElement(By.xpath("(//*[text()='Alert with Textbox '])")).click();
        driver.findElement(By.xpath("(//button[@onclick='promptbox()'])")).click();
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();
        String actualText = driver.findElement(By.id("demo1")).getText();
        Assert.assertTrue("text aynı değil", actualText.contains("TechProEducation"));
    }
}
