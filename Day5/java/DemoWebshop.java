package Assessments.Day5.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DemoWebshop {
    public static void main(String[] args) throws IOException, InterruptedException {
//        1.Navigate to DemoWebshop application
//        2.Click on login link .
//        3.Enter email and password and click on login button by reading the data from property file.

        FileInputStream fis=new FileInputStream("src/test/resources/DDT/common_data.properties");
        Properties p=new Properties();
        p.load(fis);
        String browser=p.getProperty("browser");
        String url=p.getProperty("url");
        String email=p.getProperty("email");
        String password=p.getProperty("password");

        WebDriver driver=null;
        if(browser.equals("chrome"))
            driver=new ChromeDriver();
        else
            driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[value='Log in']")).click();


    }
}
