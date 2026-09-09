package Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;



public class Day3_assnmt3 {
	public static void main(String[] args) throws InterruptedException, IOException {
//		1.Navigate to demowebshop
//		2.Identify the webelement(14.1-inch laptop)-->identify add to cart button capture the size and them click on the buuton.
//		3.Click on shopping cart link.
//		4.verify remove check box is selected or not and capture the complete information using getRect().
//		5.Verify Alert message is displayed or not before and after clicking on Apply coupon button
//		6.Take screenshot of image(Laptop).
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		
		
		WebElement addToCart= driver.findElement(By.xpath("//a[text()='14.1-inch Laptop']/../..//input[@value='Add to cart']"));
		System.out.println(addToCart.getSize()); //Capture the Add to cart size
		addToCart.click();
		
		//Click on shopping cart link
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		
		//verify remove check box is selected or not
		WebElement removeCheckBox= driver.findElement(By.xpath("//input[@type='checkbox' and @name='removefromcart']"));
		System.out.println(removeCheckBox.isSelected()); //Checks wheather checkbox is currently selected
		
		Rectangle rect=removeCheckBox.getRect(); //Capture complete information
		System.out.println(rect.getX());
		System.out.println(rect.getY());
		System.out.println(rect.getWidth());
		System.out.println(rect.getHeight());
		
		//Before clicking apply coupon
		System.out.println("Before Applying coupon"); 
		//Here before clicking coupon,the message doesn't exist in page DOM 
		if(driver.findElements(By.className("message")).size()>0) { //In list of webElements it ntg is found,return empty list instead of 
			//NoSuchElement Exception and size checks how many elements found i.e returns 0 before
			WebElement message=driver.findElement(By.className("message"));
			System.out.println(message.isDisplayed());
		}
		else {
			System.out.println("Alert msg is not displayed");
		}
			
		WebElement coupon=driver.findElement(By.name("applydiscountcouponcode"));
		coupon.click();
		Thread.sleep(2000);	
		
		System.out.println("After Applying coupon"); //Here it generates error msg
		if(driver.findElements(By.className("message")).size()>0) { //Now size vl be 1
			WebElement message=driver.findElement(By.className("message"));
			System.out.println(message.isDisplayed());//checks wheather that ele is actually visible
			System.out.println(message.getText()); //gets actual text displayed on webpage
		}
		else {
			System.out.println("Alert msg is not displayed");
		}
		
		//Return back to main page and take screenshot of that laptop
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(3000);
		WebElement laptopImage = driver.findElement(By.xpath("//img[@alt='Picture of 14.1-inch Laptop']")	);
		System.out.println(laptopImage.getSize());
		File src = laptopImage.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ss/laptop.png");
		FileHandler.copy(src, dest);
		System.out.println("Laptop WebElement screenshot taken successfully");	
	}
}
