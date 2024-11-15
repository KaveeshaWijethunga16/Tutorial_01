import com.sun.jdi.ByteValue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage(){

        ChromeOptions chromeOptions = new ChromeOptions();
 chromeOptions.setBrowserVersion("130");
      //chromeOptions.addArguments("--start-maximized");
   // chromeOptions.addArguments("--incognito");
//        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        //manage size of the widow
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml;jsessionid=node0en5kli6m3b4o2u5yxy4i0swf7725597.node0");

    }
    @Test
   public void textBoxTest(){

       //Type Your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Kaveesha Wijethunga");

        //Append country to this city.
       WebElement country = driver.findElement(By.id("j_idt88:j_idt91"));
       country.sendKeys("India");

       //Verify if text box is disabled
       boolean enabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
       System.out.println("Is the text box enabled" + enabled);

       //clear the typed text
       //*[@id="j_idt88:j_idt95"]
      WebElement clearText =  driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
      clearText.clear();

      //Retrieve the typed text
      WebElement retrieveText = driver.findElement(By.id("j_idt88:j_idt97"));
      String value = retrieveText.getAttribute("value");

      //Type email and Tab. Confirm control moved to next element.
       WebElement confirm = driver.findElement(By.id("j_idt88:j_idt99"));
       confirm.sendKeys("kaveesha@paymedia.lk" + Keys.TAB + "Confirm control moved to next element");


   }
}
