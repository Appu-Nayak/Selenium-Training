package Assignments;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Day3_assnmt2 {
	public static void main(String[] args) {
//		1.NAvigate to demo appa qspiders date picker---  (https://demoapps.qspiders.com/ui/datePick?sublist=0)
//		2.Click on calender.
//		3. Navigate to the next month in the current year.
//		4. Select any valid date from that month.
//		5. Verify that the selected date is displayed correctly in the date field.
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
		driver.findElement(By.cssSelector("[type='text']")).click();
		driver.findElement(By.cssSelector("[type='button']")).click();
		driver.findElement(By.cssSelector("[role='option']")).click();
		WebElement result=  driver.findElement(By.cssSelector("[type='text']"));
		result.getDomAttribute("value");
		if(result.getDomAttribute("value").contains("26/07/2026")) {
			System.out.println("Date is displayed Correctly");
			
		}else {
			System.out.println("Date is not displayed Correctly");
		}

	}

}
