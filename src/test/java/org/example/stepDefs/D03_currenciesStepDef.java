package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;


public class D03_currenciesStepDef {
    P03_homePage home= new P03_homePage();

    @Given("user change currency to euro")
    public void changeCurr(){
        home.currency();
    }


    @Then("verify the currency symbol changed in the products")
    public void currSymbol()  {
        home.productsPrice();

        }

}


