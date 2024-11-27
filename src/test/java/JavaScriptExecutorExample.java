import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorExample {

    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeMethod
    public void OpenLinkTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void jsExecutorTest() throws InterruptedException {
        jsExecutor = (JavascriptExecutor) driver;

        // Set a value in a text box using JavaScriptExecutor
        WebElement inputNameTextBox = driver.findElement(By.xpath("//input[@id='name']"));
        jsExecutor.executeScript("arguments[0].setAttribute('value','Kaveesha')", inputNameTextBox);

        Thread.sleep(2000);

        // Highlight Element
        jsExecutor.executeScript("arguments[0].style.border = '3px solid red';", inputNameTextBox);
        jsExecutor.executeScript("arguments[0].style.background = 'yellow';", inputNameTextBox);
        Thread.sleep(2000);

        // Click an element using JavaScript
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='female']"));
        jsExecutor.executeScript("arguments[0].click();", checkbox);

        Thread.sleep(2000);

        // Scroll the page
        scrollPage();

        // Get all attributes from an element
        getAllAttributes(inputNameTextBox);

        // Reload the page
        jsExecutor.executeScript("location.reload()");
    }

    public void scrollPage() throws InterruptedException {
        // Scroll to a specific position
        jsExecutor.executeScript("window.scrollTo(0, 1000);");
        System.out.println("Current pageYOffset value is: " + jsExecutor.executeScript("return window.pageYOffset"));
        jsExecutor.executeScript("window.scrollTo(0, -1000);");

        Thread.sleep(2000);

        // Scroll to the bottom of the page
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Scroll to the top of the page
        jsExecutor.executeScript("window.scrollTo(0, 0);");

        // Scroll the page until the element is visible
        WebElement scrollElement = driver.findElement(By.xpath("//label[text()='Gender:']"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", scrollElement);
    }

    public String getAllAttributes(WebElement webElement) {
        Object elementAttributes = jsExecutor.executeScript(
                "var items = {}; " +
                        "for (var i = 0; i < arguments[0].attributes.length; i++) { " +
                        "items[arguments[0].attributes[i].name] = arguments[0].attributes[i].value; " +
                        "} return items;", webElement);
        System.out.println("All attribute values are: " + elementAttributes.toString());
        return elementAttributes.toString();
    }
}
