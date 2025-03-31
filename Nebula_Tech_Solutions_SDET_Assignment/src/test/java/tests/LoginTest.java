package test.java.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.get("https://www.mim-essay.com/login");
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.mailoption();
        loginPage.enterUsername("Atul12@mim-essay.com");
        loginPage.enterPassword("Atul@123");
        loginPage.clickLogin();
        
        Thread.sleep(7000);
        String title = driver.getTitle();
        System.out.println(title);
        
        assertTrue(driver.getTitle().contains("Dashboard"), "Title validation failed");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}