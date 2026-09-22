package Assessments.LastAssnmtTask1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
//        1.Navigatesto demoAppsQspiders slidder page
//        2.slide the bar till men cotton jacket and verify.

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
        WebElement ele=driver.findElement(By.id("slide"));
        Actions act=new Actions(driver);
        act.clickAndHold(ele).moveByOffset(200,0).release().perform();//Here use clickAndHold with moveByOffset,release to move the slider
        //And Here 200 is pixel value not any attribute value i.e move 200px horizontally(x axis0
        Thread.sleep(2000);
        WebElement jacket=driver.findElement(By.xpath("//h3[contains(text(),'Mens Cotton Jacket')]"));
        System.out.println("Product: "+jacket.getText());
        driver.quit();
    }
}
