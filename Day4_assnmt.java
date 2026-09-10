package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day4_assnmt {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		//Facebook Task
//		driver.get("https://www.facebook.com/");
//		List<WebElement> textField = driver.findElements(By.tagName("input"));
//		System.out.println(textField.size()); 
//		for(WebElement ele:textField) {
//			if(ele.getAttribute("id").equals("_R_1hmkqsqppb6amH1_")) { //compare the id passing in getAttribute
//				ele.sendKeys("appu123"); //send the password
//				break;
//			}
//		}
		
		//Zomato Task
//		driver.get("https://www.zomato.com/bangalore/delivery");
//		driver.findElement(By.xpath("//button[text()='Log in']")).click();//Click on log in
//		WebElement frame1=driver.findElement(By.id("auth-login-ui"));
//		driver.switchTo().frame(frame1); //switch to that login frame
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("9611340576"); //Pass mobile no
//		driver.switchTo().defaultContent();
//		String text=driver.findElement(By.xpath("//div[text()='Dining Out']")).getText();
//		if(text.equals("Dining Out"))
//			System.out.println("MAin page");
//		else
//			System.out.println("Not");
		
		
		//Big Basket
		driver.get("https://www.bigbasket.com/?nc=logo");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("yogurt"); //[2] bcz to get 1 out of 1
		Thread.sleep(4000);
		WebElement add = driver.findElement(By.xpath("//button[text()='Add']")); //add 1st ele to cart
		add.click();
		Thread.sleep(5000);
		WebElement add1 = driver.findElement(By.xpath("(//button[text()='Add'])[5]"));//add 5th ele to cart
		add1.click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//span[@class='sc-fUnMCh cDZjuK']")).getText(); 
		if(!text.equals(""))
		{
			System.out.println("added to cart");
			System.out.println(text+" products are added to cart");
		}
		else
		{
			System.out.println("not added to cart");
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
