package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class D09_RatingStepDef {
    P03_homePage home = new P03_homePage();
    @Given("user clicks on poor radio button")
    public  void  rateExcellent() throws InterruptedException {
        home.poorRadio().click();
        Thread.sleep(2000);
        home.pressVote().click();
        Thread.sleep(2000);
    }



    @Then("error message appears")
    public void getError(){
        String expectedResult = "Only registered users can vote.";
        String actualResult = home.errorMsg().getText();
        Assert.assertEquals(actualResult,expectedResult);
        System.out.println("expectedResult"+ expectedResult + "and " + "actualResult" + actualResult );
    }


}
