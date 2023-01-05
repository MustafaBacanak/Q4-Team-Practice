package canhoca_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P02 extends TestBase {

    @Test
    public void test01() {

        driver.get("https://www.amazon.com/");

        clickWithText("a[class='nav-a  ']","Customer Service");



    }
}
