package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderComleted {

    WebDriver driver;
    public WebDriverWait wait;

    By successMessage = By.className("Order_ModalHeader__3FDaJ");

    public OrderComleted(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void orderCompleteMessage(String customerFirstName, String customerLastName) {

        WebElement successOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));

        String actualMessegeText = successOrder.getText();
        Assert.assertTrue( " ⚠️ Оформление заказа не было завершено", actualMessegeText.contains("Заказ оформлен"));
        System.out.println("✅ Заказ для " + customerFirstName + " " + customerLastName + " успешно оформлен!\n");
    }
}