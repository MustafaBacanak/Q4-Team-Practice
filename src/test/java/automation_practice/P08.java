package automation_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P08 extends TestBase {

    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement page = findXPath("/html/body"); // ilkini alir
        Assert.assertTrue(page.isDisplayed());

        //4. Click on 'Products' button
        findXPath("//*[@class='material-icons card_travel']").click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(findXPath("//h2[@class='title text-center']").isDisplayed());

        //6. The products list is visible  // urun listesi gorunur
        Assert.assertTrue(findXPath("//*[@class='title text-center']").isDisplayed());


        //7. Click on 'View Product' of first product (İlk ürünün 'Ürünü Görüntüle'ye tıklayın)
        driver.navigate().refresh();
        findXPath("//*[text()='View Product']").click();//View Productu text ile çektim 34 sonuc verdi index eklemedim.
                                                             //cunku ilk elemanı vereck 34 eleman bulması onemli dğil


        //8. User is landed to product detail page // Kullanıcı, ürün detay sayfasına ulaştı
        Assert.assertEquals("https://automationexercise.com/product_details/1",driver.getCurrentUrl());
        Assert.assertTrue(findCss("a[href='#reviews']").isDisplayed());

        //9. Verify that detail is visible: product name, category, price, availability, condition, brand
        boolean one = findXPath("//*[.='Blue Top']").isDisplayed();
        boolean two = findXPath("//*[.='Category: Women > Tops']").isDisplayed();
        boolean three = findXPath("//*[.='Rs. 500']").isDisplayed();
        boolean four = findXPath("//*[text()=' In Stock']").isDisplayed();
        boolean five = findXPath("//*[text()=' New']").isDisplayed();
        boolean six= findXPath("//*[text()=' Polo']").isDisplayed();

        Assert.assertTrue(one && two && three && four && five && six);




    }


}

