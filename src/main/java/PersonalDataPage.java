import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PersonalDataPage {
    private WebDriver driver;

    public PersonalDataPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameField = By.xpath("//input[@id='field_name']");
    private By surnameField = By.xpath("//input[@id='field_surname']");

    private By bdayField = By.xpath("//select[@id='field_bday']");
    private By bmonthField = By.xpath("//select[@id='field_bmonth']");
    private By byearField = By.xpath("//select[@id='field_byear']");

    private By currentCity = By.xpath("//input[@id='field_citySugg_SearchInput']");
    private By hometown = By.xpath("//input[@id='field_cityBSugg_SearchInput']");

    private By genderMan = By.xpath("//input[@id='field_gender_1']");
    private By genderWoman = By.xpath("//input[@id='field_gender_2']");

    private By saveButton = By.xpath("//input[@id='hook_FormButton_button_savePopLayerEditUserProfileNew']");
    private By cancelButton = By.xpath("//input[@id='hook_FormButton_button_cancelPopLayerEditUserProfileNew']");
    private By closeButton = By.xpath("//input[@id='buttonId_button_close']");

    private By errorMessage = By.xpath("//div[@id='notifyPanel_msg']");
    private By errorNameMessage = By.xpath("//span[@class='input-e'][contains(text(),'имя')]");
    private By errorSurnameMessage = By.xpath("//span[@class='input-e'][contains(text(),'фамилию')]");
    private By errorBirthdayMessage = By.xpath("//span[@class='input-e'][contains(text(),'некорректно')]");
    private By errorCurrentCity = By.xpath("//span[@class='input-e'][contains(text(),'списка')]");
    private By successMessage = By.xpath("//div[@id='notifyPanel_msg']");

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
        new SettingPage(driver);
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
        new SettingPage(driver);
    }

    public void clearNameField() {
        driver.findElement(nameField).clear();
    }

    public void clearSurnameField() {
        driver.findElement(surnameField).clear();
    }

    public void typeNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void typeSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void selectGenderMan() {
        driver.findElement(genderMan).click();
    }

    public void selectGenderWoman() {
        driver.findElement(genderWoman).click();
    }

    public void selectBDay(String birthday) {
        Select bday = new Select(driver.findElement(bdayField));
        bday.selectByValue(birthday);
    }

    public PersonalDataPage selectBMonth(String month) {
        Select bmonth = new Select(driver.findElement(bmonthField));
        bmonth.selectByValue(month);
        return this;
    }

    public void selectBYear(String year) {
        Select byear = new Select(driver.findElement(byearField));
        byear.selectByValue(year);
    }

    public void typeCurrentCity(String currCity) {
        driver.findElement(currentCity).clear();
        driver.findElement(currentCity).sendKeys(currCity);
        driver.findElement(By.xpath("//li[@id='citySugg_InputContainer_10395291679']//div[@class='ellip']")).click();
    }

    public void clearCurrentCity() {
        driver.findElement(currentCity).clear();
    }

    public void typeHometown(String htown) {
        driver.findElement(hometown).clear();
        driver.findElement(hometown).sendKeys(htown);
        driver.findElement(By.xpath("//li[@id='cityBSugg_InputContainer_10393255457']//div[@class='ellip']")).click();
    }

    public void clearHometown() {
        driver.findElement(hometown).clear();
    }

    public String getErrorText() {
        return driver.findElement(errorMessage).getText();
    }

    public String getSuccessText() {
        return driver.findElement(successMessage).getText();
    }

    public String getErrorNameText() {
        return driver.findElement(errorNameMessage).getText();
    }

    public String getErrorSurnameText() {
        return driver.findElement(errorSurnameMessage).getText();
    }

    public String getErrorBirthdayText() {
        return driver.findElement(errorBirthdayMessage).getText();
    }

    public String getErrorCurrentCityText() {
        return driver.findElement(errorCurrentCity).getText();
    }

    public void clickCloseButton() {
        driver.findElement(closeButton).click();
    }
}
