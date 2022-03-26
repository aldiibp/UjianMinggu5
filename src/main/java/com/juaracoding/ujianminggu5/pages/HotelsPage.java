package com.juaracoding.ujianminggu5.pages;


import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.ujianminggu5.driver.DriverSingleton;

public class HotelsPage {

	private WebDriver driver;
	
	public HotelsPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"fadein\"]/header/div[2]/div/div/div/div/div[2]/nav/ul/li[2]/a")
	WebElement menuHotels;
	
	@FindBy(xpath = "//*[@id=\"fadein\"]/section[2]/div/div[2]/div/div/div/div[1]/div/div[8]/div/div[1]/a")
	WebElement selectHotel;
	
	@FindBy(xpath = "//*[@id=\"single-content-nav\"]/ul/li[2]/a")
	WebElement menuRooms;
	
	@FindBy(css = "#availability > div.single-content-item.padding-top-40px.padding-bottom-30px.rooms > div:nth-child(2) > div.card-body > div > div.col-md-9 > form > div > div.col-md-3.booked_40 > div > div > button")
	WebElement btnBookNow;
	
	@FindBy(name = "nationality")
	WebElement inputNationality;
	
	@FindBy(name = "firstname_1")
	WebElement inputFirstName1;
	
	@FindBy(name = "lastname_1")
	WebElement inputLastName1;
	
	@FindBy(name = "firstname_2")
	WebElement inputFirstName2;
	
	@FindBy(name = "lastname_2")
	WebElement inputLastName2;
	
	@FindBy(xpath = "//*[contains(@id,\"gateway\")]")
	List<WebElement> radPayment;
	
	@FindBy(css = "#fadein > div.booking_data > form > section > div > div > div.col-lg-8 > div:nth-child(4) > div > div > div > label")
	WebElement checklist;
	
	@FindBy(id = "booking")
	WebElement btnBooking;
	
	public void Scroll() {
	JavascriptExecutor je = (JavascriptExecutor) driver;
	je.executeScript("window.scrollBy(0,500)");
	}
	
	public void goToMenuHotels() {
		menuHotels.click();
	}
	
	public void selectHotels() {
		DriverSingleton.Wait();
		Scroll();
		selectHotel.click();
	}
	
	public void goToBookingNow() {
		DriverSingleton.Wait();
		menuRooms.click();
		btnBookNow.click();
	}
	
	public void submitBooking(String nationality, String firstName1, String lastName1, String firstName2, String lastName2 ) {
		inputNationality.sendKeys(nationality, Keys.ENTER);
		Scroll();
		inputFirstName1.sendKeys(firstName1);
		inputLastName1.sendKeys(lastName1);
		inputFirstName2.sendKeys(firstName2);
		inputLastName2.sendKeys(lastName2);
		Scroll();
		radPayment.get(2).click();
		checklist.click();
		btnBooking.click();
	}
	
	
}
