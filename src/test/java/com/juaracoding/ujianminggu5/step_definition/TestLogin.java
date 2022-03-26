package com.juaracoding.ujianminggu5.step_definition;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.ujianminggu5.config.AutomationFrameworkConfig;
import com.juaracoding.ujianminggu5.driver.DriverSingleton;
import com.juaracoding.ujianminggu5.pages.LoginPage;
import com.juaracoding.ujianminggu5.utils.ConfigurationProperties;
import com.juaracoding.ujianminggu5.utils.Constants;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class TestLogin {

	private WebDriver driver;
	private LoginPage loginPage;
	
	@Autowired
	ConfigurationProperties configProperties;
	
	@Before
	public void initializeObject() {
		DriverSingleton.getInstance(configProperties.getBrowser());
		loginPage = new LoginPage();
	}
	
	@Given("Customer mengakses url")
	public void aksesUrl() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
	}
	
    @When("Customer input email dan password")
    public void inputEmailPassword() {
    	loginPage.inputEmailPassword(configProperties.getEmail(), configProperties.getPassword());
    	loginPage.submitLogin();
    }
    
    @Then("Customer berhasil login")
    public void berhasilLogin() {
    	DriverSingleton.Wait();
    	loginPage.logout();
    }
    
    @When("Customer input email dan password yang salah")
    public void inputEmailPasswordSalah() {
    	DriverSingleton.Wait();
    	loginPage.inputEmailPasswordWrong(configProperties.getEmail2(), configProperties.getPassword2());
    	loginPage.submitLogin();
    }
	
	@Then("Customer tidak berhasil login")
    public void gagalLogin() {
		DriverSingleton.Wait();
		String expect = "Wrong";
		
		System.out.println(loginPage.txtMessages());
		assertThat(loginPage.txtMessages(), containsString(expect));
		
	}
    
    
    
}
