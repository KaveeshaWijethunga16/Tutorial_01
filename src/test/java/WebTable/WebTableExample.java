package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

    }
    @Test
    public void WebTableTest1() throws InterruptedException {

        // How many rows in the table
        int rowCount = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("Total count of rows : " +rowCount);

        //how many columns in the table
        int columnCount = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("Total count of rows : " +columnCount);

        //Retrieve all the data from table
        for(int i=1 ; i<=rowCount ; i++){
            for (int j=1 ; j<= columnCount ; j++){
               String tblData =  driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.println(tblData + " ");

            }
            System.out.println();
        }

        //print ID and Name only

        for (int i = 1; i <= rowCount; i++) {
            String tblID = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[1]")).getText();
            String tblProductName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[2]")).getText();
            System.out.println("Table ID : " + tblID + "\t\t" + "Product Name : " + tblProductName);


            if (tblProductName.equals("Tablet")) {
                String productPrice = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[3]")).getText();
                System.out.println("Product 3 price is : " + productPrice);
                break;

            }
        }

            //select all the checkBoxes

            int pageCount = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
            List<WebElement> pages =  driver.findElements(By.xpath("//ul[@id='pagination']/li"));

            for (int k = 0; k < pageCount; k++) {
                pages.get(k).click();
                Thread.sleep(200);

                for (int l = 1; l <=rowCount ; l++) {

                    boolean check = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+l+"]/td[4]/input")).isSelected();
                    if(!check){
                        driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+l+"]/td[4]/input")).click();
                        Thread.sleep(300);
                    }



                }

            }


            //select one checkbox

        int tblRow = 1;
        driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+tblRow+"]/td[4]/input")).click();
















    }
}
