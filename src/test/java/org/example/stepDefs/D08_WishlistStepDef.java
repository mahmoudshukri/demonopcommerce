package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDef {
    P03_homePage home = new P03_homePage();
    SoftAssert softAssert=new SoftAssert();
    @Given("User add an item to wishlist by clicking the heart symbol")
    public void addToWish(){
        home.getItemWishList().click();
    }
    @Then("The message The product has been added to your wishlist appear")
    public void successMessage(){
        String expectedMessage="The product has been added to your wishlist";
        String actualMessage=home.getSuccessMsg().getText();
        softAssert.assertTrue(actualMessage.contains(expectedMessage),"Success Message appears normally");
        System.out.println("Expected is:" + expectedMessage + "Actual is:" +actualMessage );

        String expectedColor="(75, 176, 122, 1)";
        String actualColor = home.getMessageBkColor();
        softAssert.assertEquals(actualColor.contains(expectedColor),true);
        softAssert.assertTrue(actualColor.contains(expectedColor));
        System.out.println("Expected is:" + expectedColor + "Actual is:" +actualColor );
        softAssert.assertAll();
    }


    @When("User waits after adding the item to his wishlist")
    public void waitToAddItem(){
        WebDriverWait wating= new WebDriverWait(Hooks.driver, Duration.ofSeconds(8));

        //waiting for the message to show
        wating.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));

        //waiting for the message to hide
        wating.until(ExpectedConditions.invisibilityOfElementLocated(By.id("bar-notification")));

    }
    @And("User navigates to the wishlist page")
    public void openWishlistPage() {
        home.openWishlist().click();
    }
    @Then("verify that quantity is not equal zero")
    public void checkQuantityBigThanZero() {
        String QuantityValue = home.verifyQuantity().getAttribute("value");
        softAssert.assertNotSame(QuantityValue, "0");
    }





















}
