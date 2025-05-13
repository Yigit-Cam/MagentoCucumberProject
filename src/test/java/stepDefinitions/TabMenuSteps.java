package stepDefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.RegisterAndLogin;
import pages.TabNav;
import utilities.ConfigReader;

import java.util.List;

public class TabMenuSteps {
    TabNav tb = new TabNav();
    RegisterAndLogin ral = new RegisterAndLogin();

    @And("check the TABMenu connections at")
    public void checkTheTABMenuConnectionsAt() {
        List<WebElement> tabMenuList = tb.tabMenuElementList;
        for (int i = 0; i < tabMenuList.size(); i++) {
            String checkText = tabMenuList.get(i).getText();
            tb.myClick(tabMenuList.get(i));
            String pageTitle = tb.pageTitleHeading.getText();
            Assert.assertEquals(checkText, pageTitle, "Wrong page!");
            if (i == 1 || i == 2) {
                tb.myClick(tabMenuList.get(i));
                for (int j = 0; j <2; j++) {
                    String[] check = {"Tops", "Bottoms"};
                    List<WebElement> categoriesList = tb.categoriesMenuList;
                    String categories = categoriesList.get(j).getText();
                    Assert.assertEquals(check[j], categories, "Submenus not displayed!");
                }
                if (i == 1) {
                    tb.scrollToElement(tabMenuList.get(i));
                    List<WebElement> roleMenuElementWomen = tb.roleMenuListWomen;
                    tb.myClick(roleMenuElementWomen.get(i - 1));
                    List<WebElement> products = tb.productList;
                    Assert.assertFalse(products.isEmpty(), "No products found to view!");
                }
                if (i == 2) {
                    tb.scrollToElement(tabMenuList.get(i));
                    List<WebElement> roleMenuElementMen = tb.roleMenuListMen;
                    tb.myClick(roleMenuElementMen.get(i - 1));
                    List<WebElement> products = tb.productList;
                    Assert.assertFalse(products.isEmpty(), "No products found to view!");
                }
            }
        }
    }
}
