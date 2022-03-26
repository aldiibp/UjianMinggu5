package com.juaracoding.ujianminggu5.step_definition;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.ujianminggu5.config.AutomationFrameworkConfig;
import com.juaracoding.ujianminggu5.driver.DriverSingleton;
import com.juaracoding.ujianminggu5.pages.HotelsPage;
import com.juaracoding.ujianminggu5.pages.LoginPage;
import com.juaracoding.ujianminggu5.utils.ConfigurationProperties;
import com.juaracoding.ujianminggu5.utils.Constants;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;


@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class TestHotels {

	private WebDriver driver;
	private LoginPage loginPage;
	private HotelsPage hotelPage;
	
	@Autowired
	ConfigurationProperties configProperties;
	
	@Before
	public void initializeObject() {
		DriverSingleton.getInstance(configProperties.getBrowser());
		loginPage = new LoginPage();
		hotelPage = new HotelsPage();
		
	}
	
	@When("Customer klik menu Hotels")
	public void goToMenuHotel() {
		loginPage.inputEmailPassword(configProperties.getEmail(), configProperties.getPassword());
    	loginPage.submitLogin();
    	DriverSingleton.Wait();
		
		hotelPage.goToMenuHotels();
	}
	
    @When("Customer memilih hotel")
    public void SearchHotel() {
    	DriverSingleton.Wait();
    	hotelPage.selectHotels();
    }
    
    @When("Customer klik Booking Now")
    public void Booking() {
    	DriverSingleton.Wait();
    	hotelPage.goToBookingNow();
    }
    
    @When("Customer input Identitas and Payment Method")
    public void inputIdentitasPayment() {
    	hotelPage.submitBooking(configProperties.getNationality(), configProperties.getFirstName1(), 
    			configProperties.getLastName1(), configProperties.getFirstName2(), configProperties.getLastName2());
    }
    
    @Then("Customer berhasil Booking Hotel")
	public void berhasilBooking() {
    	driver.navigate().refresh();
    }
	
}
