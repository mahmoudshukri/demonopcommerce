package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;



public class P02_login {
    public WebElement loginBtn(){
        WebElement loginBtn = Hooks.driver.findElement(By.className("ico-login"));
        return loginBtn;
    }
    public WebElement userName(){
        WebElement userName = Hooks.driver.findElement(By.id("Email"));
        return userName;
    }
    public WebElement password(){
        WebElement password = Hooks.driver.findElement(By.id("Password"));
        return password;
    }


    public void loginCredentials(String Email, String Password){

        userName().sendKeys(Email);
        password().sendKeys(Password);
    }
    public WebElement presslogInBtn(){
        WebElement logInBtn = Hooks.driver.findElement(By.className("login-button"));
        return logInBtn;
    }
    public WebElement myAccount(){
        WebElement myAccount =Hooks.driver.findElement(By.cssSelector("li>[class=\"ico-account\"]"));
        return myAccount;
    }
    public void failureMessage(){
        SoftAssert soft = new SoftAssert();
        String expectedResult = "Login was unsuccessful";
        String actualResult = Hooks.driver.findElement(By.className("message-error")).getText();
        soft.assertEquals(actualResult.contains(expectedResult),true);
        System.out.println(actualResult+" : "+"is actual"+" : "+ expectedResult + " : " + "is expected");

        String textColorRGBA = Hooks.driver.findElement(By.className("message-error")).getCssValue("color");
        String textColorHex= Color.fromString(textColorRGBA).asHex();
        System.out.println(textColorHex +" = "+textColorRGBA);
        soft.assertEquals(textColorHex,"#e4434b");
        soft.assertFalse(textColorRGBA.contains(textColorHex));
        soft.assertAll();
    }

}
