package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderFormFinish {

    WebDriver driver;
    public WebDriverWait wait;

    By confirmButton = By.xpath(".//button[text()='Да']");



    public OrderFormFinish(WebDriver driver) {

         this.driver = driver;
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


     public void ClickYesOnFinishForm () {
          WebElement confirmBtn = wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
          confirmBtn.click();
          System.out.println("✅ Нажата кнопка подтверждения 'Да' на финишной форме");
     }

}
