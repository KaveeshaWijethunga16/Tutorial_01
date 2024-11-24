import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionMouseOperation {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

@Test
    public void mouseOperationTest(){

        driver.get("https://www.leafground.com/drag.xhtml;jsessionid=node01de3i803lreutbblwe0pke2577788661.node0");

        System.out.println("1)<<<<<<<move to an element opertaion>>>>>>>>>");

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("menuform:j_idt37")))
        .moveToElement(driver.findElement(By.id("menuform:j_idt38")))
        .moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();

    System.out.println("1)<<<<<<<Drag and drop Operations>>>>>>>>>");
    WebElement from = driver.findElement(By.id("form:drag"));
    WebElement to = driver.findElement(By.id("form:drop_content"));

    //action.clickAndHold(from).moveToElement(to).release(to).perform();//1st method
    action.dragAndDrop(from,to).perform();//2nd method

    System.out.println("1)<<<<<<<Slider Operations>>>>>>>>>");

    WebElement slidepointer1 = driver.findElement(By.xpath("//div[@id='form:j_idt125']/span[1]"));
    System.out.println("Location of the slider point 1 :" + slidepointer1.getLocation());
    action.dragAndDropBy(slidepointer1,50,0).perform();
    System.out.println("Location of sliderpointer 1 after moving :" +slidepointer1.getLocation());


    }
@Test
    public void mouseOperationsTest2(){

        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        System.out.println("40 <<<<<<<<<<Right click>>>>>>>>>>>>>>>>");

        Actions actions1 = new Actions(driver);

        WebElement rightclickbutton =driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        actions1.contextClick(rightclickbutton).perform();
        driver.findElement(By.xpath("//span[text()='Edit']")).click();
        Alert alertPop =driver.switchTo().alert();
        System.out.println("Alert shows the  text as : " +alertPop);
        alertPop.accept();

    }


    }
