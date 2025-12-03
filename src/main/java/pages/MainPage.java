package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;
    public WebDriverWait wait;

    // Локаторы кнопок "заказать" для OrderScooterTest

    By startOrderButtonTop = By.className("Button_Button__ra12g");
    By startOrderButtonMiddle = By.xpath("(//button[text()='Заказать'])[2]");

    public MainPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickQuestion(int index) {

        By questionLocator = By.id("accordion__heading-" + index);

        WebElement questionByIndex = wait.until(ExpectedConditions.elementToBeClickable(questionLocator));

        // Прокручиваем страницу так, чтобы элемент оказался в видимой области

        // Прокручиваем к элементу
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", questionByIndex);

        // Кликаем по вопросу
        try {
            questionByIndex.click();
            System.out.println("✅ Успешно кликнули на  вопрос ");
            return;
        } catch (Exception e) {
            System.out.println("⚠️ Клик на вопрос не удался");
        }

    }

    public void verificateAnswer(int index, String otvet){

        By answerLocator = By.id("accordion__panel-" + index);
        WebElement answerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
        String actualAnswer = answerElement.getText();
        Assert.assertEquals("Ответ для вопроса №" + (index) + " не совпадает", otvet, actualAnswer);
        System.out.println("Правильный ответ: " + otvet);
        System.out.println("Текст на странице: " + actualAnswer);
    }
    public void clickOrderBtn(boolean choiceBtnTop) {
        if (choiceBtnTop) {

            WebElement orderBtn = wait.until(ExpectedConditions.elementToBeClickable(startOrderButtonTop));
            orderBtn.click();
            System.out.println("✅ Клик по кнопке 'Заказать' (верхняя) выполнен");
        } else {
            WebElement orderBtn = wait.until(ExpectedConditions.elementToBeClickable(startOrderButtonMiddle));
            orderBtn.click();
            System.out.println("✅ Клик по кнопке 'Заказать' (нижняя) выполнен");

        }
    }
}