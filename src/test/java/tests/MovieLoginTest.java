package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MovieLoginPage;

public class MovieLoginTest extends BaseTest {

    @Test(description = "Dang nhap thanh cong")
    public void testLoginSuccess() {
        MovieLoginPage page = new MovieLoginPage(driver, wait);
        page.open();
        page.login("nguyenbinz", "772005");
        Assert.assertTrue(page.isLoginSuccess(), "Dang nhap that bai");
    }
}