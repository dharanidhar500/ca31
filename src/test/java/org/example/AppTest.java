package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppTest {
    WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeClass
    void setupDriver(String browser, String link) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }


        else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();}

        driver.get("https://mail.google.com" );
        driver.manage().window().maximize();
    }



    @Test
    void getTitlefrompage() throws InterruptedException {

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("dharanidhar510@gmail.com");
        Thread.sleep(1000);
        driver.findElement((By.xpath("//div[@id='identifierNext']"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("dharani1500");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
        Thread.sleep(1000);
        driver.close();

    }

    @AfterClass
    void closeDriver() {
        driver.close();

    }
}