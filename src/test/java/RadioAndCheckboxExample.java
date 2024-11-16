import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioAndCheckboxExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
//find the default selected radio button
    public void radioTests(){
        driver.get("https://www.leafground.com/radio.xhtml");

        boolean chromeradioOption =  driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxradioOption =  driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariradioOption =  driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeradioOption =  driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if(chromeradioOption){
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("The selected option is : " +chromeText);
        } else if (firefoxradioOption) {
            String fireFoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("The selected option is : " +fireFoxText);

        } else if (safariradioOption) {
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("The selected option is : " + safariText);

        } else if (edgeradioOption) {
            String edgeText = driver.findElement(By.xpath("//label[@for='jj_idt87:console2:3']")).getText();
            System.out.println("The selected option is : " +edgeText);

        }

        //Select the age group (only if selected)

        WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age"));
        boolean isChecked =  myAgeGroup.isSelected();
        if(!isChecked){
            driver.findElement(By.xpath("//label[@for='j_idt87:age:1']")).click();
        }


    }
@Test
    public void checkBoxTest(){

        //select wanted checkboxes and verifying these checkboxes selected  status

        driver.get("https://www.leafground.com/checkbox.xhtml");

        List<WebElement> selectCheckBox =  driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for(WebElement element : selectCheckBox){
            if(!element.getText().equals("Others")){
                element.click();
            }
        }

        for (int i = 1; i < selectCheckBox.size(); i++) {
            boolean checkBoxes = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//label)[ "+ i+ "]")).isSelected();
            System.out.println("CheckBox " + i + "Selected status is " +checkBoxes);
        }
    }

    }
