package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MovieLoginPage extends BasePage {


    private static final String URL = "https://demo1.cybersoft.edu.vn/sign-in";

    private static final By INPUT_USERNAME = By.id("taiKhoan");
    private static final By INPUT_PASSWORD = By.id("matKhau");
    private static final By BTN_LOGIN = By.xpath("//span[text()='Đăng nhập']/parent::button");

    public MovieLoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get(URL);
    }

    public void enterUsername(String username) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_USERNAME));
        el.clear();
        el.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_PASSWORD));
        el.clear();
        el.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(BTN_LOGIN)).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Đăng nhập thành công thì trang sẽ rời khỏi URL đăng nhập
    public boolean isLoginSuccess() {
        try {
            return wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(URL)));
        } catch (Exception e) {
            return false;
        }
    }
}