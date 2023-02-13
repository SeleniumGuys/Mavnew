package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory or Object Repository
    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(className = "oxd-button oxd-button--medium oxd-button--main orangehrm-login-button")
    WebElement loginButton;

    @FindBy(className = "oxd-text oxd-text--p orangehrm-login-forgot-header")
    WebElement forgotPassword;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img")
    WebElement companyLogo;


    //initializing objects
    public LoginPage(){
        PageFactory.initElements(driver,this);
        //here "this" refers to all objects in this current class.
        // PageFactory.initElements(driver,LoginPage.class); --> this can also be used instead of "this" keyword
    }

    //Actions

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateCompanyLogo(){
        return companyLogo.isDisplayed();
    }

    public DashboardPage login(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd );
        loginButton.click();
        return new DashboardPage();
        //when you login to this application it should navigate you to dashboard.
        // So we created a method that return us Dashboard Page object.


    }



}
