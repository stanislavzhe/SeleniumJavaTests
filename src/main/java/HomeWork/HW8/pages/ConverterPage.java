package HomeWork.HW8.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Stas on 06.10.2018.
 */
public class ConverterPage {
    private WebDriver driver;

    @FindBy(xpath = "(//*[@class='widget widget-converter']//a)[1]")
    private WebElement converterTitle;
    @FindBy(id = "sell")
    private WebElement sellButton;
    @FindBy(id = "buy")
    private WebElement buyButton;
    @FindBy(id = "currency_amount")
    private WebElement currencyAmountField;
    @FindBy(id = "converter_currency")
    private WebElement converterCurrency;
    @FindBy(id = "converter_bank")
    private WebElement converterBank;
    @FindBy(css = "#UAH #currency_exchange")
    private WebElement currencyExchangeUAH;
    @FindBy(css = "#USD #currency_exchange")
    private WebElement currencyExchangeUSD;
    @FindBy(css = "#EUR #currency_exchange")
    private WebElement currencyExchangeEUR;
    @FindBy(css = "#RUB #currency_exchange")
    private WebElement currencyExchangeRUB;
    @FindBy(css = "#UAH #currency_rate")
    private WebElement currencyRateUAH;
    @FindBy(css = "#USD #currency_rate")
    private WebElement currencyRateUSD;
    @FindBy(css = "#EUR #currency_rate")
    private WebElement currencyRateEUR;
    @FindBy(css = "#RUB #currency_rate")
    private WebElement currencyRateRUB;

    public ConverterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getConverterTitle() {
        return converterTitle.getText();
    }

    public void clickOnSellButton() {
        sellButton.click();
    }

    public void clickOnBuyButton() {
        buyButton.click();
    }

    public ConverterPage clearCurrencyAmountField() {
        ConverterPage converterPage = new ConverterPage(driver);
        currencyAmountField.clear();
        return converterPage;
    }

    public void enterCurrencyAmount(String currencyAmount) {
        currencyAmountField.sendKeys(currencyAmount);
    }

    public void setConverterCurrency(Currency currency) {
        Select currencyFromValue = new Select(converterCurrency);
        currencyFromValue.selectByValue(currency.name());
    }

    public void setConverterBank(String bank) {
        Select converterBankByName = new Select(converterBank);
        converterBankByName.selectByVisibleText(bank);
    }

    public double getValueFromElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String value = (String) executor.executeScript(" return arguments[0].value;",
                element);
        return Double.parseDouble(value);
    }

    public double currencyAmountFieldValue() {
        return getValueFromElement(currencyAmountField);
    }

    public double currencyExchangeUAHValue() {
        return getValueFromElement(currencyExchangeUAH);
    }

    public double currencyExchangeUSDValue() {
        return getValueFromElement(currencyExchangeUSD);
    }

    public double currencyExchangeEURValue() {
        return getValueFromElement(currencyExchangeEUR);
    }

    public double currencyExchangeRUBValue() {
        return getValueFromElement(currencyExchangeRUB);
    }

    public double currencyRateUAHValue() {
        return getValueFromElement(currencyRateUAH);
    }

    public double currencyRateUSDValue() {
        return getValueFromElement(currencyRateUSD);
    }

    public double currencyRateEURValue() {
        return getValueFromElement(currencyRateEUR);
    }

    public double currencyRateRUBValue() {
        return getValueFromElement(currencyRateRUB);
    }

    public enum Currency {
        UAH,
        USD,
        EUR,
        RUB
    }

//    #EUR .info
//    <p id="RUB" style="display: none;">
//    widget-currency_bank - css - table with currency values
//    .widget-currency_bank tbody tr
//    document.querySelectorAll("#RUB #currency_exchange")[0].value
//    "6 405.50"
}
