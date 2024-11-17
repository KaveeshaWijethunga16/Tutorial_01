import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml;jsessionid=node01x6lku7flm8om1lf0rh7e0pg947730280.node0");

    }
@Test
    //click and confirm on new window opens
    public void windowTest() throws InterruptedException {

        String oldWindow =  driver.getWindowHandle();
        System.out.println("Parent window : " +oldWindow);

        WebElement openBtn = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        openBtn.click();
        Thread.sleep(3000);

        Set<String> handles = driver.getWindowHandles();
        System.out.println("handel size " + handles.size());

   // 01 method using for loop

    for(String newWindow:handles){
        System.out.println(newWindow);
        driver.switchTo().window(newWindow);
        System.out.println("Page tile is : " +driver.getTitle());
    }

    //02 method using List
//    List<String>  list= new ArrayList<String>(handles);
//    if(list.size() >1){
//        driver.switchTo().window(list.get(1));
//        System.out.println("Child tab title is : " + driver.getPageSource());
//        driver.close();
//        driver.switchTo().window(oldWindow);
//    }
    driver.close();
    driver.switchTo().window(oldWindow);


    WebElement openBtn1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
    boolean openButtonVisibility = openBtn1.isDisplayed();
    System.out.println("Open button visibility" + openButtonVisibility);

    //02 Find the number of opened tabs

    WebElement multiWindowbtn  = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']/span"));
    multiWindowbtn.click();
    Thread.sleep(3000);

    Set<String>  multiWindows = driver.getWindowHandles();
    int NoOfWindows =multiWindows.size();
    System.out.println("No of windows " +NoOfWindows);


    //03 close all windows expect primary

    WebElement closeWindowbtn= driver.findElement(By.id("j_idt88:j_idt93"));
    closeWindowbtn.click();
    Thread.sleep(3000);

    Set<String>  multiWindowsHandle = driver.getWindowHandles();
    for(String allWindows:multiWindowsHandle){
        if(!allWindows.equals(oldWindow)){
            driver.switchTo().window(allWindows);
            driver.close();
        }

    }
//
//    driver.quit(); ---> close all multiWindows
//    driver.close(); --->  close single browser which on focus
}


}
