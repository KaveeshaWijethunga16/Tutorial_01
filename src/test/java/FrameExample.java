import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml;jsessionid=node07znb10tb7ono1c9l6c6wpsx2d7742870.node0");

    }
@Test
    public void frameTest(){
        //click me (Inside Frame)

        driver.switchTo().frame(0);

        WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();

       String afterClickButton = button1.getText();
        System.out.println("After clicking on the button displayed text" +afterClickButton);

    //Click Me (Inside Nested frame)

        driver.switchTo().defaultContent();//main frame
        driver.switchTo().frame(2);
        driver.switchTo().frame("frame2");

        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();

        //How many frame in this page

        driver.switchTo().defaultContent();

        List<WebElement> noOfFrames =  driver.findElements(By.tagName("iframe"));
        int count = noOfFrames.size();
        System.out.println("No of frames in the page " + count);

        for (WebElement iframeElement:noOfFrames){
            String frameSRCAttributeVzlue = iframeElement.getAttribute("SRC");
            System.out.println("Attribute name of iframe : " + frameSRCAttributeVzlue);
        }






    }
}