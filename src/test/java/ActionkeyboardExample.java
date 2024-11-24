import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionkeyboardExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void TestOperation1() throws InterruptedException {

        driver.get("https://www.google.com/");

        WebElement googleSearchBox =  driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("Welcome");

        Actions actions =new Actions(driver);

        //select the text box
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        Thread.sleep(5000);

        actions.keyDown(Keys.SHIFT)
                .sendKeys("writing capital sentence").perform();


        Thread.sleep(5000);

        actions.keyUp(Keys.SHIFT)
                .sendKeys("writing capital sentences");
        Thread.sleep(5000);

        actions.keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL)
                .sendKeys("x")
                .build().perform();

        //to write in capital in a text box

//        actions.keyDown(googleSearchBox, Keys.SHIFT)
//                .sendKeys("learn with hashi")
//                .perform();

            }

            //select all elements using control
    @Test
    public  void KeyBoardActionTest2() throws InterruptedException {

        driver.get("https://www.leafground.com/list.xhtml");
        Thread.sleep(3000);

        List<WebElement> selectable = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = selectable.size();

        System.out.println("Li count is : " +size);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(selectable.get(0))
                .click(selectable.get(1))
                .click(selectable.get(2))
                .perform();

    }

}


