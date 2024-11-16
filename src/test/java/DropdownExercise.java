import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownExercise {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage(){

        driver = new ChromeDriver();
        //manage size of the widow

        //method 01
        driver.manage().window().maximize();

//        //method 02
//        Dimension newSize = new Dimension(800,600);
//        driver.manage().window().setSize(newSize);


    }

    @Test
    public void leafgroundpageDropDownTest() throws InterruptedException{

        driver.get("https://www.leafground.com/select.xhtml");


        //1.1)Ways of select values in basic dropdown
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdown);
        //select from index array [0,1,2..]
        select.selectByIndex(1);
        Thread.sleep(3000);
        //select from text
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);
        //select from value
        //select.selectByValue();

        //1.2)Get the number of drop down options
        List<WebElement> listNoOfOptions = select.getOptions();
        int size = listNoOfOptions.size();
        System.out.println("Number of dropdown options : " +size);

        for (WebElement element:listNoOfOptions){
            System.out.println(element.getText());
        }

        //1.3)Using sendkeys select the dropdown value

        dropdown.sendKeys("Puppeteer");
        Thread.sleep(3000);

        //1.4)Selecting value in a bootstrap dropdown(no select options using ul-li)
        WebElement DropDown2  =driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        DropDown2.click();

        List<WebElement> listOfDropDown2 =driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));

        for (WebElement element :listOfDropDown2){
            String dropDownValue2 = element.getText();
            if (dropDownValue2.equals("USA")){
                element.click();
                break;
            }

        }




    }
@Test
// google search - pick a value from suggestions
    public void googlesearchDropDown() throws InterruptedException{

        driver.get("https://www.google.co.uk/");
        driver.findElement(By.name("q")).sendKeys("Hanna");
        Thread.sleep(2000);

    List<WebElement> googleDropDown =driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='pcTkSc']"));
        for (WebElement element :googleDropDown){
            System.out.println(element.getText());
        }






    }
}
