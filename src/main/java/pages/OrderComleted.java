package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderComleted {

    WebDriver driver;
    public WebDriverWait wait;

    By successMessage = By.xpath(".//div[contains(text(), 'Заказ оформлен')]");

    public OrderComleted(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void orderCompleteMessage(String customerFirstName, String customerLastName) {

       wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
       System.out.println("✅ Заказ для " + customerFirstName + " " + customerLastName + " успешно оформлен!\n");
    }
}
