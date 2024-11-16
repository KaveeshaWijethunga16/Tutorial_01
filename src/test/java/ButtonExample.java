import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage(){

        driver = new ChromeDriver();
        //manage size of the widow

        //method 01
        //driver.manage().window().maximize();

        //method 02
        Dimension newSize = new Dimension(800,600);
        driver.manage().window().setSize(newSize);
        driver.get("https://www.leafground.com/button.xhtml");

    }

    @Test
    public void buttonTests(){

        //click and confirm title
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        //method 02
//        if (expectedTitle.equals(actualTitle)){
//            System.out.println("Actual Tile same as expected");
//        }else{
//            System.out.println("Actual title same as expected");
//        }
        //method - 02
        Assert.assertEquals(actualTitle, expectedTitle,"Title miss matched");

        driver.navigate().back();

        //Find the position of the submit button

        WebElement position = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = position.getLocation();
        int x = xyPoint.getX();
        int y =xyPoint.getY();
        System.out.println("X position is : " +x + "Y position is " +y);

        //Find the save button color

        WebElement btnColor = driver.findElement(By.id("j_idt88:j_idt96"));
        String color =  btnColor.getCssValue("background-color");
        System.out.println("Button color : " +color);

        //Find the height and width of this button
        WebElement btnSize = driver.findElement(By.id("j_idt88:j_idt98"));
        int btnHeight = btnSize.getSize().getHeight();
        int btnWidth =  btnSize.getSize().getHeight();
        System.out.println("Button height :" + btnHeight + "Button width :" +btnWidth);


    }



}
