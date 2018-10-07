package HomeWork.HW8;

import HomeWork.HW8.pages.ConverterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Stas on 06.10.2018.
 */
public class ConverterTest {
    WebDriver driver;
    private static final double delta = 0.05;

    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.chrome.driver", "D:\\megogoTest\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://finance.i.ua/converter/");
    }

    @Test
    public void checkConverterBla() throws InterruptedException {
        String bankName = "НБУ";
        double expectedAmountFieldValue = 100;
        ConverterPage converterPage = new ConverterPage(driver);
        converterPage.clearCurrencyAmountField().enterCurrencyAmount(String.valueOf(expectedAmountFieldValue));
        converterPage.setConverterCurrency(ConverterPage.Currency.UAH);
        converterPage.setConverterBank(bankName);

        double actualAmountFieldValue = converterPage.currencyAmountFieldValue();
        double actualRateUSDValue = converterPage.currencyRateUSDValue();
        double actualRateEURValue = converterPage.currencyRateEURValue();
        double actualRateRUBValue = converterPage.currencyRateRUBValue();
        double actualExchangeUSDValue = converterPage.currencyExchangeUSDValue();
        double actualExchangeEURValue = converterPage.currencyExchangeEURValue();
        double actualExchangeRUBValue = converterPage.currencyExchangeRUBValue();

        double expectedExchangeUSDValue = round(actualAmountFieldValue / actualRateUSDValue, 2);
        double expectedExchangeEURValue = round(actualAmountFieldValue / actualRateEURValue, 2);
        double expectedExchangeRUBValue = round(actualAmountFieldValue / actualRateRUBValue, 2);

        Assert.assertEquals(expectedAmountFieldValue, actualAmountFieldValue, delta);
        Assert.assertEquals(expectedExchangeUSDValue, actualExchangeUSDValue, delta);
        Assert.assertEquals(expectedExchangeEURValue, actualExchangeEURValue, delta);
        Assert.assertEquals(expectedExchangeRUBValue, actualExchangeRUBValue, delta);
    }


    @AfterMethod()
    public void close() {
        driver.close();
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
