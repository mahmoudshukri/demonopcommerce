package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class P01_registration {

    public WebElement registerBtn(){
        WebElement registerBtn = Hooks.driver.findElement(By.className("ico-register"));
        return registerBtn;
    }
    public WebElement genderBtn(){
        WebElement genderBtn= Hooks.driver.findElement(By.id("gender-male"));
        return genderBtn;

    }
    public WebElement firstName(){
        WebElement firstName = Hooks.driver.findElement(By.id("FirstName"));
        return firstName;
    }
    public WebElement lastName(){
        WebElement lastName = Hooks.driver.findElement(By.id("LastName"));
        return lastName;
    }
    public void enterFirstLastNames(String FirstName, String LastName) {
        firstName().sendKeys(FirstName);
        lastName().sendKeys(LastName);

    }
    public void date_of_birth()
    {

        WebElement birthDay = Hooks.driver.findElement(By.name("DateOfBirthDay"));
        Select select = new Select(birthDay);
        select.selectByIndex(10); // select by index: this is day 10

        WebElement birthMonth = Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        select = new Select(birthMonth);
        select.selectByValue("3"); // select by value ,and it should be String: this is March

        WebElement birthYear = Hooks.driver.findElement(By.name("DateOfBirthYear"));
        select = new Select(birthYear);
        select.selectByVisibleText("1998"); // select by linkText and it should be String
    }
    public WebElement email(){
        WebElement email =Hooks.driver.findElement(By.id("Email"));
        return email;
    }
    public WebElement passwordId(){
        WebElement passwordId = Hooks.driver.findElement(By.id("Password"));
        return passwordId;
    }
    public WebElement confirmpasswordId(){
        WebElement confirmpasswordId = Hooks.driver.findElement(By.id("ConfirmPassword"));
        return confirmpasswordId;
    }
    public void setPassword (String Password, String ConfirmPassword) {
        passwordId().sendKeys(Password);
        confirmpasswordId().sendKeys(ConfirmPassword);
    }
    public WebElement register(){
       WebElement register = Hooks.driver.findElement(By.id("register-button"));
        return register;
    }
    public void successMessage(){
        SoftAssert soft = new SoftAssert();
        String expectedResult = "Your registration completed";
        String actualResult = Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).getText();
        soft.assertEquals(actualResult.contains(expectedResult),true);

        String textColorRGBA = Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).getCssValue("color");

        String textColorHex= Color.fromString(textColorRGBA).asHex();
        System.out.println(textColorHex +" = "+textColorRGBA);
        soft.assertEquals(textColorHex,"#4cb17c");
        soft.assertFalse(textColorRGBA.contains(textColorHex));
        soft.assertAll();
    }
}
