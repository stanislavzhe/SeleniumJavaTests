package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Stas on 29.09.2018.
 */
public class CartPageAddress {
    WebDriver driver;

    public CartPageAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='button btn btn-default button-medium']")
    private WebElement proceedToCheckoutButton;
    public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }
    public WebElement getProceedToCheckoutButton() {
        return proceedToCheckoutButton;
    }

    @FindBy(css = "#address_invoice .address_firstname.address_lastname")
    private WebElement firstAndLastNamesBillingAddress;
    public String getFirstAndLastNamesBillingAddressText() {
        return firstAndLastNamesBillingAddress.getText();
    }

    @FindBy(css = "#address_invoice .address_company")
    private WebElement companyNamesBillingAddress;
    public String getCompanyNamesBillingAddressText() {
        return companyNamesBillingAddress.getText();
    }

    @FindBy(css = "#address_invoice .address_address1.address_address2")
    private WebElement addressBillingAddress;
    public String getAddressBillingAddress() {
        return addressBillingAddress.getText();
    }

    @FindBy(css = "#address_invoice .address_city.address_state_name.address_postcode")
    private WebElement cityStatePostCodeBillingAddress;
    public String getCityStatePostCodeBillingAddress() {
        return cityStatePostCodeBillingAddress.getText();
    }

    @FindBy(css = "#address_invoice .address_country_name")
    private WebElement countryBillingAddress;
    public String getCountryBillingAddress() {
        return countryBillingAddress.getText();
    }

    @FindBy(css = "#address_invoice .address_phone")
    private WebElement phoneBillingAddress;
    public String getPhoneBillingAddress() {
        return phoneBillingAddress.getText();
    }

    @FindBy(css = "#address_invoice .address_phone_mobile")
    private WebElement mobilePhoneBillingAddress;
    public String getMobilePhoneBillingAddress() {
        return mobilePhoneBillingAddress.getText();
    }



//    IN THIS CLASS
//    @FindBy(id = "address_invoice")
//    private WebElement form;
//
//    public String getForm() {
//        return form.getText();
//    }
//    IN TEST CLASS
//        String formText = cartPageAddress.getForm();
//        System.out.println("2: " + formText);
//        String[] lines = formText.split("\\n");
//        System.out.println(lines[0]);//YOUR BILLING ADDRESS
//        System.out.println(lines[1]);//First Name Address Last Name Address

}
