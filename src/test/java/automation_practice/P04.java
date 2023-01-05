package automation_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P04 extends TestBase {

    @Test
    public void test01() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String windowsTitle = driver.getTitle();
        Assert.assertEquals("Automation Exercise",windowsTitle);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("i[class='fa fa-lock']")).click();

        //5. Verify 'Login to your account' is visible
        boolean loginText = driver.findElement(By.cssSelector("div[class='login-form']>h2")).isDisplayed();
        Assert.assertTrue(loginText);

        //6. Enter correct email address and password
        WebElement login =driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        login.sendKeys("hacihuseyinbulat@gmail.com",Keys.TAB,"1234");

        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        //8. Verify that 'Logged in as username' is visible
        boolean girisText = driver.findElement(By.xpath(" //*[text()=' Logged in as ']")).isDisplayed();
        Assert.assertTrue(girisText);

        //9. Click 'Logout' button
        driver.findElement(By.partialLinkText("gout")).click();

        //10. Verify that user is navigated to login page
        Assert.assertTrue(loginText);

    }
}
