package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;

public class D07_followUsStepDef {

    P03_homePage home = new P03_homePage();

    @When("User clicks on {} link")
    public void clickLink(String socialMedia) throws InterruptedException {
        Thread.sleep(2000);
        home.followUsLinks(socialMedia).click();
    }

    @Then("{} is opened in new tab")
    public void openUrl(String expectedLink){
Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ArrayList<String> newTabs= new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(newTabs.get(1));
        String actualLink= home.url();
        Assert.assertEquals(actualLink.contains(expectedLink),true);
        System.out.println("Actual Results is : "+  actualLink + "And" + "Expected Results is : "+ expectedLink);

    }
}
