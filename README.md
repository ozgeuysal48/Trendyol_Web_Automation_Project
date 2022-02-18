# Trendyol_Web_Automation_Project



Steps output:
Given open Trendyol homepage                                                # steps.StepDefinitions.openTheHomepage()

  When type masa üstü bilgisayar on the search box and click to search button # steps.StepDefinitions.typeTextAndEnter()
  
Selected product name: Zeiron Intel I5-650 I5-650 3,46ghz 8gb 500gb 18,5'' Masaüstü Takım

  And Select one product                                                      # steps.StepDefinitions.selectOneProduct()
  
  Then click to Sepete Ekle button                                            # steps.StepDefinitions.clickToSepeteEkleButton()
  
  And click to Sepetim                                                        # steps.StepDefinitions.clickToSepetim()
  
Product name in the basket: Zeiron Intel I5-650 I5-650 3,46ghz 8gb 500gb 18,5'' Masaüstü Takım

  And verify that the selected product is correct in the basket               # steps.StepDefinitions.verifyThatTheSelectedProductIsCorrectInTheBasket()
  
  And click to Çöp Sepeti button                                              # steps.StepDefinitions.clickToCopSepetiButton()
  
  And click to Sil button on the Pop-Up                                       # steps.StepDefinitions.clickToSilButtonOnThePopUp()
  
  And go to Sepetim                                                           # steps.StepDefinitions.goToSepetim()
  
  And check that there is not any product in the basket.                      # steps.StepDefinitions.checkThatThereIsNotAnyProductInTheBasket()
  
