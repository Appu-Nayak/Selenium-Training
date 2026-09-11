package Assessments.Day5.java;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class DemoappsqspidersTask {
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
//        1.Navigate to Demoappsqspiders application
//        2.Enter name, email,password and click on login submit button
//        3.Read the data from json file.
        FileReader fir=new FileReader("src/test/resources/DDT/properties.json");
        JSONParser jsonParser=new JSONParser();
        Object obj=jsonParser.parse(fir);
        JSONObject json= (JSONObject) obj;

        String browser = json.get("browser").toString();
        String url = json.get("url").toString();
        String username = json.get("username").toString();
        String fullName = json.get("fullName").toString();
        String email = json.get("Email").toString();
        String password=json.get("password").toString();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("fullname")).sendKeys(fullName);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id("submit")).click();
    }
}
