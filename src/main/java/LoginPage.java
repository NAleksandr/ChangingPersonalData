import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath("//input[@id='field_email']");
    private By passwordField = By.xpath("//input[@id='field_password']");
    private By signInButton = By.xpath("//input[@class='button-pro __wide']");

    public void clickSignIn() {
        driver.findElement(signInButton).click();
        new ProfilePage(driver);
    }

    public void typeLoginField(String login) {
        driver.findElement(loginField).sendKeys(login);
    }

    public void typePasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void typeLogin(String login, String password) {
        this.typeLoginField(login);
        this.typePasswordField(password);
        this.clickSignIn();
        new ProfilePage(driver);
    }
}
