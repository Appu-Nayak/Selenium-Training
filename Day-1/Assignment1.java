package HandlinWebElements;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

public class Assignment1 {
	public static void main(String[] args) throws IOException {
//		1.Launch SauceDemo. 
//		2.Login using the valid credentials provided on the application. 
//		3.On the Products page, use JavaScript Executor to scroll to the bottom of the page. 
//		4. Take a screenshot of the page after scrolling. 
//		5.Save the screenshot with a meaningful name such as products-page.png.
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		WebElement name=driver.findElement(By.id("user-name"));
		name.sendKeys("standard_user");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		WebElement btn=driver.findElement(By.id("login-button"));
		btn.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)");
		TakesScreenshot tks=(TakesScreenshot) driver;
		File src=tks.getScreenshotAs(OutputType.FILE);
		File dest=new File("./folder/products-page.png");
		FileHandler.copy(src, dest);
		
		
		
	}

}
