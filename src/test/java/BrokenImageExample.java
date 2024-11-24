import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class BrokenImageExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    public void findBrokenImageTest(){
        driver.get("https://the-internet.herokuapp.com/broken_images");

        List<WebElement> images = driver.findElements(By.xpath("//div[@class='example']/img"));

        //if natural width = 0 then it is broken image

        int i=1;
        for (WebElement image:images){
            if (image.getAttribute("naturalWidth").equals("0")){
                System.out.println("Image " +i +"is broken");
            }else{
                System.out.println("Image " +i +"is not broken");
            }

            i++;
        }



    }
}
