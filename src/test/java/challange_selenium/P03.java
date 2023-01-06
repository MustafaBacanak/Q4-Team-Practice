package challange_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {

//1. http://zero.webappsecurity.com sayfasina gidin
//2. Signin buttonuna tiklayin
//3. Login alanine  "username" yazdirin
//4. Password alanine "password" yazdirin
//5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
//6. Online Banking menusunden Pay Bills sayfasina gidin
//7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
//8. tarih kismina "2020-09-10" yazdirin
//9. Pay buttonuna tiklayin
//10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("button[id='signin_button']")).click();

        //3. Login alanine  "username" yazdirin
        driver.findElement(By.cssSelector("input[id='user_login']")).sendKeys("username");
        Thread.sleep(2000);

        //4. Password alanine "password" yazdirin
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("password");
        Thread.sleep(2000);

        //5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(1000);
        driver.navigate().back();

        //6. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("li#onlineBankingMenu")).click();
        driver.findElement(By.cssSelector("span#pay_bills_link")).click();
        Thread.sleep(2000);

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.cssSelector("input[id='sp_amount']")).sendKeys("250");
        Thread.sleep(2000);

        //8. tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.cssSelector("input[id='sp_date']")).sendKeys("2020-09-10");
        Thread.sleep(2000);

        //9. Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
        Thread.sleep(2000);

        //10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin
        WebElement message =driver.findElement(By.cssSelector("span[title='$ 250 payed to payee sprint']"));

        if (message.getText().equals("The payment was successfully submitted.")){
            System.out.println("Congratulations !! Test Passed :) ");
        }else
            System.out.println("Sorry... Test Failed");

        driver.close();

    }
}
