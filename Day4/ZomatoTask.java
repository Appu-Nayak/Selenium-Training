package Assignments.Day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ZomatoTask {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.zomato.com/bangalore/delivery");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();//Click on log in
		WebElement frame1=driver.findElement(By.id("auth-login-ui"));
		driver.switchTo().frame(frame1); //switch to that login frame
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("9611340576"); //Pass mobile no
		driver.switchTo().defaultContent();
		String text=driver.findElement(By.xpath("//div[text()='Dining Out']")).getText();
		if(text.equals("Dining Out"))
			System.out.println("MAin page");
		else
			System.out.println("Not");
    }
}
