Feature: Trendyol
  @shopping
  Scenario: Basket check
    Given open Trendyol homepage
    When type masa üstü bilgisayar on the search box and click to search button
    And Select one product
    Then click to Sepete Ekle button
    And click to Sepetim
    And verify that the selected product is correct in the basket
    And click to Çöp Sepeti button
    And click to Sil button on the Pop-Up
    And go to Sepetim
    And check that there is not any product in the basket.

