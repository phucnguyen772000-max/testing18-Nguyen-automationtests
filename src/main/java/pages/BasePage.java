package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    // thuoc tinh giup tuong tac tren website nhu"
    // truy cap page, fill value,click,checkbox
    protected WebDriver driver;
    // thuoc  tinh giup tim kiem locator de dang hon tranh  truong flaky test ( luc back luc khong)
    protected WebDriverWait wait;
    // thuoc tinh chen code javasript giup tuong tac tren website
    // hightlight,scroll, doublick
    protected JavascriptExecutor js;
    public BasePage(WebDriver driver, WebDriverWait wait)
    {
        this.driver = driver;
        this.wait = wait;
        this.js =(JavascriptExecutor)  driver;

    }
}
