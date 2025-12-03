
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;


@RunWith(Parameterized.class)
public class OrderScooterTest extends BaseTest {



    private final int index;
    private final boolean choiceBtnTop;
    private final String customerFirstName;
    private final String customerLastName;
    private final String customerAdress;
    private final String metroStation;
    private final String customerPhoneNumber;
    private final String orderDate;
    private final String orderPeriod;
    private final String orderScooterColor;
    private final String orderComment;

    // Конструктор
    public OrderScooterTest(int index, boolean choiceBtnTop, String customerFirstName, String customerLastName,
                            String customerAdress, String metroStation, String customerPhoneNumber,
                            String orderDate, String orderPeriod, String orderScooterColor, String orderComment) {
        this.index = index;
        this.choiceBtnTop = choiceBtnTop;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerAdress = customerAdress;
        this.metroStation = metroStation;
        this.customerPhoneNumber = customerPhoneNumber;
        this.orderDate = orderDate;
        this.orderPeriod = orderPeriod;
        this.orderScooterColor = orderScooterColor;
        this.orderComment = orderComment;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                {0, true,  "Александр", "Пушкин", "Москва, Пушкинская пл.", "Охотный Ряд", "+79090123456", "23", "сутки", "black", "Ух, прокачусь!"} ,
                {1, false, "Александр", "Блок", "Москва, улица Тверская, д. 3", "Арбатская", "+79090123456", "24", "сутки", "grey", "Карету мнеб, карету!"}/*,
                {2, true,  "Антон", "Чехов", "Москва, Старая Басманная ул., 16/18, стр. 1", "Курская", "+7 909 0123456", "23", "сутки", "black", "Не очень срочно"},
                {3, false, "Иван", "Тургенев", "Москва, Софийская набережная", "Октябрьская", "79090123456", "23", "сутки", "black", "Скорей бы лето"},
                {4, true,  "Лев", "Толстой", "Москва, Воздвиженка, 3/5", "Арбатская", "+79090123456", "01", "сутки", "black", "Смогу принять с 9 до 11"},
                {5, false, "Михаил", "Булгаков", "Москва, Большая Садовая ул., 10", "Менделеевская", "+79090123456", "30", "сутки", "grey", "Люблю чёрный жемчуг"},
                {6, true,  "Ernest", "Hemingway", "Москва", "Охотный Ряд", "+79090123456", "31", "сутки", "grey", "Urgently, please"},
                {7, false, "Федор", "Достоевский", "Москва, Сретенский бульвар", "Чистые пруды", "+79090123456", "03", "сутки", "black", "Я этого точно достоин А Толстому самоката не досталось!"}
        */
        };
    }
    @Test
    public void testOrderProcess() {
        System.out.println("Запуск теста #" + (index + 1) + ": " + customerFirstName + " " + customerLastName);


        // === Шаг 1: Выбор кнопки "Заказать" (верхняя или нижняя) ===
        mainPage.clickOrderBtn(choiceBtnTop);

        // === Шаг 2: Первая форма ===
        orderFormFirst.enterDataToFormFirst(customerFirstName, customerLastName, customerAdress, customerPhoneNumber, metroStation);

        // === Шаг 3: Вторая форма ===
        orderFormSecond.enterDataToSecondForm(orderDate, orderPeriod, orderScooterColor, orderComment);

        // === Шаг 4: Финишная Форма ===
        orderFormFinish.ClickYesOnFinishForm ();

        // === Шаг 5: Подтверждение успешного оформления заказа ===

        orderCompleted.orderCompleteMessage(customerFirstName, customerLastName);
    }



}
