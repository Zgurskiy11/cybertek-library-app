package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.LibraryLoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;

public class PageNavigations_StepDefinition {
    LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    LandingPage landingPage = new LandingPage();  //this page extends CommonElementsPage

    @When("I click on {string} link")
    public void i_click_on_link(String string) {
        String xpath = "//span[.='" + string + "']";
        Driver.getDriver().findElement(By.xpath(xpath)).click();

//        if (string.equals("users")) {
//           landingPage.usersLink.click(); //using method from Abstract class
//        }
    }


    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer int1) {
        Select select = new Select(landingPage.recordsDropdown);
        String actualOption = select.getFirstSelectedOption().getText();
        String expectedOption = String.valueOf(int1);
        Assert.assertEquals(expectedOption, actualOption);
    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {
        Select select = new Select(landingPage.recordsDropdown);
        List<WebElement> showOptions = select.getOptions();
        //   BrowserUtils.sleep(3);
        int count = 0;
        for (WebElement showOption : showOptions) {
            for (String option : options) {
                if (showOption.getText().equals(option)) {
                    count++;
                }
            }
        }

        int exp = options.size();
        int actual = count;
        Assert.assertEquals(exp, actual);
        Driver.closeDriver();
    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> columns) {
        int count = 0;
        List<WebElement> actualColumns = landingPage.columnsNames;
        for (String column : columns) {
            for (WebElement actualColumn : actualColumns) {
                if (actualColumn.getText().equals(column)) {
                    count++;
                }
            }
        }
        int exp = columns.size();
        int actual = count;
        Assert.assertEquals(exp, actual);
        Driver.closeDriver();
    }

    @When("I am login using {string} and {string}")
    public void i_am_login_using_and(String email, String password) {
        libraryLoginPage.login(email, password);
    }

    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String expectedName) {
        wait.until(ExpectedConditions.visibilityOf(landingPage.accountHolderName));
        String actualName = landingPage.accountHolderName.getText();
        //  BrowserUtils.sleep(3);
        Assert.assertEquals(expectedName, actualName);
        Driver.closeDriver();
    }


}
