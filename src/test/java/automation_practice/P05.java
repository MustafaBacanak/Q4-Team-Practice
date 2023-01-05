package automation_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class P05 extends TestBase {

    @Test
    public void test01() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertEquals("Automation Exercise",driver.getTitle());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("i[class='fa fa-lock']")).click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='signup-form']>h2")).isDisplayed());

        //6. Enter name and already registered email address
        findXPath("//input[@type='text']").sendKeys("hüseyin", Keys.TAB,"hacihuseyinbulat@gmail.com");

        //7. Click 'Signup' button
        findCss("button[data-qa='signup-button']").click();

        //8. Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Email Address already exist!']")).isDisplayed());

    }
}
