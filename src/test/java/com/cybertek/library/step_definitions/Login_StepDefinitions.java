package com.cybertek.library.step_definitions;
import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.LibraryLoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.cucumber.java.jv.Lan;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Login_StepDefinitions {
    LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    LandingPage landingPage = new LandingPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("libraryUrl"));
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        libraryLoginPage.login("librarian13@library","9rf6axdD");
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        Assert.assertTrue(libraryLoginPage.dashBoard.isDisplayed());
        Driver.closeDriver();
    }

    @When("I login as a student")
    public void i_login_as_a_student() {
        libraryLoginPage.login(ConfigurationReader.getProperty("student11Username"),ConfigurationReader.getProperty("student11Password"));
    }

    @When("I enter username {string}")
    public void i_enter_username(String string) {
        libraryLoginPage.emailInput.sendKeys(string);
    }

    @When("I enter password {string}")
    public void i_enter_password(String string) {
        libraryLoginPage.passwordInput.sendKeys(string);
    }

    @When("click the sign in button")
    public void click_the_sign_in_button() {
        libraryLoginPage.clickSignInButton();
    }

    @Then("there should be {int} users")
    public void there_should_be_users(Integer int1) {
        wait.until(ExpectedConditions.visibilityOf(landingPage.userCount));
        String exp = String.valueOf(int1);
        String act = landingPage.userCount.getText();
        Assert.assertEquals(exp, act);
    }

    @When("I login using {string} and {string}")
    public void i_login_using_and(String string, String string2) {
        libraryLoginPage.login(string,string2);
        libraryLoginPage.clickSignInButton();
    }
}
