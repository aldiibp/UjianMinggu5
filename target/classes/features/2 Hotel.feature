Feature: Customer Memesan Hotel pada Fitur Menu Hotelss
  Scenario: Testing Menu Hotels
    When Customer klik menu Hotels
    And Customer memilih hotel
    And Customer klik Booking Now
    And Customer input Identitas and Payment Method
    Then Customer berhasil Booking Hotel
    