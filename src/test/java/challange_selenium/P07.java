package challange_selenium;

    //1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
    //2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
    //3-Option3 ü seçin.
    //4-Option3 ün seçili olduğunu doğrulayın.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class P07 {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void test01() {
//      1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//      2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
        WebElement gorunum = driver.findElement(By.cssSelector("div[class='cen-right-align'] fieldset legend"));
        Assert.assertTrue(gorunum.isDisplayed());
//        3-Option3 ü seçin.
        WebElement opt3 = driver.findElement(By.cssSelector("#dropdown-class-example"));
        Select select = new Select(opt3);
        select.selectByVisibleText("Option3");
//        4-Option3 ün seçili olduğunu doğrulayın.
        String result  = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Option3",result);
    }
    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
