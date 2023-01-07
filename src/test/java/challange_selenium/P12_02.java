package challange_selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P12_02 extends TestBase {

    @Test
    public void test01() {
        Actions actions =new Actions(driver);

        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hoverOver = findXPath("//*[.='Hover Over Me First!']");
        actions.moveToElement(hoverOver).perform();

        //3. "Link 1" e tiklayin
        findCss("div[class='dropdown hover'] a[class='list-alert']").click();

        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHoldBox = findId("click-box");
        actions.clickAndHold(clickAndHoldBox).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldBox.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement colorChange=findId("double-click");

        String ilkRenk=colorChange.getAttribute("class");
        actions.doubleClick(colorChange).perform();
        String ikinciRenk=colorChange.getAttribute("class");

        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        Assert.assertNotEquals(ilkRenk,ikinciRenk);

    }
}
