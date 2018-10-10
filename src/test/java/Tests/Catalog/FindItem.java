package Tests.Catalog;


import Tests.BaseTest;
import org.testng.annotations.Test;
import pages.MenuNavigation;

public class FindItem extends BaseTest{

    @Test(groups = "positive")
    public void findValidItem() throws InterruptedException {
        MenuNavigation menuNavigation = new MenuNavigation(driver);
        menuNavigation.inputIntoSearchField("Blouse");
        menuNavigation.clickToSubmitSearch();
        Thread.sleep(2000);

    }

    @Test(groups = "negative")
    public void findNonValidItem() throws InterruptedException {
        MenuNavigation menuNavigation = new MenuNavigation(driver);
        menuNavigation.inputIntoSearchField("MacBook");
        menuNavigation.clickToSubmitSearch();
        Thread.sleep(2000);

    }
}
