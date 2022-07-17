package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    P03_homePage home = new P03_homePage();
    SoftAssert soft = new SoftAssert();


    @Given("user click on search box")
    public void pressSeach_Field () throws InterruptedException {
        home.searchBox().click();
        Thread.sleep(2000);
    }

    @When("user Enter productName as {string}")
    public void enterProdName(String productName) throws InterruptedException {
        home.searchBox().sendKeys(productName);
        Thread.sleep(2000);
    }

    @And("user click on search button")
    public void pressSearch() throws InterruptedException {
        home.searchBtn().click();
        Thread.sleep(2000);
    }

    @Then("verify url contains {string}")
    public void verifyUrl(String productName) {
        String expectedURL = "https://demo.nopcommerce.com/search?q="+productName;
        String actualURL = home.searchUrl();
        soft.assertEquals(actualURL, expectedURL, "The Url is https://demo.nopcommerce.com/search?q=");
        soft.assertTrue(actualURL.contains(expectedURL));
        soft.assertAll();
    }


    @And("verify result contains {string}")
    public void verifyProductName(String productName) {
        for (WebElement items : home.productsTitles()) {
            soft.assertTrue(items.getText().toLowerCase().contains((productName.toLowerCase())));
        }

    }

    @And("verify the Count number of search {string}")
          public void verifyCount(String name){
            home.search_Result_Count(name);

        }



    }


