import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample{

    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage(){

        driver = new ChromeDriver();
        //manage size of the widow
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/dashboard.xhtml");

    }

@Test
    public void linkTest(){
        //Take me to dashboard
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        //Find my destination
        WebElement whereToGo = driver.findElement(By.partialLinkText("Find the URL"));
        String path = whereToGo.getAttribute("href");
        System.out.println("This link is going to : " + path);



       //I am I broken link
    WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
    brokenLink.click();
    String title = driver.getTitle();

    if (title.contains("404")){
        System.out.println("The link is broken");
    }else{
        System.out.println("Not Borken");

    }
    driver.navigate().back();

    //Duplicate link

    WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
    homeLink1.click();
    driver.navigate().back();

    //Count Page Link

    List<WebElement> LinkCount = driver.findElements(By.tagName("a"));
    int pageLinkCount=LinkCount.size();
    System.out.println("No of link counts on the page : " + pageLinkCount);


    //Count layout links
    WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
    List<WebElement>  CountOfLayoutElements = driver.findElements(By.tagName("a"));
    System.out.println("Number pof Layout Elements : " +CountOfLayoutElements.size() );


    }
}
