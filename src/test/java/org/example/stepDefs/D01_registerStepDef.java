package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_registration;


public class D01_registerStepDef {
    P01_registration reg =new P01_registration();

    @Given("user go to register page")
    public void goRegisterPage()
    {
        reg.registerBtn().click();
    }
    @When("user select gender type")
    public void selectGender(){

        reg.genderBtn().click();
    }
    @And("user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void Names(String FirstName , String LastName
     ){
    reg.enterFirstLastNames(FirstName,LastName);
    }
    @And("user enter date of birth")
    public void birthDate(){
        reg.date_of_birth();
    }
    @And("user enter email \"(.*)\"$")
    public void enter_Email (String email){
        reg.email().sendKeys(email);
    }
    @And("user fills Password fields \"(.*)\" and \"(.*)\"$")
    public void enter_passwords(String Password, String ConfirmPassword){
        reg.setPassword(Password, ConfirmPassword);
    }
    @When("user clicks on register button")
    public void clickRegister(){
        reg.register().click();
    }
    @Then("success message is displayed")
    public void successRegister (){
        reg.successMessage();

    }
}
