package pages;

import dto.UserDtoLombok;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        //element budet naiden togda kogda on budet nujen
    }

    @FindBy(id = "name")
    WebElement inputName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(id = "email")
    WebElement inputEmail;
    @FindBy(id = "password")
    WebElement inputPassword;
    @FindBy(xpath = "//label[@for='terms-of-use']")
    WebElement checkBox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;
    @FindBy(xpath = "//h2[@class='message']")
    WebElement popUpMessage;


    public void typeRegistrationForm(UserDtoLombok user) {
        inputName.sendKeys(user.getName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());

    }

    public void clickCheckBox() {
        // checkBox.click();
        System.out.println(checkBox.getRect().getWidth() + "x" + checkBox.getRect().getHeight());
        //raspechataem razmer elementa
        int widthCheckBox = checkBox.getRect().getWidth();
        int heightCheckBox = checkBox.getRect().getHeight();
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBox, -widthCheckBox / 3, -heightCheckBox / 4)
                .click().perform();

    }

    public void clickBtnYalla() {
        btnYalla.click();
    }

    public boolean isPopUpMessagePresent() {
        return istextInElementPresent(popUpMessage, "You are logged in success");
    }
}
