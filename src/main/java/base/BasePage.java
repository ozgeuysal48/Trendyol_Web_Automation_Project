
package base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage {

   public WebDriver driver  = null;
   WebElement       element = null;

   String           expected;
   String           actual;

   public ChromeOptions disableNotifications() {
      Map<String, Object> prefs = new HashMap<String, Object>();
      prefs.put("profile.default_content_setting_values.notifications", 2);
      ChromeOptions options = new ChromeOptions();
      return options.setExperimentalOption("prefs", prefs);
   }

   public void openHomePage(String url) {
      System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
      
      driver = new ChromeDriver(disableNotifications());
      driver.manage().window().maximize();
      driver.get(url);

      driver.findElement(By.id("Group-38")).click(); // close the pop-up on the home page.
   }

   public void clickByLocator(String locator, String locVal) {
      try {
         switch (locator) {
            case "className" :
               Thread.sleep(3000);
               element = driver.findElement(By.className(locVal));
               element.click();
               break;
            case "cssSelector" :
               Thread.sleep(3000);
               element = driver.findElement(By.cssSelector(locVal));
               element.click();
               break;
            case "xpath" :
               Thread.sleep(3000);
               element = driver.findElement(By.xpath(locVal));
               element.click();
               break;
            case "id" :
               Thread.sleep(3000);
               element = driver.findElement(By.id(locVal));
               element.click();
               break;
         }
      }
      catch (Exception e) {
         System.out.println(e.getStackTrace());
      }
   }

   public void sendKeysByLocator(String locator, String locVal, String keys) {
      try {
         switch (locator) {
            case "className" :
               Thread.sleep(3000);
               element = driver.findElement(By.className(locVal));
               element.sendKeys(keys);
               break;
            case "cssSelector" :
               Thread.sleep(3000);
               element = driver.findElement(By.cssSelector(locVal));
               element.sendKeys(keys);
               break;
            case "xpath" :
               Thread.sleep(3000);
               element = driver.findElement(By.xpath(locVal));
               element.sendKeys(keys);
               break;
            case "id" :
               Thread.sleep(3000);
               element = driver.findElement(By.id(locVal));
               element.sendKeys(keys);
               break;
         }
      }
      catch (Exception e) {
         System.out.println(e.getStackTrace());
      }
   }

   public String getExpected() {
      return expected;
   }

   public String getActual() {
      return actual;
   }

   public void setExpected() throws InterruptedException {
      Thread.sleep(2000);
      this.expected = driver.findElement(By.className("pb-item")).getAttribute("title");
   }

   public void setActual() {
      String brand = driver.findElement(By.cssSelector(".prdct-desc-cntnr-ttl")).getText();
      this.actual = brand + " " + driver.findElement(By.cssSelector(".prdct-desc-cntnr-name.hasRatings")).getText();
   }

   public void checkBasket() throws InterruptedException {
      Thread.sleep(2000);
      String basket = driver.findElement(By.className("pb-empty-basket")).getAttribute("innerText");
      Assert.assertTrue(basket.contains("Sepetinde ürün bulunmamaktadır."));
      driver.quit();
   }
   
   public void switch2NextPage() {
      String currentTab = driver.getWindowHandle();
      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
      int index = tabs.indexOf(currentTab);
      driver.switchTo().window((String) tabs.get(index + 1)); // switch to next page
   }
}
