package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderFormFirst {
    WebDriver driver;
    public WebDriverWait wait;

    public OrderFormFirst(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Локаторы для заполнения первой формы
    By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    By metroOptions = By.cssSelector(".select-search__select");
    By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");

    public void enterDataToFormFirst(String customerFirstName, String customerLastName, String customerAdress, String customerPhoneNumber, String metroStation) {


            // Заполняем первую форму ззаказа
            wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(customerFirstName);
            driver.findElement(lastNameField).sendKeys(customerLastName);
            driver.findElement(addressField).sendKeys(customerAdress);
            driver.findElement(phoneField).sendKeys(customerPhoneNumber);
            driver.findElement(metroField).sendKeys(metroStation);

            // Ждём и кликаем по станции метро
        WebElement metroOption = wait.until(ExpectedConditions.elementToBeClickable(metroOptions));
        metroOption.click();
        System.out.println("✅ Клик по полю 'Станция метро' выполнен");

            // Кнопка "Далее"
        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextBtn.click();
        System.out.println("✅ Клик по кнопке 'Далее' выполнен");


    }



}
