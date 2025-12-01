package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderFormSecond {

    WebDriver driver;
    public WebDriverWait wait;

    public OrderFormSecond(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //By dateField = By.className("Input_Input__1iN_Z Input_Responsible__1jDKN react-datepicker-ignore-onclickoutside");
    By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //By periodField =
    By periodField = By.className("Dropdown-control");
    //By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");
    By blackColor = By.id("black");
    By greyColor = By.id("grey");
    By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    By finalOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");




    public void enterDataToSecondForm(String orderDate, String orderPeriod, String orderScooterColor ,String orderComment) {

        // Дата заказа

        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(dateField));
        dateInput.sendKeys(orderDate);
        dateInput.sendKeys(Keys.ENTER);

        // Срок аренды
        WebElement periodDropdown = driver.findElement(periodField);
        periodDropdown.click();
        System.out.println("✅ выпадающее меню 'Срок аренды'открыто");
        By periodOption = By.xpath(".//div[text()='" + orderPeriod + "']");
        WebElement periodItem = wait.until(ExpectedConditions.elementToBeClickable(periodOption));
        periodItem.click();
        System.out.println("✅ Выбор периода выполнен");

        // Цвет самоката
        if ("black".equals(orderScooterColor)) {
            WebElement blackColorBtn = wait.until(ExpectedConditions.elementToBeClickable(blackColor));
            blackColorBtn.click();
            System.out.println("✅ выбран цвет самоката: чёрный");
        }
        else if ("grey".equals(orderScooterColor)) {
            WebElement greyColorBtn = wait.until(ExpectedConditions.elementToBeClickable(greyColor));
            greyColorBtn.click();
            System.out.println("✅ выбран цвет самоката: серый");
        }

        // Комментарий
        if (orderComment != null && !orderComment.isEmpty()) {
            driver.findElement(commentField).sendKeys(orderComment);
        }

        // Кнопка "Заказать" на второй странице
        WebElement finalBtn = wait.until(ExpectedConditions.elementToBeClickable(finalOrderButton));
        finalBtn.click();
        System.out.println("✅ нажата финальная кнопка 'Заказать'");
    }



}
