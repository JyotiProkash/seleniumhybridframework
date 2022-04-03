package com.hybridframework.qa.testpages;

import com.hybridframework.qa.sourcepages.HomePage;
import com.hybridframework.qa.sourcepages.StorePage;
import com.hybridframework.qa.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Created by Jyoti 03/04/2022
 */

public class NavigationTest extends BaseTest {
    @Test
    public void NavigateFromHomeToStoreUsingMainMenu() {
        StorePage storePage = new HomePage(getDriver()).
                load().getMyHeader().
                navigateToStoreUsingMenu();
        Assert.assertEquals(storePage.getTitle(), "Store");
    }
}
