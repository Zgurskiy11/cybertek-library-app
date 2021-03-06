package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage extends CommonElementsPage {
    public LandingPage(){
        PageFactory.initElements(Driver.getDriver(),  this);
    }

    @FindBy(id = "user_count")
    public WebElement userCount;


    @FindBy(xpath = "//select[@name='tbl_users_length']")
    public WebElement recordsDropdown;

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> columnsNames;



}
