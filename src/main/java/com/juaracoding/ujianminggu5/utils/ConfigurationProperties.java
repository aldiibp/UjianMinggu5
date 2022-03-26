package com.juaracoding.ujianminggu5.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;
	
	@Value("${email}")
	private String email;
	
	@Value("${password}")
	private String password;

	@Value("${email2}")
	private String email2;
	
	@Value("${password2}")
	private String password2;
	
	@Value("${nationality}")
	private String nationality;
	
	@Value("${firstName1}")
	private String firstName1;
	
	@Value("${lastName1}")
	private String lastName1;
	
	@Value("${firstName2}")
	private String firstName2;
	
	@Value("${lastName2}")
	private String lastName2;
	
	//--------GET----------
	
	public String getBrowser() {
		return browser;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail2() {
		return email2;
	}

	public String getPassword2() {
		return password2;
	}

	public String getNationality() {
		return nationality;
	}

	public String getFirstName1() {
		return firstName1;
	}

	public String getLastName1() {
		return lastName1;
	}

	public String getFirstName2() {
		return firstName2;
	}

	public String getLastName2() {
		return lastName2;
	}

	
	

	
}
