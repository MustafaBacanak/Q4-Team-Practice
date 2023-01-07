package challange_selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class deneme extends TestBase {
    @Test
    public void name() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//body")).isDisplayed());

        //4. Click on 'Products' button
        driver.findElement(By.cssSelector("*[class='material-icons card_travel']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement productsPage= driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(productsPage.isDisplayed());

        //6. The products list is visible
        Assert.assertTrue(driver.findElement(By.cssSelector("*[class='features_items']")).isDisplayed());

        //7. Click on 'View Product' of first product
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@href='/product_details/1']")).click();

        //8. User is landed to product detail page
        Assert.assertTrue(driver.findElement(By.cssSelector("*[class='product-information']")).isDisplayed());

        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
    }
}
