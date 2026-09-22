package Assessments.LastAssnmtTask1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task4 {
    public static void main(String[] args) throws InterruptedException {
//        1.Navigate to ShopperStack application 2.Click on any product
//        3.And Check the product is available to that pincode or not.

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.shoppersstack.com/");
        driver.findElement(By.xpath("//span[text()='sonata wrist watch with blue dial']")).click();
        driver.findElement(By.id("Check Delivery")).sendKeys("583121");
        WebElement ref = driver.findElement(By.id("Check"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));//Explicit Wait
        wait.until(ExpectedConditions.elementToBeClickable(ref));
        ref.click();
        String text = driver.findElement(By.id("Check Delivery-helper-text")).getText();
        System.out.println(text);
//        Output: Not Deliveriable. Check deliverable pins.
    }
}
