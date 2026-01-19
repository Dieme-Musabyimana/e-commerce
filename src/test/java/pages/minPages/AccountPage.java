package pages.minPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver){
        super(driver);

    }
    public void load(String url){
        driver.get(url);
    }

    @FindBy(id = "reg_username") private WebElement usernameRegField;
    @FindBy(id = "reg_email") private WebElement emailRegField;
    @FindBy(id = "reg_password") private WebElement passwordRegField;
    @FindBy(name = "register") private WebElement registerButton;
    @FindBy(css= ".woocommerce-error") private WebElement errorMessage;
    @FindBy(linkText = "Dashboard") private WebElement dasdboardLinkText;

    @FindBy(id = "username") private WebElement usernameLoginField;
    @FindBy(id = "password") private WebElement passwordLoginField;
    @FindBy(name = "login") private WebElement loginButton;
    @FindBy(id = "rememberme") private WebElement rememberMeBox;


    public void enterRegistrationDetails(String username, String email, String password) {
        WebElement nameRegFld = wait.until(ExpectedConditions.visibilityOf(usernameRegField));
        nameRegFld.clear();
        nameRegFld.sendKeys(username);

        WebElement emailRegFld = wait.until(ExpectedConditions.visibilityOf(emailRegField));
        emailRegFld.clear();
        emailRegFld.sendKeys(email);

        WebElement passwordRegFld = wait.until(ExpectedConditions.visibilityOf(passwordRegField));
        passwordRegFld.clear();
        passwordRegFld.sendKeys(password);

}

    public void enterUniqueRegistrationDetails(String username, String email, String password) {
        String uniqueID = String.valueOf(System.currentTimeMillis());
        String dynamicUsername = username + uniqueID;
        String[] emailParts = email.split("@");
        String dynamicEmail = emailParts[0] + uniqueID + "@" + emailParts[1];

        enterRegistrationDetails(dynamicUsername, dynamicEmail, password);

    }
public void clickRegisterButton(){
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
}
public String getDashboardText(){
      return  wait.until(ExpectedConditions.visibilityOf(dasdboardLinkText)).getText();

}
public String getErrorMessage(){
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
}

public void enterLoginCredentials(String username, String password){
        WebElement usernameLoginFld = wait.until(ExpectedConditions.visibilityOf(usernameLoginField));
        usernameLoginFld.clear();
        usernameLoginFld.sendKeys(username);

        WebElement passwordLoginFld = wait.until(ExpectedConditions.visibilityOf(passwordLoginField));
        passwordLoginFld.clear();
        passwordLoginFld.sendKeys(password);
}
public void clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
}

}
