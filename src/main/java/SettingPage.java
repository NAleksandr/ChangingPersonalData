import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingPage {
    private WebDriver driver;

    public SettingPage(WebDriver driver) {
        this.driver = driver;
    }

    private By personalData = By.xpath("//div[@class='user-settings_i_tx textWrap']");

    public void clickPersonalData() {
        driver.findElement(personalData).click();
        new PersonalDataPage(driver);
    }
}
