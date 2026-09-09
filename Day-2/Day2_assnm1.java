package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Day2_assnm1 {
	public static void main(String[] args) {
		//Testcase 1
//		1.Navigate to the facebook application.
//		2.Click on create new account button.
//		3.Verify that fistname and surname textfields are aligned in same line or not.
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//span[text()='Create new account']")).click();
		
		WebElement firstName=driver.findElement(By.id("_R_1cl2p4jikacppb6amH1_"));
		WebElement surname=driver.findElement(By.id("_R_1kl2p4jikacppb6amH1_"));
		int firstLoc=firstName.getLocation().getY(); //both share same height from top of page
		int surnameLoc=surname.getLocation().getY(); //getY() gives equal
		if(firstLoc==surnameLoc)
			System.out.println("Both ar are aligned in same line");
		else
			System.out.println("Not");
		
		
	}
}
