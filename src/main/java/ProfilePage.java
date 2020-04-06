import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private By mySettings = By.xpath("//div[@id='hook_Block_MainContainer']//li[3]//a[1]//div[1]");

    public void clickMySettings() {
        driver.findElement(mySettings).click();
        new SettingPage(driver);
    }
}
