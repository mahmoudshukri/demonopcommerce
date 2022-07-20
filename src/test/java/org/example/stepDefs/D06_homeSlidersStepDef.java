package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import org.example.pages.P03_homePage;

import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D06_homeSlidersStepDef {
P03_homePage home= new P03_homePage();
SoftAssert softAssert=new SoftAssert();
    @Given("user click on first slider and navigates to nokia verify url")

    public void clickSlider_1(){
    home.Slider_1().click();
        String expectedResult= "https://demo.nopcommerce.com/nokia-lumia-1020";
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(),expectedResult);
        softAssert.assertAll();
    }



    @And("user click on second slider and navigate to iphone and verify Url")
    public void clickSlider_2() {
        Hooks.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        home.Slider_2().click();
        String expectedResult = "https://demo.nopcommerce.com/iphone-6";
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(), expectedResult);
        softAssert.assertAll();

    }


}



















