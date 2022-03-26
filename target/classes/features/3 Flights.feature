Feature: Customer Memesan Pesawat pada Fitur Menu Flights
  Scenario: Testing Menu Flights
    When Customer klik menu Flights
    And Customer memilih Penerbangan
    And Customer klik Booking Now
    And Customer input Identitas and Payment Method
    Then Customer berhasil Booking Penerbangan