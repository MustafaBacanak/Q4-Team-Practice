
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;


public class P03 extends TestBase {
    @Test
    public void Test01() {


        //1. Launch browser
        //2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");

        //3. Verify that home page is visible successfully
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        Assert.assertEquals("https://automationexercise.com/", actualURL);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        //5. Verify 'Login to your account' is visible
        assert driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed();
        //6. Enter incorrect email address and password
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).
                sendKeys("merhaba@hotmail.com", Keys.TAB, "12345");
        //7. Click 'login' button
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        //8. Verify error 'Your email or password is incorrect!' is visible
        assert driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).isDisplayed();
    }
}