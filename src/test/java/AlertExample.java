import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");

    }
    @Test
    public void AlertTest() throws InterruptedException {
        //Alert (Simple Dialog)

        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        //accept an alert
        alert.accept();

        //Alert (Confirm Dialog)

        WebElement alertConfirm = driver.findElement(By.id("j_idt88:j_idt93"));
        alertConfirm.click();
        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(3000);
        //cancel an alert
        alert2.dismiss();

        //Alert (prompt Dialog)
        WebElement alertPrompt = driver.findElement(By.id("j_idt88:j_idt104"));
        alertPrompt.click();
        Alert alert3 = driver.switchTo().alert();
        Thread.sleep(3000);
        String alertText = alert3.getText();
        System.out.println("Alert text is : " +alertText);
        alert3.sendKeys("My name is kaveesha");
        alert3.accept();


    }
}
