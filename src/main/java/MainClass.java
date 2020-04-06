//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.PageFactory;
//
//import java.util.concurrent.TimeUnit;
//
//public class MainClass {
//
//    static WebDriver driver;
//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "/Users/user/IdeaProjects/ChangingPersonalData/drivers/chromedriver");
//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//
//        driver.get("https://ok.ru/");
//
//        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
//        ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
//        SettingPage settingPage = PageFactory.initElements(driver, SettingPage.class);
//        PersonalDataPage personalDataPage = PageFactory.initElements(driver, PersonalDataPage.class);
//
//        loginPage.typeLoginField("79998071041");
//        loginPage.typePasswordField("jbLWrXSs1");
//        loginPage.clickSignIn();
//
//        profilePage.clickMySettings();
//
//        settingPage.clickPersonalData();
//
//        personalDataPage.typeNameField("Иван");
//        personalDataPage.typeSurnameField("Иванов");
//        personalDataPage.clickSaveButton();
//
//        driver.quit();
//    }
//}
