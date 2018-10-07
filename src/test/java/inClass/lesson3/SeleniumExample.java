package inClass.lesson3;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExample {

    @Test
    public void initBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\megogoTest\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        driver.close();
    }
}
