package Assessments.Day5.java;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class OrangeHrmTask {
    public static void main(String[] args) throws IOException, InterruptedException {
//        1.Navigate to orange Hrm application
//        2.Enter the username password and click on login buuton by reading the data from excel file.
        FileInputStream fir=new FileInputStream("src/test/resources/DDT/Excel_SauceDemo.xlsx");
        Workbook wb=WorkbookFactory.create(fir);

        String browser = wb.getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
        String url = wb.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
        String username = wb.getSheet("Sheet1").getRow(2).getCell(2).getStringCellValue();
        String password = wb.getSheet("Sheet1").getRow(2).getCell(3).getStringCellValue();

        WebDriver driver=null;
        if(browser.equals("chrome"))
            driver=new ChromeDriver();
        if(browser.equals("Edge"))
            driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.findElement(By.cssSelector("[name='username']")).sendKeys(username);
        driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();

    }
}
