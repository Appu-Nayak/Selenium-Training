package Assessments.LastAssnmtTask1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
public class Task3 {
    public static void main(String[] args) throws InterruptedException {
//        1.Navigate to demoAppsQspiders draganddrop multiple page
//        2.drag and drop the accessories accordingly.

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToMultiple?sublist=3");

        WebElement laptopCharger = driver.findElement(By.id("dragElement1"));
        WebElement mobileCover = driver.findElement(By.id("dragElement2"));
        WebElement laptopCover = driver.findElement(By.id("dragElement3"));
        WebElement mobileCharger = driver.findElement(By.id("dragElement4"));

        WebElement mobileAccessories = driver.findElement(By.id("dropZone1"));
        WebElement laptopAccessories = driver.findElement(By.id("dropZone2"));

        Actions actions=new Actions(driver);
        // Mobile Cover, Mobile Charger -> Mobile Accessories
        actions.keyDown(Keys.CONTROL) //Presses and holds the Ctrl key.
                .click(mobileCover)//Clicks Mobile Cover while Ctrl is held.
                .click(mobileCharger)//Clicks Mobile Charger while Ctrl is still held.
                .keyUp(Keys.CONTROL) //Releases the Ctrl key.
                .perform(); //Executes the complete Actions sequence.

        // draging to Mobile Accessories
        actions.clickAndHold(mobileCover) //Clicks Mobile Cover and keeps the mouse button pressed.
                .moveToElement(mobileAccessories)//While still holding the mouse button, moves the mouse to the Mobile Accessories drop area.
                .release()//Releases the mouse button.
                .perform();//Executes the whole action.

        // Laptop Cover, laptop Charger -> laptop Accessories
        actions.keyDown(Keys.CONTROL)//This step selects multiple items.
                .click(laptopCover)
                .click(laptopCharger)
                .keyUp(Keys.CONTROL)
                .perform();

        // draging to laptop Accessories
        actions.clickAndHold(laptopCover) //Here drags an item to the drop zone.
                .moveToElement(laptopAccessories)
                .release()
                .perform();
    }
}
