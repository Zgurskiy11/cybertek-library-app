package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class CommonElementsPage {
public CommonElementsPage(){
   PageFactory.initElements(Driver.getDriver(),  this);
}
   @FindBy(xpath = "//span[.='Users']")
   public WebElement usersLink;

}
