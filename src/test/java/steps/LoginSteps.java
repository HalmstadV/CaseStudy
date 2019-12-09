package steps;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.client.AppiumClient;
import pages.HomePage;
import pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginSteps extends BaseTest {

    LoginPage loginPage = new LoginPage();
    AppiumClient appiumClient = new AppiumClient(loginPage);


    @Given("I have started application")
    public void iHaveStartedApplication() throws Exception {
        BaseTest.setUp();
    }

    @When("I fill email as {string}")
    public void iFillEmailAs(String email) {
        loginPage.fillEmailBox(email);
    }

    @And("I fill password as {string}")
    public void iFillPasswordAs(String password) {
        loginPage.fillPassword(password);
    }

    @And("I click on Sign in button")
    public void iClickOnSignInButton() {
        loginPage.clickLoginButton();
    }

    @Then("I expect to be logged in")
    public void iExpectToBeLoggedIn() {
        HomePage homePage = new HomePage();
        appiumClient.changePage(homePage);
        assertThat("Category Section should be visible.", homePage.isHomepageVisible());

    }

    @Given("i have logged in with email: {string} and password: {string}")
    public void iHaveLoggedInWithEmailAndPassword(String email, String password) throws Exception {
        iHaveStartedApplication();
        iFillEmailAs(email);
        iFillPasswordAs(password);
        iClickOnSignInButton();
        iExpectToBeLoggedIn();
    }
}
