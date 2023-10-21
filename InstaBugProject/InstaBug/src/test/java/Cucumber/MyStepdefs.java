package Cucumber;

import BrowserActions.BrowserActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class MyStepdefs {
    private final String USERNAME_LOCATOR ="user-name";
    private final String PASSWORD_LOCATOR ="password";
    private final String HOMEPAGE = "https://www.saucedemo.com/inventory.html";
    private final String LOGIN_BUTTON = "login-button";
    private final String ERROR = "//*[@id=\"login_button_container\"]";
    private final String CART_LOCATOR = "shopping_cart_container";
    private final String WEBSITE = "https://www.saucedemo.com/";
    private final String BROWSER_TYPE = "CHROME";
    private final String PASSWORD = "secret_sauce";

    @Given("I navigate to website")
    public void iNavigateToWebsite() {
        BrowserActions.newDriver(BROWSER_TYPE);
        BrowserActions.maximize();
        BrowserActions.navigate(WEBSITE);
    }


    @Then("Homepage opens successfully")
    public void homepageOpensSuccessfully() {
        String url = BrowserActions.urlToBe();
        Assert.assertEquals(url, HOMEPAGE);
        Boolean flag = BrowserActions.elementPresent(CART_LOCATOR);
        Assert.assertTrue(flag);
        BrowserActions.closeBrowser();
    }


    @Given("I entered using userName {string} and password {string}")
    public void iEnteredUsingUserNameAndPassword(String userName, String password) {
        BrowserActions.setValue("id", USERNAME_LOCATOR, userName);
        BrowserActions.setValue("id", PASSWORD_LOCATOR, password);
        BrowserActions.click("id", LOGIN_BUTTON);
    }

    @Then("error message appears {string}")
    public void errorMessageAppears(String errorMessage) {
        String actualMessage = BrowserActions.getText(ERROR);
        Assert.assertEquals(actualMessage, errorMessage);
        System.out.println(actualMessage);
    }

    @Given("I entered the {string} and password correctly")
    public void iEnteredTheAndPasswordCorrectly(String userName) {
        BrowserActions.setValue("id", USERNAME_LOCATOR, userName);
        BrowserActions.setValue("id", PASSWORD_LOCATOR, PASSWORD);
        BrowserActions.click("id", LOGIN_BUTTON);
    }

    @Given("Leave the fields empty and click login")
    public void leaveTheFieldsEmptyAndClickLogin() {
        BrowserActions.click("id", LOGIN_BUTTON);
    }

    @Given("enter username field only {string}")
    public void enterUsernameFieldOnly(String username) {
        BrowserActions.setValue("id", USERNAME_LOCATOR, username);
    }

    //law hams7 captialized user
    @Given("enter username field {string} and password")
    public void enterUsernameFieldAndPassword(String userName) {
        BrowserActions.setValue("id",USERNAME_LOCATOR,userName);
        BrowserActions.setValue("id", PASSWORD_LOCATOR, PASSWORD);
        BrowserActions.click("id", LOGIN_BUTTON);
    }
}

