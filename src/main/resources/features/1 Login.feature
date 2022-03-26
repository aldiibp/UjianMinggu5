Feature: Customer Login to PHP Travels
	
	@loginValid
  Scenario: Testing Login Customer Valid
    Given Customer mengakses url
    When Customer input email dan password
    Then Customer berhasil login
    
	@LoginInvalid
	Scenario: Testing Login Customer Invalid
		When Customer input email dan password yang salah
		Then Customer tidak berhasil login