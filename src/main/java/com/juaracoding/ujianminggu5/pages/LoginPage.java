package com.juaracoding.ujianminggu5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.ujianminggu5.driver.DriverSingleton;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "cookie_stop")
	WebElement btnGotIt;
	
	@FindBy(name = "email")
	WebElement inputEmail;
	
	@FindBy(name = "password")
	WebElement inputPassword;
	
	@FindBy(name = "email")
	WebElement inputEmail2;
	
	@FindBy(name = "password")
	WebElement inputPassword2;
	
	@FindBy(xpath = "//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button")
	WebElement btnLogin;
	
	@FindBy(css = "#fadein > div.sidebar-nav > div > div.sidebar-menu-wrap > ul > li:nth-child(5) > a")
	WebElement btnLogout;
	
	@FindBy(className = "message")
	WebElement txtMessage;
	
	
	public void inputEmailPassword(String email, String password) {
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
	}
	
	public void inputEmailPasswordWrong(String email2, String password2) {
		btnGotIt.click();
		inputEmail.sendKeys(email2);
		inputPassword.sendKeys(password2);
	}
	
	public void submitLogin() {
		btnLogin.click();
	}
	
	public void logout() {
		btnLogout.click();
	}
	
	public String txtMessages() {
		return txtMessage.getText();
	}

}
