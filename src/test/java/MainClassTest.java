import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClassTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private SettingPage settingPage;
    private PersonalDataPage personalDataPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/user/IdeaProjects/ChangingPersonalData/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://ok.ru/");
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        settingPage = new SettingPage(driver);
        personalDataPage = new PersonalDataPage(driver);
    }

    @Test
    public void SuccessChangeOfPersonalData() {

        // Изменяем значения во всех возможных полях (Фамилия, Имя, Пол, Дата Рождения, Город проживания, Родной город)
        loginPage.typeLogin("79998071041", "qazwsx123");
        profilePage.clickMySettings();
        settingPage.clickPersonalData();
        personalDataPage.clearNameField();
        personalDataPage.clearSurnameField();
        personalDataPage.typeNameField("Иван");
        personalDataPage.typeSurnameField("Иванов");
        personalDataPage.selectGenderMan();
        personalDataPage.selectBDay("12");
        personalDataPage.selectBYear("1995");
        personalDataPage.typeCurrentCity("Стокгольм");
        personalDataPage.typeHometown("Владивосток");
        personalDataPage.clickSaveButton();

//        String successChange = personalDataPage.getSuccessText();
//        Assert.assertEquals("Ваши изменения сохранены.", successChange);
//        personalDataPage.clickCloseButton();

        String errorChange = personalDataPage.getErrorText();
        Assert.assertEquals("Увы, часто менять имя в ОК нельзя. Попробуйте, пожалуйста, через сутки.", errorChange);
        personalDataPage.clickCloseButton();
    }

    @Test
    public void RepeatedChangeOfNamePerDay() {

        // Повторное изменение имени в течении суток
        loginPage.typeLogin();
        profilePage.clickMySettings();
        settingPage.clickPersonalData();
        personalDataPage.clearNameField();
        personalDataPage.typeNameField("Петя");
        personalDataPage.clickSaveButton();

        String errorChange = personalDataPage.getErrorText();
        Assert.assertEquals("Увы, часто менять имя в ОК нельзя. Попробуйте, пожалуйста, через сутки.", errorChange);
        personalDataPage.clickCloseButton();
    }

    @Test
    public void RepeatedChangeOfSurnamePerDay() {

        // Повторное изменение фамилии в течении суток
        loginPage.typeLogin("79998071041", "qazwsx123");
        profilePage.clickMySettings();
        settingPage.clickPersonalData();
        personalDataPage.clearSurnameField();
        personalDataPage.typeSurnameField("Чапаев");
        personalDataPage.clickSaveButton();

        String errorChange = personalDataPage.getErrorText();
        Assert.assertEquals("Увы, часто менять имя в ОК нельзя. Попробуйте, пожалуйста, через сутки.", errorChange);
        personalDataPage.clickCloseButton();
    }

    @Test
    public void CheckDisplayErrorIfEmptyName() {

        //Отображение ошибки когда поле Имя пустое
        loginPage.typeLogin("79998071041", "qazwsx123");
        profilePage.clickMySettings();
        settingPage.clickPersonalData();
        personalDataPage.clearNameField();
        personalDataPage.clickSaveButton();

        String errorName = personalDataPage.getErrorNameText();
        Assert.assertEquals("Пожалуйста, укажите ваше имя.", errorName);
    }

    @Test
    public void CheckDisplayErrorIfEmptySurname() {

        //Отображение ошибки когда поле Фамилия пустое
        loginPage.typeLogin("79998071041", "qazwsx123");
        profilePage.clickMySettings();
        settingPage.clickPersonalData();
        personalDataPage.clearSurnameField();
        personalDataPage.clickSaveButton();

        String errorSurname = personalDataPage.getErrorSurnameText();
        Assert.assertEquals("Пожалуйста, укажите вашу фамилию.", errorSurname);
    }

    @Test
    public void CheckDisplayErrorIfInvalidDate() {

        //Отображение ошибки когда некорректно заполнена Дата Рождения
        loginPage.typeLogin("79998071041", "qazwsx123");
        profilePage.clickMySettings();
        settingPage.clickPersonalData();
        personalDataPage.selectBDay("29");
        personalDataPage.selectBYear("1994");
        personalDataPage.clickSaveButton();

        String errorBirthday = personalDataPage.getErrorBirthdayText();
        Assert.assertEquals("День вашего рождения указан некорректно.", errorBirthday);
    }

    @Test
    public void CheckDisplayErrorIfEmptyCurrentCity() {

        //Отображение ошибки когда город проживания пустой
        loginPage.typeLogin("79998071041", "qazwsx123");
        profilePage.clickMySettings();
        settingPage.clickPersonalData();
        personalDataPage.clearCurrentCity();
        personalDataPage.clickSaveButton();

        String errorCurrentCity = personalDataPage.getErrorCurrentCityText();
        Assert.assertEquals("Пожалуйста, выберите место проживания из списка", errorCurrentCity);
    }

    @Test
    public void ChangePersonalDataIfEmptyHometown() {

        //В случае, если не заполнено поле Родной город, сохраненин отрабатывает без ошибок
        loginPage.typeLogin("79998071041", "qazwsx123");
        profilePage.clickMySettings();
        settingPage.clickPersonalData();
        personalDataPage.clearHometown();
        personalDataPage.clickSaveButton();

        String successChange = personalDataPage.getSuccessText();
        Assert.assertEquals("Ваши изменения сохранены.", successChange);
        personalDataPage.clickCloseButton();
    }

    @Test
    public void ChangeGender() {

        //Изменение значения чекбокса Пол
        loginPage.typeLogin("79998071041", "qazwsx123");
        profilePage.clickMySettings();
        settingPage.clickPersonalData();
        personalDataPage.selectGenderWoman();
        personalDataPage.clickSaveButton();

        String successChange = personalDataPage.getSuccessText();
        Assert.assertEquals("Ваши изменения сохранены.", successChange);
        personalDataPage.clickCloseButton();
    }

    @Test
    public void CancelChangeOfPersonalData() {

        //Корректное изменение данных, отмена сохранения
        loginPage.typeLogin("79998071041", "qazwsx123");
        profilePage.clickMySettings();
        settingPage.clickPersonalData();
        personalDataPage.clearNameField();
        personalDataPage.clearSurnameField();
        personalDataPage.typeNameField("Иван");
        personalDataPage.typeSurnameField("Иванов");
        personalDataPage.selectGenderMan();
        personalDataPage.selectBDay("12");
        personalDataPage.selectBYear("1995");
        personalDataPage.typeCurrentCity("Стокгольм");
        personalDataPage.typeHometown("Владивосток");
        personalDataPage.clickCancelButton();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
