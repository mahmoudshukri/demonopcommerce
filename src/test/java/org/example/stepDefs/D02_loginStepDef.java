package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.example.pages.P02_login;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    P02_login log = new P02_login();

    @Given("user go to login page")
    public void goLoginPage()
    {
        log.loginBtn().click();
    }
    @When("user login with valid \"(.*)\" and \"(.*)\"$")
    public void validLogin(String Email , String Password){
        log.loginCredentials(Email, Password);
    }
    @And("user press on login button")
    public void pressLoginBtn(){

    log.presslogInBtn().click();
    }
    @Then("user login to the system successfully")
    public void successLogin(){
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");

        log.myAccount();
        soft.assertTrue(log.myAccount(),"My Account Tab is visible");
        soft.assertAll();

    }
    @When("user login with invalid \"(.*)\" and \"(.*)\"$")
    public void invalidLogin(String Email , String Password){
        log.loginCredentials(Email, Password);
    }
    @Then("user could not login to the system")
    public void failMessage(){
        log.failureMessage();
    }


}
