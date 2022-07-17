package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D05_hoverCategoriesStepDef {
    P03_homePage home = new P03_homePage();
    @Given("User hover random on one of the three main category on the top menu")
    public void slctRandomCategory() throws InterruptedException {
        home.categoriesMenu();
    }

   @When("user click on random sub category of product and get Text")
    public void selectRandomSubCategory(){
        home.clickSubCategory();
   }


    @Then("verify if the category title is matching")
    public void verifyCategory_title(){
        home.verifyTitle();
    }




































}
