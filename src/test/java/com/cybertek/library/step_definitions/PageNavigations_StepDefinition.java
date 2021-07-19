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
        string = string.toLowerCase();
        if (string.equals("users")) {
           landingPage.usersLink.click(); //using method from Abstract class
        }
    }


    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer int1) {
        Select select = new Select(landingPage.recordsDropdown);
        String actualOption=select.getFirstSelectedOption().getText();
        String expectedOption =String.valueOf(int1);
        Assert.assertEquals(expectedOption,actualOption);
    }
    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {
        Select select = new Select(landingPage.recordsDropdown);
        List<WebElement> showOptions = select.getOptions();
        BrowserUtils.sleep(3);
        int count = 0;
        for (WebElement showOption : showOptions) {
            for (String option : options) {
                if (showOption.getText().equals(option)){
                    count++;
                }
            }
        }
        System.out.println(count);
        int exp = options.size();
        int actual = count;
        Assert.assertEquals(exp,actual);
        Driver.closeDriver();
    }

}
