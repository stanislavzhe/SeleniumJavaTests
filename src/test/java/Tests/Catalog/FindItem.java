package Tests.Catalog;


import Tests.BaseTest;
import org.testng.annotations.Test;
import pages.MenuNavigation;

public class FindItem extends BaseTest{

    @Test(groups = "positive")
    public void findValidItem() throws InterruptedException {
        MenuNavigation menuNavigation = new MenuNavigation(driver);
        menuNavigation.inputIntoSearchField("Blouse");
        Thread.sleep(5000);

    }

    @Test(groups = "negative")
    public void findNonValidItem() throws InterruptedException {
        MenuNavigation menuNavigation = new MenuNavigation(driver);
        menuNavigation.inputIntoSearchField("MacBook");
        Thread.sleep(5000);

    }
}
