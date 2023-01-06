package challange_selenium;

// https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
// maximize the web site
// ikinci emojiye tıklayın
// ikinci emoji altındaki tüm öğelere tıklayın
// ana iframe'e geri dön
// formu doldurun,(Formu istediğiniz metinlerle doldurun)
// uygula butonuna tıklayın


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.List;
public class P09 extends TestBase {
    @Test
    public void test01(){
        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        //maximize the web site

        // ikinci emojiye tıklayın
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("*[href='#nature']")).click();

        // ikinci emoji altındaki tüm öğelere tıklayın
        List<WebElement> emojies = driver.findElements(By.xpath("//*[@id='nature']/div/img"));
        emojies.forEach(WebElement::click);

        // ana iframe'e geri dön
        driver.switchTo().defaultContent();

        //formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> textBoxes = driver.findElements(By.cssSelector("*[class='mdl-textfield__input']"));
        textBoxes.stream().skip(0).limit(11).forEach(t->t.sendKeys(RandomStringUtils.random(10, true, true)));

        // uygula butonuna tıklayın
        driver.findElement(By.id("send")).click();
    }
}
