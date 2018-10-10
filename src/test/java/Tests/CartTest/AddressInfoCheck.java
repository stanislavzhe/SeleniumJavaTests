package Tests.CartTest;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.Date;

public class AddressInfoCheck {

    public WebDriver driver;
    private static String emailAuthPage = "ab@abc.com";
    private static final String customersFirstName = "Stas";
    private static final String customersLastName = "Zheleznov";
    private static final String password = "12345";
    private static final String firstNameAddressSection = "First Name Address";
    private static final String lastNameAddressSection = "Last Name Address";
    private static final String companyName = "Company Name";
    private static final String address = "Country, City, Street, 99";
    private static final String city = "City";
    private static final String zipcode = "02139";
    private static final String additionalInfo = "Hello\nHow are your?";
    private static final String phone = "044 063 63 63";
    private static final String mobilePhone = "063 063 63 63";
    private static final String addressAlias = "my address alias";
    private static final String dayValue = "16";
    private static final String monthValue = "6";
    private static final String yearValue = "1988";
    private static final String stateValue = "New York"; // or value "32"//
    private static final String countryValue = "United States"; // or value "21"//
    private static final String sortByValue = "price:asc";
    private static final int indexForFirstElement = 0;
    private static final int indexForSecondElement = 1;
    private static final double delta = 0;
    public static int timeOut = 15;

    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.chrome.driver", "E:\\megogoTest\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void AddressInfoAndPaymentInfoCheck() throws InterruptedException {
//        Зарегистрировать нового пользователя - проверить что пользователь зарегистрирован
//        Открыть Dresses
//        Переключится в List View
//        Отфильтровать товары по размеру L
//        Отсортировать товары по возрастанию цены
//        Добавить первые два товара в корзину
//        Перейти в корзину
//        Проверить что оба товара в корзине
//        Проверить что Total товаров равно Total Products
//        Проверить что скидка на цену корректная
//        Перейти в Address - проверить Billing Address
//        Перейти в Shipping
//        Активировать “I agree ...”
//        Перейти на страницу Payment
//        Сравнить что значения в блоке Payment соответствуют значениям на Cart  Summary
        String expectedTitleAfterLogin = "MY ACCOUNT";
        String expectedTextOnAccountButton = customersFirstName + " " + customersLastName;
        String expectedTextOnLogoutButton = "Sign out";
        String expectedFirstAndLastNamesBillingAddressText = firstNameAddressSection + " " + lastNameAddressSection;
        String expectedCompanyNameBillingAddressText = companyName;
        String expectedAddressBillingAddressText = address;
        String expectedCityStatePostCodeBillingAddressText = city + ", " + stateValue + " " + zipcode;
        String expectedCountryBillingAddressText = countryValue;
        String expectedPhoneAddressText = phone;
        String expectedMobilePhoneBillingAddressText = mobilePhone;
        int expectedCartSize = 2;

        generateEmail();
        createNewUser();
        checkThatUserRegisteredCorrect(
                expectedTitleAfterLogin,
                expectedTextOnAccountButton,
                expectedTextOnLogoutButton);
        CategoryPage categoryPage =
                OpenDressesAndSelectFilters();

        String actualFirstElementNameCategoryPage = categoryPage.
                getNameForProductByIndex(indexForFirstElement);
        String actualSecondElementNameCategoryPage = categoryPage.
                getNameForProductByIndex(indexForSecondElement);

        CartPageSummary cartPageSummary =
                addFirstAndSecondItemsToCartAndGoToCart(categoryPage);
        checkThatTwoItemsAddedToCart(
                expectedCartSize,
                actualFirstElementNameCategoryPage,
                actualSecondElementNameCategoryPage,
                cartPageSummary);
        checkThatTotalItemsEqualsTotalProducts(cartPageSummary);
        checkDiscountIsCorrect(cartPageSummary);

        String firstItemNameSummaryPage = cartPageSummary.
                getNameForProductByIndex(indexForFirstElement);
        String secondItemNameSummaryPage = cartPageSummary.
                getNameForProductByIndex(indexForSecondElement);;
        String firstItemQuantitySummaryPage = cartPageSummary.
                getQuantityForItemByIndex(indexForFirstElement);
        String secondItemQuantitySummaryPage = cartPageSummary.
                getQuantityForItemByIndex(indexForSecondElement);
        String firstItemTotalPriceSummaryPage = cartPageSummary.
                getItemTotalPriceByIndex(indexForFirstElement);
        String secondTotalPriceForItemSummaryPage = cartPageSummary.
                getItemTotalPriceByIndex(indexForSecondElement);
        String totalProductPriceSummaryPage = cartPageSummary.
                getTotalProductPrice();
        String totalShippingPriceSummaryPage = cartPageSummary.
                getTotalShippingPrice();
        String totalPriceSummaryPage = cartPageSummary.
                getTotalSPrice();

        CartPageAddress cartPageAddress =
                goToAddress(cartPageSummary);
        checkThatAddressIsCorrect(
                expectedFirstAndLastNamesBillingAddressText,
                expectedCompanyNameBillingAddressText,
                expectedAddressBillingAddressText,
                expectedCityStatePostCodeBillingAddressText,
                expectedCountryBillingAddressText,
                expectedPhoneAddressText,
                expectedMobilePhoneBillingAddressText,
                cartPageAddress);
        cartPageAddress.clickOnProceedToCheckoutButton();
        CartPagePayment cartPagePayment = goToPaymentPage();
        checkValuesInPaymentEqualsSameInSummary(
                firstItemNameSummaryPage,
                secondItemNameSummaryPage,
                firstItemQuantitySummaryPage,
                secondItemQuantitySummaryPage,
                firstItemTotalPriceSummaryPage,
                secondTotalPriceForItemSummaryPage,
                totalProductPriceSummaryPage,
                totalShippingPriceSummaryPage,
                totalPriceSummaryPage,
                cartPagePayment);
    }

    private void checkValuesInPaymentEqualsSameInSummary(
            String firstItemNameSummaryPage,
            String secondItemNameSummaryPage,
            String firstItemQuantitySummaryPage,
            String secondItemQuantitySummaryPage,
            String firstItemTotalPriceSummaryPage,
            String secondTotalPriceForItemSummaryPage,
            String totalProductPriceSummaryPage,
            String totalShippingPriceSummaryPage,
            String totalPriceSummaryPage,
            CartPagePayment cartPagePayment) {
        String firstItemNamePaymentPage = cartPagePayment.getNameForProductByIndex(indexForFirstElement);
        String secondItemNamePaymentPage = cartPagePayment.getNameForProductByIndex(indexForSecondElement);
        ;
        String firstItemQuantityPaymentPage = cartPagePayment.getQuantityForItemVyIndex(indexForFirstElement);
        String secondItemQuantityPaymentPage = cartPagePayment.getQuantityForItemVyIndex(indexForSecondElement);
        String firstItemTotalPricePaymentPage = cartPagePayment.getItemTotalPriceByIndex(indexForFirstElement);
        String secondTotalPriceForItemPaymentPage = cartPagePayment.getItemTotalPriceByIndex(indexForSecondElement);
        String totalProductPricePaymentPage = cartPagePayment.getTotalProductPrice();
        String totalShippingPricePaymentPage = cartPagePayment.getTotalShippingPrice();
        String totalPricePaymentPage = cartPagePayment.getTotalSPrice();

        Assert.assertEquals(firstItemNameSummaryPage,firstItemNamePaymentPage);
        Assert.assertEquals(secondItemNameSummaryPage,secondItemNamePaymentPage);
        Assert.assertEquals(firstItemQuantitySummaryPage,firstItemQuantityPaymentPage);
        Assert.assertEquals(secondItemQuantitySummaryPage,secondItemQuantityPaymentPage);
        Assert.assertEquals(firstItemTotalPriceSummaryPage,firstItemTotalPricePaymentPage);
        Assert.assertEquals(secondTotalPriceForItemSummaryPage,secondTotalPriceForItemPaymentPage);
        Assert.assertEquals(totalProductPriceSummaryPage,totalProductPricePaymentPage);
        Assert.assertEquals(totalShippingPriceSummaryPage,totalShippingPricePaymentPage);
        Assert.assertEquals(totalPriceSummaryPage,totalPricePaymentPage);
    }

    private CartPagePayment goToPaymentPage() {
        CartPageShipping cartPageShipping = new CartPageShipping(driver);
        elementClickable(cartPageShipping.getProceedToCheckoutButton());
        cartPageShipping.selectIAgreeWithTermCheckbox();
        cartPageShipping.clickOnProceedToCheckoutButton();

        CartPagePayment cartPagePayment = new CartPagePayment(driver);
        elementClickable(cartPagePayment.getPayByBankWireButton());
        return cartPagePayment;
    }

    private void checkThatAddressIsCorrect(
            String expectedFirstAndLastNamesBillingAddressText,
            String expectedCompanyNameBillingAddressText,
            String expectedAddressBillingAddressText,
            String expectedCityStatePostCodeBillingAddressText,
            String expectedCountryBillingAddressText,
            String expectedPhoneAddressText,
            String expectedMobilePhoneBillingAddressText,
            CartPageAddress cartPageAddress) {
        String actualFirstAndLastNamesBillingAddressText = cartPageAddress.getFirstAndLastNamesBillingAddressText();
        String actualCompanyNameBillingAddressText = cartPageAddress.getCompanyNamesBillingAddressText();
        String actualAddressBillingAddressText = cartPageAddress.getAddressBillingAddress();
        String actualCityStatePostCodeBillingAddressText = cartPageAddress.getCityStatePostCodeBillingAddress();
        String actualCountryBillingAddressText = cartPageAddress.getCountryBillingAddress();
        String actualPhoneAddressText = cartPageAddress.getPhoneBillingAddress();
        String actualMobilePhoneBillingAddressText = cartPageAddress.getMobilePhoneBillingAddress();

        Assert.assertEquals(expectedFirstAndLastNamesBillingAddressText, actualFirstAndLastNamesBillingAddressText);
        Assert.assertEquals(expectedCompanyNameBillingAddressText, actualCompanyNameBillingAddressText);
        Assert.assertEquals(expectedAddressBillingAddressText, actualAddressBillingAddressText);
        Assert.assertEquals(expectedCityStatePostCodeBillingAddressText, actualCityStatePostCodeBillingAddressText);
        Assert.assertEquals(expectedCountryBillingAddressText, actualCountryBillingAddressText);
        Assert.assertEquals(expectedPhoneAddressText, actualPhoneAddressText);
        Assert.assertEquals(expectedMobilePhoneBillingAddressText, actualMobilePhoneBillingAddressText);
    }

    private CartPageAddress goToAddress(CartPageSummary cartPageSummary) {
        cartPageSummary.clickOnProceedToCheckoutButton();
        CartPageAddress cartPageAddress = new CartPageAddress(driver);
        elementClickable(cartPageAddress.getProceedToCheckoutButton());
        return cartPageAddress;
    }

    private void checkDiscountIsCorrect(CartPageSummary cartPageSummary) {
        double actualDiscount = cartPageSummary.discountDouble(); //TODO: take to test class method
        double actualOldPrice = cartPageSummary.getPriceParseToDouble(cartPageSummary.
                getPriceWithoutCurrency(cartPageSummary.getOldPriceText())); //TODO: take to test class method
        double expectedPriceAfterDiscount = cartPageSummary.countPriceAfterDiscount(actualOldPrice,actualDiscount); //TODO: take to test class method
        double actualPriceAfterDiscount = cartPageSummary.getPriceParseToDouble(cartPageSummary.
                getPriceWithoutCurrency(cartPageSummary.getPriceWithDiscount())); //TODO: take to test class method
        Assert.assertEquals(expectedPriceAfterDiscount,actualPriceAfterDiscount,delta);
    }

    private void checkThatTotalItemsEqualsTotalProducts(CartPageSummary cartPageSummary) {
        double actualSumOfTotalPricesForAllItemsInCart = cartPageSummary.getSumOfTotalPricesForAllItemsInCart();
        double actualTotalProductPriceDouble = cartPageSummary.getSumOfTotalPricesForAllItemsInCart();
        Assert.assertEquals(actualSumOfTotalPricesForAllItemsInCart, actualTotalProductPriceDouble, delta);
    }

    //check that two items in cart: cart size = 2, name for items same as in category page
    private void checkThatTwoItemsAddedToCart(
            int expectedCartSize,
            String actualFirstElementNameCategoryPage,
            String actualSecondElementNameCategoryPage,
            CartPageSummary cartPageSummary) {
        int actualCartSize = cartPageSummary.getCartItemsSize();
        Assert.assertEquals(expectedCartSize, actualCartSize);
        String actualFirstElementNameCartPage = cartPageSummary.getNameForProductByIndex(indexForFirstElement);
        String actualSecondElementNameCartPage = cartPageSummary.getNameForProductByIndex(indexForSecondElement);
        Assert.assertEquals(actualFirstElementNameCategoryPage, actualFirstElementNameCartPage);
        Assert.assertEquals(actualSecondElementNameCategoryPage, actualSecondElementNameCartPage);
    }

    private CartPageSummary addFirstAndSecondItemsToCartAndGoToCart(CategoryPage categoryPage) {
        categoryPage.clickOnAddToCartButtonItemByIndex(indexForFirstElement);
        ProductAddedToCart productAddedToCart = new ProductAddedToCart(driver);
        elementClickable(productAddedToCart.getCloseWindowButton());
        productAddedToCart.clickOnCloseWindowButton();
        elementClickable(categoryPage.getAddToCartButtonSecondItem());
        categoryPage.clickOnAddToCartButtonItemByIndex(indexForSecondElement);
        productAddedToCart = new ProductAddedToCart(driver);
        elementVisible(productAddedToCart.getProceedToCheckoutButton(),timeOut);
        elementClickable(productAddedToCart.getProceedToCheckoutButton());
        productAddedToCart.clickOnProceedToCheckoutButton();
        CartPageSummary cartPageSummary = new CartPageSummary(driver);
        elementVisible(cartPageSummary.getCartTitle(), timeOut);
        return cartPageSummary;
    }


    //need to generate email for register (timestamp + email)
    private void generateEmail() {
        Date date = new Date();
        long time = date.getTime();
        emailAuthPage = time + emailAuthPage;
    }

    private void createNewUser() {
        MenuNavigation menuNavigation = new MenuNavigation(driver);
        menuNavigation.clickOnSignButton();
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.typeEmailOnAuthPage(emailAuthPage);
        authenticationPage.clickOnSubmitButtonAuthPage();
        AccountCreationPage accountCreationPage = new AccountCreationPage(driver);
        elementVisible(accountCreationPage.getGenderMrRadioButton(), timeOut);
        accountCreationPage.selectMrGender();
        accountCreationPage.typeCustomersFirstName(customersFirstName);
        accountCreationPage.typeCustomersLastName(customersLastName);
        accountCreationPage.typePassword(password);
        accountCreationPage.typeNewlettersCheckbox();
        accountCreationPage.typeSpecialOffersCheckbox();
        accountCreationPage.typeFirstNameAddressSection(firstNameAddressSection);
        accountCreationPage.typeLastNameAddressSection(lastNameAddressSection);
        accountCreationPage.typeCompanyName(companyName);
        accountCreationPage.typeAddress(address);
        accountCreationPage.typeCity(city);
        accountCreationPage.typeZipcode(zipcode);
        accountCreationPage.typeAdditionalInfo(additionalInfo);
        accountCreationPage.typePhone(phone);
        accountCreationPage.typeMobilePhone(mobilePhone);
        accountCreationPage.typeAddressAlias(addressAlias);
        accountCreationPage.selectDay(dayValue);
        accountCreationPage.selectMonth(monthValue);
        accountCreationPage.selectYear(yearValue);
        accountCreationPage.selectState(stateValue);
        accountCreationPage.selectCountry(countryValue);
        accountCreationPage.clickOnRegisterButton();
    }
    private void checkThatUserRegisteredCorrect(
            String expectedTitleAfterLogin,
            String expectedTextOnAccountButton,
            String expectedTextOnLogoutButton) {
        MyAccount myAccount = new MyAccount(driver);
        String actualTitleAfterLogin = myAccount.getPageHeadingText();
        String actualTextOnAccountButton = myAccount.getAccountButtonText();
        String actualTextOnLogoutButton = myAccount.getLogoutButtonText();
        Assert.assertEquals(actualTitleAfterLogin, expectedTitleAfterLogin);
        Assert.assertEquals(actualTextOnAccountButton, expectedTextOnAccountButton);
        Assert.assertEquals(actualTextOnLogoutButton, expectedTextOnLogoutButton);
    }

    private CategoryPage OpenDressesAndSelectFilters() {
        MenuNavigation menuNavigation = new MenuNavigation(driver);
        menuNavigation.clickOnDressSFMenuSectionButton();

        CategoryPage categoryPage = new CategoryPage(driver);
        elementClickable(categoryPage.getListViewButton());
        categoryPage.clickOnListViewButton();
        categoryPage.selectSSizeCheckbox();
        categoryPage.loaderSectionNotShown(timeOut);
        categoryPage.sortBy(sortByValue);
        categoryPage.loaderSectionNotShown(timeOut);
        return categoryPage;
    }

    protected void elementClickable(WebElement element) {
        new WebDriverWait(driver, timeOut).
                until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void elementVisible(WebElement element, int timeout) {
        new WebDriverWait(driver, timeout).
                until(ExpectedConditions.visibilityOf(element));
    }

    @AfterMethod()
    public void close() {
        driver.close();
    }
}
