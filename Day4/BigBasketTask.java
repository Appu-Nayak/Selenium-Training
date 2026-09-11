package Assignments.Day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class BigBasketTask {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.bigbasket.com/?nc=logo");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("yogurt"); //[2] bcz to get 1 out of 1
        Thread.sleep(3000);
        WebElement add = driver.findElement(By.xpath("//button[text()='Add']")); //add 1st ele to cart
        add.click();
        Thread.sleep(2000);
        WebElement add1 = driver.findElement(By.xpath("(//button[text()='Add'])[5]"));//add 5th ele to cart
        add1.click();
        Thread.sleep(2000);
        WebElement cart = driver.findElement(By.cssSelector("[class='mx-4 flex-1']"));
        if(cart.getText().contains("An item has been added to your basket successfully"))
        {
            System.out.println("An item is added to cart");
        }
        else
        {
            System.out.println("An item is not added to cart");
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
