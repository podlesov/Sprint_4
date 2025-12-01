import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;

import static constant.Url.SCOOTERO_ORDER_URL;

public class BaseTest {

    MainPage mainPage;
    OrderFormFirst orderFormFirst;
    OrderFormSecond orderFormSecond;
    OrderComleted orderCompleted;
    OrderFormFinish orderFormFinish;

    WebDriver driver;
    public WebDriverWait wait;

     By cookieButtonLocator = By.id("rcc-confirm-button");

    @Before
    public void setUp() {
     // /*     Устанавливанм драйвер для Chrome
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--start-maximized");
        // Закомментируйте следующую строку с --headless, если хотите видеть выполнение теста в браузере
        // options.addArguments("--headless");

        driver = new ChromeDriver(options);

    //  */
       /*  Устанавливаем драйвер для Firefox
        WebDriverManager.firefoxdriver().setup();

        // Настройки Firefox
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--start-maximized");
        // Закоментипруй следующую строку, если хотите видеть браузер
        // options.addArguments("--headless");

        // Создаём экземпляр FirefoxDriver
        driver = new FirefoxDriver(options);
     // */
        mainPage = new MainPage(driver);
        orderFormFirst = new OrderFormFirst(driver);
        orderFormSecond = new OrderFormSecond(driver);
        orderCompleted = new OrderComleted(driver);
        orderFormFinish = new OrderFormFinish(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(SCOOTERO_ORDER_URL);
        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(cookieButtonLocator));
        cookieButton.click();










    }




    // /*
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // */
}
