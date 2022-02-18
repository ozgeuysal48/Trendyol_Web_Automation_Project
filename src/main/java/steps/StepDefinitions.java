
package steps;

import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import org.junit.Assert;

public class StepDefinitions extends BasePage {
   String url       = "https://www.trendyol.com";
   String searchKey = "Masaüstü bilgisayar";

   @Given("open Trendyol homepage")
   public void openTheHomepage() {
      openHomePage(url);
   }

   @When("type masa üstü bilgisayar on the search box and click to search button")
   public void typeTextAndEnter() throws InterruptedException {
      sendKeysByLocator("className", "search-box", searchKey);
      clickByLocator("className", "search-icon");
   }

   @And("Select one product")
   public void selectOneProduct() throws InterruptedException {
      setActual();
      System.out.println("Selected product name: " + getActual());
      clickByLocator("className", "prdct-desc-cntnr-ttl");
   }

   @Then("click to Sepete Ekle button")
   public void clickToSepeteEkleButton() throws InterruptedException {
      switch2NextPage();
      clickByLocator("className", "add-to-basket-button-text");
   }

   @And("click to Sepetim")
   public void clickToSepetim() throws InterruptedException {
      clickByLocator("className", "goBasket");
   }

   @And("verify that the selected product is correct in the basket")
   public void verifyThatTheSelectedProductIsCorrectInTheBasket() throws InterruptedException {
      setExpected();
      System.out.println("Product name in the basket: " + getExpected());
      Assert.assertEquals(getActual(), getExpected());
   }

   @And("click to Çöp Sepeti button")
   public void clickToCopSepetiButton() throws InterruptedException {
      clickByLocator("className", "i-trash");
   }

   @And("click to Sil button on the Pop-Up")
   public void clickToSilButtonOnThePopUp() throws InterruptedException {
      clickByLocator("xpath", "//*[contains (text(),'Sil')]");
   }

   @And("go to Sepetim")
   public void goToSepetim() throws InterruptedException {
      clickByLocator("xpath", "//a[contains(@href,'/sepet')]");
   }

   @And("check that there is not any product in the basket.")
   public void checkThatThereIsNotAnyProductInTheBasket() throws InterruptedException {
      checkBasket();
   }
}
