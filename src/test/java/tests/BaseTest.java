package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

// class thiet lap moi truong chay test
public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    // ham setupmoitruong
    @BeforeMethod(alwaysRun = true)
    //them key beformethod de chay ham nay trc khi chay test
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        //cau hinh giao dien cho chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        int timeout = Integer.parseInt(ConfigReader.get("timeout"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }
    // ham teardow, moi truong test
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    // vi caca page con dieu can login trc nen can define function login o trng class cha
    protected void loginAsAdmin() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver,wait);
        loginPage.open();
        loginPage.login(ConfigReader.get("username"),ConfigReader.get("password"));
        wait.until(ExpectedConditions.urlContains("dashboard"));
    };


}

