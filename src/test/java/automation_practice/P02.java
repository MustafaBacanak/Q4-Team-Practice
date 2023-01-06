package automation_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class P02 extends TestBase {
    @Test
    public void test01() {


        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // //3. Verify that home page is visible successfully
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://automationexercise.com/";
        Assert.assertEquals(expectedURL, actualURL);

        // //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        // //5. Verify 'Login to your account' is visible
        assert driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed();

        // //6. Enter correct email address and password
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).
                sendKeys("bacanak117@gmail.com", Keys.TAB, "12345");

        //7. Click 'login' button
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

        //8. Verify that 'Logged in as username' is visible
        assert driver.findElement(By.xpath("//*[text()='bacanak']")).isDisplayed();

        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();

        //10. Verify that 'ACCOUNT DELETED!' is visible
        assert driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed();

    }
}