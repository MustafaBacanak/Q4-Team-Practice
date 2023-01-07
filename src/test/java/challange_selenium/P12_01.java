package challange_selenium;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P12_01 extends TestBase {

    @Test
    public void test01() {
        Actions actions =new Actions(driver);

        //  #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        //  #Fill in capitals by country

        WebElement oslo = findId("box1");
        WebElement norway = findId("box101");

        WebElement stockholm = findId("box2");
        WebElement sweden = findId("box102");

        WebElement washington = findId("box3");
        WebElement unitedStates = findId("box103");

        WebElement copenhagen = findId("box4");
        WebElement denmark = findId("box104");

        WebElement seoul = findId("box5");
        WebElement southKorea = findId("box105");

        WebElement rome = findId("box6");
        WebElement italy = findId("box106");

        WebElement madrid = findId("box7");
        WebElement spain = findId("box107");

        actions
                .dragAndDrop(oslo,norway)
                .dragAndDrop(stockholm,sweden)
                .dragAndDrop(washington,unitedStates)
                .dragAndDrop(copenhagen,denmark)
                .dragAndDrop(seoul,southKorea)
                .dragAndDrop(rome,italy)
                .dragAndDrop(madrid,spain).release().build().perform();

    }
}