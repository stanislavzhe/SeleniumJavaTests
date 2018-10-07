package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CategoryPage {
    private WebDriver driver;
    private final double startSliderPrice = 16;
    private final double endSliderPrice = 53;

    @FindBy(className = "icon-th-list")
    private WebElement listViewButton;
    @FindBy(id = "uniform-layered_id_attribute_group_1")
    private WebElement sSizeCheckbox;
    @FindBy(id = "selectProductSort")
    private WebElement sortBySelect;
    @FindBy(xpath = "(//*[@class='button ajax_add_to_cart_button btn btn-default'])[1]")
    private WebElement addToCartButtonFirstItem;
    @FindBy(xpath = "(//*[@class='button ajax_add_to_cart_button btn btn-default'])[2]")
    private WebElement addToCartButtonSecondItem;
    @FindAll(@FindBy(xpath = "(//*[@class='button ajax_add_to_cart_button btn btn-default'])"))
    private List<WebElement> listOfAddToCartButtonsForItems;
    @FindAll(@FindBy(css = ".product-container .product-name"))
    private List<WebElement> listOfElementsWithProductNames;
    @FindAll(@FindBy(id = "layered_price_slider"))
    private WebElement priceSlider;
    @FindAll(@FindBy(xpath = "//*[@id='layered_price_slider']/a[1]"))
    private WebElement sliderStartPoint;
    @FindAll(@FindBy(xpath = "//*[@id='layered_price_slider']/a[2]"))
    private WebElement sliderEndPoint;
    @FindBy(xpath = "(//*[@class='discount']/following::a[@class='button ajax_add_to_cart_button btn btn-default'])[1]")
    private WebElement addToCartButtonForFirstElementWithDiscount;
    @FindBy(xpath = "(//*[@class='product-container']//*[contains(text(),'Dress') " +
            "and (@class='product-name')]/following::a[@class='button ajax_add_to_cart_button btn btn-default'])[1]")
    private WebElement addToCartButtonForFisrtElementWithDressText;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getListViewButton() {
        return listViewButton;
    }

    public void selectSSizeCheckbox() {
        sSizeCheckbox.click();
    }

    public CategoryPage clickOnListViewButton() {
        listViewButton.click();
        return this;
    }

    public WebElement getsSizeCheckbox() {
        return sSizeCheckbox;
    }

    public void sortBy(String sortByValue) {
        Select sortValue = new Select(sortBySelect);
        sortValue.selectByValue(sortByValue);
    }

    // .product_list > p - loader section with icon and loading text
    public void loaderSectionNotShown(int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector(".product_list > p")));
        new WebDriverWait(driver, timeout).until(ExpectedConditions.
                invisibilityOfElementLocated(By.cssSelector(".product_list > p")));
    }

    public WebElement getAddToCartButtonFirstItem() {
        return addToCartButtonFirstItem;
    }

    public void clickOnAddToCartButtonFirstItem() {
        addToCartButtonFirstItem.click();
    }

    public WebElement getAddToCartButtonSecondItem() {
        return addToCartButtonSecondItem;
    }

    public void clickOnAddToCartButtonSecondItem() {
        addToCartButtonSecondItem.click();
    }

    public WebElement getListOfAddToCartButtonsForItems(int index) {
        return listOfAddToCartButtonsForItems.get(index);
    }

    public void clickOnAddToCartButtonItemByIndex(int index) {
        getListOfAddToCartButtonsForItems(index).click();
    }

    public String getNameForProductByIndex(int index) {
        return listOfElementsWithProductNames.get(index).getText();
    }

    public double countRangeForEndPoint(double priceForEndPoint) {
        return (endSliderPrice - priceForEndPoint) * (-1);
    }

    public int countPXRangeForSliderPoint(double rangeForPoint) {
        double priceOfOnePoint = (endSliderPrice - startSliderPrice) / 100;
        int rangeToSetFirstPoint = (int)
                ((rangeForPoint) / priceOfOnePoint);
        return (int) (rangeToSetFirstPoint * 2.5);
    }

    public CategoryPage drugFirstSliderToPrice(double priceForStartPoint) {
        double rangeForStartPoint = priceForStartPoint - startSliderPrice;
        int PXRange = countPXRangeForSliderPoint(rangeForStartPoint);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(sliderStartPoint, PXRange, 0).build().perform();
        return this;
    }

    public CategoryPage drugEndSliderToPrice(double priceForEndPoint) {
        double rangeForEndPoint = (endSliderPrice - priceForEndPoint) * (-1);
        int PXRange = countPXRangeForSliderPoint(rangeForEndPoint);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(sliderEndPoint, PXRange, 0).build().perform();
        return this;
    }

    public void addToCartElementWithDisoount() {
        addToCartButtonForFirstElementWithDiscount.click();
    }

    public void addToCartElementWithDressText(int timeout) {
        loaderSectionNotShown(timeout);
        addToCartButtonForFisrtElementWithDressText.click();
    }
}
