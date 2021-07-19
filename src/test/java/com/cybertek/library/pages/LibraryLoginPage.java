package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {
    public LibraryLoginPage(){
        PageFactory.initElements(Driver.getDriver(),  this);
    }


    @FindBy(css = "input#inputEmail")
    public WebElement emailInput;

    @FindBy(css = "input#inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement singInButton;

    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement dashBoard;



    public  void clickSignInButton(){
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
        libraryLoginPage.singInButton.click();
    }
}

