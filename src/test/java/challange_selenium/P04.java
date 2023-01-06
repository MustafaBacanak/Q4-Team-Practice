package challange_selenium;

//1. "https://www.saucedemo.com" Adresine gidin
//2. Username kutusuna "standard_user" yazdirin
//3. Password kutusuna "secret_sauce" yazdirin
//4. Login tusuna basin
//5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
//6. Add to Cart butonuna basin
//7. Alisveris sepetine tiklayin
//8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
//9. Sayfayi kapatin

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04 {

    static String ilkUrunIsim;
    static String sepettekiUrun;
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

//2. Username kutusuna "standard_user" yazdirin
        findWithId("user-name").sendKeys("standard_user");
        Thread.sleep(1000);

//3. Password kutusuna "secret_sauce" yazdirin
        findWithId("password").sendKeys("secret_sauce");
        Thread.sleep(1000);

//4. Login tusuna basin
        findWithId("login-button").click();
        Thread.sleep(1000);

//5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement webElement= findWithCssSelector("a#item_4_title_link>div.inventory_item_name");
        ilkUrunIsim =webElement.getText();
        System.out.println("Kaydedilen ürün İsmi = " + ilkUrunIsim);
        webElement.click();
        Thread.sleep(1000);

//6. Add to Cart butonuna basin
        findWithId("add-to-cart-sauce-labs-backpack").click();
        Thread.sleep(1000);

//7. Alisveris sepetine tiklayin
        findWithCssSelector(".shopping_cart_link").click();
        Thread.sleep(1000);


//8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        sepettekiUrun= findWithCssSelector(".inventory_item_name").getText();
        System.out.println("Sepetteki ürün ismi = "+sepettekiUrun);

        if (ilkUrunIsim.equals(sepettekiUrun)){
            System.out.println("Ürün sepete başarılı bir şekilde eklendi");
        }else
            System.out.println("Ürün sepete eklenemedi");

//9. Sayfayi kapatin
        driver.close();
    }

    public static WebElement findWithId(String key) {
        return driver.findElement(By.id(key));
    }
    public static WebElement findWithCssSelector(String key){
        return driver.findElement(By.cssSelector(key));
    }
}


