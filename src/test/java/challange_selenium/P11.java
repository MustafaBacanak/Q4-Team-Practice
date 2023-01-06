package challange_selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.List;

public class P11 extends TestBase {

    @Test
    public void test() {

        //go to https://www.amazon.com.tr/
        driver.get("https://www.amazon.com.tr/");
        findId("sp-cc-accept").click();  //Çerez

        //search iphone13 512
        findId("twotabsearchtextbox").sendKeys("iPhone13 512", Keys.ENTER);

        //check that the results are listed
        List<WebElement> result = driver.findElements(By.xpath("//*[@class='a-size-base-plus a-color-base a-text-normal']"));

        //click iphone13 at the top of the list
        result.get(0).click();

        //Log the following values for each size .Size information .Price .Color .Stock status
        String phoneName = driver.findElement(By.id("productTitle")).getText();
        System.out.print(phoneName+"   ");

        String size = driver.findElement(By.id("inline-twister-expanded-dimension-text-size_name")).getText();
        System.out.println("Size :" + size);

        String color = driver.findElement(By.id("inline-twister-expanded-dimension-text-color_name")).getText();
        System.out.print("Color:"+color+"   ");

        String price = driver.findElement(By.xpath("(//*[@class='a-section slots-padding'])[2]")).getText();
        System.out.println("Price:"+price);

        String stock = driver.findElement(By.xpath("//*[@class='a-size-medium a-color-success']")).getText();
        System.out.println("Stock:"+stock);
    }
}