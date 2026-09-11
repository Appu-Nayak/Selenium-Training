package Assignments.Day4;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class FacebookTask {
    public static void main(String[] args) {
        //	Facebook Task
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com/");
		List<WebElement> textField = driver.findElements(By.tagName("input")); //Stores all the input tags
		System.out.println(textField.size());
		for(WebElement ele:textField) {
			if(ele.getAttribute("id").equals("_R_1hmkqsqppb6amH1_")) { //compare the id passing in getAttribute
				ele.sendKeys("appu123"); //send the password
				break;
			}
		}
    }
}
